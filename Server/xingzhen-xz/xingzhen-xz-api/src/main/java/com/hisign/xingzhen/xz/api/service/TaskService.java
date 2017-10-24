
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import com.hisign.xingzhen.xz.api.param.TaskAddParam;
import com.hisign.xingzhen.xz.api.param.TaskMoveParam;
import com.hisign.xingzhen.xz.api.param.TaskSelectParam;

/**
 * 《任务》 业务逻辑服务接口
 * @author 何建辉
 */
public interface TaskService extends BaseService<Task,TaskModel, String>{
    public JsonResult getTaskPage(TaskSelectParam taskSelectParam);

    public JsonResult taskDetail(String id,String userId);

    public JsonResult addTask(TaskAddParam taskAddParam);

    public JsonResult deleteTaskById(String id,String userId);

    public JsonResult moveTask(TaskMoveParam taskMoveParam);
}