package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.TaskFk;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;
import com.hisign.xingzhen.xz.api.param.TaskFkAddParam;
import com.hisign.xingzhen.xz.api.service.TaskFkService;
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
 * 《任务反馈》 rest服务类
 * @author 何建辉
 *
 */
 @Api(description = "任务反馈")
@RestController
@RequestMapping("taskFK")
public class TaskFkRest extends BaseRest<TaskFk,TaskFkModel, String, TaskFkService> implements TaskFkService {

	@Override
	@Autowired
	@Resource(name = "taskFkService")
	public void setBaseService(TaskFkService baseService) {
		super.setBaseService(baseService);
	}


    /**
     * 新增任务反馈
     * @param taskFkAddParam
     * @return
     */
    @Override
    @ApiOperation(value = "新增任务反馈",httpMethod ="POST",response = String.class)
    @RequestMapping(value = "/addTaskFk", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addTaskFk(@ApiParam @RequestBody TaskFkAddParam taskFkAddParam) {
        return baseService.addTaskFk(taskFkAddParam);
    }
}