package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


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

}