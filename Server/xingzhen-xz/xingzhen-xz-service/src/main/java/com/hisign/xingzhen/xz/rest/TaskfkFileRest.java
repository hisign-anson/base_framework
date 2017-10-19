package com.hisign.xingzhen.xz.rest;

import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.service.TaskfkFileService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hisign.bfun.bif.*;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.*;


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