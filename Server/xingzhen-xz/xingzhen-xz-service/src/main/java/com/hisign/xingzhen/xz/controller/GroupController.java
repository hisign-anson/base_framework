package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.param.GroupParam;
import com.hisign.xingzhen.xz.api.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * 《专案组》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "专案组")
@RestController
@RequestMapping("/xz/group")
public class GroupController extends BaseController{

    @Autowired
    private GroupService groupService;

    @ApiOperation(value = "添加专案组",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addGroup(@Valid @RequestBody Group group, BindingResult result) throws BusinessException {
        JsonResult jr = handleResult(result);
        if (jr.getFlag()!=1){
            return jr;
        }
        return groupService.addNotNull(group);
    }

    /**
     * 查询分页
     * @param groupParam 专案组
     * @return 返回JsonResult
     */
    @ApiOperation(value = "专案组查询分页",httpMethod ="POST",response = GroupModel.class)
    @RequestMapping(value = "/getGroupPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getGroupPage(@RequestBody GroupParam groupParam) {
        if (StringUtils.isNotBlank(groupParam.getOrderBy())){
            Group.GroupEnum groupEnum = Group.GroupEnum.valueOf(groupParam.getOrderBy());
            if (groupEnum!=null){
                groupParam.setOrderBy(groupEnum.get());
            }
        }else {
            groupParam.setDesc(false);
        }
        return groupService.getGroupPage(groupParam);
    }

    /**
     * 查询子专案组列表
     * @param groupId 父专案组ID
     * @return JsonResult
     */
    @ApiOperation(value = "查询子专案组列表",httpMethod ="POST",response = GroupModel.class)
    @RequestMapping(value = "/getChildGroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getChildGroupList(@RequestParam String groupId,@RequestParam String memberName) {
        return groupService.getChildGroupList(groupId,memberName);
    }

    /**
     * 查询任务详情
     * @param id
     * @return
     */
    @ApiOperation(value = "查看专案组详情",httpMethod ="POST",response = GroupModel.class)
    @RequestMapping(value = "/groupDetail/{id}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getById(@PathVariable String id) {
        GroupModel model = groupService.getById(id);
        return JsonResultUtil.success(model);
    }

    @ApiOperation(value = "获取所有专案组根据用户id",httpMethod ="POST",response = GroupModel.class)
    @RequestMapping(value = "/getAllGroupByUserId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getAllGroupByUserId(@RequestParam String userId) {
        return groupService.getAllGroupByUserId(userId);
    }
}