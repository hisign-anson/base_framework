package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.controller.BaseController;
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
@RequestMapping("/xz/asjAj")
public class AsjAjController extends BaseController{

    @Autowired
    AsjAjService asjAjService;

    /**
     * 所有案件查询分页
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "所有案件查询分页",httpMethod ="POST",response = AsjAjModel.class)
    @RequestMapping(value = "/getAjPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getAjPage(@RequestBody AsjAjParam param) {
        AsjAj aj = new AsjAj();
        BeanUtils.copyProperties(param,aj);

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

        criteria.add("1", BaseEnum.ConditionEnum.EQ,"1");

        //返回字段
        conditions.setReturnFields(new String[]{AsjAjEnum.id.get(),AsjAjEnum.ajbh.get(), AsjAjEnum.ajmc.get(), AsjAjEnum.ajlx.get(), AsjAjEnum.ajstate.get(), AsjAjEnum.ab.get(), AsjAjEnum.zyaq.get(), AsjAjEnum.fadd.get(), AsjAjEnum.ajzbry.get()});
        conditions.setLimit(param.getBegin(),param.getEnd());

        return asjAjService.getPage(conditions);
    }


    /**
     * 组内涉及案件分页
     * @param param
     * @return
     */
    @ApiOperation(value = "组内涉及案件分页",httpMethod ="POST",response = AsjAjModel.class)
    @RequestMapping(value = "/getAjGroupPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getAjGroupPage(@RequestBody AsjAjParam param) {
        return asjAjService.getAjGroupPage(param);
    }

    @ApiOperation(value = "根据专案组id获取最早关联案件",httpMethod ="POST",response = AsjAjModel.class)
    @RequestMapping(value = "/getFirstCaseByGroupId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public AsjAjModel getFirstCaseByGroupId(@RequestParam String id) {
        return asjAjService.getFirstCaseByGroupId(id);
    }
}