package com.hisign.shuwu.sys.api.model;

import java.io.Serializable;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public class SysCommonDict implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4775257380066279701L;
	private String id;
    private String key;
    private String name;
    private String value;
    private String pId;
    private String isParent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }
}
