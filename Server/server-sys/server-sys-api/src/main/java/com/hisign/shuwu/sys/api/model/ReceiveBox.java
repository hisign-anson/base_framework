
package com.hisign.shuwu.sys.api.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.hisign.bfun.bannotation.Column;
import com.hisign.bfun.bannotation.PK;
import com.hisign.bfun.bannotation.Table;
import com.hisign.shuwu.common.model.BaseModel;

/**
 * 《系统消息收件箱》 实体
 * @author 何建辉
 *
 */
@Table(value="sys_receive_box")
public class ReceiveBox extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PK(value="ID")
	private String id; //主键
	
	@Column(value="MSG_ID")
	private String msgId; //消息ID
	
	@Column(value="SENDER_NAME")
	private String senderName; //发送人真实姓名
	
	@Column(value="SENDER_ID")
	private String senderId; //发送人登录账户
	
	@Column(value="RECEIVER_ID")
	private String receiverId; //收件人登录账户
	
	@Column(value="RECEIVER_NAME")
	private String receiverName; //接收人真实姓名
	
	@Column(value="RECEIVER_TYPE")
	private String receiverType; //接收人类型(不使用)
	
	@Column(value="MSG_STATE")
	private String msgState; //消息状态 0未读 1 已读
	
	@Column(value="DEL")
	private String del; //是否删除 0正常 1 删除
	
	@Column(value="SECRECY")
	private String secrecy; //密级
	
	@Column(value="CREATE_DATE")
	private Date createDate; //录入时间
	
	@Column(value="CREATE_PID")
	private String createPid; //录入员姓名
	
	@Column(value="MODIFY_DATE")
	private Date modifyDate; //修改时间
	
	@Column(value="MODIFY_PID")
	private String modifyPid; //修改人员姓名
	
	@Column(value="REV1")
	private String rev1; //保留字段1
	
	@Column(value="REV2")
	private String rev2; //保留字段2
	
	@Column(value="REV3")
	private String rev3; //保留字段3
	
	@Column(value="REV4")
	private String rev4; //保留字段4
	
	@Column(value="SENDER_UNIT")
	private String senderUnit; //发送人单位
	
	@Column(value="MSG_CONTENT")
	private String msgContent; //消息内容
	
	private Message message;
    
	/**
	 *默认空构造函数
	 */
	public ReceiveBox() {
		super();
	}
	 
	/**
	 * @return ID 主键
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID 主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @return MSG_ID 消息ID
	 */
	public String getMsgId(){
		return this.msgId;
	}
	/**
	 * @param MSG_ID 消息ID
	 */
	public void setMsgId(String msgId){
		this.msgId = msgId;
	}
	/**
	 * @return SENDER_NAME 发送人真实姓名
	 */
	public String getSenderName(){
		return this.senderName;
	}
	/**
	 * @param SENDER_NAME 发送人真实姓名
	 */
	public void setSenderName(String senderName){
		this.senderName = senderName;
	}
	/**
	 * @return SENDER_ID 发送人登录账户
	 */
	public String getSenderId(){
		return this.senderId;
	}
	/**
	 * @param SENDER_ID 发送人登录账户
	 */
	public void setSenderId(String senderId){
		this.senderId = senderId;
	}
	/**
	 * @return RECEIVER_ID 收件人登录账户
	 */
	public String getReceiverId(){
		return this.receiverId;
	}
	/**
	 * @param RECEIVER_ID 收件人登录账户
	 */
	public void setReceiverId(String receiverId){
		this.receiverId = receiverId;
	}
	/**
	 * @return RECEIVER_NAME 接收人真实姓名
	 */
	public String getReceiverName(){
		return this.receiverName;
	}
	/**
	 * @param RECEIVER_NAME 接收人真实姓名
	 */
	public void setReceiverName(String receiverName){
		this.receiverName = receiverName;
	}
	/**
	 * @return RECEIVER_TYPE 接收人类型(不使用)
	 */
	public String getReceiverType(){
		return this.receiverType;
	}
	/**
	 * @param RECEIVER_TYPE 接收人类型(不使用)
	 */
	public void setReceiverType(String receiverType){
		this.receiverType = receiverType;
	}
	/**
	 * @return MSG_STATE 消息状态
	 */
	public String getMsgState(){
		return this.msgState;
	}
	/**
	 * @param MSG_STATE 消息状态
	 */
	public void setMsgState(String msgState){
		this.msgState = msgState;
	}
	/**
	 * @return DEL 是否删除
	 */
	public String getDel(){
		return this.del;
	}
	/**
	 * @param DEL 是否删除
	 */
	public void setDel(String del){
		this.del = del;
	}
	/**
	 * @return SECRECY 密级
	 */
	public String getSecrecy(){
		return this.secrecy;
	}
	/**
	 * @param SECRECY 密级
	 */
	public void setSecrecy(String secrecy){
		this.secrecy = secrecy;
	}
	/**
	 * @return CREATE_DATE 录入时间
	 */
	public Date getCreateDate(){
		return this.createDate;
	}
	/**
	 * @param CREATE_DATE 录入时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 * @return CREATE_PID 录入员姓名
	 */
	public String getCreatePid(){
		return this.createPid;
	}
	/**
	 * @param CREATE_PID 录入员姓名
	 */
	public void setCreatePid(String createPid){
		this.createPid = createPid;
	}
	/**
	 * @return MODIFY_DATE 修改时间
	 */
	public Date getModifyDate(){
		return this.modifyDate;
	}
	/**
	 * @param MODIFY_DATE 修改时间
	 */
	public void setModifyDate(Date modifyDate){
		this.modifyDate = modifyDate;
	}
	/**
	 * @return MODIFY_PID 修改人员姓名
	 */
	public String getModifyPid(){
		return this.modifyPid;
	}
	/**
	 * @param MODIFY_PID 修改人员姓名
	 */
	public void setModifyPid(String modifyPid){
		this.modifyPid = modifyPid;
	}
	/**
	 * @return REV1 保留字段1
	 */
	public String getRev1(){
		return this.rev1;
	}
	/**
	 * @param REV1 保留字段1
	 */
	public void setRev1(String rev1){
		this.rev1 = rev1;
	}
	/**
	 * @return REV2 保留字段2
	 */
	public String getRev2(){
		return this.rev2;
	}
	/**
	 * @param REV2 保留字段2
	 */
	public void setRev2(String rev2){
		this.rev2 = rev2;
	}
	/**
	 * @return REV3 保留字段3
	 */
	public String getRev3(){
		return this.rev3;
	}
	/**
	 * @param REV3 保留字段3
	 */
	public void setRev3(String rev3){
		this.rev3 = rev3;
	}
	/**
	 * @return REV4 保留字段4
	 */
	public String getRev4(){
		return this.rev4;
	}
	/**
	 * @param REV4 保留字段4
	 */
	public void setRev4(String rev4){
		this.rev4 = rev4;
	}
	/**
	 * @return SENDER_UNIT 发送人单位
	 */
	public String getSenderUnit(){
		return this.senderUnit;
	}
	/**
	 * @param SENDER_UNIT 发送人单位
	 */
	public void setSenderUnit(String senderUnit){
		this.senderUnit = senderUnit;
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public static String getTableName() {
		return "sys_receive_box";
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
	
	public static enum ReceiveBoxEnum{
		id("ID","主键"),
		msgId("MSG_ID","消息ID"),
		senderName("SENDER_NAME","发送人真实姓名"),
		senderId("SENDER_ID","发送人登录账户"),
		receiverId("RECEIVER_ID","收件人登录账户"),
		receiverName("RECEIVER_NAME","接收人真实姓名"),
		receiverType("RECEIVER_TYPE","接收人类型(不使用)"),
		msgState("MSG_STATE","消息状态"),
		del("DEL","是否删除"),
		secrecy("SECRECY","密级"),
		createDate("CREATE_DATE","录入时间"),
		createPid("CREATE_PID","录入员姓名"),
		modifyDate("MODIFY_DATE","修改时间"),
		modifyPid("MODIFY_PID","修改人员姓名"),
		rev1("REV1","保留字段1"),
		rev2("REV2","保留字段2"),
		rev3("REV3","保留字段3"),
		rev4("REV4","保留字段4"),
		msgContent("MSG_CONTENT","消息内容"),
		senderUnit("SENDER_UNIT","发送人单位");
		
		private String fieldName;
		private String remark;
		
		ReceiveBoxEnum(String fieldName,String remark){
			this.fieldName = fieldName;
			this.remark = remark;
		}
		
		public String get(){
			return this.fieldName;
		}
		
		public String getRemark(){
			return this.remark;
		}
	}
}
