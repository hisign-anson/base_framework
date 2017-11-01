
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.model.TaskfkFileModel;

/**
 * 《任务反馈文件表》 业务逻辑服务接口
 * @author 何建辉
 */
public interface TaskfkFileService extends BaseService<TaskfkFile,TaskfkFileModel, String>{
    public JsonResult downloadLog(String fkFileId,String userId);
}