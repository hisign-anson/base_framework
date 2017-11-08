package com.hisign.xingzhen.sys.rest;

import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.sys.api.model.SysCommonDict;
import com.hisign.xingzhen.sys.api.model.SysDict;
import com.hisign.xingzhen.sys.api.model.TreeModel;
import com.hisign.xingzhen.sys.api.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/sysDictService")
@RestController
public class SysDictRest implements SysDictService {

    @Autowired
    @Resource(name = "sysDictService")
    private SysDictService sysDictService;

    @Override
    @RequestMapping(value = "/querySingleDictByRoot", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> querySingleDictByRoot(@RequestParam(value = "root") String root) {
        return sysDictService.querySingleDictByRoot(root);
    }

    @Override
    @RequestMapping(value = "/queryMultiDictByRoot", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> queryMultiDictByRoot(@RequestParam(value = "root") String root) {
        return sysDictService.queryMultiDictByRoot(root);
    }

    @Override
    @RequestMapping(value = "/queryDictByKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysDict queryDictByKey(@RequestParam(value = "root") String root, @RequestParam(value = "key") String key) {
        return sysDictService.queryDictByKey(root,key);
    }

    @Override
    @RequestMapping(value = "/queryDictListByKeys", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> queryDictListByKeys(@RequestParam(value = "root") String root, @RequestParam(value = "keys") String keys) {
        return sysDictService.queryDictListByKeys(root,keys);
    }

    @Override
    @RequestMapping(value = "/queryDictListByCondition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> queryDictListByCondition(@RequestParam(value = "root") String root, @RequestParam(value = "queryType") String queryType, @RequestParam(value = "queryString") String queryString) {
        return sysDictService.queryDictListByCondition(root,queryType,queryString);
    }

    @Override
    @RequestMapping(value = "/findCommDictList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysCommonDict> findCommDictList(@RequestParam(value = "userId") String userId, @RequestParam(value = "rootKey") String rootKey) {
        return sysDictService.findCommDictList(userId,rootKey);
    }

    @Override
    @RequestMapping(value = "/deleteCommon", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int deleteCommon(@RequestParam(value = "id") String id) {
        return sysDictService.deleteCommon(id);
    }

    @Override
    @RequestMapping(value = "/insertCommon", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int insertCommon(@RequestBody Map<String, String> node) {
        return sysDictService.insertCommon(node);
    }

    @Override
    @RequestMapping(value = "/addDictGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String addDictGroup(@RequestBody Map<String, String> map) {
        return sysDictService.addDictGroup(map);
    }

    @Override
    @RequestMapping(value = "/deleteCommDictById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void deleteCommDictById(@RequestParam(value = "groupId") String groupId) {
        sysDictService.deleteCommDictById(groupId);
    }

    @Override
    @RequestMapping(value = "/deleteDictInGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void deleteDictInGroup(@RequestParam(value = "groupId") String groupId) {
        sysDictService.deleteDictInGroup(groupId);
    }

    @Override
    @RequestMapping(value = "/renameDictGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void renameDictGroup(@RequestParam(value = "groupId") String groupId, @RequestParam(value = "groupName") String groupName) {
        sysDictService.renameDictGroup(groupId, groupName);
    }

    @Override
    @RequestMapping(value = "/addCommDict", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addCommDict(@RequestParam(value = "rootKey") String rootKey, @RequestParam(value = "dictKey") String dictKey, @RequestParam(value = "groupId") String groupId, @RequestParam(value = "userId") String userId) throws Exception {
        return sysDictService.addCommDict(rootKey, dictKey, groupId, userId);
    }

    @Override
    @RequestMapping(value = "/getGuid", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getGuid() {
        return sysDictService.getGuid();
    }

    @Override
    @RequestMapping(value = "/initDictForGXSDM", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysCommonDict> initDictForGXSDM(@RequestParam(value = "userUnit") String userUnit) throws Exception {
        return sysDictService.initDictForGXSDM(userUnit);
    }

    @Override
    @RequestMapping(value = "/getDictListByParentKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> getDictListByParentKey(@RequestBody SysDict sysDict) {
        return sysDictService.getDictListByParentKey(sysDict);
    }

    @Override
    @RequestMapping(value = "/getCountDictListByParentKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Long getCountDictListByParentKey(SysDict sysDict) {
        return sysDictService.getCountDictListByParentKey(sysDict);
    }

    @Override
    @RequestMapping(value = "/getDictListByRootKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> getDictListByRootKey(@RequestBody SysDict sysDict) {
        return sysDictService.getDictListByRootKey(sysDict);
    }

    @Override
    @RequestMapping(value = "/getDictCountByParentKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int getDictCountByParentKey(@RequestBody SysDict sysDict) {
        return sysDictService.getDictCountByParentKey(sysDict);
    }

    @Override
    @RequestMapping(value = "/getDictTreeByParentKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<TreeModel> getDictTreeByParentKey(@RequestBody SysDict sysDict) {
        return sysDictService.getDictTreeByParentKey(sysDict);
    }

    @Override
    @RequestMapping(value = "/delDictByKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void delDictByKey(@RequestParam(value = "key") String key, @RequestParam(value = "rootKey") String rootKey) {
        sysDictService.delDictByKey(key, rootKey);
    }

    @Override
    @RequestMapping(value = "/delDictById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public void delDictById(@RequestParam(value = "id") String id) {
        sysDictService.delDictById(id);
    }

    @Override
    @RequestMapping(value = "/getDictById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysDict getDictById(@RequestParam(value = "id") String id) {
        return sysDictService.getDictById(id);
    }

    @Override
    @RequestMapping(value = "/addDict", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addDict(@RequestBody SysDict sysDict) {
        return sysDictService.addDict(sysDict);
    }

    @Override
    @RequestMapping(value = "/updateDict", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateDict(@RequestBody SysDict sysDict) {
        return sysDictService.updateDict(sysDict);
    }

    @Override
    @RequestMapping(value = "/getDictByPKAndDK", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysDict getDictByPKAndDK(@RequestParam(value="parentKey") String parentKey, @RequestParam(value="dictKey") String dictKey) {
        return sysDictService.getDictByPKAndDK(parentKey,dictKey);
    }
}
