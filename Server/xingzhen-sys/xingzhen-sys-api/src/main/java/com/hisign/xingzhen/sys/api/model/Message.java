
package com.hisign.xingzhen.sys.api.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.hisign.bfun.bannotation.Column;
import com.hisign.bfun.bannotation.PK;
import com.hisign.bfun.bannotation.Table;
import com.hisign.xingzhen.common.model.BaseModel;

/**
 * 《系统消息》 实体
 * @author 何建辉
 *
 */
@Table(value="sys_message")
public class Message extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PK(value="ID")
	private String id; //主键
	
	@Column(value="SUBJECT")
	private String subject; //消息标题
	
	@Column(value="CONTENT")
	private String content; //消息内容
	
	@Column(value="TYPE")
	private String type; //消息类型
	
	@Column(value="MSG_LEVEL")
	private String msgLevel; //消息等级
	
	@Column(value="DEL")
	private String del; //是否删除
	
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
	private String rev1; //附件
	
	@Column(value="REV2")
	private String rev2; //发布人
	
	@Column(value="REV3")
	private Date rev3; //发布时间
	
	@Column(value="REV4")
	private String rev4; //是否发布 0未发布，1已发布
	
	@Column(value="MSG_VEST")
	private String msgVest; //消息归属
	
	@Column(value="TSLB")
	private String tslb; //类别
	
	@Column(value="ATT_ID")
	private String attId; //关注编号
	
    
	/**
	 *默认空构造函数
	 */
	public Message() {
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
	 * @return SUBJECT 消息标题
	 */
	public String getSubject(){
		return this.subject;
	}
	/**
	 * @param SUBJECT 消息标题
	 */
	public void setSubject(String subject){
		this.subject = subject;
	}
	/**
	 * @return CONTENT 消息内容
	 */
	public String getContent(){
		return this.content;
	}
	/**
	 * @param CONTENT 消息内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * @return TYPE 消息类型
	 */
	public String getType(){
		return this.type;
	}
	/**
	 * @param TYPE 消息类型
	 */
	public void setType(String type){
		this.type = type;
	}
	/**
	 * @return MSG_LEVEL 消息等级
	 */
	public String getMsgLevel(){
		return this.msgLevel;
	}
	/**
	 * @param MSG_LEVEL 消息等级
	 */
	public void setMsgLevel(String msgLevel){
		this.msgLevel = msgLevel;
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
	public Date getRev3(){
		return this.rev3;
	}
	/**
	 * @param REV3 保留字段3
	 */
	public void setRev3(Date rev3){
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
	 * @return MSG_VEST 消息归属
	 */
	public String getMsgVest(){
		return this.msgVest;
	}
	/**
	 * @param MSG_VEST 消息归属
	 */
	public void setMsgVest(String msgVest){
		this.msgVest = msgVest;
	}
	/**
	 * @return TSLB 类别
	 */
	public String getTslb(){
		return this.tslb;
	}
	/**
	 * @param TSLB 类别
	 */
	public void setTslb(String tslb){
		this.tslb = tslb;
	}
	/**
	 * @return ATT_ID 关注编号
	 */
	public String getAttId(){
		return this.attId;
	}
	/**
	 * @param ATT_ID 关注编号
	 */
	public void setAttId(String attId){
		this.attId = attId;
	}
	
	public static String getTableName() {
		return "sys_message";
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
	
	public static enum MessageEnum{
		id("ID","主键"),
		subject("SUBJECT","消息标题"),
		content("CONTENT","消息内容"),
		type("TYPE","消息类型"),
		msgLevel("MSG_LEVEL","消息等级"),
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
		msgVest("MSG_VEST","消息归属"),
		tslb("TSLB","类别"),
		attId("ATT_ID","关注编号");
		
		private String fieldName;
		private String remark;
		
		MessageEnum(String fieldName,String remark){
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
