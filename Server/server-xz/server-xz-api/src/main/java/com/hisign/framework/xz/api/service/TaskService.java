
package com.hisign.framework.xz.api.service;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.framework.xz.api.entity.Task;
import com.hisign.bfun.bif.BaseService;
import com.hisign.framework.xz.api.model.TaskModel;

/**
 * 《任务》 业务逻辑服务接口
 * @author 何建辉
 */
public interface TaskService extends BaseService<Task,TaskModel, String>{
    public JsonResult getTaskPage(Task task);
}