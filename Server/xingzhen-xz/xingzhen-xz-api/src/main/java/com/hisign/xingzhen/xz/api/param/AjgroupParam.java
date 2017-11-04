package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by hisign on 2017/10/23.
 */
public class AjgroupParam implements Serializable{

    @ApiModelProperty(value = "案件关联ID",required = true)
    @NotEmpty(message = "案件关联id不能为空")
    private String id; //案件关联ID

    @ApiModelProperty(value = "专案组ID",required = true)
    @NotEmpty(message = "专案组不能为空")
    private String groupid; //专案组ID

    @ApiModelProperty(value = "创建人",required = true)
    @NotEmpty(message = "当前用户不能为空")
    private String creator; //创建人

    @ApiModelProperty(value = "接收字段-案件名称")
    private String caseName;//接收字段-案件名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }
}
