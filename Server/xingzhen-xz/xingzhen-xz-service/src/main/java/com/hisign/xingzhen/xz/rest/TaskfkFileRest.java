package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.model.TaskfkFileModel;
import com.hisign.xingzhen.xz.api.service.TaskfkFileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 《任务反馈文件表》 rest服务类
 * @author 何建辉
 *
 */
@RestController
@RequestMapping("/xz/taskfkFileService")
public class TaskfkFileRest extends BaseRest<TaskfkFile, TaskfkFileModel, String, TaskfkFileService> implements TaskfkFileService {

	@Override
	@Autowired
	@Resource(name = "taskfkFileService")
	public void setBaseService(TaskfkFileService baseService) {
		super.setBaseService(baseService);
	}

    /**
     * 记录下载附件日志
     * @param fkFileId
     * @return
     */
    @Override
    @ApiOperation(value = "记录下载附件日志",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/downloadLog", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult downloadLog(@RequestParam String fkFileId, @RequestParam String userId) {
        if(StringUtils.isEmpty(userId)){
            return JsonResultUtil.error("当前登陆用户不能为空");
        }
        return baseService.downloadLog(fkFileId,userId);
    }
}