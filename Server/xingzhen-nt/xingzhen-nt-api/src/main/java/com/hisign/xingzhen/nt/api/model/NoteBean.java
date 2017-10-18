package com.hisign.xingzhen.nt.api.model;

import java.util.List;

public class NoteBean extends MsgBase {

	/** **/
	private static final long serialVersionUID = -494692744656162922L;
	
	private String senderId;
	private List<?> list;
	
	public String getSenderId() {
		return senderId;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
}
