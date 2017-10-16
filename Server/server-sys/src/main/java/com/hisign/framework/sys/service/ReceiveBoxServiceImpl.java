
package com.hisign.framework.sys.service;

import java.util.List;

import com.hisign.framework.sys.mapper.ReceiveBoxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hisign.bfun.benum.BaseEnum.BusinessExceptionEnum;
import com.hisign.bfun.benum.BaseEnum.IsInEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseMapper;
import com.hisign.bfun.bif.BaseServiceImpl;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.framework.common.constant.Constants.MessageStatus;
import com.hisign.framework.common.util.ListUtils;
import com.hisign.framework.sys.api.model.ReceiveBox;
import com.hisign.framework.sys.api.model.ReceiveBox.ReceiveBoxEnum;
import com.hisign.framework.sys.api.service.ReceiveBoxService;


/**
 * 《系统消息收件箱》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("receiveBoxService")
public class ReceiveBoxServiceImpl extends BaseServiceImpl<ReceiveBox,ReceiveBox, String> implements ReceiveBoxService{

	@Autowired
	protected ReceiveBoxMapper receiveBoxMapper;
	
	@Override
	protected BaseMapper<ReceiveBox,ReceiveBox, String> initMapper() {
		return receiveBoxMapper;
	}
	
	@Override
	@Transactional
	public JsonResult add(List<ReceiveBox> list) throws BusinessException {
		receiveBoxMapper.batchInsert(list);
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		receiveBoxMapper.updateCustom(params);
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		receiveBoxMapper.deleteByIds(ids);
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		receiveBoxMapper.deleteCustom(conditions);
		return JsonResultUtil.success();
	}
	
	
	@Transactional
	public JsonResult setRead(String[] ids)  throws BusinessException{
		try {
			UpdateParams updateParams = new UpdateParams(ReceiveBox.class);
			updateParams.add(ReceiveBoxEnum.msgState.get(), MessageStatus.STATUS_1);
			Conditions conn = new Conditions(null);
			List<Object> list = ListUtils.arr2List(ids);
			conn.createCriteria().add(ReceiveBoxEnum.id.get(), IsInEnum.IN,list);
			updateParams.setConditions(conn);
			receiveBoxMapper.updateCustom(updateParams);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.UPDATE,e);
		}
		return success();
	}

	@Transactional
	public JsonResult delMsg(String[] ids)  throws BusinessException{
		try {
			List<Object> list = ListUtils.arr2List(ids);
			Conditions conditions = new Conditions();
			conditions.createCriteria().add(ReceiveBoxEnum.id.get(), IsInEnum.IN,list);
			receiveBoxMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.UPDATE,e);
		}
		return success();
	}

}