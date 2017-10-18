package com.hisign.xingzhen.sys.rest;

import com.hisign.xingzhen.sys.api.model.SysMessage;
import com.hisign.xingzhen.sys.api.service.SysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sys/sysMessageService")
@RestController
public class SysMessageRest implements SysMessageService {

    @Autowired
    @Resource(name = "sysMessageService")
    private SysMessageService sysMessageService;

    @Override
    @RequestMapping(value = "/findSysMessageByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysMessage> findSysMessageByFilter(@RequestBody SysMessage filter) throws Exception {
        return sysMessageService.findSysMessageByFilter(filter);
    }

    @Override
    @RequestMapping(value = "/findSysMessage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysMessage findSysMessage(@RequestBody SysMessage sysMessage) throws Exception {
        return sysMessageService.findSysMessage(sysMessage);
    }

    @Override
    @RequestMapping(value = "/findSysMessageByFilterForCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int findSysMessageByFilterForCount(@RequestBody SysMessage filter) throws Exception {
        return sysMessageService.findSysMessageByFilterForCount(filter);
    }

    @Override
    @RequestMapping(value = "/setSysMessageRead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void setSysMessageRead(@RequestBody SysMessage sysMessage) throws Exception {
        sysMessageService.setSysMessageRead(sysMessage);
    }

    @Override
    @RequestMapping(value = "/deleteSysMessageByIds", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteSysMessageByIds(@RequestBody List<String> listId) throws Exception {
        sysMessageService.deleteSysMessageByIds(listId);
    }

    @Override
    @RequestMapping(value = "/deleteSysMessageByUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteSysMessageByUser(@RequestBody SysMessage sysMessage) throws Exception {
        sysMessageService.deleteSysMessageByUser(sysMessage);
    }

    @Override
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void sendMessage(@RequestBody SysMessage sysMessage) throws Exception {
        sysMessageService.sendMessage(sysMessage);
    }

    @Override
    @RequestMapping(value = "/findZnxx", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysMessage> findZnxx(@RequestBody SysMessage sysMessage) throws Exception {
        return sysMessageService.findZnxx(sysMessage);
    }
}
