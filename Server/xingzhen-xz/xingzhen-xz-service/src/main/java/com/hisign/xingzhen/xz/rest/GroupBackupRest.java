package com.hisign.xingzhen.xz.rest;

import com.hisign.xingzhen.xz.api.entity.GroupBackup;
import com.hisign.xingzhen.xz.api.model.GroupBackupModel;
import com.hisign.xingzhen.xz.api.service.GroupBackupService;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
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

    @Override
    @Autowired
    @Resource(name = "groupBackupService")
    public void setBaseService(GroupBackupService baseService) {
        super.setBaseService(baseService);
    }

}