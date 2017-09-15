package com.hisign.shuwu.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisign.shuwu.common.model.JsonResult;
import com.hisign.shuwu.common.util.JsonResultUtil;
import com.hisign.shuwu.sys.api.model.SysOrgInfo;
import com.hisign.shuwu.sys.api.service.SysOrgInfoService;
import com.hisign.shuwu.sys.mapper.SysOrgInfoMapper;

@Service("sysOrgInfoService")
public class SysOrgInfoServiceImpl implements SysOrgInfoService {
    @Autowired 
	private SysOrgInfoMapper sysOrgInfoMapper;

	@Override
	public List<SysOrgInfo> queryListByCondition(SysOrgInfo info) {
		return sysOrgInfoMapper.queryListByCondition(info);
	}

	@Override
	public SysOrgInfo getOrgInfoByID(String orgId) {
		return sysOrgInfoMapper.selectByKey(orgId);
	}
	
	@Override
	public SysOrgInfo getOrgInfoByName(String name) {
		List<SysOrgInfo> list = sysOrgInfoMapper.queryListByCondition(new SysOrgInfo(name));
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public JsonResult add(SysOrgInfo info) {
		int count = sysOrgInfoMapper.queryCountByCondition(new SysOrgInfo(info.getOrgCode()));
		if(count > 0){
			return JsonResultUtil.error("单位编号已存在,请重新输入");
		}
		//单位级别
		
		sysOrgInfoMapper.insert(info);
		return JsonResultUtil.success();
	}
	
	@Override
	public JsonResult update(SysOrgInfo info) {
		SysOrgInfo oldSysOrgInfo = sysOrgInfoMapper.selectByKey(info.getOrgId());
		if(!oldSysOrgInfo.getOrgCode().equals(info.getOrgCode())){
			int count = sysOrgInfoMapper.queryCountByCondition(new SysOrgInfo(info.getOrgCode()));
			if(count > 0){
				return JsonResultUtil.error("单位编号已存在,请重新输入");
			}
		}
		sysOrgInfoMapper.update(info);
		return JsonResultUtil.success();
	}

	@Override
	public void deleteByKey(String orgId) {
		sysOrgInfoMapper.deleteByKey(orgId);
	}

	@Override
	public List<SysOrgInfo> getOrgTreeListBySuperId(String superId) {
		return sysOrgInfoMapper.getOrgTreeListBySuperId(superId);
	}
	
	@Override
	public List<SysOrgInfo> getOrgNotIn(List<String> orgIds){
		return sysOrgInfoMapper.findOrgNotIn(orgIds);
	}
	
	@Override
	public List<SysOrgInfo> getOrgIn(List<String> orgIds){
		return sysOrgInfoMapper.findOrgIn(orgIds);
	}
}
