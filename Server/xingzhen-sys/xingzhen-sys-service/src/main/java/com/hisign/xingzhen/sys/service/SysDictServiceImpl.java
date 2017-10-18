package com.hisign.xingzhen.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.common.util.JsonResultUtil;
import com.hisign.xingzhen.common.util.PingYinUtil;
import com.hisign.xingzhen.sys.api.model.SysCommonDict;
import com.hisign.xingzhen.sys.api.model.SysDict;
import com.hisign.xingzhen.sys.api.model.TreeModel;
import com.hisign.xingzhen.sys.api.service.SysDictService;
import com.hisign.xingzhen.sys.mapper.SysDictMapper;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
@Service("sysDictService")
public class SysDictServiceImpl implements SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    /**
     * 单级字典查询
     * @param root 字典类型
     * @return
     */
    @Override
    public List<SysDict> querySingleDictByRoot(String root) {
        List<SysDict> list = sysDictMapper.querySingleDictByRoot(root.toUpperCase());
        return list;
    }

    /**
     * 多级字典查询
     * @param root 字典类型
     * @return
     */
    @Override
    public List<SysDict> queryMultiDictByRoot(String root) {
        List<SysDict> list = sysDictMapper.queryMultiDictByRoot(root.toUpperCase());
        return list;
    }

    /**
     * 根据字典代码查询字典信息
     * @param root 字典类型
     * @param key 字典代码
     * @return
     */
    @Override
    public SysDict queryDictByKey(String root, String key) {
        SysDict query = new SysDict();
        query.setRoot(root.toUpperCase());
        query.setKey(key);
        SysDict dict = sysDictMapper.queryDictByKey(query);
        return dict;
    }

    /**
     * 根据多个字典代码(使用英文逗号分隔)查询字典信息
     * @param root 字典类型
     * @param keys 字典代码字符串
     * @return
     */
    @Override
    public List<SysDict> queryDictListByKeys(String root, String keys){
        SysDict query = new SysDict();
        query.setRoot(root.toUpperCase());
        query.setKeys(keys.split(","));
        List<SysDict> list = sysDictMapper.queryDictListByKeys(query);
        return list;
    }

    /**
     * 字典查询
     * @param root 字典类型
     * @param queryType 查询类型 1-代码 2-拼音 3-中文
     * @param queryString 查询条件
     * @return
     */
    @Override
    public List<SysDict> queryDictListByCondition(String root, String queryType, String queryString) {
        SysDict query = new SysDict();
        query.setRoot(root.toUpperCase());
        query.setQueryString(queryString.toUpperCase());
        query.setQueryType(queryType);
        List<SysDict> list = sysDictMapper.queryDictListByCondition(query);
        return list;
    }

    /**
     * 查询常用字典
     * @param userId
     * @param rootKey
     * @return
     */
    public List<SysCommonDict> findCommDictList(String userId, String rootKey){
        Map<String,String> map = new HashMap<String,String>();
        map.put("userId", userId);
        map.put("rootKey", rootKey);
        return sysDictMapper.findCommDictList(map);
    }

    /**
     * 删除常用字典
     * @return
     */
    public int deleteCommon(String id){
        return sysDictMapper.deleteCommon(id);
    }

    /**
     * 插入常用字典
     */
    public int insertCommon(Map<String,String> node){
        return sysDictMapper.insertCommon(node);
    }

    /**
     * 新建组
     */
    public String addDictGroup(Map<String,String> map){
        sysDictMapper.addDictGroup(map);
        return map.get("id");
    }

    /**
     * 根据id删除常用节点
     * @param groupId
     */
    public void deleteCommDictById(String groupId){
        sysDictMapper.deleteCommDictById(groupId);
    }

    /**
     * 根据id删除常用组
     * @param groupId
     */
    public void deleteDictInGroup(String groupId){
        sysDictMapper.deleteDictInGroup(groupId);
    }

    /**
     * 修改组名
     * @param groupId
     * @param groupName
     */
    public void renameDictGroup(String groupId,String groupName){
        Map<String,String> map = new HashMap<String,String>();
        map.put("groupId",groupId);
        map.put("groupName",groupName);
        sysDictMapper.renameDictGroup(map);
    }

    /**
     * 新增常用项
     * @param rootKey
     * @param dictKey
     * @param groupId
     * @param userId
     * @return
     * @throws Exception
     */
    public String addCommDict(String rootKey, String dictKey, String groupId, String userId) throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        map.put("rootKey", rootKey);
        map.put("dictKey", dictKey);
        map.put("userId", userId);
        map.put("groupId", groupId);
        //判断要插入的字典在字典表中存在，且在常用字典中当前用户下不存在
        SysDict sysDict = sysDictMapper.findDictInfoForCommonDict( map);
        if(sysDict == null) return null;
        map.put("dictId", sysDict.getId());
        //map.put("id","");//作为返回值
        //插入常用字典表
        sysDictMapper.addCommonDict(map);
        return map.get("id");
    }

    public String getGuid(){
        return sysDictMapper.getGuid();
    }

    /**
     * 获取当前用户下的单位代码
     * @param userUnit
     * @return
     * @throws Exception
     */
    public List<SysCommonDict> initDictForGXSDM(String userUnit) throws Exception{
        List<SysCommonDict> list;
        if(null==userUnit||"".equals(userUnit)){
            list = new ArrayList<SysCommonDict>() ;
        }else{
            list = sysDictMapper.initDictForGXSDM(userUnit);
        }
        return list;
    }

	@Override
	public List<SysDict> getDictListByParentKey(SysDict sysDict) {
		return sysDictMapper.getDictListByParentKey(sysDict);
	}

	@Override
	public int getDictCountByParentKey(SysDict sysDict) {
		return sysDictMapper.getDictCountByParentKey(sysDict);
	}
	@Override
	public List<SysDict> getDictListByRootKey(SysDict sysDict) {
		return sysDictMapper.getDictListByRootKey(sysDict);
	}

	@Override
	public List<TreeModel> getDictTreeByParentKey(SysDict sysDict) {
		List<TreeModel> trList = new ArrayList<TreeModel>();
		List<SysDict> list = sysDictMapper.getDictListByParentKey(sysDict);
		for (SysDict dict : list) {
			TreeModel treeModel = new TreeModel();
			treeModel.setId(dict.getKey());
			treeModel.setName(dict.getValue());
			treeModel.setIsParent(this.getDictCountByParentKey(dict)>0);
			treeModel.setpId(dict.getParentKey()==null?"":dict.getParentKey());
			treeModel.setSort(dict.getSort());
			treeModel.setRootKey(dict.getRoot());
			trList.add(treeModel);
		}
		return trList;
	}

	@Override
	public void delDictByKey(String key,String rootKey) {
		sysDictMapper.delDictByKey(key,rootKey);
	}

	@Override
	public void delDictById(String id) {
		sysDictMapper.delDictById(id);
	}

	@Override
	public SysDict getDictById(String id) {
		return sysDictMapper.selectById(id);
	}

	@Override
	public JsonResult addDict(SysDict sysDict) {
		int count = sysDictMapper.checkExitByKey(sysDict.getKey(),sysDict.getParentKey(),sysDict.getRoot());
		if(count > 0){
			return JsonResultUtil.error("字典值已存在，请重新输入");
		}
		sysDict.setPy(PingYinUtil.getFirstSpell(sysDict.getValue()));
		sysDictMapper.insertDict(sysDict);
		return JsonResultUtil.success();
	}

	@Override
	public JsonResult updateDict(SysDict sysDict) {
		SysDict oldSysDict = sysDictMapper.selectById(sysDict.getId());
		if(!oldSysDict.getKey().equals(sysDict.getKey())){
			int count = sysDictMapper.checkExitByKey(sysDict.getKey(),sysDict.getParentKey(),sysDict.getRoot());
			if(count > 0){
				return JsonResultUtil.error("字典值已存在，请重新输入");
			}
		}
		sysDict.setPy(PingYinUtil.getFirstSpell(sysDict.getValue()));
		sysDictMapper.updateDict(sysDict);
		return JsonResultUtil.success();
	}

}
