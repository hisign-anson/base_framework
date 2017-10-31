package com.hisign.xingzhen.xz.service.impl;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.group.CreateGroupResult;
import cn.jmessage.api.user.UserClient;
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
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;
import com.hisign.xingzhen.xz.api.param.SysUserInfoParam;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


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
    private UserClient userClient;

    @Override
    protected BaseMapper<Usergroup,UsergroupModel, String> initMapper() {
        return usergroupMapper;
    }
    
    @Override
    @Transactional
    public JsonResult add(List<Usergroup> list) throws BusinessException {
        try {
            String creator = list.get(0).getCreator();
            List<String> ids = new ArrayList<>();
            String groupId = list.get(0).getGroupid();
            for (Usergroup usergroup : list) {
                ids.add(usergroup.getUserid());
                usergroup.setCreatetime(new Date());
                usergroup.setDeleteflag(Constants.DELETE_FALSE);
                usergroup.setId(UUID.randomUUID().toString());
                usergroup.setLastupdatetime(new Date());
                usergroup.setGroupid(groupId);
            }

            //获取专案组对象
            GroupModel groupModel = groupMapper.findById(groupId);
            if (groupModel==null){
                return error("抱歉，该专案组不存在!");
            }

            usergroupMapper.batchInsert(list);

            //如果未创建极光群组
            if (StringUtils.isEmpty(groupModel.getJmgid())){
                //创建极光群组
                try {
                    CreateGroupResult cgr = jMessageClient.createGroup(creator, groupModel.getGroupname(), groupModel.getGroupname(), ListUtils.list2Array(ids));
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
            jMessageClient.addOrRemoveMembers(Long.valueOf(groupModel.getJmgid()),ListUtils.list2Array(ids),null);

            try {
                String content = StringUtils.concat("专案组(ID:", groupId, ")", "人员(ID:", ids.toString(), ")添加");
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, content, creator, new Date(), groupId);
                xzLogMapper.insertNotNull(xzLog);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
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
    public JsonResult addNotNull(Usergroup entity) throws BusinessException {
        Date now=new Date();
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatetime(now);
        entity.setDeleteflag(Constants.DELETE_FALSE);
        entity.setLastupdatetime(now);
        JsonResult result = super.addNotNull(entity);
        if (result.getFlag()==1){
            //保存操作日志
            try {
                String content = StringUtils.concat("专案组(ID:", entity.getGroupid(), ")", "人员(ID:", entity.getUserid(), ")添加");
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, content, entity.getCreator(), entity.getCreatetime(), entity.getGroupid());
                xzLogMapper.insertNotNull(xzLog);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            return JsonResultUtil.success(super.getById(entity.getId()));
        }
        return result;
    }

    @Override
    @Transactional
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

        Conditions conditions = new Conditions();
        conditions.createCriteria().add(Usergroup.UsergroupEnum.groupid.get(), BaseEnum.ConditionEnum.EQ,ug.getGroupid())
                .add(Usergroup.UsergroupEnum.userid.get(), BaseEnum.ConditionEnum.EQ,ug.getUserid());
        usergroupMapper.deleteCustom(conditions);

        //极光群组删除用户
        if (StringUtils.isNotBlank(group.getJmgid())){
            try {
                jMessageClient.addOrRemoveMembers(Long.valueOf(group.getJmgid()),null,ListUtils.obj2strArr(userIds));
            } catch (APIConnectionException e) {
                log.error("Connection error. Should retry later. ", e);
                throw new BusinessException("对不起，群组移除成员失败!");
            } catch (APIRequestException e) {
                log.error("Error response from JPush server. Should review and fix it. ", e);
                log.info("HTTP Status: " + e.getStatus());
                log.info("Error Message: " + e.getMessage());
                throw new BusinessException("对不起，群组移除成员失败!");
            }
        }

        try {
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
    public JsonResult getGroupMemberList(String groupId) {
        List<SysUserInfo> list = usergroupMapper.findGroupMemberList(groupId);
        return JsonResultUtil.success(list);
    }
}