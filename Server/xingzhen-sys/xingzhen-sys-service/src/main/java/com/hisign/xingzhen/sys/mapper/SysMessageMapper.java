package com.hisign.xingzhen.sys.mapper;

import java.util.List;

import com.hisign.xingzhen.sys.api.model.SysMessage;

/**
 * 消息查询
 */
public interface SysMessageMapper {

    /**
     * 查询收件箱列表
     */
    List<SysMessage> findSysMessageByFilter(SysMessage filter);

    /**
     * 查询消息详细信息
     */
    SysMessage findSysMessage(SysMessage sysMessage);

    /**
     * 查询收件箱列表总数
     */
    int findSysMessageByFilterForCount(SysMessage filter);

    /**
     * 收件箱设置已读标记
     */
    void setSysMessageRead(SysMessage sysMessage);

    /**
     * 删除sys-message数据
     * @param id
     */
    void deleteSysMessageById(String id);

    /**
     * 删除sys-receive-box数据
     */
    void deleteSysReceiveByMsgId(String id);

    /**
     * 假删除sys-receive-box的数据，update del=1
     */
    void deleteSysReceiveByUser(SysMessage sysMessage);

    /**
     * 发送消息 insert sys_message
     */
    void insertSysMessage(SysMessage sysMessage);

    /**
     * 发送消息 insert sys_receiver_box
     */
    void insertSysReceiverBox(SysMessage sysMessage);

    /**
     * 查询站内消息
     */
    List<SysMessage> findZnxxMessage(SysMessage sysMessage);

    /**
     * 查询站内消息接收人list
     */
    List<SysMessage> findZnxxReceivers(SysMessage sysMessage);
}


