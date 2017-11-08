package com.hisign.xingzhen.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hisign.xingzhen.sys.api.model.SysCommonDict;
import com.hisign.xingzhen.sys.api.model.SysDict;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public interface SysDictMapper {

    List<SysDict> querySingleDictByRoot(String root);

    List<SysDict> queryMultiDictByRoot(String root);

    SysDict queryDictByKey(SysDict query);

    List<SysDict> queryDictListByKeys(SysDict query);

    List<SysDict> queryDictListByCondition(SysDict query);

    List<SysCommonDict> findCommDictList(Map<String, String> map);

    int deleteCommon(String id);

    int insertCommon(Map<String, String> node);

    /**
     * 新建组
     */
    int addDictGroup(Map<String, String> map);

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
     * 分组重命名
     * @param map
     */
    void renameDictGroup(Map<String, String> map);

    /**
     * 查询要插入的字典在字典表中存在，且在常用字典中当前用户下不存在
     * @param map
     * @return
     */
    SysDict findDictInfoForCommonDict(Map<String, String> map);

    /**
     * 插入常用字典表
     * @param map
     */
    void addCommonDict(Map<String, String> map);

    /**
     * 获取guid
     * @return
     */
    String getGuid();

    /**
     * 获取当前用户下的单位代码
     * @param userUnit
     */
    public List<SysCommonDict> initDictForGXSDM(String userUnit);

	List<SysDict> getDictListByParentKey(SysDict sysDict);

	Long getCountDictListByParentKey(SysDict sysDict);

	List<SysDict> getDictListByRootKey(SysDict sysDict);

	int getDictCountByParentKey(SysDict sysDict);

	int delDictByKey(@Param("key") String key, @Param("rootKey") String rootKey);

	int delDictById(@Param("id") String id);

	SysDict selectById(@Param("id") String id);

	int checkExitByKey(@Param("key") String key, @Param("parentKey") String parentKey, @Param("root") String root);

	int insertDict(SysDict sysDict);

	int updateDict(SysDict sysDict);
	
	SysDict findDictByPKAndDK(@Param("parentKey") String parentKey,@Param("dictKey") String dictKey);

}


