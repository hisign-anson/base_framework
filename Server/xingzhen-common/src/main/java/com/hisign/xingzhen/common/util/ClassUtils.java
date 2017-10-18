package com.hisign.xingzhen.common.util;

import com.hisign.bfun.bannotation.Column;
import com.hisign.xingzhen.common.model.annotation.TField;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author 何建辉
 *
 */
public class ClassUtils {

	public static Map<String, Object> object2Map(Object obj){
		return object2Map(obj, false);
	}
	
	/**
	 * 类名: ClassUtils.java
	 * 描述: 
	 * 公司: 北京海鑫科金高科技股份有限公司
	 * 作者: 何建辉
	 * 版本: 
	 * 参数: @param obj
	 * 参数: @param isUseTField 是否使用TField注解
	 * 参数: @return
	 * 创建时间: 2017年5月12日
	 * 最后修改时间: 2017年5月12日
	 */
	public static Map<String, Object> object2Map(Object obj,boolean isUseTField){
		Field[] fields = obj.getClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				if (isUseTField) {
					TField tField = field.getAnnotation(TField.class);
					if (tField!=null && tField.isTranMap()) {
						map.put(field.getName(), field.get(obj));
					}
				}else{
					map.put(field.getName(), field.get(obj));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	
	public static Map<String, Object> obj2DBFMap(Object obj){
		Field[] fields = obj.getClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Column c = field.getAnnotation(Column.class);
				if (c!=null && StringUtils.isNotBlank(c.value())) {
					map.put(c.value(), field.get(obj));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	
	public static List<Map<String, Object>> list2Map(List<Object> list){
		return list2Map(list, false);
	}
	
	public static List<Map<String, Object>> list2Map(List<Object> list,boolean isUseTField){
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		for (Object object : list) {
			Map<String, Object> map = object2Map(object,isUseTField);
			listMap.add(map);
		}
		return listMap;
	}
	
	
	public static List<String> getFieldNames(@SuppressWarnings("rawtypes") Class clazz){
		Field[] fields = clazz.getDeclaredFields();
		List<String> list = new ArrayList<String>();
		for (Field field : fields) {
			field.setAccessible(true);
			list.add(field.getName());
		}
		return list;
	}
	
	public static List<String> getCHFieldNames(@SuppressWarnings("rawtypes") Class clazz){
		Field[] fields = clazz.getDeclaredFields();
		List<String> list = new ArrayList<String>();
		for (Field field : fields) {
			field.setAccessible(true);
			TField tField = field.getAnnotation(TField.class);
			if (tField!=null) {
				list.add(tField.chName());
			}
		}
		return list;
	}
	
	public static String[] getFieldNamesArray(@SuppressWarnings("rawtypes") Class clazz){
		List<String> list = getFieldNames(clazz);
		return ListUtils.list2Array(list);
	}
	
	public static String[] getCHFieldNamesArray(@SuppressWarnings("rawtypes") Class clazz){
		List<String> list = getCHFieldNames(clazz);
		return ListUtils.list2Array(list);
	}
	
}
