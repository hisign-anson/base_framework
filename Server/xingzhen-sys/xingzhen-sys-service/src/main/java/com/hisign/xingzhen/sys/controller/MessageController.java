package com.hisign.xingzhen.sys.controller;

import com.hisign.bfun.benum.BaseEnum.ConditionEnum;
import com.hisign.bfun.benum.BaseEnum.DESCEnum;
import com.hisign.bfun.benum.BaseEnum.IsBTEnum;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.Conditions.Criteria;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.constant.CommonEnums.ErrorEnum;
import com.hisign.xingzhen.common.constant.Constants.IsDel;
import com.hisign.xingzhen.common.constant.Constants.MessageStatus;
import com.hisign.xingzhen.common.constant.Constants.MessageType;
import com.hisign.xingzhen.common.constant.Constants.ReceiveMessageType;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.common.util.ListUtils;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.sys.api.model.Message;
import com.hisign.xingzhen.sys.api.model.Message.MessageEnum;
import com.hisign.xingzhen.sys.api.model.ReceiveBox;
import com.hisign.xingzhen.sys.api.model.ReceiveBox.ReceiveBoxEnum;
import com.hisign.xingzhen.sys.api.model.SysOrgInfo;
import com.hisign.xingzhen.sys.api.service.MessageService;
import com.hisign.xingzhen.sys.api.service.ReceiveBoxService;
import com.hisign.xingzhen.sys.api.service.SysOrgInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/message")
@Api("消息接口")
public class MessageController extends BaseController {
	
	private Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	@Resource(name = "messageService")
	private MessageService messageService;
	
	@Autowired
	@Resource(name = "receiveBoxService")
	private ReceiveBoxService receiveBoxService;
	
	@Autowired
	private SysOrgInfoService sysOrgInfoService;
	
	@RequestMapping(value="add",method = RequestMethod.POST , produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "添加消息",httpMethod ="POST",response = JsonResult.class)
	public JsonResult add(@RequestBody Message message){
			return this.messageService.saveAndPush(message);
	}
	
	@RequestMapping(value="del",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "删除消息",httpMethod ="POST",response = JsonResult.class)
	public JsonResult del(@RequestBody Map<String, Object> map){
		@SuppressWarnings("unchecked")
		List<String> ids =  (List<String>) map.get("ids");
		ids.add(ids.get(0));
		return messageService.delByMessages(ListUtils.list2Array(ids));
	}
	
	@RequestMapping(value="update",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "修改消息",httpMethod ="POST",response = JsonResult.class)
	public JsonResult update(@RequestBody Message message){
		return messageService.updateAndPush(message);
	}
	
	@RequestMapping(value="findById",method = RequestMethod.GET)
	@ApiOperation(value = "根据id获取消息",httpMethod ="GET",response = JsonResult.class)
	public JsonResult findById(@RequestParam String id){
		Message message = messageService.getById(id);
		if (message==null) {
			return error("对不起,该记录不存在,请刷新页面再试");
		}
		if (StringUtils.isNotBlank(message.getDel()) && String.valueOf(IsDel.DEL_1).equals(message.getDel())) {
			return error("对不起,该通知公告已被删除");
		}
		return success(message);
	}
	

