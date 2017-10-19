
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.xz.api.entity.TaskFk;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;

/**
 * 《任务反馈》 数据访问接口
 * @author 何建辉
 *
 */
public interface TaskFkMapper extends BaseMapper<TaskFk,TaskFkModel,String> {
    public String updateTaskQrzt(TaskFk taskFk);
}