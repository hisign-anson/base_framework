package com.hisign.framework.xz.rest;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.framework.common.util.StringUtils;
import com.hisign.framework.xz.api.entity.AsjAj;
import com.hisign.framework.xz.api.entity.AsjAj.AsjAjEnum;
import com.hisign.framework.xz.api.entity.Group;
import com.hisign.framework.xz.api.model.AsjAjModel;
import com.hisign.framework.xz.api.service.AsjAjService;

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
 * 《案件》 rest服务类
 *
 * @author 何建辉
 */
@Api(description="案件")
@RestController
@RequestMapping("asjAj")
public class AsjAjRest extends BaseRest<AsjAj,AsjAjModel, String, AsjAjService> implements AsjAjService{

    @Override
    @Autowired
    @Resource(name = "asjAjService")
    public void setBaseService(AsjAjService baseService) {
        super.setBaseService(baseService);
    }

    /**
     * 所有案件查询分页
     *
     * @param group
     * @return
     */
    @ApiOperation(value = "所有案件查询分页",httpMethod ="POST",response = AsjAjModel.class)
    @RequestMapping(value = "/getAjPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getAjPage(@RequestBody AsjAj aj) {
        Conditions conditions = new Conditions(AsjAj.class);
        Conditions.Criteria criteria = conditions.createCriteria();
        //案件编号
        if (StringUtils.isNotBlank(aj.getAjbh())) {
            criteria.add(AsjAjEnum.ajbh.get(), BaseEnum.ConditionEnum.LIKE, "%" + aj.getAjbh() + "%");
        }
        //案别
        if (StringUtils.isNotBlank(aj.getAb())) {
            criteria.add(AsjAjEnum.ab.get(), BaseEnum.ConditionEnum.EQ, aj.getAb());
        }
        //案件名称
        if (StringUtils.isNotBlank(aj.getAjmc())) {
            criteria.add(AsjAjEnum.ajmc.get(), BaseEnum.ConditionEnum.LIKE, "%" + aj.getAjmc() + "%");
        }
        //案发时间
        if (aj.getStartTime() != null && aj.getEndTime() != null) {
            criteria.add(AsjAjEnum.fasjcz.get(), BaseEnum.IsBTEnum.BT, aj.getStartTime(), aj.getEndTime());
        }
        //案件状态
        if (StringUtils.isNotBlank(aj.getAjstate())) {
            criteria.add(AsjAjEnum.ajstate.get(), BaseEnum.ConditionEnum.EQ, aj.getAjstate());
        }

        //返回字段
        conditions.setReturnFields(new String[]{AsjAjEnum.ajbh.get(), AsjAjEnum.ajmc.get(), AsjAjEnum.ajlx.get(), AsjAjEnum.ajstate.get(), AsjAjEnum.ab.get(), AsjAjEnum.zyaq.get(), AsjAjEnum.fadd.get(), AsjAjEnum.ajzbry.get()});
        return baseService.getPage(conditions);
    }


    /**
     * 组内涉及案件分页
     * @param aj
     * @return
     */
    @Override
    @ApiOperation(value = "组内涉及案件分页",httpMethod ="POST",response = AsjAjModel.class)
    @RequestMapping(value = "/getAjGroupPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getAjGroupPage(@RequestBody AsjAj aj) {
        return baseService.getAjGroupPage(aj);
    }
}