package com.hisign.shuwu.nt.api.service;

import com.hisign.shuwu.nt.api.exception.NoticeException;
import com.hisign.shuwu.nt.api.model.MsgBean;
import com.hisign.shuwu.nt.api.model.NoteBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 发送消息接口
 * @author lqf
 * @Date 2017年6月19日
 */

@FeignClient(name = "ntService")
public interface NtService {
	/**
	 * 发送短信
	 * 
	 */
	@RequestMapping(value = "/sendNote", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	public void sendNote(@RequestBody NoteBean bean) throws NoticeException;
	
	/**
	 * 推送系统消息
	 * 
	 */
	@RequestMapping(value = "/sendMsg", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	public void sendMsg(@RequestBody MsgBean bean) throws NoticeException;
	
}
