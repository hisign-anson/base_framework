
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.TaskFk;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;
import com.hisign.xingzhen.xz.api.param.TaskFkAddParam;

/**
 * 《任务反馈》 业务逻辑服务接口
 * @author 何建辉
 */
public interface TaskFkService extends BaseService<TaskFk,TaskFkModel, String>{
    public JsonResult addTaskFk(TaskFkAddParam taskFkAddParam);
}