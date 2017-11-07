
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.model.TaskfkFileModel;
import org.springframework.stereotype.Repository;

/**
 * 《任务反馈文件表》 数据访问接口
 * @author 何建辉
 *
 */
@Repository
public interface TaskfkFileMapper extends BaseMapper<TaskfkFile,TaskfkFileModel,String> {

}