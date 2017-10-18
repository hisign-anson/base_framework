package com.hisign.xingzhen.xz.service.impl;

import com.hisign.xingzhen.xz.api.model.AjgroupModel;
import com.hisign.xingzhen.xz.mapper.AjgroupMapper;
import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.xingzhen.xz.api.service.AjgroupService;
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
 * 《案件专案组关联》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("ajgroupService")
public class AjgroupServiceImpl extends BaseServiceImpl<Ajgroup,AjgroupModel, String> implements AjgroupService{

	@Autowired
	protected AjgroupMapper ajgroupMapper;
	
	@Override
	protected BaseMapper<Ajgroup,AjgroupModel, String> initMapper() {
		return ajgroupMapper;
	}
	
	@Override
	@Transactional
	public JsonResult add(List<Ajgroup> list) throws BusinessException {
		try {
			ajgroupMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			ajgroupMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			ajgroupMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			ajgroupMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

}