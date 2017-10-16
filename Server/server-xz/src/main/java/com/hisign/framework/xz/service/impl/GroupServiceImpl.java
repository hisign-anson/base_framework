package com.hisign.framework.xz.service.impl;

import com.hisign.framework.common.constant.Constants;
import com.hisign.framework.common.util.SerialNumGenerater;
import com.hisign.framework.xz.api.model.GroupModel;
import com.hisign.framework.xz.mapper.GroupMapper;
import com.hisign.framework.xz.api.entity.Group;
import com.hisign.framework.xz.api.service.GroupService;

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
 * 《专案组》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("groupService")
public class GroupServiceImpl extends BaseServiceImpl<Group,GroupModel, String> implements GroupService {

    @Autowired
    protected GroupMapper groupMapper;

    @Override
    protected BaseMapper<Group,GroupModel, String> initMapper() {
        return groupMapper;
    }


    @Override
    public JsonResult add(Group entity) throws BusinessException {
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatetime(new Date());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        entity.setLastupdatetime(new Date());
        return super.add(entity);
    }

    @Override
    @Transactional
    public JsonResult add(List<Group> list) throws BusinessException {
        try {
            groupMapper.batchInsert(list);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            groupMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            groupMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            groupMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    private String createGroupNo() {
        String maxNo = groupMapper.getMaxNo();
        String nextNumber = SerialNumGenerater.getInstance().getNextNumber(maxNo, 4);
        return "ZAZ"+nextNumber;
    }

    @Override
    public JsonResult getGroupPage(Group group) {
        List<GroupModel> list = groupMapper.getGroupByCondition(group);
        long count = groupMapper.getCountGroupByCondition(group);
        return JsonResultUtil.success(count,list);
    }
}