package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.model.TaskfkFileModel;
import com.hisign.xingzhen.xz.api.service.TaskfkFileService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


 /**
 * 《任务反馈文件表》 rest服务类
 * @author 何建辉
 *
 */
@RestController
public class TaskfkFileRest extends BaseRest<TaskfkFile, TaskfkFileModel, String, TaskfkFileService> implements TaskfkFileService {

	@Override
	@Autowired
	@Resource(name = "taskfkFileService")
	public void setBaseService(TaskfkFileService baseService) {
		super.setBaseService(baseService);
	}

     /**
      * 下载反馈任务附件
      * @param taskfkId
      * @return
      */
     @Override
     @ApiOperation(value = "下载反馈任务附件",httpMethod ="DELETE",response = String.class)
     @ApiImplicitParams({ @ApiImplicitParam(name="taskfkId",value = "任务反馈id",required = true,dataType = "String"),@ApiImplicitParam(name="userId",value = "当前用户id",required = true,dataType = "String")})
     @RequestMapping(value = "/deleteTaskById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
     public JsonResult downloadTaskfkFile(String taskfkId,String userId) {
         return baseService.downloadTaskfkFile(taskfkId,userId);
     }
 }