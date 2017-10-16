package com.hisign.framework.xz.service.impl;

import com.hisign.framework.common.constant.Constants;
import com.hisign.framework.common.util.StringUtils;
import com.hisign.framework.sys.api.model.SysUserInfo;
import com.hisign.framework.xz.api.model.UsergroupModel;
import com.hisign.framework.xz.mapper.UsergroupMapper;
import com.hisign.framework.xz.api.entity.Usergroup;
import com.hisign.framework.xz.api.service.UsergroupService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatetime(new Date());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        return super.add(entity);
    }

    @Override
    public JsonResult deleteUsergroup(String userId, String groupId) {
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(groupId)){
            return error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
        }

        Usergroup usergroup = new Usergroup();
        usergroup.setUserid(userId);
        usergroup.setGroupid(groupId);

        Conditions conditions = new Conditions();
        conditions.createCriteria().add(Usergroup.UsergroupEnum.userid.get(), BaseEnum.ConditionEnum.EQ,userId)
                .add(Usergroup.UsergroupEnum.groupid.get(), BaseEnum.ConditionEnum.EQ,groupId);
        usergroupMapper.deleteCustom(conditions);

        return success("移除组内成员成功");
    }

    @Override
    public JsonResult getUsergroupPage(SysUserInfo info) {
        List<SysUserInfo> list = usergroupMapper.getGroupUserList(info);
        long count = usergroupMapper.getGroupUserCount(info);
        return JsonResultUtil.success(count,list);
    }
}