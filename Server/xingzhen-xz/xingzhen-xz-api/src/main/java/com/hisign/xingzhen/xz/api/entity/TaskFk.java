package com.hisign.xingzhen.xz.api.entity;

import com.hisign.bfun.bannotation.Column;
import com.hisign.bfun.bannotation.PK;
import com.hisign.bfun.bannotation.Table;
import com.hisign.xingzhen.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 《任务反馈》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "任务反馈")
@Table(value="t_task_fk")
public class TaskFk extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @PK(value="ID")
    @ApiModelProperty(value = "任务反馈ID")
    private String id; //任务反馈ID

    @Column(value="TASKID")
    @ApiModelProperty(value = "任务ID")
    private String taskid; //任务ID

    @Column(value="FKXS")
    @ApiModelProperty(value = "反馈线索")
    private String fkxs; //反馈线索

    @Column(value="FKR")
    @ApiModelProperty(value = "反馈人")
    private String fkr; //反馈人

    @Column(value="FK_TIME")
    @ApiModelProperty(value = "反馈时间")
    private Date fkTime; //反馈时间

    @Column(value="QRZT")
    @ApiModelProperty(value = "确认状态")
    private String qrzt; //确认状态

    @Column(value="QR_TIME")
    @ApiModelProperty(value = "确认时间")
    private Date qrTime; //确认时间

    @Column(value="BZ")
    @ApiModelProperty(value = "备注")
    private String bz; //备注

    @Column(value="CREATOR")
    @ApiModelProperty(value = "创建人")
    private String creator; //创建人

    @Column(value="CREATETIME")
    @ApiModelProperty(value = "创建时间")
    private Date createtime; //创建时间

    @Column(value="DEPARMENTCODE")
    @ApiModelProperty(value = "创建人单位")
    private String deparmentcode; //创建人单位

    @Column(value="LASTUPDATETIME")
    @ApiModelProperty(value = "修改时间")
    private Date lastupdatetime; //修改时间

    @Column(value="DELETEFLAG")
    @ApiModelProperty(value = "删除标识")
    private String deleteflag; //删除标识


    /**
     *默认空构造函数
     */
    public TaskFk() {
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
        return "t_task_fk";
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("TaskFk [")
                .append("id=").append(this.getId())
                .append(",taskid=").append(this.getTaskid())
                .append(",fkxs=").append(this.getFkxs())
                .append(",fkr=").append(this.getFkr())
                .append(",fkTime=").append(this.getFkTime())
                .append(",qrzt=").append(this.getQrzt())
                .append(",qrTime=").append(this.getQrTime())
                .append(",bz=").append(this.getBz())
                .append(",creator=").append(this.getCreator())
                .append(",createtime=").append(this.getCreatetime())
                .append(",deparmentcode=").append(this.getDeparmentcode())
                .append(",lastupdatetime=").append(this.getLastupdatetime())
                .append(",deleteflag=").append(this.getDeleteflag())
                .append("]");
        return builder.toString();
    }

    public static enum TaskFkEnum{
        id("ID","任务反馈ID"),
        taskid("TASKID","任务ID"),
        fkxs("FKXS","反馈线索"),
        fkr("FKR","反馈人"),
        fkTime("FK_TIME","反馈时间"),
        qrzt("QRZT","确认状态"),
        qrTime("QR_TIME","确认时间"),
        bz("BZ","备注"),
        creator("CREATOR","创建人"),
        createtime("CREATETIME","创建时间"),
        deparmentcode("DEPARMENTCODE","创建人单位"),
        lastupdatetime("LASTUPDATETIME","修改时间"),
        deleteflag("DELETEFLAG","删除标识");

        private String fieldName;
        private String remark;

        TaskFkEnum(String fieldName,String remark){
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