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
import com.hisign.xingzhen.xz.api.entity.Cb;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.model.CbModel;
import com.hisign.xingzhen.xz.api.service.CbService;
import com.hisign.xingzhen.xz.mapper.CbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 《催办记录》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("cbService")
public class CbServiceImpl extends BaseServiceImpl<Cb,CbModel, String> implements CbService{

	@Autowired
	protected CbMapper cbMapper;
	
	@Override
	protected BaseMapper<Cb,CbModel, String> initMapper() {
		return cbMapper;
	}
	
	@Override
	@Transactional
	public JsonResult add(List<Cb> list) throws BusinessException {
		try {
			cbMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			cbMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			cbMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			cbMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

     @Override
     public JsonResult addCb(Cb cb) {
         Date now=new Date();
         cb.setId(UUID.randomUUID().toString());
         cb.setCreatetime(now);
         cb.setLastupdatetime(now);
         cb.setDeleteflag(Constants.DELETE_FALSE);
         Task task=new Task();
         task.setId(cb.getTaskid());
         task.setCbzt("1");
         task.setLastupdatetime(now);
         return super.addNotNull(cb);
     }
 }