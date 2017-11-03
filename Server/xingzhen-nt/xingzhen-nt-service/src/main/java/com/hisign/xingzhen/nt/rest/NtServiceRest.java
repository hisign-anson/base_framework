package com.hisign.xingzhen.nt.rest;

import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.JMBean;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.model.NoteBean;
import com.hisign.xingzhen.nt.api.service.NtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/nt/ntService")
@RestController
public class NtServiceRest implements NtService {

    @Autowired
    @Resource(name = "ntService")
    NtService ntService;

    @Override
    @RequestMapping(value = "/sendNote", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void sendNote(@RequestBody NoteBean bean) throws NoticeException {
        ntService.sendNote(bean);
    }

    @Override
    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void sendMsg(@RequestBody MsgBean bean) throws NoticeException {
        ntService.sendMsg(bean);
    }

    @Override
    @RequestMapping(value = "/sendJM", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void sendJM(@RequestBody JMBean bean) throws NoticeException {
        ntService.sendJM(bean);
    }
}
