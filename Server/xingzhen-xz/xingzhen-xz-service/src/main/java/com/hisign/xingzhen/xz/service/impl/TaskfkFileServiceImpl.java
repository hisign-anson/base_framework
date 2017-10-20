package com.hisign.xingzhen.xz.service.impl;

import com.hisign.xingzhen.xz.api.model.TaskfkFileModel;
import com.hisign.xingzhen.xz.mapper.TaskfkFileMapper;
import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.service.TaskfkFileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bif.*;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.*;


 /**
 * 《任务反馈文件表》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("taskfkFileService")
public class TaskfkFileServiceImpl extends BaseServiceImpl<TaskfkFile,TaskfkFileModel, String> implements TaskfkFileService{

	@Autowired
	protected TaskfkFileMapper taskfkFileMapper;
	
	@Override
	protected BaseMapper<TaskfkFile, TaskfkFileModel, String> initMapper() {
		return taskfkFileMapper;
	}
	
	@Override
	@Transactional
	public JsonResult add(List<TaskfkFile> list) throws BusinessException {
		try {
			taskfkFileMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			taskfkFileMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			taskfkFileMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			taskfkFileMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

}