
package com.hisign.shuwu.sys.api.service;

import java.util.List;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.shuwu.sys.api.model.Message;

 /**
 * 《系统消息》 业务逻辑服务接口
 * @author 何建辉
 */
public interface MessageService extends BaseService<Message, String>{
	
	public JsonResult delByMessages(String[] ids) throws BusinessException;
	
	public JsonResult publishMsg(String id, String publishId, String publishName, List<String> orgIds) throws BusinessException;

	public JsonResult saveAndPush(Message message) throws BusinessException;

	public JsonResult updateAndPush(Message message) throws BusinessException;

}