package com.hisign.xingzhen.xz.service.impl;

import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.util.IpUtil;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.XzLogModel;
import com.hisign.xingzhen.xz.api.service.XzLogService;

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
 * 《日志》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("xzLogService")
public class XzLogServiceImpl extends BaseServiceImpl<XzLog, XzLogModel, String> implements XzLogService {

    @Autowired
    protected XzLogMapper xzLogMapper;

    @Override
    protected BaseMapper<XzLog, XzLogModel, String> initMapper() {
        return xzLogMapper;
    }

    @Override
    @Transactional
    public JsonResult add(List<XzLog> list) throws BusinessException {
        try {
            xzLogMapper.batchInsert(list);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            xzLogMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            xzLogMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            xzLogMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    public JsonResult addNotNull(XzLog entity) throws BusinessException {
        entity.setDeleteFlag(Constants.DELETE_FALSE);
        entity.setId(UUID.randomUUID().toString());
        entity.setIp(IpUtil.getRemotIpAddr(BaseRest.getRequest()));
        entity.setLogType(Constants.XZLogType.CHAT);
        return super.addNotNull(entity);
    }
}