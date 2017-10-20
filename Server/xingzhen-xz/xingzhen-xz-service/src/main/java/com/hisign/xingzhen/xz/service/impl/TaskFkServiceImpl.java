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
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.entity.TaskFk;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;
import com.hisign.xingzhen.xz.api.service.TaskFkService;
import com.hisign.xingzhen.xz.mapper.TaskFkMapper;
import com.hisign.xingzhen.xz.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 《任务反馈》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("taskFkService")
public class TaskFkServiceImpl extends BaseServiceImpl<TaskFk,TaskFkModel, String> implements TaskFkService{

	@Autowired
	protected TaskFkMapper taskFkMapper;

    @Autowired
    protected TaskMapper taskMapper;
	
	@Override
	protected BaseMapper<TaskFk,TaskFkModel, String> initMapper() {
		return taskFkMapper;
	}
	
	@Override
	@Transactional
	public JsonResult add(List<TaskFk> list) throws BusinessException {
		try {
			taskFkMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			taskFkMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			taskFkMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			taskFkMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

     @Override
     @Transactional
     public JsonResult addTaskFk(TaskFk taskFk) {
         Date now=new Date();
         taskFk.setId(UUID.randomUUID().toString());
         taskFk.setFkTime(now);
         taskFk.setCreatetime(now);
         taskFk.setLastupdatetime(now);
         taskFk.setDeleteflag(Constants.DELETE_FALSE);
         Task task=new Task();
         task.setId(taskFk.getTaskid());
         task.setFkzt("1");
         task.setFkTime(now);
         task.setLastupdatetime(now);
         taskMapper.updateNotNull(task);
         return super.addNotNull(taskFk);
     }
 }