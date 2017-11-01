package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import com.hisign.xingzhen.xz.api.param.TaskAddParam;
import com.hisign.xingzhen.xz.api.param.TaskMoveParam;
import com.hisign.xingzhen.xz.api.param.TaskSelectParam;
import com.hisign.xingzhen.xz.api.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 《任务》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "任务")
@RestController
@RequestMapping("/xz/task")
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    /**
     * 新增任务
     * @param taskAddParam
     * @return
     */
    @ApiOperation(value = "新增任务",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addTask", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addTask(@Valid @RequestBody TaskAddParam taskAddParam, BindingResult result) {
        JsonResult jr = handleResult(result);
        if (jr.getFlag()!=JsonResultUtil.SUCCESS){
            return jr;
        }
        Task task=new Task();
        BeanUtils.copyProperties(taskAddParam, task);
        return taskService.addNotNull(task);
    }


    /**
     * 删除任务
     * @param  id userId
     * @return
     */
    @ApiOperation(value = "删除任务",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/deleteTaskById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult deleteTaskById(@RequestParam String id,@RequestParam String userId) {
        if(StringUtils.isEmpty(userId)){
            return JsonResultUtil.error("删除记录失败,当前登陆用户不能为空");
        }
        return taskService.deleteTaskById(id,userId);
    }

    /**
     * 查询分页
     * @param taskSelectParam
     * @return
     */
    @ApiOperation(value = "任务管理查询分页",httpMethod ="POST",response = TaskModel.class)
    @RequestMapping(value = "/getTaskPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getTaskPage(@RequestBody TaskSelectParam taskSelectParam) {
        return taskService.getTaskPage(taskSelectParam);
    }

    /**
     * 查询任务详情
     * @param id  userId
     * @return
     */
    @ApiOperation(value = "任务详情",httpMethod ="GET",response = TaskModel.class)
    @RequestMapping(value = "/taskDetail", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult taskDetail(@RequestParam String id,@RequestParam String userId) {
        if(StringUtils.isEmpty(userId)){
            return JsonResultUtil.error("查看记录失败,当前登陆用户不能为空");
        }
        return taskService.taskDetail(id, userId);
    }

    /**
     * 移交任务
     * @param taskMoveParam
     * @return
     */
    public JsonResult moveTask(@RequestBody TaskMoveParam taskMoveParam) {
        return taskService.moveTask(taskMoveParam);
    }

    @ApiOperation(value = "移交任务",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/moveTask", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult moveTask(@Valid @RequestBody TaskMoveParam taskMoveParam, BindingResult result) {
        JsonResult jr = handleResult(result);
        if (jr.getFlag()!=JsonResultUtil.SUCCESS){
            return jr;
        }
        return taskService.moveTask(taskMoveParam);
    }
}