package com.hisign.xingzhen.sys.api.model;

import java.util.Date;

import com.hisign.xingzhen.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "组织机构")
public class SysOrgInfo extends BaseModel{
    /** **/
	private static final long serialVersionUID = -1833115062500267643L;
	/** 组织机构ID**/
	@ApiModelProperty(value = "组织机构ID")
    private String orgId;

    /** 组织机构名称**/
	@ApiModelProperty(value = "组织机构名称")
    private String orgName;

    /** 组织机构编码**/
	@ApiModelProperty(value = "组织机构编码")
    private String orgCode;

    /** 单位级别**/
	@ApiModelProperty(value = "单位级别")
    private Integer orgLevel;

    /** 上级机构ID**/
	@ApiModelProperty(value = "上级机构ID")
    private String superId;

    /** 上级机构名称**/
	@ApiModelProperty(value = "上级机构名称")
    private String superName;

    /** 状态0:正常1:删除**/
	@ApiModelProperty(value = "状态0:正常1:删除")
    private Integer status;

    /**拼音全程 **/
	@ApiModelProperty(value = "拼音全程")
    private String pinyin;

    /** 拼音首字母**/
	@ApiModelProperty(value = "拼音首字母")
    private String firstLetter;

    /** 单位简称**/
	@ApiModelProperty(value = "单位简称")
    private String shortenedName;

    /** **/
	@ApiModelProperty(value = "创建人")
    private String createPid;

    /** **/
	@ApiModelProperty(value = "创建时间")
    private Date createTime;

    /** **/
	@ApiModelProperty(value = "修改人")
    private String modifyPid;

    /** **/
	@ApiModelProperty(value = "修改时间")
    private Date modifyTime;
    public SysOrgInfo() {
	}
	public SysOrgInfo(String orgCode) {
		this.orgCode = orgCode;
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
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the pinyin
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * @param pinyin the pinyin to set
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * @return the firstLetter
	 */
	public String getFirstLetter() {
		return firstLetter;
	}

	/**
	 * @param firstLetter the firstLetter to set
	 */
	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	/**
	 * @return the shortenedName
	 */
	public String getShortenedName() {
		return shortenedName;
	}

	/**
	 * @param shortenedName the shortenedName to set
	 */
	public void setShortenedName(String shortenedName) {
		this.shortenedName = shortenedName;
	}

	/**
	 * @return the createPid
	 */
	public String getCreatePid() {
		return createPid;
	}

	/**
	 * @param createPid the createPid to set
	 */
	public void setCreatePid(String createPid) {
		this.createPid = createPid;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the modifyPid
	 */
	public String getModifyPid() {
		return modifyPid;
	}

	/**
	 * @param modifyPid the modifyPid to set
	 */
	public void setModifyPid(String modifyPid) {
		this.modifyPid = modifyPid;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
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
	 * @return the superName
	 */
	public String getSuperName() {
		return superName;
	}
	/**
	 * @param superName the superName to set
	 */
	public void setSuperName(String superName) {
		this.superName = superName;
	}

    
}