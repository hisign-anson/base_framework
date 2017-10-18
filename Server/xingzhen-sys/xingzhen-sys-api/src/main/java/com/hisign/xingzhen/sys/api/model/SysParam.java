package com.hisign.xingzhen.sys.api.model;

import com.hisign.xingzhen.common.model.BaseModel;

/**
 * @author lqf
 * @Date 2017年4月1日
 */
public class SysParam extends BaseModel {

    /** **/
	private static final long serialVersionUID = 8704663416066932509L;
	/**
     * id
     */
    private String id;
    /**
     * 中文名称
     */
    private String chineseName;
    /**
     * 英文名称
     */
    private String englishName;
    /**
     * 参数值
     */
    private String value;
    /**
     * 参数默认值
     */
    private String defaultValue;
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
     * 备注
     */
    private String remark;
    /**
     * 行号
     */
    private String rownum;
    /**
     * 下拉框
     */
    private String option;
    /**
     * 参数类型
     */
    private String paramType;
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 分组ID
     */
    private String configId;
    /**
     * 隐藏标记
     */
    private String hideFlag;
    /**
     * 排序
     */
    private String paramSort;
    /**
     * 删除标记
     */
    private String deleteFlag;
    /**
     * 参数名
     */
    private String name;
    /**
     * 修改id
     */
    private String paramEditId;

    public String getParamEditId() {
        return paramEditId;
    }

    public void setParamEditId(String paramEditId) {
        this.paramEditId = paramEditId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getChineseName() {
        return chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getValue() {
        return value;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public String getParamType() {
        return paramType;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getRownum() {
        return rownum;
    }

    public void setRownum(String rownum) {
        this.rownum = rownum;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getHideFlag() {
        return hideFlag;
    }

    public void setHideFlag(String hideFlag) {
        this.hideFlag = hideFlag;
    }

    public String getParamSort() {
        return paramSort;
    }

    public void setParamSort(String paramSort) {
        this.paramSort = paramSort;
    }
}