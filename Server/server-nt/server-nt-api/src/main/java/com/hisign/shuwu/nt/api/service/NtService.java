package com.hisign.shuwu.nt.api.service;

import com.hisign.shuwu.nt.api.exception.NoticeException;
import com.hisign.shuwu.nt.api.model.MsgBean;
import com.hisign.shuwu.nt.api.model.NoteBean;

/**
 * 发送消息接口
 * @author lqf
 * @Date 2017年6月19日
 */
public interface NtService {
	/**
	 * 发送短信
	 * 
	 */
	public void sendNote(NoteBean bean) throws NoticeException;
	
	/**
	 * 推送系统消息
	 * 
	 */
	public void sendMsg(MsgBean bean) throws NoticeException;
	
}
