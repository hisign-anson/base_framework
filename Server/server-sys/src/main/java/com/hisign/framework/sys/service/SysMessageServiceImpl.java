package com.hisign.framework.sys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.util.StringUtil;
import com.hisign.framework.sys.api.model.SysMessage;
import com.hisign.framework.sys.api.service.SysMessageService;
import com.hisign.framework.sys.mapper.SysMessageMapper;

/**
 * 消息
 */
@Service("sysMessageService")
public class SysMessageServiceImpl implements SysMessageService {
    @Resource
    private SysMessageMapper sysMessageMapper;

    /**
     * 查询消息列表
     * @param filter
     * @return
     */
    @Override
    public List<SysMessage> findSysMessageByFilter(SysMessage filter)  throws Exception{
        filter.setNoTslbSql(getTslbSql(filter.getNoTslb()));
        return sysMessageMapper.findSysMessageByFilter(filter);
    }

    /**
     * 查询消息详细信息
     */
    @Override
    public SysMessage findSysMessage(SysMessage sysMessage) throws Exception{
        return sysMessageMapper.findSysMessage(sysMessage);
    }

    /**
     * 查询消息列表总数
     */
    @Override
    public int findSysMessageByFilterForCount(SysMessage filter)  throws Exception{
        filter.setNoTslbSql(getTslbSql(filter.getNoTslb()));
        return sysMessageMapper.findSysMessageByFilterForCount(filter);
    }

    /**
     * 将消息设为已读
     * @param sysMessage
     */
    @Override
    public void setSysMessageRead(SysMessage sysMessage) throws Exception{
        if(sysMessage.getListId()!=null){
            for(String id : sysMessage.getListId()){
                sysMessage.setId(id);
                sysMessageMapper.setSysMessageRead(sysMessage);
            }
        }
    }

    /**
     * 删除消息
     * @param listId
     */
    @Override
    public void deleteSysMessageByIds(List<String> listId)  throws Exception{
        if(listId!=null){
            for(String id : listId){
                sysMessageMapper.deleteSysMessageById(id);
                sysMessageMapper.deleteSysReceiveByMsgId(id);
            }
        }
    }

    /**
     * 假删除消息 update sys-receive-box del=1
     * @param sysMessage
     * @throws Exception
     */
    @Override
    public void deleteSysMessageByUser(SysMessage sysMessage) throws Exception{
        SysMessage message = new SysMessage();
        if(sysMessage.getListId()!=null){
            for(String id : sysMessage.getListId()){
                message.setId(id);
                sysMessageMapper.deleteSysReceiveByUser(message);
            }
        }
    }

    /**
     * 发送消息
     * @param sysMessage
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendMessage(SysMessage sysMessage) throws Exception{
        List<SysMessage> list = sysMessage.getReceiverList(); //获取收件人列表
        SysMessage message;
        String msgId = UUID.randomUUID().toString().replaceAll("-","").toUpperCase(); //生成消息表的id sys_message的id
        sysMessage.setId(msgId);

        if(list != null && list.size() > 0) {
            //向消息表插入消息内容 sys_message
            sysMessageMapper.insertSysMessage(sysMessage);

            for(SysMessage msg : list){
                message = new SysMessage();
                message.setMsgId(msgId);//msg_id
                message.setReceiverId(msg.getReceiverId());//receiver_id
                message.setReceiverName(msg.getReceiverName());//receiver_name
                message.setSenderId(msg.getSenderId());//sender_id
                message.setSenderName(msg.getSenderName());//sender_name

                //向消息收件箱表插入消息接收人信息 sys_receiver_box
                sysMessageMapper.insertSysReceiverBox(message);
            }
        }

    }

    /**
     * 查询站内消息
     * @param sysMessage
     * @return
     */
    @Override
    public List<SysMessage> findZnxx(SysMessage sysMessage){
        List<SysMessage> message = new ArrayList<SysMessage>();
        List<SysMessage> receiverList = new ArrayList<SysMessage>();
        message = sysMessageMapper.findZnxxMessage(sysMessage);
        for(SysMessage msg : message){
            msg.setMsgId(msg.getId());
            receiverList = sysMessageMapper.findZnxxReceivers(msg);
            msg.setReceiverList(receiverList);

            //设置发送人姓名
            if(StringUtil.isEmpty(msg.getSenderName()) && receiverList != null && receiverList.size() > 0){
                msg.setSenderName(receiverList.get(0).getSenderName());
            }
        }
        return message;
    }

    /**
     * 获取右下角不需要弹出的消息类型
     */
    public String getTslbSql(List<String> noTslb){
        if(noTslb != null && noTslb.size() > 0){
            StringBuffer noTslbSql = new StringBuffer();;
            noTslbSql.append("(");
            for(String tslb : noTslb){
                noTslbSql.append("'"+tslb+"',");
            }
            noTslbSql.deleteCharAt(noTslbSql.toString().lastIndexOf(',')).append(")");
            return noTslbSql.toString();
        }
        return null;
    }
}
