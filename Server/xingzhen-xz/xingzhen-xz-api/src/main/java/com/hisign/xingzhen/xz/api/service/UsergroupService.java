
package com.hisign.xingzhen.xz.api.service;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.bfun.bif.BaseService;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;

/**
 * 《人员专案组关联》 业务逻辑服务接口
 *
 * @author 何建辉
 */
public interface UsergroupService extends BaseService<Usergroup,UsergroupModel, String> {

    public JsonResult deleteUsergroup(Usergroup usergroup);

    public JsonResult getUsergroupPage(SysUserInfo info);

    public JsonResult getGroupMemberList(SysUserInfo info);

}