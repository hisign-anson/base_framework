package com.hisign.xingzhen.sys.service;


import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.common.util.JsonResultUtil;
import com.hisign.xingzhen.sys.api.model.SysOrgInfo;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.service.SysOrgInfoService;
import com.hisign.xingzhen.sys.mapper.SysOrgInfoMapper;
import com.hisign.xingzhen.sys.mapper.SysUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysOrgInfoService")
public class SysOrgInfoServiceImpl implements SysOrgInfoService {
    @Autowired
	private SysOrgInfoMapper sysOrgInfoMapper;
    
    @Autowired
	private SysUserInfoMapper sysUserInfoMapper;

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

	@Override
	public JsonResult getTreeListBySuperId(String superId){
		SysOrgInfo orgInfo = new SysOrgInfo();
		orgInfo.setSuperId(superId);
		orgInfo.setEnd(Integer.MAX_VALUE);
		//获取下属单位列表
		List<SysOrgInfo> list = sysOrgInfoMapper.queryListByCondition(orgInfo);

		//获取该单位下的人，不需要子单位的人
		SysUserInfo userInfo = new SysUserInfo();
		userInfo.setOrgId(superId);
		userInfo.setEnd(Integer.MAX_VALUE);
		List<SysUserInfo> userInfoList = sysUserInfoMapper.queryListByCondition(userInfo);
		long num = sysUserInfoMapper.findAllCountBySuperId(superId);
		Map<String, Object> map = new HashMap<>();
		map.put("orgList",list);
		map.put("num",num);
		map.put("userList",userInfoList);

		//所有人数
		if (list!=null && list.size()>0){
			for (SysOrgInfo sysOrgInfo : list) {
				//获取每个单位下的人数
				orgInfo.setSuperId(sysOrgInfo.getOrgId());
				num = sysUserInfoMapper.findAllCountBySuperId(sysOrgInfo.getOrgId());
				sysOrgInfo.setUserNum(num);
			}
		}
		return JsonResultUtil.success(map);
	}
}
