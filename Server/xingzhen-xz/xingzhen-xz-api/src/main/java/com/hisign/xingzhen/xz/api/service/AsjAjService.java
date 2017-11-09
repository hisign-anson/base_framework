
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.AsjAj;
import com.hisign.bfun.bif.BaseService;
import com.hisign.xingzhen.xz.api.model.AsjAjModel;
import com.hisign.xingzhen.xz.api.param.AsjAjParam;

/**
 * 《案件》 业务逻辑服务接口
 *
 * @author 何建辉
 */
public interface AsjAjService extends BaseService<AsjAj,AsjAjModel, String> {

    public JsonResult getAjGroupPage(AsjAjParam param);

    public AsjAjModel getFirstCaseByGroupId(String id);

    public AsjAjModel getCaseById(String id);

}