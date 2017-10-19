
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.model.TaskModel;

/**
 * 《任务》 业务逻辑服务接口
 * @author 何建辉
 */
public interface TaskService extends BaseService<Task,TaskModel, String>{
    public JsonResult getTaskPage(Task task);

    public JsonResult taskDetail(String id);

    public JsonResult addTask(Task task);

    public JsonResult deleteTaskById(String id);

    public JsonResult moveTask(Task task);
}