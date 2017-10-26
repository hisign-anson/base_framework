
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.param.GroupParam;

/**
 * 《专案组》 业务逻辑服务接口
 *
 * @author 何建辉
 */
public interface GroupService extends BaseService<Group,GroupModel, String> {

    public JsonResult getGroupPage(GroupParam groupParam);

    public JsonResult getChildGroupList(String pgroupid);

    public JsonResult getAllGroupByUserId(String userId);
}