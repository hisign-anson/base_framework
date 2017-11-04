package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.xingzhen.xz.api.param.AjgroupParam;
import com.hisign.xingzhen.xz.api.service.AjgroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


/**
 * 《案件专案组关联》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "案件专案组关联")
@RestController
@RequestMapping("/xz/ajgroup")
public class AjgroupController extends BaseController {

    @Autowired
    private AjgroupService ajgroupService;

    /**
     *@Author: 何建辉
     *@Description: 关联案件列表
     *@Date: 2017/11/1 17:07
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "关联案件列表",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addAjGroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addAjGroupList(@Valid @RequestBody List<Ajgroup> ajGroupList, BindingResult result) throws BusinessException {
        JsonResult jr = handleResult(result);
        if (jr.getFlag()!= JsonResultUtil.SUCCESS){
            return jr;
        }
        //

        return ajgroupService.add(ajGroupList);
    }

    /**
     *@Author: 何建辉
     *@Description: 移除案件
     *@Date: 2017/11/1 17:07
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "移除案件",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/removeAjGroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult removeAjGroupList(@Valid @RequestBody List<AjgroupParam> ajGroupList, BindingResult result) throws BusinessException {
        JsonResult jr = handleResult(result);
        if (!jr.isSuccess()){
            return jr;
        }

        return ajgroupService.removeCaseList(ajGroupList);
    }

}