package com.hisign.xingzhen.nt.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.util.ListUtils;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.nt.api.common.RespCode;
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.model.NoteBean;
import com.hisign.xingzhen.sys.api.model.ReceiveBox;
import com.hisign.xingzhen.sys.api.model.SysUser;
import com.hisign.xingzhen.sys.api.service.ReceiveBoxService;
import com.hisign.xingzhen.sys.api.service.SysUserService;

@Component("sendService")
@Configuration
public class SendService {
	private static final Logger logger = LoggerFactory.getLogger(SendService.class);
	
	@Value("${sms.url}")
	private String url;
	@Value("${sms.eAccount}")
	private String eAccount;
	@Value("${sms.uAccount}")
	private String uAccount;
	@Value("${sms.uPassword}")
	private String uPassword;
	@Value("${sms.lang}")
	private String lang;
	private String func = "send";
	
	@Autowired
    private ReceiveBoxService receiveBoxService;
	@Autowired
	private SysUserService sysUserService;
	
	public String sendSms(NoteBean note) throws NoticeException{
		if(note!=null){
			try {
				@SuppressWarnings("unchecked")
				List<String> list = (List<String>) note.getList();
				if(!CollectionUtils.isEmpty(list) && org.apache.commons.lang.StringUtils.isNotBlank(note.getMsgContent())){
					Map<String, String> postData = new HashMap<String, String>();
					postData.put("func", func);
					postData.put("eAccount", eAccount);
					postData.put("uAccount", uAccount);
					postData.put("uPassword", uPassword);
					postData.put("lang", lang);
					String smsMobiles = org.apache.commons.lang.StringUtils.join(list, ",");
					postData.put("smsMobiles", smsMobiles);
					JSONObject jsonObject = JSON.parseObject(note.getMsgContent());
					String smsData = jsonObject.getString("prefix")+jsonObject.getString("applyLevel")+ ","+jsonObject.getString("repayName")+jsonObject.getString("suffix");
					postData.put("smsData", smsData);
				
					String content = "";
					StringBuilder sb = new StringBuilder();
					sb.append(url).append("?").append("func=").append(func).append("&eAccount=").append(eAccount).append("&uAccount=").append(uAccount).append("&uPassword=").append(uPassword).
					append("&lang=").append(lang).append("&smsMobiles=").append(smsMobiles).append("&smsData=").append(note.getMsgContent());
					content = get(sb.toString());
					logger.debug("发送短信返回值11："+content);
					if(content == null){
						return RespCode.ERROR.name();
					}
					if (content.indexOf("-1")>0) {
						logger.debug("发送短信，登录失败");
						return RespCode.FAIL.name();
					}else if (content.indexOf("-1")>-2) {
						logger.debug("短信平台内部错误");
						return RespCode.ERROR.name();
					}
				}
			} catch (Exception e) {
				logger.debug("发送短信异常",e);
				throw new NoticeException(e.getMessage(), 0);
			}
		}
		return RespCode.SUCCESS.name();
	}
	
	public String sendMsg(MsgBean note) throws NoticeException{
		if(note!=null){
			try {
				List<ReceiveBox> list = createBoxListOfMsg(note);
				if(!CollectionUtils.isEmpty(list)){
					JsonResult r = receiveBoxService.add(list);
					if(r.getFlag() ==1 ){
						return RespCode.SUCCESS.name();
					}else{
						return RespCode.ERROR.name();
					}
				}
			} catch (Exception e) {
				logger.debug("发布信息异常", e);
				throw new NoticeException(e.getMessage(), 0);
			}
			
		}
		return RespCode.SUCCESS.name();
	}
	

