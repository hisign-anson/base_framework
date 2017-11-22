package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.sys.api.service.MessageService;
import com.hisign.xingzhen.xz.api.entity.Cb;
import com.hisign.xingzhen.xz.api.entity.IMessage;
import com.hisign.xingzhen.xz.api.model.CbModel;
import com.hisign.xingzhen.xz.api.param.IMessageParam;
import com.hisign.xingzhen.xz.api.service.CbService;
import com.hisign.xingzhen.xz.api.service.es.IMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author 何建辉
 */
@RestController
@RequestMapping("/xz/iMessageService")
public class IMessageRest implements IMessageService {

    @Autowired
    @Resource(name = "iMessageService")
    IMessageService iMessageService;

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void save(@RequestBody List<IMessage> message) {
        iMessageService.save(message);
    }

    @Override
    @RequestMapping(value = "/findByPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult findByPage(@RequestBody IMessageParam msg) {
        return null;
    }


}