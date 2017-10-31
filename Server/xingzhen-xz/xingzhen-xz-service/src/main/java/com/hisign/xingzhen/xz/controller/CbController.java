package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.xz.api.entity.Cb;
import com.hisign.xingzhen.xz.api.service.CbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 《催办记录》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "催办记录")
@RestController
@RequestMapping("/xz/cb")
public class CbController extends BaseController {

    @Autowired
    private CbService cbService;

    /**
     * 催办任务
     * @param
     * @return
     */
    @ApiOperation(value = "催办任务",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/addCb", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult addCb(@RequestParam String taskid,@RequestParam String userId,@RequestParam String deparmentcode) {
        Cb cb=new Cb();
        cb.setTaskid(taskid);
        cb.setCreator(userId);
        cb.setDeparmentcode(deparmentcode);
        return cbService.addNotNull(cb);
    }
}