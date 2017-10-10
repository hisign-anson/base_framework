package com.hisign.framework.sys.api.service;

import java.util.List;

import com.hisign.framework.sys.api.model.SysMessage;

/**
 * 消息
 */
public interface SysMessageService {
    /**
     * 查询消息列表
     */
    public List<SysMessage> findSysMessageByFilter(SysMessage filter) throws Exception;

    /**
     * 查询消息详细信息
     */
    public SysMessage findSysMessage(SysMessage sysMessage) throws Exception;

    /**
     * 查询消息列表总数
     */
    public int findSysMessageByFilterForCount(SysMessage filter) throws Exception;

    /**
     * 将消息设为已读
     */
    public void setSysMessageRead(SysMessage sysMessage) throws Exception;

    /**
     * 删除消息
     */
    public void deleteSysMessageByIds(List<String> listId) throws Exception;

    /**
     * 假删除消息 update sys-receive-box del=1
     */
    public void deleteSysMessageByUser(SysMessage sysMessage) throws Exception;

    /**
     * 发送消息
     */
    public void sendMessage(SysMessage sysMessage) throws Exception;

    /**
     * 查询站内消息
     */
    public List<SysMessage> findZnxx(SysMessage sysMessage) throws Exception;
}
