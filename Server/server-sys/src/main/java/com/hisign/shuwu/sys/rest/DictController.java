package com.hisign.shuwu.sys.rest;


import com.hisign.shuwu.common.model.JsonResult;
import com.hisign.shuwu.common.util.JsonResultUtil;
import com.hisign.shuwu.sys.api.model.SysCommonDict;
import com.hisign.shuwu.sys.api.model.SysDict;
import com.hisign.shuwu.sys.api.model.TreeModel;
import com.hisign.shuwu.sys.api.service.SysDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 系统字典控件控制器
 *
 */
@RequestMapping("/sys/dict")
@RestController
public class DictController {

	private static final Logger logger = LoggerFactory.getLogger(DictController.class);

    @Resource
    private SysDictService sysDictService;

    
    

    /**
     * 单级字典查询
     *
     * @param root
     * @return
     */
    @RequestMapping(value = "/single", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult singleDict(@RequestParam String root) {
        List<SysDict> list = sysDictService.querySingleDictByRoot(root);
        return JsonResultUtil.success(list);
    }


    /**
     * 多级字典查询
     *
     * @param root
     * @return
     */
    @RequestMapping(value = "/multi", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult multiDict(@RequestParam String root) {
        List<SysDict> resultList = sysDictService.queryMultiDictByRoot(root);;
        return JsonResultUtil.success(resultList);
    }

    /**
     * 根据字典key查询字典信息
     *
     * @param root
     * @param key
     * @return
     */
    @RequestMapping(value = "/{root}/{key}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getDictByKey(@PathVariable("root") String root, @PathVariable("key") String key) {
        SysDict dict = this.sysDictService.queryDictByKey(root, key);
        return JsonResultUtil.success(dict);
    }

    /**
     * 根据多个字典key查询字典信息（英文逗号分隔）
     *
     * @param root
     * @param keys
     * @return
     */
    @RequestMapping(value = "/keys", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getDicstByKeys(@RequestParam String root, @RequestParam String keys) {
        List<SysDict> list = this.sysDictService.queryDictListByKeys(root, keys);
        return JsonResultUtil.success(list);
    }

    /**
     * 根据条件查询字典信息
     *
     * @param root
     * @param queryType
     * @param queryString
     * @return
     */
    @RequestMapping(value = "/{root}/query", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult queryDictList(@PathVariable("root") String root, @RequestParam("queryType") String queryType, @RequestParam("queryString") String queryString) {
        String query = "";
        try {
            query = URLDecoder.decode(queryString, "UTF-8");
        } catch (Exception e) {
            query = queryString;
        }
        List<SysDict> list = this.sysDictService.queryDictListByCondition(root, queryType, query);

        return JsonResultUtil.success(list);
    }

    /**
     * 根据条件查询字典信息
     *
     * @param root
     * @param queryType
     * @param queryString
     * @return
     */
    @RequestMapping(value = "/{root}/query/json", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult queryDictListWithFlag(@PathVariable("root") String root, @RequestParam("queryType") String queryType, @RequestParam("queryString") String queryString) {
        try {
            String query = URLDecoder.decode(queryString, "UTF-8");
            List<SysDict> list = this.sysDictService.queryDictListByCondition(root, queryType, query);
            return JsonResultUtil.success(list);
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }

    /**
     * 删除常用项
     *
     * @return
     */
    @RequestMapping(value = "/delete/commonDict", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteCommon(@RequestParam String groupId) {
        logger.info("删除编号为[{}]的常用字典", groupId);
        try {
            //删除字典
            sysDictService.deleteCommDictById(groupId);
            //删除字典组
            sysDictService.deleteDictInGroup(groupId);
            return JsonResultUtil.success();
        } catch (Exception e) {
            return JsonResultUtil.error("删除常用字典失败！");
        }
    }

    /**
     * 添加常用项
     *
     * @return
     */
    @RequestMapping(value = "/insert/commonDict", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult insertCommon(@RequestBody Map<String, String> param) {
        try {
        	String userId = param.get("userId");  
        	String rootKey = param.get("rootKey");
        	String dictKey = param.get("dictKey");
        	String groupId = param.get("groupId");
            //插入常用字典
            String id = sysDictService.addCommDict(rootKey.toUpperCase(), dictKey, groupId, userId);
            return JsonResultUtil.success(id);
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }

    /**
     * 查询常用项
     *
     * @return
     */
    @RequestMapping(value = "/search/commonDict", method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult searchCommon(@RequestParam String userId, @RequestParam String root) {
        try {
            List<SysCommonDict> commonDictList = sysDictService.findCommDictList(userId, root.toUpperCase());//常用字典
            return JsonResultUtil.success(commonDictList);
        } catch (Exception e) {
            logger.error("查询常用字典项", e);
            return JsonResultUtil.error(e.getMessage());
        }
    }

    /**
     * 新建组
     *
     * @return
     */
    @RequestMapping(value = "/insert/group", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult insertGroup(@RequestBody Map<String, String> param) {
        try {
            //插入组并且返回ID
            String groupId = sysDictService.addDictGroup(param);
            return JsonResultUtil.success(groupId);
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }

    /**
     * 分组重命名
     *
     * @return
     */
    @RequestMapping(value = "/update/rename", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult renameGroup(@RequestBody Map<String, String> param) {
        try {
        	String groupId = param.get("groupId");
        	String groupName =  param.get("groupName");
            //修改组名
            sysDictService.renameDictGroup(groupId, groupName);
            return JsonResultUtil.success();
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }
    @RequestMapping(value = "/getDictListByParentKey", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult getDictListByParentKey(@RequestBody SysDict param) {
        try {
        	param.setParentKey(param.getKey());
            List<SysDict> list =  sysDictService.getDictListByParentKey(param);
            int count =  sysDictService.getDictCountByParentKey(param);
            return JsonResultUtil.success(count,list);
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }
    @RequestMapping(value = "/getDictTreeByParentKey", method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public List<TreeModel> getDictTreeByParentKey(@RequestParam(required = false) String id) {
    	
        try {
        	SysDict param = new SysDict();
        	param.setParentKey(id);
            return sysDictService.getDictTreeByParentKey(param);
        } catch (Exception e) {
            return new ArrayList<TreeModel>();
        }
    }
    @RequestMapping(value = "{key}/delDictByKey/{rootKey}", method = RequestMethod.DELETE,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult delDictByKey(@PathVariable String key,@PathVariable String rootKey) {
    	try {
            sysDictService.delDictByKey(key,rootKey);
            return JsonResultUtil.success();
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }
    @RequestMapping(value = "{id}/delDictById", method = RequestMethod.DELETE,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult delDictById(@PathVariable String id) {
    	try {
            sysDictService.delDictById(id);
            return JsonResultUtil.success();
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }
    @RequestMapping(value = "/getDictById", method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult getDictById(@RequestParam String id) {
    	try {
    		SysDict sysDict = sysDictService.getDictById(id);
            return JsonResultUtil.success(sysDict);
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/addDict", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult addDict(@RequestBody SysDict param) {
    	try {
            return sysDictService.addDict(param);
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/updateDict", method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public JsonResult updateDict(@RequestBody SysDict param) {
    	try {
            return sysDictService.updateDict(param);
        } catch (Exception e) {
            return JsonResultUtil.error(e.getMessage());
        }
    }
    
    

}
