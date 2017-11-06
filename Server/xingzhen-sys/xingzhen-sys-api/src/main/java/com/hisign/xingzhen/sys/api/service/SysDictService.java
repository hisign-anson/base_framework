package com.hisign.xingzhen.sys.api.service;

import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.sys.api.model.SysCommonDict;
import com.hisign.xingzhen.sys.api.model.SysDict;
import com.hisign.xingzhen.sys.api.model.TreeModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@FeignClient(name = "sysService",path = "/sys/sysDictService")
public interface SysDictService {

    /**
     * 单级字典查询
     * @param root 字典类型
     * @return
     */
    @RequestMapping(value = "/querySingleDictByRoot", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> querySingleDictByRoot(@RequestParam(value = "root") String root);

    /**
     * 多级字典查询
     * @param root 字典类型
     * @return
     */
    @RequestMapping(value = "/queryMultiDictByRoot", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> queryMultiDictByRoot(@RequestParam(value = "root") String root);

    /**
     * 根据字典代码查询字典信息
     * @param root 字典类型
     * @param key 字典代码
     * @return
     */
    @RequestMapping(value = "/queryDictByKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysDict queryDictByKey(@RequestParam(value = "root") String root, @RequestParam(value = "key") String key);

    /**
     * 根据多个字典代码(使用英文逗号分隔)查询字典信息
     * @param root 字典类型
     * @param keys 字典代码字符串
     * @return
     */
    @RequestMapping(value = "/queryDictListByKeys", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> queryDictListByKeys(@RequestParam(value = "root") String root, @RequestParam(value = "keys") String keys);

    /**
     * 字典查询
     * @param root 字典类型
     * @param queryType 查询类型 1-代码 2-拼音 3-中文
     * @param queryString 查询条件
     * @return
     */
    @RequestMapping(value = "/queryDictListByCondition", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> queryDictListByCondition(@RequestParam(value = "root") String root, @RequestParam(value = "queryType") String queryType, @RequestParam(value = "queryString") String queryString);

    /**
     * 查询常用字典
     * @param userId
     * @param rootKey
     * @return
     */
    @RequestMapping(value = "/findCommDictList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysCommonDict> findCommDictList(@RequestParam(value = "userId") String userId, @RequestParam(value = "rootKey") String rootKey);

    /**
     * 删除常用字典
     * @return
     */
    @RequestMapping(value = "/deleteCommon", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int deleteCommon(@RequestParam(value = "id") String id);

    /**
     * 插入常用字典
     */
    @RequestMapping(value = "/insertCommon", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int insertCommon(@RequestBody Map<String, String> node);

    /**
     * 新建组
     */
    @RequestMapping(value = "/addDictGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addDictGroup(@RequestBody Map<String, String> map);

    /**
     * 根据id删除常用节点
     * @param groupId
     */
    @RequestMapping(value = "/deleteCommDictById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteCommDictById(@RequestParam(value = "groupId") String groupId);

    /**
     * 根据id删除常用组
     * @param groupId
     */
    @RequestMapping(value = "/deleteDictInGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void deleteDictInGroup(@RequestParam(value = "groupId") String groupId);

    /**
     * 修改组名
     * @param groupId
     * @param groupName
     */
    @RequestMapping(value = "/renameDictGroup", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void renameDictGroup(@RequestParam(value = "groupId") String groupId, @RequestParam(value = "groupName") String groupName);

    /**
     * 新增常用项
     * @param rootKey
     * @param dictKey
     * @param groupId
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addCommDict", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addCommDict(@RequestParam(value = "rootKey") String rootKey, @RequestParam(value = "dictKey") String dictKey, @RequestParam(value = "groupId") String groupId, @RequestParam(value = "userId") String userId) throws Exception;

    /**
     * 获取guid()
     * @return
     */
    @RequestMapping(value = "/getGuid", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getGuid();

    /**
     * 获取当前用户下的单位代码
     * @param userUnit
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/initDictForGXSDM", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysCommonDict> initDictForGXSDM(@RequestParam(value = "userUnit") String userUnit) throws Exception;

    @RequestMapping(value = "/getDictListByParentKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> getDictListByParentKey(@RequestBody SysDict sysDict);

    @RequestMapping(value = "/getCountDictListByParentKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Long getCountDictListByParentKey(@RequestBody SysDict sysDict);

    @RequestMapping(value = "/getDictListByRootKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysDict> getDictListByRootKey(@RequestBody SysDict sysDict);

    @RequestMapping(value = "/getDictCountByParentKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public int getDictCountByParentKey(@RequestBody SysDict sysDict);

    @RequestMapping(value = "/getDictTreeByParentKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<TreeModel> getDictTreeByParentKey(@RequestBody SysDict sysDict);

    @RequestMapping(value = "/delDictByKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void delDictByKey(@RequestParam(value = "key") String key, @RequestParam(value = "rootKey") String rootKey);

    @RequestMapping(value = "/delDictById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void delDictById(@RequestParam(value = "id") String id);

    @RequestMapping(value = "/getDictById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysDict getDictById(@RequestParam(value = "id") String id);

    @RequestMapping(value = "/addDict", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addDict(@RequestBody SysDict sysDict);

    @RequestMapping(value = "/updateDict", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateDict(@RequestBody SysDict sysDict);

}
