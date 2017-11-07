package com.hisign.xingzhen.sys.mapper;

import java.util.List;

import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.param.SysUserInfoParam;
import org.apache.ibatis.annotations.Param;

public interface SysUserInfoMapper {
    int deleteByKey(String userId);
    int insert(SysUserInfo userInfo);
    SysUserInfo selectByKey(String userId);
    List<SysUserInfo> queryListByCondition(SysUserInfo userInfo);
    int queryCountByCondition(SysUserInfo userInfo);
    int update(SysUserInfo userInfo);
    int updateNotNull(SysUserInfo userInfo);

    //根据SuperId获取该组织下所有人数
    long findAllCountBySuperId(@Param("superId") String superId);

    List<SysUserInfo> findByIds(List<String> ids);

}