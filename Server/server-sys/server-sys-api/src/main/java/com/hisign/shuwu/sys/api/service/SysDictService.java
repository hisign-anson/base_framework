package com.hisign.shuwu.sys.api.service;

import java.util.List;
import java.util.Map;

import com.hisign.shuwu.common.model.JsonResult;
import com.hisign.shuwu.sys.api.model.SysCommonDict;
import com.hisign.shuwu.sys.api.model.SysDict;
import com.hisign.shuwu.sys.api.model.TreeModel;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public interface SysDictService {

    /**
     * 单级字典查询
     * @param root 字典类型
     * @return
     */
    public List<SysDict> querySingleDictByRoot(String root);

    /**
     * 多级字典查询
     * @param root 字典类型
     * @return
     */
    public List<SysDict> queryMultiDictByRoot(String root);

    /**
     * 根据字典代码查询字典信息
     * @param root 字典类型
     * @param key 字典代码
     * @return
     */
    public SysDict queryDictByKey(String root, String key);

    /**
     * 根据多个字典代码(使用英文逗号分隔)查询字典信息
     * @param root 字典类型
     * @param keys 字典代码字符串
     * @return
     */
    public List<SysDict> queryDictListByKeys(String root, String keys);

    /**
     * 字典查询
     * @param root 字典类型
     * @param queryType 查询类型 1-代码 2-拼音 3-中文
     * @param queryString 查询条件
     * @return
     */
    public List<SysDict> queryDictListByCondition(String root, String queryType, String queryString);

    /**
     * 查询常用字典
     * @param userId
     * @param rootKey
     * @return
     */
    public List<SysCommonDict> findCommDictList(String userId, String rootKey);

    /**
     * 删除常用字典
     * @return
     */
    public int deleteCommon(String id);

    /**
     * 插入常用字典
     */
    public int insertCommon(Map<String, String> node);

    /**
     * 新建组
     */
    String addDictGroup(Map<String, String> map);

    /**
     * 根据id删除常用节点
     * @param groupId
     */
    void deleteCommDictById(String groupId);

    /**
     * 根据id删除常用组
     * @param groupId
     */
    void deleteDictInGroup(String groupId);

    /**
     * 修改组名
     * @param groupId
     * @param groupName
     */
    void renameDictGroup(String groupId, String groupName);

    /**
     * 新增常用项
     * @param rootKey
     * @param dictKey
     * @param groupId
     * @param userId
     * @return
     * @throws Exception
     */
    String addCommDict(String rootKey, String dictKey, String groupId, String userId) throws Exception;

    /**
     * 获取guid()
     * @return
     */
    public String getGuid();

    /**
     * 获取当前用户下的单位代码
     * @param userUnit
     * @return
     * @throws Exception
     */
    public List<SysCommonDict> initDictForGXSDM(String userUnit) throws Exception;

	public List<SysDict> getDictListByParentKey(SysDict sysDict);
	
	public List<SysDict> getDictListByRootKey(SysDict sysDict);

	public int getDictCountByParentKey(SysDict sysDict);

	public List<TreeModel> getDictTreeByParentKey(SysDict sysDict);

	public void delDictByKey(String key, String rootKey);

	public void delDictById(String id);

	public SysDict getDictById(String id);

	public JsonResult addDict(SysDict sysDict);

	public JsonResult updateDict(SysDict sysDict);

}
