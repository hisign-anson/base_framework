
package com.hisign.framework.sys.api.service;

import java.util.List;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.framework.sys.api.model.Message;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 《系统消息》 业务逻辑服务接口
 * @author 何建辉
 */
@FeignClient(name = "sysService")
public interface MessageService extends BaseService<Message, String>{

	@RequestMapping(value = "/delByMessages", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult delByMessages(@RequestBody String[] ids) throws BusinessException;

	@RequestMapping(value = "/publishMsg", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult publishMsg(@RequestParam(value = "id") String id, @RequestParam(value = "publishId") String publishId, @RequestParam(value = "publishName") String publishName, @RequestBody List<String> orgIds) throws BusinessException;

	@RequestMapping(value = "/saveAndPush", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult saveAndPush(@RequestBody Message message) throws BusinessException;

	@RequestMapping(value = "/updateAndPush", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult updateAndPush(@RequestBody Message message) throws BusinessException;

}