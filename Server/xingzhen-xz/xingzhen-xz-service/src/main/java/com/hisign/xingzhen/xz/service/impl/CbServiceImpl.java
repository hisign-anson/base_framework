package com.hisign.xingzhen.xz.service.impl;

import com.hisign.xingzhen.xz.api.model.CbModel;
import com.hisign.xingzhen.xz.mapper.CbMapper;
import com.hisign.xingzhen.xz.api.entity.Cb;
import com.hisign.xingzhen.xz.api.service.CbService;
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

 }