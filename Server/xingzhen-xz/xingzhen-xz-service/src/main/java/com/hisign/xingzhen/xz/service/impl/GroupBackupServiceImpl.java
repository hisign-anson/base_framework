package com.hisign.xingzhen.xz.service.impl;

import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.xz.api.model.GroupBackupModel;
import com.hisign.xingzhen.xz.mapper.GroupBackupMapper;
import com.hisign.xingzhen.xz.api.entity.GroupBackup;
import com.hisign.xingzhen.xz.api.service.GroupBackupService;

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
 * 《专案组归档记录》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("groupBackupService")
public class GroupBackupServiceImpl extends BaseServiceImpl<GroupBackup, GroupBackupModel, String> implements GroupBackupService {

    @Autowired
    protected GroupBackupMapper groupBackupMapper;

    @Override
    protected BaseMapper<GroupBackup, GroupBackupModel, String> initMapper() {
        return groupBackupMapper;
    }

    @Override
    public JsonResult add(GroupBackup entity) throws BusinessException {
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatetime(new Date());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        return super.add(entity);
    }

    @Override
    @Transactional
    public JsonResult add(List<GroupBackup> list) throws BusinessException {
        try {
            groupBackupMapper.batchInsert(list);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            groupBackupMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            groupBackupMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            groupBackupMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

}