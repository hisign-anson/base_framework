package com.hisign.xingzhen.xz.service.impl;

import cn.jmessage.api.message.MessageType;
import com.alibaba.fastjson.JSONObject;
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
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.JMBean;
import com.hisign.xingzhen.nt.api.service.NtService;
import com.hisign.xingzhen.sys.api.model.SysUser;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.xingzhen.xz.api.entity.AsjAj;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.AjgroupModel;
import com.hisign.xingzhen.xz.api.model.AsjAjModel;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.service.AjgroupService;
import com.hisign.xingzhen.xz.mapper.AjgroupMapper;
import com.hisign.xingzhen.xz.mapper.AsjAjMapper;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


/**
 * 《案件专案组关联》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("ajgroupService")
public class AjgroupServiceImpl extends BaseServiceImpl<Ajgroup, AjgroupModel, String> implements AjgroupService {

    Logger log = LoggerFactory.getLogger(AjgroupService.class);

    @Autowired
    protected AjgroupMapper ajgroupMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private NtService ntService;

    @Autowired
    private AsjAjMapper asjAjMapper;

    @Autowired
    private XzLogMapper xzLogMapper;

    @Autowired
    private SysUserService sysUserService;

    @Override
    protected BaseMapper<Ajgroup, AjgroupModel, String> initMapper() {
        return ajgroupMapper;
    }

    @Override
    public JsonResult add(Ajgroup entity) throws BusinessException {
        return addNotNull(entity);
    }

    @Override
    public JsonResult addNotNull(Ajgroup entity) throws BusinessException {
        GroupModel groupModel=groupMapper.findById(entity.getGroupid());
        if(groupModel==null){
            return error("专案组不存在");
        }
        //子专案组不能关联案件
        if (StringUtils.isNotBlank(groupModel.getPgroupid())){
            return error("抱歉，子专案组不能关联案件");
        }

        Date now=new Date();
        entity.setId(StringUtils.getUUID());
        entity.setPgroupid(groupModel.getPgroupid());
        entity.setCreatetime(now);
        entity.setLastupdatetime(now);
        entity.setPgroupid(groupModel.getPgroupid());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        JsonResult result = super.addNotNull(entity);
        if (result.isSuccess()){
            try {
                //保存操作日志
                String content = StringUtils.concat("专案组(ID:",entity.getGroupid(),")关联案件(ID:", entity.getAjid(),")");
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()), Constants.XZLogType.GROUP, content, entity.getCreator(), entity.getCreatetime(), entity.getId());
                xzLogMapper.insertNotNull(xzLog);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            return JsonResultUtil.success(super.getById(entity.getId()));
        }
        return error(BaseEnum.BusinessExceptionEnum.INSERT.Msg());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult add(List<Ajgroup> ajgroupList) throws BusinessException {
        try {
            List<Object> ids = new ArrayList<>();
            String groupId = ajgroupList.get(0).getGroupid();
            String creator = ajgroupList.get(0).getCreator();

            //获取专案组对象
            GroupModel groupModel = groupMapper.findById(groupId);
            if (groupModel==null){
                log.error("专案组不存在，[id=?]",groupId);
                return error("抱歉，关联的专案组不存在，请刷新页面再试!");
            }

            //获取用户信息
            SysUserInfo user = sysUserService.getUserInfoByUserId(creator);
            if (user==null){
                log.error("该用户不存在，[user=?]",user);
                return error("抱歉，该用户不存在，请刷新页面再试!");
            }

            Date date = new Date();
            for (Ajgroup ajgroup : ajgroupList) {
                ids.add(ajgroup.getAjid());
                ajgroup.setGroupid(groupId);
                ajgroup.setPgroupid(groupModel.getPgroupid());
                ajgroup.setDeleteflag(Constants.DELETE_FALSE);
                ajgroup.setCreatetime(date);
                ajgroup.setLastupdatetime(date);
                ajgroup.setId(StringUtils.getUUID());
                ajgroup.setPgroupid(null);
            }

            Conditions conditions = new Conditions(AsjAj.class);
            Conditions.Criteria criteria = conditions.createCriteria();
            criteria.add(AsjAj.AsjAjEnum.id.get(), BaseEnum.IsInEnum.IN,ids);

            conditions.setReturnFields(new String[]{AsjAj.AsjAjEnum.id.get(),AsjAj.AsjAjEnum.ajmc.get()});

            List<AsjAjModel> list = asjAjMapper.findList(conditions);
            if (list.size()!=ajgroupList.size()){
                log.error("关联的案件有些不存在，[ids=?]",ids);
                return error("抱歉，参数错误，请刷新页面再试!");
            }

            //若存在重复，则删除
            Conditions con = new Conditions(Ajgroup.class);
            Conditions.Criteria cri = con.createCriteria();
            cri.add(Ajgroup.AjgroupEnum.ajid.get(), BaseEnum.IsInEnum.IN,ids)
            .add(Ajgroup.AjgroupEnum.groupid.get(), BaseEnum.ConditionEnum.EQ,groupId);

            ajgroupMapper.deleteCustom(con);

            //关联案件
            long num = ajgroupMapper.batchInsert(ajgroupList);
            if (num!=ajgroupList.size()){
                throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT);
            }
            //推送消息移动端,不需要回滚
            try {
                JMBean jmBean = new JMBean(StringUtils.getUUID(), Constants.SEND_CONNECT_CASE_INFO,Constants.JM_FROM_TYPE_ADMIN, Constants.JM_TARGET_TYPE_GROUP, MessageType.CUSTOM.getValue(), creator, groupModel.getJmgid());
                //msgBody
                Map<String, Object> map = new HashMap<>();
                map.put("msgType",Constants.SEND_CONNECT_CASE_INFO);
                map.put("title","关联案件");
                map.put("groupId",groupId);

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i!=0){
                        sb.append(",");
                    }
                    sb.append(list.get(i).getAjmc());
                }
                map.put("caseName",sb.toString());
                map.put("creator",creator);
                map.put("createName",user.getUserName());
                map.put("createTime",date);

                jmBean.setMsg_body(JSONObject.toJSONString(map));
                ntService.sendJM(jmBean);
            } catch (NoticeException e) {
                //不做回滚
                log.error("推送消息到移动端失败",e);
            }

        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            ajgroupMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            ajgroupMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            ajgroupMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    /**
     * 移除案件
     * @param ajgroupList
     * @return
     * @throws BusinessException
     */
    @Transactional(rollbackFor = Exception.class)
    public JsonResult removeCaseList(List<Ajgroup> ajgroupList) throws BusinessException {

        List<Object> ids = new ArrayList<>();
        Ajgroup aj = ajgroupList.get(0);
        for (Ajgroup ajgroup : ajgroupList) {
            if (StringUtils.isEmpty(ajgroup.getId())){
                log.error("错误，关联的id为空");
                return error("抱歉，参数错误，请刷新页面再试!");
            }
            ids.add(ajgroup.getId());
        }

        //获取专案组对象
        GroupModel groupModel = groupMapper.findById(aj.getGroupid());
        if (groupModel==null){
            log.error("专案组不存在，[id=?]",aj);
            return error("抱歉，关联的专案组不存在，请刷新页面再试!");
        }

        //获取用户信息
        SysUserInfo user = sysUserService.getUserInfoByUserId(aj.getCreator());
        if (user==null){
            log.error("该用户不存在，[user=?]",user);
            return error("抱歉，该用户不存在，请刷新页面再试!");
        }

        Conditions conditions = new Conditions(AsjAj.class);
        Conditions.Criteria criteria = conditions.createCriteria();
        criteria.add(AsjAj.AsjAjEnum.id.get(), BaseEnum.IsInEnum.IN,ids);

        List<AjgroupModel> ajgroupModelList = ajgroupMapper.findList(conditions);
        if (ajgroupModelList.size()!=ajgroupList.size()){
            log.info("ajgroupModelList=[]",ajgroupModelList);
            return error("抱歉，参数错误，请刷新页面再试!");
        }

        for (AjgroupModel ajgroupModel : ajgroupModelList) {
            //子专案组不能移除案件
            if (StringUtils.isNotBlank(ajgroupModel.getPgroupid())){
                return error("抱歉，子专案组不能移除案件");
            }
        }

        ajgroupMapper.deleteCustom(conditions);

        //推送消息移动端,不需要回滚
        try {
            JMBean jmBean = new JMBean(StringUtils.getUUID(), Constants.SEND_CONNECT_CASE_INFO,Constants.JM_FROM_TYPE_ADMIN, Constants.JM_TARGET_TYPE_GROUP, MessageType.CUSTOM.getValue(), aj.getCreator(), groupModel.getJmgid());
            //msgBody
            Map<String, Object> map = new HashMap<>();
            map.put("msgType",Constants.SEND_REMOVE_CASE_INFO);
            map.put("title","关联案件");
            map.put("groupId",aj.getGroupid());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ajgroupList.size(); i++) {
                if (i!=0){
                    sb.append(",");
                }
                sb.append(ajgroupList.get(i).getCaseName());
            }
            map.put("caseName",sb.toString());
            map.put("creator",aj.getCreator());
            map.put("createName",user.getUserName());
            map.put("createTime",new Date());

            jmBean.setMsg_body(JSONObject.toJSONString(map));
            ntService.sendJM(jmBean);
        } catch (NoticeException e) {
            //不做回滚
            log.error("推送消息到移动端失败",e);
        }

        return success();
    }
}