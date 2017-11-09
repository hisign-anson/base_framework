package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.AsjAj;
import com.hisign.xingzhen.xz.api.entity.AsjAj.AsjAjEnum;
import com.hisign.xingzhen.xz.api.model.AsjAjModel;
import com.hisign.xingzhen.xz.api.param.AsjAjParam;
import com.hisign.xingzhen.xz.api.service.AsjAjService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 《案件》 rest服务类
 *
 * @author 何建辉
 */
@Api(description="案件")
@RestController
@RequestMapping("/xz/asjAjService")
public class AsjAjRest extends BaseRest<AsjAj,AsjAjModel, String, AsjAjService> implements AsjAjService{

    @Override
    @Autowired
    @Resource(name = "asjAjService")
    public void setBaseService(AsjAjService baseService) {
        super.setBaseService(baseService);
    }

    /**
     * 组内涉及案件分页
     * @param param
     * @return
     */
    @Override
    @ApiOperation(value = "组内涉及案件分页",httpMethod ="POST",response = AsjAjModel.class)
    @RequestMapping(value = "/getAjGroupPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getAjGroupPage(@RequestBody AsjAjParam param) {
        return baseService.getAjGroupPage(param);
    }

    @Override
    @ApiOperation(value = "根据专案组id获取最早关联案件",httpMethod ="POST",response = AsjAjModel.class)
    @RequestMapping(value = "/getFirstCaseByGroupId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public AsjAjModel getFirstCaseByGroupId(@RequestParam String id) {
        return baseService.getFirstCaseByGroupId(id);
    }

    @Override
    @ApiOperation(value = "获取案件详情",httpMethod ="POST",response = AsjAjModel.class)
    @RequestMapping(value = "/getCaseById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public AsjAjModel getCaseById(@RequestParam String id) {
        return baseService.getCaseById(id);
    }
}