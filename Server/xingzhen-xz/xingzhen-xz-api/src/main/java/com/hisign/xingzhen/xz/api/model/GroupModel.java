package com.hisign.xingzhen.xz.api.model;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import java.util.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《专案组》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "专案组")
public class GroupModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "专案组ID")
    private String id; //专案组ID

    @ApiModelProperty(value = "父专案组ID")
    private String pgroupid; //父专案组ID

    @ApiModelProperty(value = "专案组编号")
    private String groupnum; //专案组编号

    @ApiModelProperty(value = "专案组名称")
    private String groupname; //专案组名称

    @ApiModelProperty(value = "专案组类别")
    private String grouptype; //专案组类别

    @ApiModelProperty(value = "归档状态")
    private String backupStatu; //归档状态

    @ApiModelProperty(value = "归档时间")
    private Date backupTime; //归档时间

    @ApiModelProperty(value = "归档原因")
    private String backupReason; //归档原因

    @ApiModelProperty(value = "创建人")
    private String creator; //创建人

    @ApiModelProperty(value = "创建人姓名")
    private String createname; //创建人姓名

    @ApiModelProperty(value = "创建时间")
    private Date createtime; //创建时间

    @ApiModelProperty(value = "创建人单位")
    private String deparmentcode; //创建人单位

    @ApiModelProperty(value = "修改时间")
    private Date lastupdatetime; //修改时间

    @ApiModelProperty(value = "删除标识")
    private String deleteflag; //删除标识

    @ApiModelProperty(value = "成员数")
    private int num;//成员数

    @ApiModelProperty(value = "涉及案件数")
    private int caseNum;//涉及案件数


    /**
     *默认空构造函数
     */
    public GroupModel() {
        super();
    }

    /**
     * @return ID 专案组ID
     */
    public String getId(){
        return this.id;
    }
    /**
     * @param ID 专案组ID
     */
    public void setId(String id){
        this.id = id;
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
     * @return GROUPNUM 专案组编号
     */
    public String getGroupnum(){
        return this.groupnum;
    }
    /**
     * @param GROUPNUM 专案组编号
     */
    public void setGroupnum(String groupnum){
        this.groupnum = groupnum;
    }
    /**
     * @return GROUPNAME 专案组名称
     */
    public String getGroupname(){
        return this.groupname;
    }
    /**
     * @param GROUPNAME 专案组名称
     */
    public void setGroupname(String groupname){
        this.groupname = groupname;
    }
    /**
     * @return GROUPTYPE 专案组类别
     */
    public String getGrouptype(){
        return this.grouptype;
    }
    /**
     * @param GROUPTYPE 专案组类别
     */
    public void setGrouptype(String grouptype){
        this.grouptype = grouptype;
    }
    /**
     * @return BACKUP_STATU 归档状态
     */
    public String getBackupStatu(){
        return this.backupStatu;
    }
    /**
     * @param BACKUP_STATU 归档状态
     */
    public void setBackupStatu(String backupStatu){
        this.backupStatu = backupStatu;
    }
    /**
     * @return BACKUP_TIME 归档时间
     */
    public Date getBackupTime(){
        return this.backupTime;
    }
    /**
     * @param BACKUP_TIME 归档时间
     */
    public void setBackupTime(Date backupTime){
        this.backupTime = backupTime;
    }
    /**
     * @return BACKUP_REASON 归档原因
     */
    public String getBackupReason(){
        return this.backupReason;
    }
    /**
     * @param BACKUP_REASON 归档原因
     */
    public void setBackupReason(String backupReason){
        this.backupReason = backupReason;
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
     * @return CREATENAME 创建人姓名
     */
    public String getCreatename(){
        return this.createname;
    }
    /**
     * @param CREATENAME 创建人姓名
     */
    public void setCreatename(String createname){
        this.createname = createname;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(int caseNum) {
        this.caseNum = caseNum;
    }
}