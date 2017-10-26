package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.param.GroupParam;
import com.hisign.xingzhen.xz.api.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.concurrent.locks.Condition;


/**
 * 《专案组》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "专案组")
@RestController
@RequestMapping("/xz/group")
public class GroupRest extends BaseRest<Group,GroupModel, String, GroupService> implements GroupService{

    @Override
    @Autowired
    @Resource(name = "groupService")
    public void setBaseService(GroupService baseService) {
        super.setBaseService(baseService);
    }

    @ApiOperation(value = "添加专案组",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addGroup(@Valid @RequestBody Group group, BindingResult result) throws BusinessException {
        JsonResult jr = handleResult(result);
        if (jr.getFlag()!=1){
            return jr;
        }
        return baseService.addNotNull(group);
    }

    /**
     * 查询分页
     * @param groupParam 专案组
     * @return 返回JsonResult
     */
    @ApiOperation(value = "专案组查询分页",httpMethod ="GET",response = GroupModel.class)
    @RequestMapping(value = "/getGroupPage", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getGroupPage(@ApiParam GroupParam groupParam) {
        return baseService.getGroupPage(groupParam);
    }

    /**
     * 查询子专案组列表
     * @param pGroupId 父专案组ID
     * @return JsonResult
     */
    @ApiOperation(value = "查询子专案组列表",httpMethod ="GET",response = GroupModel.class)
    @RequestMapping(value = "/getChildGroupList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getChildGroupList(@RequestParam String pGroupId) {
        return baseService.getChildGroupList(pGroupId);
    }

    /**
     * 查询任务详情
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "查看专案组详情",httpMethod ="GET",response = GroupModel.class)
    @RequestMapping(value = "/groupDetail/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public GroupModel getById(@PathVariable String id) {
        return baseService.getById(id);
    }

    @ApiOperation(value = "获取所有专案组根据用户id",httpMethod ="GET",response = GroupModel.class)
    @RequestMapping(value = "/getAllGroupByUserId", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public JsonResult getAllGroupByUserId(@RequestParam String userId) {
        return baseService.getAllGroupByUserId(userId);
    }
}