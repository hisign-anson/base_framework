package com.hisign.framework.sys.rest;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.framework.sys.api.model.ReceiveBox;
import com.hisign.framework.sys.api.service.ReceiveBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/sys/receiveBoxService")
@RestController
public class ReceiveBoxRest extends BaseRest<ReceiveBox,ReceiveBox, String, ReceiveBoxService> implements ReceiveBoxService {

    @Override
    @Autowired
    @Resource(name = "receiveBoxService")
    public void setBaseService(ReceiveBoxService baseService) {
        super.setBaseService(baseService);
    }

    @Override
    @RequestMapping(value = "/setRead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult setRead(@RequestBody String[] ids) throws BusinessException {
        return baseService.setRead(ids);
    }

    @Override
    @RequestMapping(value = "/delMsg", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delMsg(@RequestBody String[] ids) throws BusinessException {
        return baseService.delMsg(ids);
    }

}
