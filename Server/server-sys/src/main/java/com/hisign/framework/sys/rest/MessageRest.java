package com.hisign.framework.sys.rest;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.framework.sys.api.model.Message;
import com.hisign.framework.sys.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sys/message")
@RestController
public class MessageRest extends BaseRest<Message, String, MessageService> implements MessageService {

    @Override
    @Autowired
    @Resource(name = "messageService")
    public void setBaseService(MessageService baseService) {
        super.setBaseService(baseService);
    }

    @Override
    @RequestMapping(value = "/delByMessages", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult delByMessages(@RequestBody String[] ids) throws BusinessException {
        return baseService.delByMessages(ids);
    }

    @Override
    @RequestMapping(value = "/publishMsg", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult publishMsg(@RequestParam String id,@RequestParam String publishId,@RequestParam String publishName,@RequestBody List<String> orgIds) throws BusinessException {
        return baseService.publishMsg(id,publishId,publishName,orgIds);
    }

    @Override
    @RequestMapping(value = "/saveAndPush", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult saveAndPush(@RequestBody Message message) throws BusinessException {
        return baseService.saveAndPush(message);
    }

    @Override
    @RequestMapping(value = "/updateAndPush", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult updateAndPush(@RequestBody Message message) throws BusinessException {
        return baseService.updateAndPush(message);
    }
}
