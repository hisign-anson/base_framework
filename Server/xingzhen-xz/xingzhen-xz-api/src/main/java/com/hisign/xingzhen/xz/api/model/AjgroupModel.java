package com.hisign.xingzhen.xz.api.model;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import java.util.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《案件专案组关联》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "案件专案组关联")
public class AjgroupModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "案件关联ID")
    private String id; //案件关联ID

    @ApiModelProperty(value = "案件ID")
    private String ajid; //案件ID

    @ApiModelProperty(value = "案件编号")
    private String ajbh; //案件编号

    @ApiModelProperty(value = "专案组ID")
    private String groupid; //专案组ID

    @ApiModelProperty(value = "父专案组ID")
    private String pgroupid; //父专案组ID

    @ApiModelProperty(value = "创建人")
    private String creator; //创建人

    @ApiModelProperty(value = "创建时间")
    private Date createtime; //创建时间

    @ApiModelProperty(value = "创建人单位")
    private String deparmentcode; //创建人单位

    @ApiModelProperty(value = "修改时间")
    private Date lastupdatetime; //修改时间

    @ApiModelProperty(value = "删除标识")
    private String deleteflag; //删除标识


    /**
     *默认空构造函数
     */
    public AjgroupModel() {
        super();
    }

    /**
     * @return ID 案件关联ID
     */
    public String getId(){
        return this.id;
    }
    /**
     * @param ID 案件关联ID
     */
    public void setId(String id){
        this.id = id;
    }
    /**
     * @return AJID 案件ID
     */
    public String getAjid(){
        return this.ajid;
    }
    /**
     * @param AJID 案件ID
     */
    public void setAjid(String ajid){
        this.ajid = ajid;
    }
    /**
     * @return AJBH 案件编号
     */
    public String getAjbh(){
        return this.ajbh;
    }
    /**
     * @param AJBH 案件编号
     */
    public void setAjbh(String ajbh){
        this.ajbh = ajbh;
    }
    /**
     * @return GROUPID 专案组ID
     */
    public String getGroupid(){
        return this.groupid;
    }
    /**
     * @param GROUPID 专案组ID
     */
    public void setGroupid(String groupid){
        this.groupid = groupid;
    }
    /**
     * @return PGROUPID 父专案组ID
     */
    public String getPgroupid(){
        return this.pgroupid;
    }
    /**
     * @param PGROUPID 父专案组ID
     */
    public void setPgroupid(String pgroupid){
        this.pgroupid = pgroupid;
    }
    /**
     * @return CREATOR 创建人
     */
    public String getCreator(){
        return this.creator;
    }
    /**
     * @param CREATOR 创建人
     */
    public void setCreator(String creator){
        this.creator = creator;
    }
    /**
     * @return CREATETIME 创建时间
     */
    public Date getCreatetime(){
        return this.createtime;
    }
    /**
     * @param CREATETIME 创建时间
     */
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }
    /**
     * @return DEPARMENTCODE 创建人单位
     */
    public String getDeparmentcode(){
        return this.deparmentcode;
    }
    /**
     * @param DEPARMENTCODE 创建人单位
     */
    public void setDeparmentcode(String deparmentcode){
        this.deparmentcode = deparmentcode;
    }
    /**
     * @return LASTUPDATETIME 修改时间
     */
    public Date getLastupdatetime(){
        return this.lastupdatetime;
    }
    /**
     * @param LASTUPDATETIME 修改时间
     */
    public void setLastupdatetime(Date lastupdatetime){
        this.lastupdatetime = lastupdatetime;
    }
    /**
     * @return DELETEFLAG 删除标识
     */
    public String getDeleteflag(){
        return this.deleteflag;
    }
    /**
     * @param DELETEFLAG 删除标识
     */
    public void setDeleteflag(String deleteflag){
        this.deleteflag = deleteflag;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}