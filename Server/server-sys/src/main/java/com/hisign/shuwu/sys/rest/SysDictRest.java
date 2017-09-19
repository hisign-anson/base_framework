package com.hisign.shuwu.sys.rest;

import com.hisign.shuwu.common.model.JsonResult;
import com.hisign.shuwu.sys.api.model.SysCommonDict;
import com.hisign.shuwu.sys.api.model.SysDict;
import com.hisign.shuwu.sys.api.model.TreeModel;
import com.hisign.shuwu.sys.api.service.SysDictService;
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
    @RequestMapping(value = "/querySingleDictByRoot", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> querySingleDictByRoot(@RequestParam String root) {
        return sysDictService.querySingleDictByRoot(root);
    }

    @Override
    @RequestMapping(value = "/queryMultiDictByRoot", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> queryMultiDictByRoot(@RequestParam String root) {
        return sysDictService.queryMultiDictByRoot(root);
    }

    @Override
    @RequestMapping(value = "/queryDictByKey", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysDict queryDictByKey(@RequestParam String root, @RequestParam String key) {
        return sysDictService.queryDictByKey(root,key);
    }

    @Override
    @RequestMapping(value = "/queryDictListByKeys", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> queryDictListByKeys(@RequestParam String root, @RequestParam String keys) {
        return sysDictService.queryDictListByKeys(root,keys);
    }

    @Override
    @RequestMapping(value = "/queryDictListByCondition", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> queryDictListByCondition(@RequestParam String root, @RequestParam String queryType, @RequestParam String queryString) {
        return sysDictService.queryDictListByCondition(root,queryType,queryString);
    }

    @Override
    @RequestMapping(value = "/findCommDictList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysCommonDict> findCommDictList(@RequestParam String userId, @RequestParam String rootKey) {
        return sysDictService.findCommDictList(userId,rootKey);
    }

    @Override
    @RequestMapping(value = "/deleteCommon", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int deleteCommon(@RequestParam String id) {
        return sysDictService.deleteCommon(id);
    }

    @Override
    @RequestMapping(value = "/insertCommon", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int insertCommon(@RequestBody Map<String, String> node) {
        return sysDictService.insertCommon(node);
    }

    @Override
    @RequestMapping(value = "/addDictGroup", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addDictGroup(@RequestBody Map<String, String> map) {
        return sysDictService.addDictGroup(map);
    }

    @Override
    @RequestMapping(value = "/deleteCommDictById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteCommDictById(@RequestParam String groupId) {
        sysDictService.deleteCommDictById(groupId);
    }

    @Override
    @RequestMapping(value = "/deleteDictInGroup", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteDictInGroup(@RequestParam String groupId) {
        sysDictService.deleteDictInGroup(groupId);
    }

    @Override
    @RequestMapping(value = "/renameDictGroup", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void renameDictGroup(@RequestParam String groupId, @RequestParam String groupName) {
        sysDictService.renameDictGroup(groupId, groupName);
    }

    @Override
    @RequestMapping(value = "/addCommDict", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addCommDict(@RequestParam String rootKey, @RequestParam String dictKey, @RequestParam String groupId, @RequestParam String userId) throws Exception {
        return sysDictService.addCommDict(rootKey, dictKey, groupId, userId);
    }

    @Override
    @RequestMapping(value = "/getGuid", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getGuid() {
        return sysDictService.getGuid();
    }

    @Override
    @RequestMapping(value = "/initDictForGXSDM", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysCommonDict> initDictForGXSDM(@RequestParam String userUnit) throws Exception {
        return sysDictService.initDictForGXSDM(userUnit);
    }

    @Override
    @RequestMapping(value = "/getDictListByParentKey", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> getDictListByParentKey(@RequestBody SysDict sysDict) {
        return sysDictService.getDictListByParentKey(sysDict);
    }

    @Override
    @RequestMapping(value = "/getDictListByRootKey", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> getDictListByRootKey(@RequestBody SysDict sysDict) {
        return sysDictService.getDictListByRootKey(sysDict);
    }

    @Override
    @RequestMapping(value = "/getDictCountByParentKey", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int getDictCountByParentKey(@RequestBody SysDict sysDict) {
        return sysDictService.getDictCountByParentKey(sysDict);
    }

    @Override
    @RequestMapping(value = "/getDictTreeByParentKey", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<TreeModel> getDictTreeByParentKey(@RequestBody SysDict sysDict) {
        return sysDictService.getDictTreeByParentKey(sysDict);
    }

    @Override
    @RequestMapping(value = "/delDictByKey", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void delDictByKey(@RequestParam String key, @RequestParam String rootKey) {
        sysDictService.delDictByKey(key, rootKey);
    }

    @Override
    @RequestMapping(value = "/delDictById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void delDictById(@RequestParam String id) {
        sysDictService.delDictById(id);
    }

    @Override
    @RequestMapping(value = "/getDictById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysDict getDictById(@RequestParam String id) {
        return sysDictService.getDictById(id);
    }

    @Override
    @RequestMapping(value = "/addDict", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addDict(@RequestBody SysDict sysDict) {
        return sysDictService.addDict(sysDict);
    }

    @Override
    @RequestMapping(value = "/updateDict", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateDict(@RequestBody SysDict sysDict) {
        return sysDictService.updateDict(sysDict);
    }
}
