package com.hisign.xingzhen.sys.api.service;

import com.hisign.xingzhen.sys.api.model.SysMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 消息
 */
@FeignClient(value = "sysService",path = "/sys/sysMessageService")
public interface SysMessageService {
    /**
     * 查询消息列表
     */
    @RequestMapping(value = "/findSysMessageByFilter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysMessage> findSysMessageByFilter(@RequestBody SysMessage filter) throws Exception;

    /**
     * 查询消息详细信息
     */
    @RequestMapping(value = "/findSysMessage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysMessage findSysMessage(@RequestBody SysMessage sysMessage) throws Exception;

    /**
     * 查询消息列表总数
     */
    @RequestMapping(value = "/findSysMessageByFilterForCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int findSysMessageByFilterForCount(@RequestBody SysMessage filter) throws Exception;

    /**
     * 将消息设为已读
     */
    @RequestMapping(value = "/setSysMessageRead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void setSysMessageRead(@RequestBody SysMessage sysMessage) throws Exception;

    /**
     * 删除消息
     */
    @RequestMapping(value = "/deleteSysMessageByIds", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteSysMessageByIds(@RequestBody List<String> listId) throws Exception;

    /**
     * 假删除消息 update sys-receive-box del=1
     */
    @RequestMapping(value = "/deleteSysMessageByUser", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteSysMessageByUser(@RequestBody SysMessage sysMessage) throws Exception;

    /**
     * 发送消息
     */
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void sendMessage(@RequestBody SysMessage sysMessage) throws Exception;

    /**
     * 查询站内消息
     */
    @RequestMapping(value = "/findZnxx", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysMessage> findZnxx(@RequestBody SysMessage sysMessage) throws Exception;
}
