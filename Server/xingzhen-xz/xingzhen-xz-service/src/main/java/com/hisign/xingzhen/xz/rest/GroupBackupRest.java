package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.GroupBackup;
import com.hisign.xingzhen.xz.api.model.GroupBackupModel;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.param.GroupBackupParam;
import com.hisign.xingzhen.xz.api.service.GroupBackupService;

import javax.annotation.Resource;

import com.hisign.xingzhen.xz.api.service.GroupService;
import io.swagger.annotations.*;
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
@RequestMapping("/xz/groupBackupService")
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
    public JsonResult backup(GroupBackupParam param) throws BusinessException {
        return baseService.backup(param);
    }
}