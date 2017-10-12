package com.hisign.framework.xz.service.impl;

import com.hisign.framework.xz.mapper.UsergroupMapper;
import com.hisign.framework.xz.api.entity.Usergroup;
import com.hisign.framework.xz.api.service.UsergroupService;
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
 * 《人员专案组关联》 业务逻辑服务类
 * @author xhh
 *
 */
@Service("usergroupService")
public class UsergroupServiceImpl extends BaseServiceImpl<Usergroup, String> implements UsergroupService{

	@Autowired
	protected UsergroupMapper usergroupMapper;
	
	@Override
	protected BaseMapper<Usergroup, String> initMapper() {
		return usergroupMapper;
	}
	
	@Override
	@Transactional
	public JsonResult add(List<Usergroup> list) throws BusinessException {
		try {
			usergroupMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			usergroupMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			usergroupMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			usergroupMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

}