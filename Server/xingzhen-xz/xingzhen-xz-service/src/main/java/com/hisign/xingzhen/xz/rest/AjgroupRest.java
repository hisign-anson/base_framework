package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.xingzhen.xz.api.model.AjgroupModel;
import com.hisign.xingzhen.xz.api.service.AjgroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;


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

    @ApiOperation(value = "添加案件",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addAjGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addAjGroup(@Valid @RequestBody Ajgroup ajGroup, BindingResult result) throws BusinessException {
        JsonResult jr = handleResult(result);
        if (jr.getFlag()!=1){
            return jr;
        }
        return baseService.addNotNull(ajGroup);
    }

}