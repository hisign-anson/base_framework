package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.model.TaskfkFileModel;
import com.hisign.xingzhen.xz.api.service.TaskfkFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


 /**
 * 《任务反馈文件表》 rest服务类
 * @author 何建辉
 *
 */
@RestController
public class TaskfkFileRest extends BaseRest<TaskfkFile, TaskfkFileModel, String, TaskfkFileService> {

	@Override
	@Autowired
	@Resource(name = "taskfkFileService")
	public void setBaseService(TaskfkFileService baseService) {
		super.setBaseService(baseService);
	}
}