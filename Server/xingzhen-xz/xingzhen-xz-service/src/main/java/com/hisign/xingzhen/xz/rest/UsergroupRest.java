package com.hisign.xingzhen.xz.rest;

import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;
import com.hisign.xingzhen.xz.api.service.UsergroupService;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hisign.bfun.bif.*;
import com.hisign.bfun.bmodel.*;


/**
 * 《人员专案组关联》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "人员专案组关联")
@RestController
@RequestMapping("usergroup")
public class UsergroupRest extends BaseRest<Usergroup,UsergroupModel, String, UsergroupService> implements UsergroupService{

    @Override
    @Autowired
    @Resource(name = "usergroupService")
    public void setBaseService(UsergroupService baseService) {
        super.setBaseService(baseService);
    }

    /**
     * 移除组内成员
     * @param userId
     * @param groupId
     * @return
     */
    @Override
    @ApiOperation(value = "移除组内成员",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/deleteUsergroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult deleteUsergroup(@RequestBody Usergroup usergroup) {
        return baseService.deleteUsergroup(usergroup);
    }

    /**
     * 组内成员分页
     * @param info
     * @return
     */
    @ApiOperation(value = "组内成员分页",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/getUsergroupPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getUsergroupPage(@ApiParam SysUserInfo info){
        return baseService.getUsergroupPage(info);
    }

}