package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.GroupBackup;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.param.GroupBackupParam;
import com.hisign.xingzhen.xz.api.service.GroupBackupService;
import com.hisign.xingzhen.xz.api.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * 《专案组归档记录》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "专案组归档记录")
@RestController
@RequestMapping("/xz/groupBackup")
public class GroupBackupController extends BaseController {

    @Autowired
    private GroupBackupService groupBackupService;

    @Autowired
    private GroupService groupService;

    /**
     *@Author: 何建辉
     *@Description: 归档/撤销归档
     *@Date: 2017/11/1 17:08
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "归档/撤销归档",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/backup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult backup(@Valid @RequestBody GroupBackupParam entity, BindingResult result) throws BusinessException {
        JsonResult jr = handleResult(result);
        if (jr.getFlag()!=JsonResultUtil.SUCCESS){
            return jr;
        }
        GroupModel groupModel = groupService.getById(entity.getGroupid());
        if (groupModel==null){
            return JsonResultUtil.error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
        }
        //子专案组不能归档
        if (StringUtils.isNotBlank(groupModel.getPgroupid())){
            return JsonResultUtil.error("抱歉，改专案组是子专案组，不能归档");
        }

        return groupBackupService.backup(entity);
    }
}