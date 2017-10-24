package com.hisign.xingzhen.common.model;

import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiIgnore
public class BaseModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1006038627276588176L;

	@ApiModelProperty(hidden = true)
	private String rownum;

	@ApiModelProperty(hidden = true)
    private int begin = 0;

	@ApiModelProperty(hidden = true)
    private int end = 0;

	@ApiModelProperty(hidden = true)
    private String sortOrder; //desc

	@ApiModelProperty(hidden = true)
    private String sortName;

	@ApiModelProperty(hidden = true)
    private String key;

	@ApiModelProperty(hidden = true)
    private String value;

	@ApiModelProperty(hidden = true)
    private Date startTime;

	@ApiModelProperty(hidden = true)
    private Date endTime;

	@ApiModelProperty(hidden = true)
    private String orgId;
    /** 上级机构ID**/
	@ApiModelProperty(hidden = true)
    private String superId;

	@ApiModelProperty(hidden = true)
    private Integer orgLevel;

	@ApiModelProperty(hidden = true)
    private String userId;

	@ApiModelProperty(hidden = true)
    private String trueName;

	@ApiModelProperty(hidden = true)
    private List<String> orgIds;


    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }


    public String getRownum() {
        return rownum;
    }

    public void setRownum(String rownum) {
        this.rownum = rownum;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }


    public void setBeginAndEnd(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the orgLevel
	 */
	public Integer getOrgLevel() {
		return orgLevel;
	}

	/**
	 * @param orgLevel the orgLevel to set
	 */
	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the trueName
	 */
	public String getTrueName() {
		return trueName;
	}

	/**
	 * @param trueName the trueName to set
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	/**
	 * @return the orgIds
	 */
	public List<String> getOrgIds() {
		return orgIds;
	}

	/**
	 * @param orgIds the orgIds to set
	 */
	public void setOrgIds(List<String> orgIds) {
		this.orgIds = orgIds;
	}

	/**
	 * @return the superId
	 */
	public String getSuperId() {
		return superId;
	}

	/**
	 * @param superId the superId to set
	 */
	public void setSuperId(String superId) {
		this.superId = superId;
	}
	
	
    
}
