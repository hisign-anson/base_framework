
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.xz.api.entity.TaskFk;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 《任务反馈》 数据访问接口
 * @author 何建辉
 *
 */
public interface TaskFkMapper extends BaseMapper<TaskFk,TaskFkModel,String> {

    //查询用户待确认的反馈数量
    public Long findNotConfirmCountByCreator(@Param(value = "userId") String creator);

}