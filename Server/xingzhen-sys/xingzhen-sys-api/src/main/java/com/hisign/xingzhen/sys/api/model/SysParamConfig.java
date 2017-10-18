package com.hisign.xingzhen.sys.api.model;

import java.util.List;

import com.hisign.xingzhen.common.model.BaseModel;


/**
 * @author lqf
 * @Date 2017年4月1日
 */
public class SysParamConfig extends BaseModel {

    /** **/
	private static final long serialVersionUID = 7750126106996102019L;
	private String id;
	/**
     * 排序
     */
    private String seq;
    /**
     * 中文名称
     */
    private String chineseName;
    /**
     * 英文名称
     */
    private String englishName;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private String createDatetime;
    /**
     * 更新用户
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private String updateDatetime;

    /**
     * 分组参数
     */
    private List<SysParam> sysParamList;

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

	public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public List<SysParam> getSysParamList() {
        return sysParamList;
    }

    public void setSysParamList(List<SysParam> sysParamList) {
        this.sysParamList = sysParamList;
    }
}
