package com.hisign.xingzhen.xz.service.impl;

import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.util.IpUtil;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.UsergroupMapper;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.service.UsergroupService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bif.*;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.*;


/**
 * 《人员专案组关联》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("usergroupService")
public class UsergroupServiceImpl extends BaseServiceImpl<Usergroup,UsergroupModel, String> implements UsergroupService {

    @Autowired
    protected UsergroupMapper usergroupMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private XzLogMapper xzLogMapper;

    @Override
    protected BaseMapper<Usergroup,UsergroupModel, String> initMapper() {
        return usergroupMapper;
    }
    
    @Override
    @Transactional
    public JsonResult add(List<Usergroup> list) throws BusinessException {
        try {
            usergroupMapper.batchInsert(list);
        } catch (Exception e) {
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
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatetime(new Date());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        JsonResult result = super.addNotNull(entity);

        if (result.getFlag()==1){
            //保存操作日志
            try {
                String content = StringUtils.concat("专案组(ID:", entity.getGroupid(), ")", "人员(ID:", entity.getUserid(), ")添加");
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, content, entity.getCreator(), entity.getCreatetime(), entity.getGroupid());
                xzLogMapper.insert(xzLog);
            } catch (Exception e) {

            }
        }
        return result;
    }

    @Override
    public JsonResult deleteUsergroup(Usergroup usergroup) {
        if (StringUtils.isEmpty(usergroup.getUserid()) || StringUtils.isEmpty(usergroup.getGroupid()) || StringUtils.isEmpty(usergroup.getCreator())){
            return error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
        }

        //获取专案组
        GroupModel group = groupMapper.findById(usergroup.getGroupid());
        if (group==null){
            return error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
        }

        //判断该专案组创建人是否是该用户
        if (!usergroup.getCreator().equals(group.getCreator())){
            return error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
        }

        //判断该被移除人员是否是创建人
        if (usergroup.getUserid().equals(group.getCreator())){
            return error("抱歉,该用户是该专案组的创建人,不能被移除");
        }

        Conditions conditions = new Conditions();
        conditions.createCriteria().add(Usergroup.UsergroupEnum.userid.get(), BaseEnum.ConditionEnum.EQ,usergroup.getUserid())
                .add(Usergroup.UsergroupEnum.groupid.get(), BaseEnum.ConditionEnum.EQ,usergroup.getGroupid());
        UpdateParams updateParams = new UpdateParams(Usergroup.class);
        updateParams.add(Usergroup.UsergroupEnum.deleteflag.get(),Constants.DELETE_TRUE);
        updateParams.setConditions(conditions);
        usergroupMapper.updateCustom(updateParams);

        try {
            //保存操作日志
            StringBuilder sb = new StringBuilder();
            sb.append("用户(ID:").append(usergroup.getUserid()).append(")被用户(ID:").append(usergroup.getCreator()).append(")从专案组(ID:").append(usergroup.getGroupid()).append("移除");
            XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, sb.toString(), usergroup.getCreator(), new Date(), group.getId());
        } catch (Exception e) {

        }
        return success("移除组内成员成功");
    }

    @Override
    public JsonResult getUsergroupPage(SysUserInfo info) {
        List<SysUserInfo> list = usergroupMapper.findGroupUserList(info);
        long count = usergroupMapper.findGroupUserCount(info);
        return JsonResultUtil.success(count,list);
    }

    @Override
    public JsonResult getGroupMemberList(SysUserInfo info) {
        List<SysUserInfo> list = usergroupMapper.findGroupMemberList(info);
        return JsonResultUtil.success(list);
    }
}