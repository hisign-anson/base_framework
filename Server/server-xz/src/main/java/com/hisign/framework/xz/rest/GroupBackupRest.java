package com.hisign.framework.xz.rest;

import com.hisign.framework.xz.api.entity.GroupBackup;
import com.hisign.framework.xz.api.model.GroupBackupModel;
import com.hisign.framework.xz.api.service.GroupBackupService;

import java.util.List;
import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hisign.bfun.bif.*;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.*;


/**
 * 《专案组归档记录》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "专案组归档记录")
@RestController
@RequestMapping("groupBackup")
public class GroupBackupRest extends BaseRest<GroupBackup, GroupBackupModel, String, GroupBackupService> implements GroupBackupService {

    @Override
    @Autowired
    @Resource(name = "groupBackupService")
    public void setBaseService(GroupBackupService baseService) {
        super.setBaseService(baseService);
    }

}