
package com.hisign.xingzhen.sys.api.service;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.sys.api.model.ReceiveBox;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 《系统消息收件箱》 业务逻辑服务接口
 * @author 何建辉
 */
@FeignClient(name = "sysService",path = "/sys/receiveBoxService")
public interface ReceiveBoxService extends BaseService<ReceiveBox,ReceiveBox, String>{

	@RequestMapping(value = "/setRead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult setRead(@RequestBody String[] ids) throws BusinessException;

	@RequestMapping(value = "/delMsg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult delMsg(@RequestBody String[] ids) throws BusinessException;
}