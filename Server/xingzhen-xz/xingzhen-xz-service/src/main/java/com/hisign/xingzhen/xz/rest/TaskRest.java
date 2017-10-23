package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import com.hisign.xingzhen.xz.api.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


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
    @Override
    @ApiOperation(value = "任务管理查询分页",httpMethod ="GET",response = TaskModel.class)
    @RequestMapping(value = "/getTaskPage", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getTaskPage(@ApiParam @RequestBody Task task) {
        return baseService.getTaskPage(task);
    }

    /**
     * 查询任务详情
     * @param task
     * @return
     */
    @Override
    @ApiOperation(value = "任务详情",httpMethod ="GET",response = String.class)
    @RequestMapping(value = "/taskDetail", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult taskDetail(@ApiParam @RequestBody Task task) {
        return baseService.taskDetail(task);
    }

    /**
     * 新增任务
     * @param task
     * @return
     */
    @Override
    @ApiOperation(value = "新增任务",httpMethod ="POST",response = String.class)
    @RequestMapping(value = "/addTask", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addTask(@ApiParam @RequestBody Task task, HttpServletRequest request) {
        return baseService.addTask(task,request);
    }

    /**
     * 删除任务
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "删除任务",httpMethod ="DELETE",response = String.class)
    @RequestMapping(value = "/deleteTaskById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult deleteTaskById(@ApiParam String id) {
        return baseService.deleteTaskById(id);
    }

    /**
     * 移交任务
     * @param task
     * @return
     */
    @Override
    @ApiOperation(value = "移交任务",httpMethod ="POST",response = String.class)
    @RequestMapping(value = "/moveTask", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult moveTask(@ApiParam @RequestBody Task task) {
        return baseService.moveTask(task);
    }
}