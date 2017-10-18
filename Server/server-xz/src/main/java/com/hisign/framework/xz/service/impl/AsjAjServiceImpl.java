package com.hisign.framework.xz.service.impl;

import com.hisign.framework.xz.api.model.AsjAjModel;
import com.hisign.framework.xz.mapper.AsjAjMapper;
import com.hisign.framework.xz.api.entity.AsjAj;
import com.hisign.framework.xz.api.service.AsjAjService;
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
 * 《案件》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("asjAjService")
public class AsjAjServiceImpl extends BaseServiceImpl<AsjAj,AsjAjModel, String> implements AsjAjService{

	@Autowired
	protected AsjAjMapper asjAjMapper;
	
	@Override
	protected BaseMapper<AsjAj,AsjAjModel, String> initMapper() {
		return asjAjMapper;
	}
	
	@Override
	@Transactional
	public JsonResult add(List<AsjAj> list) throws BusinessException {
		try {
			asjAjMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			asjAjMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			asjAjMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			asjAjMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	 @Override
	 public JsonResult getAjGroupPage(AsjAj aj) {
		 List<AsjAjModel> list = asjAjMapper.getAjGroupPage(aj);
		 long count = asjAjMapper.getAjGroupPageCount(aj);
		 return JsonResultUtil.success(count,list);
	 }

	 @Override
	 public AsjAj getFirstCaseByGroupId(String id) {
		 return asjAjMapper.findFirstCaseByGroupId(id);
	 }


 }