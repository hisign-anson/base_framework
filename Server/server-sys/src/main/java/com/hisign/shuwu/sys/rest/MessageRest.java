package com.hisign.shuwu.sys.rest;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import com.hisign.shuwu.sys.api.model.Message;
import com.hisign.shuwu.sys.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sys/messageService")
@RestController
public class MessageRest implements MessageService {

    @Autowired
    @Resource(name = "messageService")
    private MessageService messageService;


    @Override
    @RequestMapping(value = "/delByMessages", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delByMessages(@RequestBody String[] ids) throws BusinessException {
        return messageService.delByMessages(ids);
    }

    @Override
    @RequestMapping(value = "/publishMsg", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult publishMsg(@RequestParam String id,@RequestParam String publishId,@RequestParam String publishName,@RequestBody List<String> orgIds) throws BusinessException {
        return messageService.publishMsg(id,publishId,publishName,orgIds);
    }

    @Override
    @RequestMapping(value = "/saveAndPush", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult saveAndPush(@RequestBody Message message) throws BusinessException {
        return messageService.saveAndPush(message);
    }

    @Override
    @RequestMapping(value = "/updateAndPush", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateAndPush(@RequestBody Message message) throws BusinessException {
        return messageService.updateAndPush(message);
    }

    @Override
    @RequestMapping(value = "/addSingle", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult add(@RequestBody Message entity) throws BusinessException {
        return messageService.add(entity);
    }

    @Override
    @RequestMapping(value = "/addNotNull", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addNotNull(@RequestBody Message entity) throws BusinessException {
        return messageService.addNotNull(entity);
    }

    @Override
    @RequestMapping(value = "/addList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult add(@RequestBody List<Message> list) throws BusinessException {
        return messageService.add(list);
    }

    @Override
    @RequestMapping(value = "/updateSingle", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult update(@RequestBody Message entity) throws BusinessException {
        return messageService.update(entity);
    }

    @Override
    @RequestMapping(value = "/updateNotNull", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateNotNull(@RequestBody Message entity) throws BusinessException {
        return messageService.updateNotNull(entity);
    }

    @Override
    @RequestMapping(value = "/updateBatch", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateBatch(@RequestBody List<Message> entity) throws BusinessException {
        return messageService.updateBatch(entity);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult update(@RequestBody UpdateParams params) throws BusinessException {
        return messageService.update(params);
    }

    @Override
    @RequestMapping(value = "/delById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delById(@RequestParam String id) throws BusinessException {
        return messageService.delById(id);
    }

    @Override
    @RequestMapping(value = "/delByIds", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delByIds(@RequestBody List<String> ids) throws BusinessException {
        return messageService.delByIds(ids);
    }

    @Override
    @RequestMapping(value = "/delBy", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delBy(@RequestBody Conditions conditions) throws BusinessException {
        return messageService.delBy(conditions);
    }

    @Override
    @RequestMapping(value = "/getById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Message getById(@RequestParam String id) {
        return messageService.getById(id);
    }

    @Override
    @RequestMapping(value = "/getByEntity", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Message getByEntity(@RequestBody Message entity) {
        return messageService.getByEntity(entity);
    }

    @Override
    @RequestMapping(value = "/getList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<Message> getList(@RequestBody Conditions conditions) {
        return messageService.getList(conditions);
    }

    @Override
    @RequestMapping(value = "/getBy", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Message getBy(@RequestBody Conditions conditions) {
        return messageService.getBy(conditions);
    }

    @Override
    @RequestMapping(value = "/getCount", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Long getCount(@RequestBody Conditions conditions) {
        return messageService.getCount(conditions);
    }

    @Override
    @RequestMapping(value = "/getPage", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getPage(@RequestBody Conditions conditions) {
        return messageService.getPage(conditions);
    }
}
