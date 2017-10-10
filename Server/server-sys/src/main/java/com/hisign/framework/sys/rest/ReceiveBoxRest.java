package com.hisign.framework.sys.rest;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.framework.sys.api.model.ReceiveBox;
import com.hisign.framework.sys.api.service.ReceiveBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/sys/sysDictService")
@RestController
public class ReceiveBoxRest extends BaseRest<ReceiveBox, String, ReceiveBoxService> implements ReceiveBoxService {

    @Override
    @Autowired
    @Resource(name = "receiveBoxService")
    public void setBaseService(ReceiveBoxService baseService) {
        super.setBaseService(baseService);
    }

    @Override
    @RequestMapping(value = "/setRead", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult setRead(String[] ids) throws BusinessException {
        return baseService.setRead(ids);
    }

    @Override
    @RequestMapping(value = "/delMsg", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delMsg(String[] ids) throws BusinessException {
        return baseService.delMsg(ids);
    }

}
