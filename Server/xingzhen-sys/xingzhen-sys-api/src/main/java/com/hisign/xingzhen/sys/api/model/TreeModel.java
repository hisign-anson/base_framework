package com.hisign.xingzhen.sys.api.model;

public class TreeModel {
     private String id;
     private String pId;
     private String name;
     private int sort;
     private boolean isParent;
     private String rootKey;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	/**
	 * @return the pId
	 */
	public String getpId() {
		return pId;
	}
	/**
	 * @param pId the pId to set
	 */
	public void setpId(String pId) {
		this.pId = pId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}
	/**
	 * @return the isParent
	 */
	public boolean getIsParent() {
		return isParent;
	}
	/**
	 * @param isParent the isParent to set
	 */
	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}
	/**
	 * @return the rootKey
	 */
	public String getRootKey() {
		return rootKey;
	}
	/**
	 * @param rootKey the rootKey to set
	 */
	public void setRootKey(String rootKey) {
		this.rootKey = rootKey;
	}
     
}
