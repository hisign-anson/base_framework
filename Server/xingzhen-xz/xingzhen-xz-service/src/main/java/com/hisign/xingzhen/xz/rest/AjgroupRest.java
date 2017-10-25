package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.xingzhen.xz.api.model.AjgroupModel;
import com.hisign.xingzhen.xz.api.service.AjgroupService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 《案件专案组关联》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "案件专案组关联")
@RestController
@RequestMapping("/xz/ajgroup")
public class AjgroupRest extends BaseRest<Ajgroup, AjgroupModel, String, AjgroupService> implements AjgroupService {

    @Override
    @Autowired
    @Resource(name = "ajgroupService")
    public void setBaseService(AjgroupService baseService) {
        super.setBaseService(baseService);
    }
}