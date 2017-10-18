package com.hisign.xingzhen.xz.rest;

import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import com.hisign.xingzhen.xz.api.service.TaskService;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hisign.bfun.bif.*;
import com.hisign.bfun.bmodel.*;


/**
 * 《任务》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "任务")
@RestController
@RequestMapping("task")
public class TaskRest extends BaseRest<Task, TaskModel, String, TaskService> implements TaskService {

    @Override
    @Autowired
    @Resource(name = "taskService")
    public void setBaseService(TaskService baseService) {
        super.setBaseService(baseService);
    }

    /**
     * 查询分页
     * @param task
     * @return
     */
    @ApiOperation(value = "任务管理查询分页",httpMethod ="POST",response = TaskModel.class)
    @RequestMapping(value = "/getTaskPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getTaskPage(@ApiParam Task task) {
        return baseService.getTaskPage(task);
    }
}