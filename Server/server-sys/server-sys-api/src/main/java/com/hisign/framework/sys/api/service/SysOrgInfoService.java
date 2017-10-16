package com.hisign.framework.sys.api.service;

import com.hisign.framework.common.model.JsonResult;
import com.hisign.framework.sys.api.model.SysOrgInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "sysService",path = "/sys/sysOrgInfoService")
public interface SysOrgInfoService {

	@RequestMapping(value = "/queryListByCondition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<SysOrgInfo> queryListByCondition(@RequestBody SysOrgInfo info);

	@RequestMapping(value = "/getOrgInfoByID", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public SysOrgInfo getOrgInfoByID(@RequestParam(value = "orgId") String orgId);

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult add(@RequestBody SysOrgInfo info);

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult update(@RequestBody SysOrgInfo info);

	@RequestMapping(value = "/deleteByKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public void deleteByKey(@RequestParam(value = "orgId") String orgId);

	@RequestMapping(value = "/getOrgTreeListBySuperId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<SysOrgInfo> getOrgTreeListBySuperId(@RequestParam(value = "superId") String superId);

	@RequestMapping(value = "/getOrgInfoByName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public SysOrgInfo getOrgInfoByName(@RequestParam(value = "name") String name);

	@RequestMapping(value = "/getOrgNotIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<SysOrgInfo> getOrgNotIn(@RequestBody List<String> orgIds);

	@RequestMapping(value = "/getOrgIn", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<SysOrgInfo> getOrgIn(@RequestBody List<String> orgIds);

}