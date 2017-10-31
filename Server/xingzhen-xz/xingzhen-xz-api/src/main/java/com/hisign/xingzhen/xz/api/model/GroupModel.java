package com.hisign.xingzhen.xz.api.model;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import java.util.*;

import com.hisign.xingzhen.xz.api.entity.Group;
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

    @ApiModelProperty(value = "专案组类别名称")
    private String grouptypeName; //专案组类别名称

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

    @ApiModelProperty(value = "创建人单位代码")
    private String deparmentcode; //创建人单位代码

    @ApiModelProperty(value = "创建人单位名称")
    private String deparmentname; //创建人单位名称

    @ApiModelProperty(value = "修改时间")
    private Date lastupdatetime; //修改时间

    @ApiModelProperty(value = "删除标识")
    private String deleteflag; //删除标识

    @ApiModelProperty(value = "极光群聊ID")
    private String jmgid; //极光群聊ID

    //-------------------------返回字段
    @ApiModelProperty(value = "涉及案件数")
    private String caseNum;

    @ApiModelProperty(value = "创建人单位名称")
    private String departmentName;

    @ApiModelProperty(value = "成员数")
    private String memberNum;

    @ApiModelProperty(value = "子专案组列表")
    private List<GroupModel> childGroupList;

    @ApiModelProperty(value = "序号")
    private String rn;

    @ApiModelProperty(hidden = true)
    private String rownum;


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
     * @return DEPARMENTCODE 创建人单位代码
     */
    public String getDeparmentcode(){
        return this.deparmentcode;
    }
    /**
     * @param DEPARMENTCODE 创建人单位代码
     */
    public void setDeparmentcode(String deparmentcode){
        this.deparmentcode = deparmentcode;
    }
    /**
     * @return DEPARMENTNAME 创建人单位名称
     */
    public String getDeparmentname(){
        return this.deparmentname;
    }
    /**
     * @param DEPARMENTNAME 创建人单位名称
     */
    public void setDeparmentname(String deparmentname){
        this.deparmentname = deparmentname;
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

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    public String getJmgid() {
        return jmgid;
    }

    public void setJmgid(String jmgid) {
        this.jmgid = jmgid;
    }

    public List<GroupModel> getChildGroupList() {
        return childGroupList;
    }

    public void setChildGroupList(List<GroupModel> childGroupList) {
        this.childGroupList = childGroupList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

	public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

    public String getGrouptypeName() {
        return grouptypeName;
    }

    public void setGrouptypeName(String grouptypeName) {
        this.grouptypeName = grouptypeName;
    }

    public String getRownum() {
        return rownum;
    }

    public void setRownum(String rownum) {
        this.rownum = rownum;
    }
}