
package com.hisign.framework.xz.api.service;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.framework.sys.api.model.SysUserInfo;
import com.hisign.framework.xz.api.entity.Usergroup;
import com.hisign.bfun.bif.BaseService;
import com.hisign.framework.xz.api.model.UsergroupModel;

import java.util.List;

/**
 * 《人员专案组关联》 业务逻辑服务接口
 *
 * @author 何建辉
 */
public interface UsergroupService extends BaseService<Usergroup,UsergroupModel, String> {

    public JsonResult deleteUsergroup(String userId, String groupId);

    public JsonResult getUsergroupPage(SysUserInfo info);

}