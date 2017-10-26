package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Cb;
import com.hisign.xingzhen.xz.api.model.CbModel;
import com.hisign.xingzhen.xz.api.service.CbService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 《催办记录》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "催办记录")
@RestController
@RequestMapping("/xz/cb")
public class CbRest extends BaseRest<Cb, CbModel, String, CbService> implements CbService {

    @Override
    @Autowired
    @Resource(name = "cbService")
    public void setBaseService(CbService baseService) {
        super.setBaseService(baseService);
    }

    /**
     * 催办任务
     * @param
     * @return
     */
    @Override
    @ApiOperation(value = "催办任务",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/addCb", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult addCb(@RequestParam String id,@RequestParam String userId,@RequestParam String deparmentcode) {
        return baseService.addCb(id,userId,deparmentcode);
    }
}