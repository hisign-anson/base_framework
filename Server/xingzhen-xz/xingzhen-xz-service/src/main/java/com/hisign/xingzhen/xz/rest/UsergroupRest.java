package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;
import com.hisign.xingzhen.xz.api.param.SysUserInfoParam;
import com.hisign.xingzhen.xz.api.service.UsergroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 《人员专案组关联》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "人员专案组关联")
@RestController
@RequestMapping("/xz/usergroupService")
public class UsergroupRest extends BaseRest<Usergroup,UsergroupModel, String, UsergroupService> implements UsergroupService{

    @Override
    @Autowired
    @Resource(name = "usergroupService")
    public void setBaseService(UsergroupService baseService) {
        super.setBaseService(baseService);
    }

    /**
     * 移除组内成员
     * @param usergroup
     * @return
     */
    @Override
    @ApiOperation(value = "移除组内成员列表",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/deleteUsergroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult deleteUsergroupList(@RequestBody List<Usergroup> usergroup) {
        if (usergroup==null){
            return JsonResultUtil.error("请选择成员");
        }
        return baseService.deleteUsergroupList(usergroup);
    }

    @Override
    public JsonResult getUsergroupPage(SysUserInfoParam info) {
        return baseService.getUsergroupPage(info);
    }

    @Override
    public JsonResult getGroupMemberList(String groupId) {
        return baseService.getGroupMemberList(groupId);
    }

}