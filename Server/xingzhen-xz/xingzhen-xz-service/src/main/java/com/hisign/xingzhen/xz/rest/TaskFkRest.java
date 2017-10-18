package com.hisign.xingzhen.xz.rest;

import com.hisign.xingzhen.xz.api.entity.TaskFk;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;
import com.hisign.xingzhen.xz.api.service.TaskFkService;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hisign.bfun.bif.*;


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
}