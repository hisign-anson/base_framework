
package com.hisign.framework.xz.api.service;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.framework.xz.api.entity.Group;
import com.hisign.bfun.bif.BaseService;
import com.hisign.framework.xz.api.model.GroupModel;

import java.util.List;

/**
 * 《专案组》 业务逻辑服务接口
 *
 * @author 何建辉
 */
public interface GroupService extends BaseService<Group,GroupModel, String> {

    public JsonResult getGroupPage(Group group);

    public JsonResult getAchievementList();

}