
package com.hisign.framework.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.framework.xz.api.entity.Task;
import com.hisign.framework.xz.api.model.TaskModel;

import java.util.List;

/**
 * 《任务》 数据访问接口
 * @author 何建辉
 *
 */
public interface TaskMapper extends BaseMapper<Task,TaskModel,String> {

     public String getMaxNo();


    public List<TaskModel> getTaskByCondition(Task task);

    public long getCountTaskByCondition(Task task);
 }