	@RequestMapping(value="findPage",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "消息分页",httpMethod ="POST",response = JsonResult.class)
	public JsonResult findPage(@RequestBody Message message){
		
		Conditions conditions = new Conditions(Message.class);
		Criteria criteria = conditions.createCriteria();
		//类型
		if (StringUtils.isNotBlank(message.getType())) {
			criteria.add(MessageEnum.type.get(), ConditionEnum.EQ,message.getType());
		}
		//标题
		if (StringUtils.isNotBlank(message.getSubject())) {
			criteria.add(MessageEnum.subject.get(), ConditionEnum.LIKE,"%"+message.getSubject()+"%");
		}
		//发布人
		if (StringUtils.isNotBlank(message.getRev2())) {
			criteria.add(MessageEnum.rev2.get(), ConditionEnum.LIKE,"%"+message.getRev2()+"%");
		}
		if(StringUtils.isNotBlank(message.getType()) && !String.valueOf(MessageType.TYPE_1).equals(message.getType())){
			//发布时间
			if (message.getStartTime()!=null) {
				criteria.add(MessageEnum.createDate.get(), IsBTEnum.BT ,message.getStartTime(),message.getEndTime());
			}
		}else {
			//发布时间
			if (message.getStartTime()!=null) {
				criteria.add(MessageEnum.rev3.get(), IsBTEnum.BT ,message.getStartTime(),message.getEndTime());
			}
		}
		
		//等级
		if (StringUtils.isNotBlank(message.getMsgLevel())) {
			criteria.add(MessageEnum.msgLevel.get(), ConditionEnum.EQ,message.getMsgLevel());
		}
		//未删除
		//criteria.add(MessageEnum.del.get(), ConditionEnum.NOTEQ, String.valueOf(IsDel.DEL_1));
		conditions.setLimit(message.getBegin(), message.getEnd());
		//排序
		conditions.setOrderByClause(new String[]{MessageEnum.createDate.get()},new DESCEnum[]{DESCEnum.DESC});
		//返回字段
		List<Message> list = messageService.getList(conditions);
		Long count = messageService.getCount(conditions);
		
		return success(count,list);
	}
	
	
	@RequestMapping(value="publish",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "发布消息",httpMethod ="POST",response = JsonResult.class)
	public JsonResult publish(@RequestBody Map<String, Object> map){
		
		String id = (String) map.get("id");
		String publishName = (String) map.get("publishName");
		String publishId = (String) map.get("publishId");
		@SuppressWarnings("unchecked")
		
		List<String> orgIds = map.get("orgIds")!=null? (List<String>) map.get("orgIds"):new ArrayList<String>();
		
		return messageService.publishMsg(id, publishId,publishName,orgIds);
	}
	
	
	@RequestMapping(value="findRePage",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "收件箱分页",httpMethod ="POST",response = JsonResult.class)
	public JsonResult findRePage(@RequestBody ReceiveBox box){
		String prefix = ReceiveBox.getTableName()+".";
		String mprefix = Message.getTableName()+".";
		Conditions conditions = new Conditions(ReceiveBox.class);
		Criteria criteria = conditions.createCriteria();
		
		//接收人
		if (StringUtils.isNotBlank(box.getReceiverId())) {
			criteria.add(ReceiveBoxEnum.receiverId.get(), ConditionEnum.EQ,box.getReceiverId());
		}
		//类型
		if (StringUtils.isNotBlank(box.getMsgState())) {
			criteria.add(ReceiveBoxEnum.msgState.get(), ConditionEnum.EQ,box.getMsgState());
		}
		//消息主题
		if (StringUtils.isNotBlank(box.getMsgId())) {
			criteria.add(MessageEnum.subject.get(), ConditionEnum.LIKE,"%"+box.getMsgId()+"%");
		}
		//接收时间
		if (box.getStartTime()!=null && box.getEndTime()!=null) {
			criteria.add(prefix+ReceiveBoxEnum.createDate.get(), IsBTEnum.BT ,box.getStartTime(),box.getEndTime());
		}
		if (!StringUtils.isNotBlank(box.getReceiverType())) {
			box.setReceiverType(String.valueOf(ReceiveMessageType.TYPE_1));
		}
		criteria.add(ReceiveBoxEnum.receiverType.get(), ConditionEnum.EQ,box.getReceiverType());
		//未删除
		criteria.add(prefix+ReceiveBoxEnum.del.get(), ConditionEnum.NOTEQ, String.valueOf(IsDel.DEL_1));
		conditions.setLimit(box.getBegin(), box.getEnd());
		//排序
		conditions.setOrderByClause(new String[]{ReceiveBoxEnum.msgState.get(),ReceiveBoxEnum.createDate.get()}, new DESCEnum[]{DESCEnum.ASC,DESCEnum.DESC});
		//连接message
		conditions.connectTable(Message.getTableName());
		//连接条件
		criteria.addConnCondition(ReceiveBoxEnum.msgId.get(),ConditionEnum.EQ,mprefix+MessageEnum.id.get());
		//返回字段
		conditions.setReturnFields(new String[]{prefix+ReceiveBoxEnum.msgId.get(),prefix+ReceiveBoxEnum.id.get(),prefix+ReceiveBoxEnum.msgState.get(),MessageEnum.subject.get()+" as "+ReceiveBoxEnum.rev1.get(),prefix+ReceiveBoxEnum.createDate.get()});
		List<ReceiveBox> list = receiveBoxService.getList(conditions);
		Long count = receiveBoxService.getCount(conditions);
		return success(count,list);
	}
	
	
	@RequestMapping(value="findReceivePage",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "收件箱分页",httpMethod ="POST",response = JsonResult.class)
	public JsonResult findReceivePage(@RequestBody ReceiveBox box){
		Conditions conditions = new Conditions(ReceiveBox.class);
		Criteria criteria = conditions.createCriteria();
		
		//接收人
		if (StringUtils.isNotBlank(box.getReceiverId())) {
			criteria.add(ReceiveBoxEnum.receiverId.get(), ConditionEnum.EQ,box.getReceiverId());
		}
		//接收人
		if (StringUtils.isNotBlank(box.getMsgContent())) {
			criteria.add(ReceiveBoxEnum.msgContent.get(), ConditionEnum.LIKE,"%"+box.getMsgContent()+"%");
		}
		//类型
		if (StringUtils.isNotBlank(box.getMsgState())) {
			criteria.add(ReceiveBoxEnum.msgState.get(), ConditionEnum.EQ,box.getMsgState());
		}
		//接收时间
		if (box.getStartTime()!=null && box.getEndTime()!=null) {
			criteria.add(ReceiveBoxEnum.createDate.get(), IsBTEnum.BT ,box.getStartTime(),box.getEndTime());
		}
		if (!StringUtils.isNotBlank(box.getReceiverType())) {
			box.setReceiverType(String.valueOf(ReceiveMessageType.TYPE_2));
		}
		criteria.add(ReceiveBoxEnum.receiverType.get(), ConditionEnum.EQ,box.getReceiverType());
		//未删除
		criteria.add(ReceiveBoxEnum.del.get(), ConditionEnum.NOTEQ, String.valueOf(IsDel.DEL_1));
		conditions.setLimit(box.getBegin(), box.getEnd());
		//排序
		conditions.setOrderByClause(new String[]{ReceiveBoxEnum.msgState.get(),ReceiveBoxEnum.createDate.get()}, new DESCEnum[]{DESCEnum.ASC,DESCEnum.DESC});
		//返回字段
		conditions.setReturnFields(new String[]{ReceiveBoxEnum.id.get(),ReceiveBoxEnum.msgContent.get(),ReceiveBoxEnum.msgState.get(),ReceiveBoxEnum.createDate.get()});
		List<ReceiveBox> list = receiveBoxService.getList(conditions);
		Long count = receiveBoxService.getCount(conditions);
		return success(count,list);
	}
	
