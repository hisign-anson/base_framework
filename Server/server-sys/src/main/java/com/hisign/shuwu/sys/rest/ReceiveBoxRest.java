package com.hisign.shuwu.sys.rest;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import com.hisign.shuwu.sys.api.model.ReceiveBox;
import com.hisign.shuwu.sys.api.service.ReceiveBoxService;
import com.hisign.shuwu.sys.service.ReceiveBoxServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/sys/sysDictService")
@RestController
public class ReceiveBoxRest extends ReceiveBoxServiceImpl implements ReceiveBoxService {
    @Override
    @RequestMapping(value = "/setRead", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult setRead(String[] ids) throws BusinessException {
        return super.setRead(ids);
    }

    @Override
    @RequestMapping(value = "/delMsg", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delMsg(String[] ids) throws BusinessException {
        return super.delMsg(ids);
    }

}
