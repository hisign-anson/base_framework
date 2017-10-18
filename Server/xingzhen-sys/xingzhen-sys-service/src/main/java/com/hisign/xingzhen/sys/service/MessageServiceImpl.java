
package com.hisign.xingzhen.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.hisign.xingzhen.sys.mapper.MessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hisign.bfun.benum.BaseEnum.BusinessExceptionEnum;
import com.hisign.bfun.benum.BaseEnum.ConditionEnum;
import com.hisign.bfun.benum.BaseEnum.IsInEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseMapper;
import com.hisign.bfun.bif.BaseServiceImpl;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.constant.CommonEnums.ErrorEnum;
import com.hisign.xingzhen.common.constant.Constants.IsPublish;
import com.hisign.xingzhen.common.constant.Constants.MessageLevel;
import com.hisign.xingzhen.common.constant.Constants.MessageType;
import com.hisign.xingzhen.common.constant.Constants.ReceiveMessageType;
import com.hisign.xingzhen.common.util.ListUtils;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.service.NtService;
import com.hisign.xingzhen.sys.api.model.Message;
import com.hisign.xingzhen.sys.api.model.Message.MessageEnum;
import com.hisign.xingzhen.sys.api.model.SysOrgInfo;
import com.hisign.xingzhen.sys.api.model.SysUser;
import com.hisign.xingzhen.sys.api.service.MessageService;
import com.hisign.xingzhen.sys.api.service.SysOrgInfoService;
import com.hisign.xingzhen.sys.api.service.SysUserService;


/**
 * 《系统消息》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message,Message, String> implements MessageService{
	private Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	private SysOrgInfoService sysOrgInfoService;
	@Autowired
	private NtService ntService;
	@Autowired
	private SysUserService sysUserService;
	
	@Override
	protected BaseMapper<Message,Message, String> initMapper() {
		return messageMapper;
	}
	
	
	@Override
	public JsonResult add(Message entity) throws BusinessException {
		if (org.apache.commons.lang.StringUtils.isBlank(entity.getType())) {
			entity.setType(String.valueOf(MessageType.TYPE_1));
		}
		if (!StringUtils.isNotBlank(entity.getMsgLevel())) {
			entity.setMsgLevel(String.valueOf(MessageLevel.LEVEL_2));
		}
		entity.setDel("0");
		entity.setSecrecy("0");
		return super.add(entity);
	}



	@Override
	@Transactional
	public JsonResult add(List<Message> list) throws BusinessException {
		try {
			messageMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			messageMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			messageMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			messageMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Transactional
	public JsonResult delByMessages(String[] ids) throws BusinessException {
		
		Conditions conditions = new Conditions();
		conditions.createCriteria()
		.add(MessageEnum.id.get(), IsInEnum.IN,ListUtils.arr2List(ids))
		.add(MessageEnum.rev4.get(),ConditionEnum.EQ,IsPublish.STATUS_0);
		
		try {
			messageMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.DELETE,e);
		}
		
		return JsonResultUtil.success();
	}
	
	/**
	 * 类名: MessageServiceImpl.java
	 * 描述: 发布通知公告
	 * 公司: 北京海鑫科金高科技股份有限公司
	 * 作者: 何建辉
	 * 版本: 
	 * 参数: @param id
	 * 参数: @return
	 * 创建时间: 2017年6月13日
	 * 最后修改时间: 2017年6月13日
	 */
	@Transactional
	public JsonResult publishMsg(String id,String publishId,String publishName,List<String> orgIds) throws BusinessException{
		Message message = getById(id);
		if (message==null) {
			return error(ErrorEnum.NOT_EXISTS.msg());
		}
		message.setRev4("1");//设置已发布
		message.setRev3(new Date());//设置发布时间
		message.setRev2(publishName); //设置发布人
		this.updateNotNull(message);
		try {
			MsgBean bean = new MsgBean();
			//发送消息公告
			bean.setMsgId(id);
			bean.setReceiverType(String.valueOf(ReceiveMessageType.TYPE_1));
			bean.setOrgIds(orgIds);
			bean.setPublishId(publishId);
			bean.setPublishName(publishName);
			ntService.sendMsg(bean);
		} catch (NoticeException e) {
			throw new BusinessException(BusinessExceptionEnum.DELETE,e);
		}
		
		return success();
	}


	@Override
	@Transactional
	public JsonResult saveAndPush(Message message) throws BusinessException {
		message.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		if("1".equals(message.getRev4())){
			message.setRev3(new Date());
		}else{
			message.setRev2(null);
		}
		JsonResult jsonResult = this.add(message);
		//发送消息
		this.pushMsg(message);
		
		return jsonResult;
	}


	@Override
	@Transactional
	public JsonResult updateAndPush(Message message) throws BusinessException {
		if("1".equals(message.getRev4())){
			message.setRev3(new Date());
		}else{
			message.setRev2(null);
		}
	    JsonResult jsonResult = this.updateNotNull(message);
	  //发送消息
	  	this.pushMsg(message);
	    return jsonResult;
	}
	
	/**
	 * 发送消息
	 * @param message
	 */
	private void pushMsg(Message message){
         if(String.valueOf(MessageType.TYPE_1).equals(message.getType()) && "1".equals(message.getRev4())){
			try {
				MsgBean bean = new MsgBean();
				//发送消息公告
				bean.setMsgId(message.getId());
				bean.setReceiverType(String.valueOf(ReceiveMessageType.TYPE_1));
				bean.setPublishId(message.getUserId());
				bean.setPublishName(message.getRev2());
				if("1".equals(message.getTslb())){//所有单位
					SysOrgInfo info = new SysOrgInfo();
					info.setStatus(0);
					List<SysOrgInfo> list = sysOrgInfoService.queryListByCondition(info);
					if(!CollectionUtils.isEmpty(list)){
						List<String> orgIds = new ArrayList<String>(list.size());
						for (SysOrgInfo orgInfo : list) {
							orgIds.add(orgInfo.getOrgId());
						}
						bean.setOrgIds(orgIds);
					}
					
				}else if("2".equals(message.getTslb())){//本单位
					List<String> orgIds = new ArrayList<String>(1);
					orgIds.add(message.getOrgId());
					bean.setOrgIds(orgIds);
				}else if("3".equals(message.getTslb())){//指定单位
					if(StringUtils.isNotBlank(message.getMsgVest())){
						JSONArray jsonArray = JSON.parseArray(message.getMsgVest());
						List<String> orgIds = new ArrayList<String>(jsonArray.size());
						for (int i = 0; i < jsonArray.size(); i++) {
							JSONObject jsonObject = jsonArray.getJSONObject(i);
							orgIds.add(jsonObject.getString("orgId"));
						}
						bean.setOrgIds(orgIds);
					}
				}else if("4".equals(message.getTslb())){//本单位人员
					if(StringUtils.isNotBlank(message.getMsgVest())){
						JSONArray jsonArray = JSON.parseArray(message.getMsgVest());
						List<String> userIds = new ArrayList<String>(jsonArray.size());
						for (int i = 0; i < jsonArray.size(); i++) {
							JSONObject jsonObject = jsonArray.getJSONObject(i);
							userIds.add(jsonObject.getString("userId"));
						}
						SysUser sysUser = new SysUser();
						sysUser.setUserIds(userIds);
						sysUser.setOpenFlag("1");
						List<SysUser> sysUsers = sysUserService.findSysUserListByUserFilter(sysUser);
						bean.setList(sysUsers);
					}
				}
				ntService.sendMsg(bean);
			} catch (Exception e) {
				logger.error("发布通知公告失败", e);
			}
			
		}
	}
}