	@RequestMapping(value="findReceivePageCount",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "收件箱数量",httpMethod ="POST",response = JsonResult.class)
	public JsonResult findReceivePageCount(@RequestBody ReceiveBox box){
		Conditions conditions = new Conditions(ReceiveBox.class);
		Criteria criteria = conditions.createCriteria();
		
		//接收人
		if (StringUtils.isNotBlank(box.getReceiverId())) {
			criteria.add(ReceiveBoxEnum.receiverId.get(), ConditionEnum.EQ,box.getReceiverId());
		}
		//类型
		if (StringUtils.isNotBlank(box.getMsgState())) {
			criteria.add(ReceiveBoxEnum.msgState.get(), ConditionEnum.EQ,box.getMsgState());
		}
		if (!StringUtils.isNotBlank(box.getReceiverType())) {
			box.setReceiverType(String.valueOf(ReceiveMessageType.TYPE_2));
		}
		criteria.add(ReceiveBoxEnum.receiverType.get(), ConditionEnum.EQ,box.getReceiverType());
		//未删除
		criteria.add(ReceiveBoxEnum.del.get(), ConditionEnum.NOTEQ, String.valueOf(IsDel.DEL_1));
		Long count = receiveBoxService.getCount(conditions);
		return success(count,null);
	}
	
	
	@RequestMapping(value="view",method = RequestMethod.GET , produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "查看消息",httpMethod ="GET",response = JsonResult.class)
	public JsonResult view(@RequestParam(required=true)String id){
		ReceiveBox box = receiveBoxService.getById(id);
		if (box!=null && StringUtils.isNotBlank(box.getMsgId())) {
			Message message = messageService.getById(box.getMsgId());
			if (message!=null) {
				box.setMessage(message);
			}
		}else {
			error(ErrorEnum.NOT_EXISTS.msg());
		}
		//修改为已读
		if (String.valueOf(MessageStatus.STATUS_0).equals(box.getMsgState())) {
			receiveBoxService.setRead(new String[]{id});
		}
		return success(box);
	}

	
	@RequestMapping(value="setRead",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "设置已读",httpMethod ="POST",response = JsonResult.class)
	public JsonResult setRead(@RequestBody Map<String, Object> map){
		
		@SuppressWarnings("unchecked")
		List<String> ids = (List<String>) map.get("ids");
		String userId = (String) map.get("userId");
		
		if (ListUtils.isEmpty(ids) || !StringUtils.isNotBlank(userId)) {
			return error(ErrorEnum.PARAM_ERROR.msg());
		}
		
		return receiveBoxService.setRead(ListUtils.list2Array(ids));
	}
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value="delRevMsgs",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "删除收件箱消息",httpMethod ="POST",response = JsonResult.class)
	public JsonResult delRevMsgs(@RequestBody Map<String, Object> map){
		
		List<String> ids = (List<String>) map.get("ids");
		
		return receiveBoxService.delMsg(ListUtils.list2Array(ids));
	}
	
	
	@RequestMapping(value="getUnSendOrg",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "根据消息id获取未发送单位",httpMethod ="GET",response = JsonResult.class)
	public JsonResult getUnSendOrg(@RequestParam String id){
		
		Conditions conditions = new Conditions();
		conditions.setDistinct(true);
		conditions.createCriteria().add(ReceiveBoxEnum.msgId.get(),ConditionEnum.EQ , id);
		conditions.setReturnFields(new String[]{ReceiveBoxEnum.msgId.get(),ReceiveBoxEnum.senderUnit.get()});
		//已发单位(处级)
		List<ReceiveBox> list = receiveBoxService.getList(conditions);
		List<String> orgIds = new ArrayList<String>();
		if (!CollectionUtils.isEmpty(list)) {
			for (ReceiveBox receiveBox : list) {
				if (StringUtils.isNotBlank(receiveBox.getSenderUnit())) {
					orgIds.add(receiveBox.getSenderUnit());
				}
			}
		}
		//未发单位（处级）
		List<SysOrgInfo> unSendList = sysOrgInfoService.getOrgNotIn(orgIds);
		return success(unSendList);
	}
	
	@RequestMapping(value="getSendedOrg",method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ApiOperation(value = "获取已发送单位",httpMethod ="GET",response = JsonResult.class)
	public JsonResult getSendedOrg(@RequestParam String id){
		
		Conditions conditions = new Conditions();
		conditions.setDistinct(true);
		conditions.createCriteria().add(ReceiveBoxEnum.msgId.get(),ConditionEnum.EQ , id);
		conditions.setReturnFields(new String[]{ReceiveBoxEnum.msgId.get(),ReceiveBoxEnum.senderUnit.get()});
		//已发单位(处级)
		List<ReceiveBox> list = receiveBoxService.getList(conditions);
		List<String> orgIds = new ArrayList<String>();
		if (!CollectionUtils.isEmpty(list)) {
			for (ReceiveBox receiveBox : list) {
				if (StringUtils.isNotBlank(receiveBox.getSenderUnit())) {
					orgIds.add(receiveBox.getSenderUnit());
				}
			}
			SysOrgInfo info = new SysOrgInfo();
			info.setOrgIds(orgIds);
			List<SysOrgInfo> sendedList = sysOrgInfoService.getOrgIn(orgIds);
			return success(sendedList);
		}
		return success(new ArrayList<String>());
	}
	
	@RequestMapping(value="/sendMsg")
	@ApiOperation(value = "发送短信",httpMethod ="GET",response = JsonResult.class)
	public JsonResult sendMsg(String url,String mobiles,String eAccount,String uAccount,String uPassword,String lang,String func,String data) throws Exception{
		StringBuilder sb = new StringBuilder();
		sb.append(url).append("?").append("func=").append(func).append("&eAccount=").append(eAccount).append("&uAccount=").append(uAccount).append("&uPassword=").append(uPassword).
		append("&lang=").append(lang).append("&smsMobiles=").append(mobiles).append("&smsData=").append(data);
		String content = get(sb.toString());
		logger.info("------------发送短信后返回："+content);
		return success();
	}
	
	private String get(String url) throws Exception{
		//实例化httpClient  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        
        //结果  
        CloseableHttpResponse response = null;  
        String content = null ;  
        //实例化get方法  
        logger.info("-----------url="+url);
        try {
			HttpGet httpGet = new HttpGet(url);
			response = httpclient.execute(httpGet);
		} catch (Exception e) {
			StringWriter sw = new StringWriter(); 
	        e.printStackTrace(new PrintWriter(sw, true)); 
			logger.error(sw.toString());
			return null;
		}  
        if(response.getStatusLine().getStatusCode()==200){  
            content = EntityUtils.toString(response.getEntity(),"utf-8");  
        }else{
        	throw new RuntimeException("Failed : HTTP error code : "+ response.getStatusLine().getStatusCode());
        }  
        return content;
	}
	
}
