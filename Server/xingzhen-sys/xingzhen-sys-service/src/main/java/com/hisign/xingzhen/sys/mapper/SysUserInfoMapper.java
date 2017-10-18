package com.hisign.xingzhen.sys.mapper;

import java.util.List;

import com.hisign.xingzhen.sys.api.model.SysUserInfo;

public interface SysUserInfoMapper {
    int deleteByKey(String userId);
    int insert(SysUserInfo userInfo);
    SysUserInfo selectByKey(String userId);
    List<SysUserInfo> queryListByCondition(SysUserInfo userInfo);
    int queryCountByCondition(SysUserInfo userInfo);
    int update(SysUserInfo userInfo);
    int updateNotNull(SysUserInfo userInfo);
}