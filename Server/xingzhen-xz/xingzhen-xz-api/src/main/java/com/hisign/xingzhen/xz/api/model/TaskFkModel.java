package com.hisign.xingzhen.xz.api.model;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import java.util.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《任务反馈》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "任务反馈")
public class TaskFkModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务反馈ID")
    private String id; //任务反馈ID

    @ApiModelProperty(value = "任务ID")
    private String taskid; //任务ID

    @ApiModelProperty(value = "专案组ID")
    private String groupid; //专案组ID

    @ApiModelProperty(value = "父专案组ID")
    private String pgroupid; //父专案组ID

    @ApiModelProperty(value = "反馈线索")
    private String fkxs; //反馈线索

    @ApiModelProperty(value = "反馈人")
    private String fkr; //反馈人

    @ApiModelProperty(value = "反馈人姓名")
    private String fkrname; //反馈人姓名

    @ApiModelProperty(value = "反馈时间")
    private Date fkTime; //反馈时间

    @ApiModelProperty(value = "确认状态，0未确认，1已确认")
    private String qrzt; //确认状态

    @ApiModelProperty(value = "确认时间")
    private Date qrTime; //确认时间

    @ApiModelProperty(value = "备注")
    private String bz; //备注

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

    //-------------------------返回字段
    @ApiModelProperty(value = "反馈附件信息")
    private List<TaskfkFileModel> taskfkFileModels;
    /**
     *默认空构造函数
     */
    public TaskFkModel() {
        super();
    }

    /**
     * @return ID 任务反馈ID
     */
    public String getId(){
        return this.id;
    }
    /**
     * @param ID 任务反馈ID
     */
    public void setId(String id){
        this.id = id;
    }
    /**
     * @return TASKID 任务ID
     */
    public String getTaskid(){
        return this.taskid;
    }
    /**
     * @param TASKID 任务ID
     */
    public void setTaskid(String taskid){
        this.taskid = taskid;
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
     * @return FKXS 反馈线索
     */
    public String getFkxs(){
        return this.fkxs;
    }
    /**
     * @param FKXS 反馈线索
     */
    public void setFkxs(String fkxs){
        this.fkxs = fkxs;
    }
    /**
     * @return FKR 反馈人
     */
    public String getFkr(){
        return this.fkr;
    }
    /**
     * @param FKR 反馈人
     */
    public void setFkr(String fkr){
        this.fkr = fkr;
    }
    /**
     * @return FKRNAME 反馈人姓名
     */
    public String getFkrname(){
        return this.fkrname;
    }
    /**
     * @param FKRNAME 反馈人姓名
     */
    public void setFkrname(String fkrname){
        this.fkrname = fkrname;
    }
    /**
     * @return FK_TIME 反馈时间
     */
    public Date getFkTime(){
        return this.fkTime;
    }
    /**
     * @param FK_TIME 反馈时间
     */
    public void setFkTime(Date fkTime){
        this.fkTime = fkTime;
    }
    /**
     * @return QRZT 确认状态
     */
    public String getQrzt(){
        return this.qrzt;
    }
    /**
     * @param QRZT 确认状态
     */
    public void setQrzt(String qrzt){
        this.qrzt = qrzt;
    }
    /**
     * @return QR_TIME 确认时间
     */
    public Date getQrTime(){
        return this.qrTime;
    }
    /**
     * @param QR_TIME 确认时间
     */
    public void setQrTime(Date qrTime){
        this.qrTime = qrTime;
    }
    /**
     * @return BZ 备注
     */
    public String getBz(){
        return this.bz;
    }
    /**
     * @param BZ 备注
     */
    public void setBz(String bz){
        this.bz = bz;
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

    public List<TaskfkFileModel> getTaskfkFileModels() {
        return taskfkFileModels;
    }

    public void setTaskfkFileModels(List<TaskfkFileModel> taskfkFileModels) {
        this.taskfkFileModels = taskfkFileModels;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}