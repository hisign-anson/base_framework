package com.hisign.xingzhen.sys.api.model;

import com.hisign.xingzhen.common.model.BaseModel;



/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public class SysDict extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2755959521187817921L;
    private String id;
	private String root;


    private String[] keys;


    private String parentKey;

    private String queryString;

    private String queryType;

    private String py;
    private Integer sort;
    private String openFlag;
    private String remark;
    

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

	public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String[] getKeys() {
        return keys;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * @return the openFlag
	 */
	public String getOpenFlag() {
		return openFlag;
	}

	/**
	 * @param openFlag the openFlag to set
	 */
	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
    
}
