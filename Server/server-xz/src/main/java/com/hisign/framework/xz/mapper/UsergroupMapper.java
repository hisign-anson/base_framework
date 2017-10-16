
package com.hisign.framework.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.framework.sys.api.model.SysUserInfo;
import com.hisign.framework.xz.api.entity.Usergroup;
import com.hisign.framework.xz.api.model.UsergroupModel;

import java.util.List;

/**
 * 《人员专案组关联》 数据访问接口
 *
 * @author 何建辉
 */
public interface UsergroupMapper extends BaseMapper<Usergroup,UsergroupModel, String> {

    public List<SysUserInfo> getGroupUserList(SysUserInfo info);

    public long getGroupUserCount(SysUserInfo info);

}