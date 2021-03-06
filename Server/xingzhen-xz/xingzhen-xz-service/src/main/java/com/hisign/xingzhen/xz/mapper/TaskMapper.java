
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 《任务》 数据访问接口
 * @author 何建辉
 *
 */
@Repository
public interface TaskMapper extends BaseMapper<Task,TaskModel,String> {

    public String findMaxNo(String deparmentcode);

    public String findGroupTaskMaxNo(String groupId);

    public List<TaskModel> findTaskByEntity(Task task);

    public long findCountTaskByEntity(Task task);

    public TaskModel findTaskById(String id);
 }