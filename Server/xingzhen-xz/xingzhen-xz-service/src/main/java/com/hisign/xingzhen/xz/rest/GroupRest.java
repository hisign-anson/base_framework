package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.param.GroupParam;
import com.hisign.xingzhen.xz.api.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Override
    @ApiOperation(value = "添加专案组",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addNotNull(@ApiParam Group group) {
        if(StringUtils.isEmpty(group.getCreator()) || StringUtils.isEmpty(group.getCreatename())){
            return JsonResultUtil.error("添加记录失败,当前登陆用户不能为空");
        }
        if(StringUtils.isEmpty(group.getDeparmentcode())){
            return JsonResultUtil.error("添加记录失败,当前登陆用户单位不能为空");
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
    @RequestMapping(value = "/groupDetail", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public GroupModel getById(@RequestParam String id) {
        return baseService.getById(id);
    }
}