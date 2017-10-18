package com.hisign.xingzhen.nt.api.model;

import java.util.List;

public class MsgBean extends MsgBase {

	/** **/
	private static final long serialVersionUID = 5866906564226547898L;
	private String publishId;
	private String publishName;
	private List<String> orgIds;
	private List<?> list;
	private String receiverType;
	
	/**
	 * @return the publishId
	 */
	public String getPublishId() {
		return publishId;
	}
	/**
	 * @param publishId the publishId to set
	 */
	public void setPublishId(String publishId) {
		this.publishId = publishId;
	}
	/**
	 * @return the publishName
	 */
	public String getPublishName() {
		return publishName;
	}
	/**
	 * @param publishName the publishName to set
	 */
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	/**
	 * @return the orgIds
	 */
	public List<String> getOrgIds() {
		return orgIds;
	}
	/**
	 * @param orgIds the orgIds to set
	 */
	public void setOrgIds(List<String> orgIds) {
		this.orgIds = orgIds;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public String getReceiverType() {
		return receiverType;
	}
	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	}
}
