package com.hisign.xingzhen.xz.service.impl;

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
import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.TaskfkFileModel;
import com.hisign.xingzhen.xz.api.service.TaskfkFileService;
import com.hisign.xingzhen.xz.mapper.TaskfkFileMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


 /**
 * 《任务反馈文件表》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("taskfkFileService")
public class TaskfkFileServiceImpl extends BaseServiceImpl<TaskfkFile,TaskfkFileModel, String> implements TaskfkFileService{

	@Autowired
	protected TaskfkFileMapper taskfkFileMapper;

    @Autowired
    protected XzLogMapper xzLogMapper;

    @Override
	protected BaseMapper<TaskfkFile, TaskfkFileModel, String> initMapper() {
		return taskfkFileMapper;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult add(List<TaskfkFile> list) throws BusinessException {
		try {
			taskfkFileMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			taskfkFileMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			taskfkFileMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			taskfkFileMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

     @Override
     public JsonResult downloadLog(String fkFileId, String userId) {
         String content="任务反馈附件单个下载（FKFILEID=" + fkFileId + "）";
         XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()), Constants.XZLogType.TASK,content , userId, new Date(), fkFileId);
         xzLogMapper.insertNotNull(xzLog);
         return success();
     }
 }
