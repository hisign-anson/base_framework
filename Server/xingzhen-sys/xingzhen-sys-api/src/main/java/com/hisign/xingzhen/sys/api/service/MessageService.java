
package com.hisign.xingzhen.sys.api.service;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.sys.api.model.Message;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 《系统消息》 业务逻辑服务接口
 * @author 何建辉
 */
@FeignClient(name = "sysService",path = "/sys/messageService")
public interface MessageService extends BaseService<Message,Message, String>{

	@RequestMapping(value = "/delByMessages", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult delByMessages(@RequestBody String[] ids) throws BusinessException;

	@RequestMapping(value = "/publishMsg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult publishMsg(@RequestParam(value = "id") String id, @RequestParam(value = "publishId") String publishId, @RequestParam(value = "publishName") String publishName, @RequestBody List<String> orgIds) throws BusinessException;

	@RequestMapping(value = "/saveAndPush", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult saveAndPush(@RequestBody Message message) throws BusinessException;

	@RequestMapping(value = "/updateAndPush", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult updateAndPush(@RequestBody Message message) throws BusinessException;

}