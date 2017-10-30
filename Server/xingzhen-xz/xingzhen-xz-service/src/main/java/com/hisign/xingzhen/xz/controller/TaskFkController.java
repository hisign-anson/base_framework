package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.xz.api.entity.TaskFk;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;
import com.hisign.xingzhen.xz.api.param.TaskFkAddParam;
import com.hisign.xingzhen.xz.api.service.TaskFkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * 《任务反馈》 rest服务类
 * @author 何建辉
 *
 */
 @Api(description = "任务反馈")
@RestController
@RequestMapping("/xz/taskFK")
public class TaskFkController extends BaseController {

	@Autowired
    private TaskFkService taskFkService;

    /**
     * 新增任务反馈
     * @param taskFkAddParam
     * @return
     */
    @ApiOperation(value = "新增任务反馈",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addTaskFk", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addTaskFk(@Valid @RequestBody TaskFkAddParam taskFkAddParam, BindingResult result) {
        JsonResult jr = handleResult(result);
        if (jr.getFlag()!=1){
            return jr;
        }
        TaskFk taskFk=new TaskFk();
        BeanUtils.copyProperties(taskFkAddParam, taskFk);
        return taskFkService.addNotNull(taskFk);
    }
}