
package com.hisign.shuwu.sys.api.service;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.shuwu.sys.api.model.ReceiveBox;

 /**
 * 《系统消息收件箱》 业务逻辑服务接口
 * @author 何建辉
 */
public interface ReceiveBoxService extends BaseService<ReceiveBox, String>{

	public JsonResult setRead(String[] ids) throws BusinessException;
	
	public JsonResult delMsg(String[] ids) throws BusinessException;
}