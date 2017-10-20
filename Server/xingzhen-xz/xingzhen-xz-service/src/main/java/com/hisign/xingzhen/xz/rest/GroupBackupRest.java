package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.GroupBackup;
import com.hisign.xingzhen.xz.api.model.GroupBackupModel;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.service.GroupBackupService;

import javax.annotation.Resource;

import com.hisign.xingzhen.xz.api.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hisign.bfun.bif.*;


/**
 * 《专案组归档记录》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "专案组归档记录")
@RestController
@RequestMapping("groupBackup")
public class GroupBackupRest extends BaseRest<GroupBackup, GroupBackupModel, String, GroupBackupService> implements GroupBackupService {

    @Autowired
    private GroupService groupService;

    @Override
    @Autowired
    @Resource(name = "groupBackupService")
    public void setBaseService(GroupBackupService baseService) {
        super.setBaseService(baseService);
    }


    @Override
    @ApiOperation(value = "归档",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult add(GroupBackup entity) throws BusinessException {

        GroupModel groupModel = groupService.getById(entity.getGroupid());
        if (groupModel==null){
            return JsonResultUtil.error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
        }
        //子专案组不能归档
        if (StringUtils.isNotBlank(groupModel.getPgroupid())){
            return JsonResultUtil.error("抱歉，改专案组是子专案组，不能归档");
        }
        return super.add(entity);
    }
}