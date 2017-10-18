
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;

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