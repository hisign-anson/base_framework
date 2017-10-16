package com.hisign.framework.xz.rest;

import com.hisign.framework.xz.api.entity.Cb;
import com.hisign.framework.xz.api.model.CbModel;
import com.hisign.framework.xz.api.service.CbService;

import java.util.List;
import javax.annotation.Resource;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.hisign.bfun.bif.*;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.*;


/**
 * 《催办记录》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "催办记录")
@RestController
@RequestMapping("cb")
public class CbRest extends BaseRest<Cb, CbModel, String, CbService> implements CbService {

    @Override
    @Autowired
    @Resource(name = "cbService")
    public void setBaseService(CbService baseService) {
        super.setBaseService(baseService);
    }

}