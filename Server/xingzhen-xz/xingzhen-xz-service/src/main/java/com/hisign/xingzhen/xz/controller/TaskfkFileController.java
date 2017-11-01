package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.xz.api.service.TaskfkFileService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 《任务反馈文件表》 rest服务类
 * @author 何建辉
 *
 */
@RestController
@RequestMapping("/xz/taskfkFile")
public class TaskfkFileController extends BaseController {

	@Autowired
    private TaskfkFileService taskfkFileService;

     /**
      * 下载反馈任务附件
      * @param taskfkId
      * @return
      */
     @ApiOperation(value = "下载反馈任务附件",httpMethod ="GET",response = String.class)
     @ApiImplicitParams({ @ApiImplicitParam(name="taskfkId",value = "任务反馈id",required = true,dataType = "String"),@ApiImplicitParam(name="userId",value = "当前用户id",required = true,dataType = "String")})
     @RequestMapping(value = "/downloadTaskfkFile", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
     public JsonResult downloadTaskfkFile(String taskfkId,String userId) {
         return taskfkFileService.downloadTaskfkFile(taskfkId,userId);
     }
 }