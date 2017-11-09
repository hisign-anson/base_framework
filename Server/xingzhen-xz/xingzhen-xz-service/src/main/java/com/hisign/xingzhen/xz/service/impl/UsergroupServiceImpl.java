package com.hisign.xingzhen.xz.service.impl;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.group.CreateGroupResult;
import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseMapper;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bif.BaseServiceImpl;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.util.IpUtil;
import com.hisign.xingzhen.common.util.ListUtils;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.service.NtService;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;
import com.hisign.xingzhen.sys.api.param.SysUserInfoParam;
import com.hisign.xingzhen.xz.api.service.UsergroupService;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.UsergroupMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 《人员专案组关联》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("usergroupService")
public class UsergroupServiceImpl extends BaseServiceImpl<Usergroup,UsergroupModel, String> implements UsergroupService {

    Logger log = LoggerFactory.getLogger(UsergroupServiceImpl.class);

    @Autowired
    protected UsergroupMapper usergroupMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private XzLogMapper xzLogMapper;

    @Autowired
    private JMessageClient jMessageClient;

    @Autowired
    private NtService ntService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    protected BaseMapper<Usergroup,UsergroupModel, String> initMapper() {
        return usergroupMapper;
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult add(List<Usergroup> list) throws BusinessException {
        try {
            Usergroup ug = list.get(0);
            String creator = ug.getCreator();
            List<Object> ids = new ArrayList<>();
            String groupId = ug.getGroupid();
            for (Usergroup usergroup : list) {
                ids.add(usergroup.getUserid());
                usergroup.setCreatetime(new Date());
                usergroup.setDeleteflag(Constants.DELETE_FALSE);
                usergroup.setId(StringUtils.getUUID());
                usergroup.setLastupdatetime(new Date());
                usergroup.setGroupid(groupId);
            }

            //获取专案组对象
            GroupModel groupModel = groupMapper.findById(groupId);
            if (groupModel==null){
                return error("抱歉，该专案组不存在!");
            }

            //获取用户信息
            SysUserInfo user = sysUserService.getUserInfoByUserId(creator);
            if (user==null){
                log.error("该用户不存在，[user=?]",user);
                return error("抱歉，该用户不存在，请刷新页面再试!");
            }

            //若存在重复添加，则删除
            Conditions con = new Conditions(Usergroup.class);
            Conditions.Criteria cri = con.createCriteria();
            cri.add(Usergroup.UsergroupEnum.groupid.get(), BaseEnum.ConditionEnum.EQ,groupId)
                    .add(Usergroup.UsergroupEnum.userid.get(), BaseEnum.IsInEnum.IN,ids);

            usergroupMapper.deleteCustom(con);

            long num = usergroupMapper.batchInsert(list);
            if (num!=list.size()){
                throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT);
            }

            //如果未创建极光群组
            if (StringUtils.isEmpty(groupModel.getJmgid())){
                //创建极光群组
                try {
                    CreateGroupResult cgr = jMessageClient.createGroup(creator, groupModel.getGroupname(), groupModel.getId(), ListUtils.obj2strArr(ids));
                    if (!cgr.isResultOK()){
                        log.info("对不起，创建群组失败!:",cgr.getResponseCode());
                        throw new BusinessException("对不起，创建群组失败!");
                    }else{
                        groupModel.setJmgid(cgr.getGid().toString());
                        //更新专案组
                        Group group = new Group();
                        BeanUtils.copyProperties(groupModel,group);
                        groupMapper.update(group);
                    }
                } catch (APIConnectionException e) {
                    log.error("Connection error. Should retry later. ", e);
                    throw new BusinessException("对不起，创建群组失败!");
                } catch (APIRequestException e) {
                    log.error("Error response from JPush server. Should review and fix it. ", e);
                    log.info("HTTP Status: " + e.getStatus());
                    log.info("Error Message: " + e.getMessage());
                    throw new BusinessException("对不起，创建群组失败!");
                }
            }

            //添加用户到极光群组
            try {
                jMessageClient.addOrRemoveMembers(Long.valueOf(groupModel.getJmgid()),ListUtils.obj2strArr(ids),null);
            } catch (APIConnectionException e) {
                log.error("连接极光失败！e={}",e);
                throw new BusinessException(BaseEnum.BusinessExceptionEnum.SYSBUSYEXCEPTION);
            } catch (APIRequestException e) {
                if (899011==e.getErrorCode()){
                    //重复关联用户
                }else{
                    log.error("关联失败！e={}",e);
                    throw new BusinessException(BaseEnum.BusinessExceptionEnum.SYSBUSYEXCEPTION);
                }
            } catch (NumberFormatException e) {
                throw new BusinessException(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION);
            }

            try {
                MsgBean bean = new MsgBean();
                //发送信息提醒
                String text = StringUtils.concat("新专案组:您已被添加到专案组[", groupModel.getGroupname(), "]");
                bean.setMsgId(StringUtils.getUUID());
                bean.setReceiverType(String.valueOf(Constants.ReceiveMessageType.TYPE_3));
                bean.setMsgContent(text);
                bean.setPublishId(creator);
                bean.setPublishName(user.getUserName());

                List<SysUserInfo> userList = sysUserService.getUserInfoByIds(ListUtils.obj2str(ids));
                if (userList!=null && userList.size()!=0){
                    bean.setList(userList);
                }
                ntService.sendMsg(bean);

                //保存操作日志
                String content = StringUtils.concat("专案组(ID:", groupId, ")", "人员(ID:", ids.toString(), ")添加");
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, content, creator, new Date(), groupId);
                xzLogMapper.insertNotNull(xzLog);
            } catch (Exception e) {
                log.error(e.getMessage(),e);
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            usergroupMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            usergroupMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            usergroupMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    public JsonResult add(Usergroup entity) throws BusinessException {
        return addNotNull(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult addNotNull(Usergroup entity) throws BusinessException {
        Date now=new Date();
        entity.setId(StringUtils.getUUID());
        entity.setCreatetime(now);
        entity.setDeleteflag(Constants.DELETE_FALSE);
        entity.setLastupdatetime(now);
        JsonResult result = super.addNotNull(entity);
        if (result.isSuccess()){
            //保存操作日志
            try {
                String content = StringUtils.concat("专案组(ID:", entity.getGroupid(), ")", "人员(ID:", entity.getUserid(), ")添加");
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, content, entity.getCreator(), entity.getCreatetime(), entity.getGroupid());
                xzLogMapper.insertNotNull(xzLog);
            } catch (Exception e) {
                log.error(e.getMessage(),e);
            }
            return JsonResultUtil.success(super.getById(entity.getId()));
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult deleteUsergroupList(List<Usergroup> usergroupList) {

        Usergroup ug = usergroupList.get(0);
        List<Object> userIds = new ArrayList<>(usergroupList.size());
        for (Usergroup usergroup : usergroupList) {
            userIds.add(usergroup.getUserid());
        }

        //获取专案组
        GroupModel group = groupMapper.findById(ug.getGroupid());
        if (group==null){
            return error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
        }

        //判断该专案组创建人是否是该用户
        if (!ug.getCreator().equals(group.getCreator())){
            return error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
        }

        //判断该被移除人员是否是创建人
        if (ug.getUserid().equals(group.getCreator())){
            return error("抱歉,该用户是该专案组的创建人,不能被移除");
        }
        //组装删除小组人员Conditions
        Conditions conditions = new Conditions();
        conditions.createCriteria().add(Usergroup.UsergroupEnum.groupid.get(), BaseEnum.ConditionEnum.EQ,ug.getGroupid())
                .add(Usergroup.UsergroupEnum.userid.get(), BaseEnum.ConditionEnum.EQ,ug.getUserid());
        usergroupMapper.deleteCustom(conditions);

        //如果是父组，小组也需要移除该人
        if (!StringUtils.isNotBlank(group.getPgroupid())){
            //获取所有小组groupid
            Conditions con = new Conditions(Group.class);
            con.createCriteria().add(Group.GroupEnum.pgroupid.get(), BaseEnum.ConditionEnum.EQ,group.getId())
                                .add(Group.GroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ,Constants.DELETE_FALSE);

            con.setReturnFields(new String[]{Group.GroupEnum.id.get(), Group.GroupEnum.jmgid.get()});
            List<GroupModel> groupList = groupMapper.findList(con);

            if (!ListUtils.isEmpty(groupList)){
                //组装小组id数组
                List<Object> groupIds = new ArrayList<>(groupList.size());
                List<Long> jmGIds = new ArrayList<>(groupList.size());
                for (GroupModel groupModel : groupList) {
                    groupIds.add(groupModel.getId());
                    jmGIds.add(Long.parseLong(groupModel.getJmgid()));
                }
                //组装删除小组人员Conditions
                Conditions ugCon = new Conditions(Usergroup.class);
                ugCon.createCriteria().add(Usergroup.UsergroupEnum.groupid.get(), BaseEnum.IsInEnum.IN,groupIds)
                                      .add(Usergroup.UsergroupEnum.userid.get(), BaseEnum.IsInEnum.IN,userIds);
                //把小组中的人员也删除
                usergroupMapper.deleteCustom(ugCon);
                Map<String, Object> map = new HashMap<>();
                map.put("msgId",StringUtils.getUUID());
                map.put("jmGids",jmGIds);
                map.put("userIds",userIds);

                try {
                    ntService.sendJMOperate(map);
                } catch (NoticeException e) {
                    log.error("删除极光小组用户失败,jmGids=[{}],userIds=[{}]",jmGIds,userIds);
                }
            }
        }

        //极光群组删除用户
        if (StringUtils.isNotBlank(group.getJmgid())){
            try {
                log.error("移除用户：",userIds);
                jMessageClient.addOrRemoveMembers(Long.valueOf(group.getJmgid()),null,ListUtils.obj2strArr(userIds));
            } catch (APIConnectionException e) {
                log.error("Connection error. Should retry later. ", e);
                throw new BusinessException("对不起，群组移除成员失败!");
            } catch (APIRequestException e) {
                int errorCode = e.getErrorCode();
                if (errorCode!=899014){
                    throw new BusinessException("对不起，群组移除成员失败!");
                }
                log.error("Error response from JPush server. Should review and fix it. ", e);
            }
        }

        try {
            MsgBean bean = new MsgBean();
            //发送信息提醒
            String text ="";
            if (!StringUtils.isNotBlank(group.getPgroupid())){
                text = StringUtils.concat("被移除:您已被专案组[", group.getGroupname(), "]及所属全部小组移除");
            }else{
                text = StringUtils.concat("被移除:您已被专案组[", group.getGroupname(), "]移除");
            }
            bean.setMsgId(StringUtils.getUUID());
            bean.setReceiverType(String.valueOf(Constants.ReceiveMessageType.TYPE_3));
            bean.setMsgContent(text);
            bean.setPublishId(ug.getCreator());
            bean.setPublishName(group.getCreatename());

            List<SysUserInfo> userList = sysUserService.getUserInfoByIds(ListUtils.obj2str(userIds));
            if (userList!=null && userList.size()!=0){
                bean.setList(userList);
            }
            ntService.sendMsg(bean);
            //保存操作日志
            StringBuilder sb = new StringBuilder();
            sb.append("用户(ID:").append(userIds.toString()).append(")被用户(ID:").append(ug.getCreator()).append(")从专案组(ID:").append(ug.getGroupid()).append("移除");
            XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, sb.toString(), ug.getCreator(), new Date(), group.getId());
        } catch (Exception e) {
            log.error("移除组内成员-操作日志失败",e);
        }
        return success("移除组内成员成功");
    }

    @Override
    public JsonResult getUsergroupPage(SysUserInfoParam info) {
        List<SysUserInfo> list = usergroupMapper.findGroupUserList(info);
        long count = usergroupMapper.findGroupUserCount(info);
        return JsonResultUtil.success(count,list);
    }

    @Override
    public JsonResult getUserInfoListByKey(SysUserInfoParam info) {
        List<SysUserInfo> list = usergroupMapper.findUserInfoListByKey(info);
        long count = usergroupMapper.findCountByKey(info);
        return JsonResultUtil.success(count,list);
    }

    @Override
    public JsonResult getGroupMemberList(String groupId) {
        List<SysUserInfo> list = usergroupMapper.findGroupMemberList(groupId);
        return JsonResultUtil.success(list);
    }
}