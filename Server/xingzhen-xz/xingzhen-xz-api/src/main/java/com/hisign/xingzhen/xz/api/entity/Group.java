package com.hisign.xingzhen.xz.api.entity;

import java.io.Serializable;
import java.util.*;
import com.hisign.bfun.bannotation.*;
import com.hisign.xingzhen.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 《专案组》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "专案组")
@Table(value="t_group")
public class Group extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @PK(value="ID")
    @ApiModelProperty(value = "专案组ID",hidden = true)
    private String id; //专案组ID

    @Column(value="PGROUPID")
    @ApiModelProperty(value = "父专案组ID")
    private String pgroupid; //父专案组ID

    @Column(value="GROUPNUM")
    @ApiModelProperty(value = "专案组编号",hidden = true)
    private String groupnum; //专案组编号

    @Column(value="GROUPNAME")
    @ApiModelProperty(value = "专案组名称",required = true)
    @NotEmpty(message = "专案组名称不能为空")
    private String groupname; //专案组名称

    @Column(value="GROUPTYPE")
    @ApiModelProperty(value = "专案组类别",required = true)
    @NotEmpty(message = "专案组类别不能为空")
    private String grouptype; //专案组类别

    @Column(value="BACKUP_STATU")
    @ApiModelProperty(value = "归档状态",hidden = true)
    private String backupStatu; //归档状态

    @Column(value="BACKUP_TIME")
    @ApiModelProperty(value = "归档时间",hidden = true)
    private Date backupTime; //归档时间

    @Column(value="BACKUP_REASON")
    @ApiModelProperty(value = "归档原因",hidden = true)
    private String backupReason; //归档原因

    @Column(value="CREATOR")
    @ApiModelProperty(value = "创建人",required = true)
    @NotEmpty(message = "当前登陆用户不能为空")
    private String creator; //创建人

    @Column(value="CREATENAME")
    @ApiModelProperty(value = "创建人姓名",required = true)
    @NotEmpty(message = "当前登陆用户姓名不能为空")
    private String createname; //创建人姓名

    @Column(value="CREATETIME")
    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createtime; //创建时间

    @Column(value="DEPARMENTCODE")
    @NotEmpty(message = "用户单位信息不能为空")
    @ApiModelProperty(value = "创建人单位",required = true)
    private String deparmentcode; //创建人单位

    @Column(value="LASTUPDATETIME")
    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date lastupdatetime; //修改时间

    @Column(value="DELETEFLAG")
    @ApiModelProperty(value = "删除标识",hidden = true)
    private String deleteflag; //删除标识

    @Column(value="JMGID")
    @ApiModelProperty(value = "极光群聊ID")
    private String jmgid; //极光群聊ID

    //===================================接收字段
    @ApiModelProperty(value = "警号",hidden = true)
    private String policeId; //警号

    @ApiModelProperty(value = "案件编号",hidden = true)
    private String ajbh; //案件编号

    /**
     *默认空构造函数
     */
    public Group() {
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

    public static String getTbName() {
        return "t_group";
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getAjbh() {
        return ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    public String getJmgid() {
        return jmgid;
    }

    public void setJmgid(String jmgid) {
        this.jmgid = jmgid;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Group [")
                .append("id=").append(this.getId())
                .append(",pgroupid=").append(this.getPgroupid())
                .append(",groupnum=").append(this.getGroupnum())
                .append(",groupname=").append(this.getGroupname())
                .append(",grouptype=").append(this.getGrouptype())
                .append(",backupStatu=").append(this.getBackupStatu())
                .append(",backupTime=").append(this.getBackupTime())
                .append(",backupReason=").append(this.getBackupReason())
                .append(",creator=").append(this.getCreator())
                .append(",createtime=").append(this.getCreatetime())
                .append(",deparmentcode=").append(this.getDeparmentcode())
                .append(",lastupdatetime=").append(this.getLastupdatetime())
                .append(",deleteflag=").append(this.getDeleteflag())
                .append(",jmgid=").append(this.getJmgid())
                .append("]");
        return builder.toString();
    }

    public static enum GroupEnum{
        id("ID","专案组ID"),
        pgroupid("PGROUPID","父专案组ID"),
        groupnum("GROUPNUM","专案组编号"),
        groupname("GROUPNAME","专案组名称"),
        grouptype("GROUPTYPE","专案组类别"),
        backupStatu("BACKUP_STATU","归档状态"),
        backupTime("BACKUP_TIME","归档时间"),
        backupReason("BACKUP_REASON","归档原因"),
        creator("CREATOR","创建人"),
        createtime("CREATETIME","创建时间"),
        deparmentcode("DEPARMENTCODE","创建人单位"),
        lastupdatetime("LASTUPDATETIME","修改时间"),
        deleteflag("DELETEFLAG","删除标识"),
        jmgid("JMGID","极光群聊ID");

        private String fieldName;
        private String remark;

        GroupEnum(String fieldName,String remark){
            this.fieldName = fieldName;
            this.remark = remark;
        }

        public String get(){
            return this.fieldName;
        }

        public String getRemark(){
            return this.remark;
        }
    }
}