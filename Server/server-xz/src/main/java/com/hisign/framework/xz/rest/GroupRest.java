package com.hisign.framework.xz.rest;

import com.hisign.framework.common.constant.Constants;
import com.hisign.framework.xz.api.entity.Group;
import com.hisign.framework.xz.api.model.GroupModel;
import com.hisign.framework.xz.api.service.GroupService;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hisign.bfun.bif.*;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.*;


/**
 * 《专案组》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "专案组")
@RestController
@RequestMapping("group")
public class GroupRest extends BaseRest<Group,GroupModel, String, GroupService> implements GroupService{

    @Override
    @Autowired
    @Resource(name = "groupService")
    public void setBaseService(GroupService baseService) {
        super.setBaseService(baseService);
    }

    /**
     * 查询分页
     * @param group
     * @return
     */
    @ApiOperation(value = "专案组查询分页",httpMethod ="GET",response = GroupModel.class)
    @RequestMapping(value = "/getGroupPage", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getGroupPage(@ApiParam Group group) {
        return baseService.getGroupPage(group);
    }

    /**
     * 所有字段
     * @param group
     * @return
     */
    @ApiOperation(value = "获取所有字段",httpMethod ="GET",response = GroupModel.class)
    @RequestMapping(value = "/getAllField", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getAllField(@ApiParam Group group) {
        return JsonResultUtil.success(new Group().toString());
    }



}