	private List<ReceiveBox> createBoxListOfMsg(MsgBean note) {
		
		List<ReceiveBox> boxs = new ArrayList<ReceiveBox>();
		
		if (!ListUtils.isEmpty(note.getOrgIds())) {
			Map<String, List<String>> param = new HashMap<String, List<String>>();
			param.put("orgIds", note.getOrgIds());
			List<Map<String, Object>> receiverList = sysUserService.getReceiverList(param);
			
			for (Map<String, Object> map : receiverList) {
				ReceiveBox box = new ReceiveBox();
				box.setModifyPid(note.getPublishId());
				box.setCreatePid(note.getPublishId());
				if (!StringUtils.isNotBlank(note.getMsgId())) {
					box.setMsgId("-1");
				}else{
					box.setMsgId(note.getMsgId());
				}
				box.setReceiverId((String)map.get("USERNAME"));
				box.setReceiverName((String)map.get("TRUE_NAME"));
				box.setReceiverType(note.getReceiverType()); //消息类型
				box.setSenderId(note.getPublishId());
				box.setMsgState(String.valueOf(Constants.MessageStatus.STATUS_0));
				box.setSenderName(note.getPublishName());
				box.setSenderUnit((String)map.get("ORG_ID"));
				box.setDel(String.valueOf(Constants.IsDel.DEL_0));
				box.setSecrecy("0");
				//消息内容
				if (StringUtils.isNotBlank(note.getMsgContent())) {
					box.setMsgContent(note.getMsgContent());
				}
				boxs.add(box);
			}
		}
		if (!ListUtils.isEmpty(note.getList())) {
			@SuppressWarnings("unchecked")
			List<JSONObject> list = (List<JSONObject>) note.getList();
			for (JSONObject obj : list) {
				if(obj!=null){
					SysUser sysUser = JSON.toJavaObject(obj, SysUser.class);
					ReceiveBox box = new ReceiveBox();
					if (!StringUtils.isNotBlank(note.getPublishId())) {
						box.setModifyPid("admin");
						box.setCreatePid("admin");
						box.setSenderId("admin");
					}else{
						box.setModifyPid(note.getPublishId());
						box.setCreatePid(note.getPublishId());
						box.setSenderId(note.getPublishId());
					}
					
					if (!StringUtils.isNotBlank(note.getMsgId())) {
						box.setMsgId("-1");
					}else{
						box.setMsgId(note.getMsgId());
					}
					box.setReceiverId(sysUser.getUserName());
					box.setReceiverName(sysUser.getTrueName());
					box.setReceiverType(note.getReceiverType()); //消息类型
					box.setMsgState(String.valueOf(Constants.MessageStatus.STATUS_0));
					box.setSenderName(note.getPublishName());
					box.setDel(String.valueOf(Constants.IsDel.DEL_0));
					box.setSecrecy("0");
					//消息内容
					if (StringUtils.isNotBlank(note.getMsgContent())) {
						box.setMsgContent(note.getMsgContent());
					}
					boxs.add(box);
				}
			}
		}
		
		return boxs;
	}
	
	private String post(String url,Map<String, String> params) throws Exception{
		//实例化httpClient  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        //实例化post方法  
        HttpPost httpPost = new HttpPost(url);   
        //处理参数  
        List<NameValuePair> nvps = new ArrayList <NameValuePair>();    
        Set<String> keySet = params.keySet();    
        for(String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }    
        //结果  
        CloseableHttpResponse response = null;  
        String content = null ;  
        //提交的参数  
        UrlEncodedFormEntity uefEntity  = new UrlEncodedFormEntity(nvps, "UTF-8");  
        //将参数给post方法  
        httpPost.setEntity(uefEntity);
        //执行post方法  
        response = httpclient.execute(httpPost);  
        if(response.getStatusLine().getStatusCode()==200){  
            content = EntityUtils.toString(response.getEntity(),"utf-8");  
        }else{
        	throw new RuntimeException("Failed : HTTP error code : "+ response.getStatusLine().getStatusCode());
        }  
        return content;
	}
	
	
	private String get(String url,Map<String, String> params) throws Exception{
		//实例化httpClient  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        
        //结果  
        CloseableHttpResponse response = null;  
        String content = "" ;  
        //执行get方法  
        Set<String> keySet = params.keySet();    
        StringBuilder sb = new StringBuilder();
        sb.append(url).append("?");
        for(String key : keySet) {
        	sb.append(key).append("=").append(params.get(key)).append("&");
        }
        url = sb.toString().substring(0, sb.toString().length()-1);
        //实例化get方法  
        logger.debug("-----------url="+url);
        HttpGet httpGet = new HttpGet(url);
        response = httpclient.execute(httpGet);  
        if(response.getStatusLine().getStatusCode()==200){  
            content = EntityUtils.toString(response.getEntity(),"utf-8");  
        }else{
        	logger.debug("------发送短信异常："+response.getStatusLine().getStatusCode());
        	logger.debug("------发送短信异常response："+response);
        }  
        return content;
	}
	
	private String get(String url) throws Exception{
		//实例化httpClient  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        
        //结果  
        CloseableHttpResponse response = null;  
        String content = "" ;  
        //实例化get方法  
        logger.debug("-----------url="+url);
        try {
			HttpGet httpGet = new HttpGet(url);
			response = httpclient.execute(httpGet);
		} catch (Exception e) {
			StringWriter sw = new StringWriter(); 
	        e.printStackTrace(new PrintWriter(sw, true)); 
			logger.error(sw.toString());
			return content;
		}  
        if(response.getStatusLine().getStatusCode()==200){  
            content = EntityUtils.toString(response.getEntity(),"utf-8");  
        }else{
        	logger.debug("------发送短信异常："+response.getStatusLine().getStatusCode());
        	logger.debug("------发送短信异常response："+response);
        }  
        return content;
	}
	
	public static void main(String[] args) throws Exception {
//		get("http://127.0.0.1:8090/sys/message/findById?id=33B566C264F84F62807E9248198DE3C5", null);
	}

}
