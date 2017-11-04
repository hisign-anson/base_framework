
package com.hisign.xingzhen.xz.mapper;

import com.hisign.bfun.bif.BaseMapper;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;
import com.hisign.xingzhen.sys.api.param.SysUserInfoParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 《人员专案组关联》 数据访问接口
 *
 * @author 何建辉
 */
@Repository
public interface UsergroupMapper extends BaseMapper<Usergroup,UsergroupModel, String> {

    public List<SysUserInfo> findGroupUserList(SysUserInfoParam info);

    public long findGroupUserCount(SysUserInfoParam info);

    public List<SysUserInfo> findGroupMemberList(@Param("groupId") String groupId);

    public List<SysUserInfo> findUserInfoListByKey(SysUserInfoParam param);

    public Long findCountByKey(SysUserInfoParam SysUserInfoParam);
}