package com.hisign.xingzhen.xz.service.impl;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseMapper;
import com.hisign.bfun.bif.BaseServiceImpl;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.util.SerialNumGenerater;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import com.hisign.xingzhen.xz.api.service.TaskService;
import com.hisign.xingzhen.xz.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 《任务》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("taskService")
public class TaskServiceImpl extends BaseServiceImpl<Task,TaskModel, String> implements TaskService {

    @Autowired
    protected TaskMapper taskMapper;

    @Override
    protected BaseMapper<Task,TaskModel, String> initMapper() {
        return taskMapper;
    }

    @Override
    public JsonResult add(Task entity) throws BusinessException {
        entity.setCreatetime(new Date());
        entity.setId(UUID.randomUUID().toString());
        entity.setTaskNo(createTaskNo(entity.getDeparmentcode()));
        entity.setDeleteflag(Constants.DELETE_FALSE);
        return super.add(entity);
    }

    @Override
    @Transactional
    public JsonResult add(List<Task> list) throws BusinessException {
        try {
            taskMapper.batchInsert(list);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            taskMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            taskMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            taskMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    private String createTaskNo(String orgId) {
        String maxNo = taskMapper.getMaxNo();
        String nextNumber = SerialNumGenerater.getInstance().getNextNumber(orgId,maxNo, 5);
        return "RW" + nextNumber;
    }

    @Override
    public JsonResult getTaskPage(Task task) {
        List<TaskModel> list = taskMapper.getTaskByCondition(task);
        long count = taskMapper.getCountTaskByCondition(task);
        return JsonResultUtil.success(count,list);
    }
}