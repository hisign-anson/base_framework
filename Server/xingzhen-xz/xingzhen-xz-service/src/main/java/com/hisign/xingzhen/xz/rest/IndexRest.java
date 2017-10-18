package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.service.IndexService;
import com.hisign.xingzhen.xz.api.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hisign on 2017/10/16.
 */
@Api(description = "首页")
@RestController
@RequestMapping("index")
public class IndexRest extends BaseController {

    @Autowired
    TaskService taskService;

    @Autowired
    IndexService indexService;

    @ApiOperation(value = "待办任务",notes = "首页待办工作",httpMethod = "GET", response = Map.class)
    @ApiImplicitParam(name = "userId",value = "当前用户id",required = true,dataType = "String")
    @RequestMapping(value = "/getTaskCountInfo", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getTaskCountInfo(@RequestParam String userId) {
        //已反馈 未确认 下发人
        Conditions conditions = new Conditions(Task.class);
        Conditions.Criteria criteria = conditions.createCriteria();

        criteria.add(Task.TaskEnum.fkzt.get(), BaseEnum.ConditionEnum.EQ, Constants.NO)
                .add(Task.TaskEnum.qrzt.get(), BaseEnum.ConditionEnum.EQ, Constants.NO)
                .add(Task.TaskEnum.fqr.get(), BaseEnum.ConditionEnum.EQ, userId);
        Long count1 = taskService.getCount(conditions);

        //未反馈 未签收 未过期 接收人
        Conditions conditions2 = new Conditions(Task.class);
        Conditions.Criteria criteria2 = conditions.createCriteria();

        criteria.add(Task.TaskEnum.fkzt.get(), BaseEnum.ConditionEnum.EQ, Constants.NO)
                .add(Task.TaskEnum.qszt.get(), BaseEnum.ConditionEnum.EQ, Constants.NO)
                .add(Task.TaskEnum.fkjzTime.get(), BaseEnum.ConditionEnum.GT_, new Date())
                .add(Task.TaskEnum.jsr.get(), BaseEnum.ConditionEnum.EQ, userId);
        Long count2 = taskService.getCount(conditions);

        //未反馈 已过期 接收人
        Conditions conditions3 = new Conditions(Task.class);
        Conditions.Criteria criteria3 = conditions.createCriteria();

        criteria.add(Task.TaskEnum.fkzt.get(), BaseEnum.ConditionEnum.EQ, Constants.NO)
                .add(Task.TaskEnum.fkjzTime.get(), BaseEnum.ConditionEnum.LTE_, new Date())
                .add(Task.TaskEnum.jsr.get(), BaseEnum.ConditionEnum.EQ, userId);
        Long count3 = taskService.getCount(conditions);

        Map<String, Long> map = new HashMap<String,Long>();
        map.put("feedback",count1);
        map.put("receive",count2);
        map.put("pastdue",count3);

        return success(map);
    }

    @ApiOperation(value = "平台成果展示",notes = "平台成果展示",httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/getAchievement", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getAchievement() {
        return indexService.getAchievementList();
    }

    @ApiOperation(value = "专案组破案情况",notes = "专案组破案情况",httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/getSolveCaseInfo", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getSolveCaseInfo() {
        return indexService.getGroupCaseInfo(Constants.YES);
    }

    @ApiOperation(value = "专案组创建情况",notes = "专案组创建情况",httpMethod = "GET", response = Map.class)
    @RequestMapping(value = "/getCreateInfo", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getCreateInfo() {
        String a = "";
        return indexService.getGroupCaseInfo(null);
    }


}