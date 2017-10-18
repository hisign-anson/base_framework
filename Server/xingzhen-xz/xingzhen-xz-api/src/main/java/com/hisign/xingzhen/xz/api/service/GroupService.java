
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bif.BaseService;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.model.GroupModel;

/**
 * 《专案组》 业务逻辑服务接口
 *
 * @author 何建辉
 */
public interface GroupService extends BaseService<Group,GroupModel, String> {

    public JsonResult getGroupPage(Group group);

}