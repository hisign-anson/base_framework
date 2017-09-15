package com.hisign.shuwu.common.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	
	public static String[] list2Array(List<String> list){
		String[] str = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			str[i] = list.get(i);
		}
		return str;
	}
	
	
	public static List<Object> arr2List(Object[] arr){
		List<Object> list = new ArrayList<Object>();
		for (Object object : arr) {
			list.add(object);
		}
		return list;
	}
	
	public static List<String> arr2ListStr(String[] arr){
		List<String> list = new ArrayList<String>();
		for (String object : arr) {
			list.add(object);
		}
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List list){
		if (list==null || list.isEmpty()) {
			return true;
		}
		return false;
	}

}
