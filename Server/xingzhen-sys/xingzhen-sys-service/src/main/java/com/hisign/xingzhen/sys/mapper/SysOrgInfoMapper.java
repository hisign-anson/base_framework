package com.hisign.xingzhen.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hisign.xingzhen.sys.api.model.SysOrgInfo;

public interface SysOrgInfoMapper {
    int deleteByKey(String orgId);
    int insert(SysOrgInfo orgInfo);
    SysOrgInfo selectByKey(String orgId);
    int update(SysOrgInfo orgInfo);
    List<SysOrgInfo> queryListByCondition(SysOrgInfo orgInfo);
    int queryCountByCondition(SysOrgInfo orgInfo);
	List<SysOrgInfo> getOrgTreeListBySuperId(@Param("superId") String superId);
	List<SysOrgInfo> findOrgNotIn(List<String> orgIds);
	List<SysOrgInfo> findOrgIn(List<String> orgIds);
}