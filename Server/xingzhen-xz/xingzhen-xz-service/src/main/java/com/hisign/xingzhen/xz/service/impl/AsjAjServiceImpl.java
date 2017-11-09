package com.hisign.xingzhen.xz.service.impl;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseMapper;
import com.hisign.bfun.bif.BaseServiceImpl;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.xz.api.entity.AsjAj;
import com.hisign.xingzhen.xz.api.model.AsjAjModel;
import com.hisign.xingzhen.xz.api.param.AsjAjParam;
import com.hisign.xingzhen.xz.api.service.AsjAjService;
import com.hisign.xingzhen.xz.mapper.AsjAjMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
	@Transactional(rollbackFor = Exception.class)
	public JsonResult add(List<AsjAj> list) throws BusinessException {
		try {
			asjAjMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			asjAjMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			asjAjMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			asjAjMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	 @Override
	 public JsonResult getAjGroupPage(AsjAjParam param) {
		 List<AsjAjModel> list = asjAjMapper.findAjGroupPage(param);
		 long count = asjAjMapper.findAjGroupPageCount(param);
		 return JsonResultUtil.success(count,list);
	 }

	 @Override
	 public AsjAjModel getById(String id) {
		 return super.getById(id);
	 }

	 @Override
	 public AsjAjModel getFirstCaseByGroupId(String id) {
		 return asjAjMapper.findFirstCaseByGroupId(id);
	 }

	 @Override
	 public AsjAjModel getCaseById(String id) {
		 return asjAjMapper.findCaseById(id);
	 }
 }