package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Cb;
import com.hisign.xingzhen.xz.api.model.CbModel;
import com.hisign.xingzhen.xz.api.service.CbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 《催办记录》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "催办记录")
@RestController
@RequestMapping("cb")
public class CbRest extends BaseRest<Cb, CbModel, String, CbService> implements CbService {

    @Override
    @Autowired
    @Resource(name = "cbService")
    public void setBaseService(CbService baseService) {
        super.setBaseService(baseService);
    }

    /**
     * 移交任务
     * @param cb
     * @return
     */
    @Override
    @ApiOperation(value = "催办任务",httpMethod ="POST",response = String.class)
    @RequestMapping(value = "/addCb", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addCb(@ApiParam @RequestBody Cb cb) {
        return baseService.addCb(cb);
    }
}