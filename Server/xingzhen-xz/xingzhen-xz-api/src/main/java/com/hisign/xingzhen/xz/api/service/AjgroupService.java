
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.bfun.bif.BaseService;
import com.hisign.xingzhen.xz.api.model.AjgroupModel;
import com.hisign.xingzhen.xz.api.param.AjgroupParam;

import java.util.List;

/**
 * 《案件专案组关联》 业务逻辑服务接口
 * @author 何建辉
 */
public interface AjgroupService extends BaseService<Ajgroup,AjgroupModel, String>{

    public JsonResult removeCaseList(List<AjgroupParam> ajgroupList) throws BusinessException;

}