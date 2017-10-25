package com.hisign.xingzhen.xz.api.entity;

import com.hisign.bfun.bannotation.Column;
import com.hisign.bfun.bannotation.PK;
import com.hisign.bfun.bannotation.Table;
import com.hisign.xingzhen.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * 《案件专案组关联》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "案件专案组关联")
@Table(value="t_ajgroup")
public class Ajgroup extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @PK(value="ID")
    @ApiModelProperty(value = "案件关联ID",hidden = true)
    private String id; //案件关联ID

    @Column(value="AJID")
    @ApiModelProperty(value = "案件ID",required = true)
    @NotEmpty(message = "案件不能为空")
    private String ajid; //案件ID

    @Column(value="AJBH")
    @ApiModelProperty(value = "案件编号",required = true)
    @NotEmpty(message = "案件编号不能为空")
    private String ajbh; //案件编号

    @Column(value="GROUPID")
    @ApiModelProperty(value = "专案组ID",required = true)
    @NotEmpty(message = "专案组不能为空")
    private String groupid; //专案组ID

    @Column(value="PGROUPID")
    @ApiModelProperty(value = "父专案组ID",hidden = true)
    private String pgroupid; //父专案组ID

    @Column(value="CREATOR")
    @ApiModelProperty(value = "创建人",required = true)
    @NotEmpty(message = "创建人不能为空")
    private String creator; //创建人

    @Column(value="CREATETIME")
    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createtime; //创建时间

    @Column(value="DEPARMENTCODE")
    @ApiModelProperty(value = "创建人单位",required = true)
    private String deparmentcode; //创建人单位

    @Column(value="LASTUPDATETIME")
    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date lastupdatetime; //修改时间

    @Column(value="DELETEFLAG")
    @ApiModelProperty(value = "删除标识",hidden = true)
    private String deleteflag; //删除标识


    /**
     *默认空构造函数
     */
    public Ajgroup() {
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

    public static String getTbName() {
        return "t_ajgroup";
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Ajgroup [")
                .append("id=").append(this.getId())
                .append(",ajid=").append(this.getAjid())
                .append(",ajbh=").append(this.getAjbh())
                .append(",groupid=").append(this.getGroupid())
                .append(",pgroupid=").append(this.getPgroupid())
                .append(",creator=").append(this.getCreator())
                .append(",createtime=").append(this.getCreatetime())
                .append(",deparmentcode=").append(this.getDeparmentcode())
                .append(",lastupdatetime=").append(this.getLastupdatetime())
                .append(",deleteflag=").append(this.getDeleteflag())
                .append("]");
        return builder.toString();
    }

    public static enum AjgroupEnum{
        id("ID","案件关联ID"),
        ajid("AJID","案件ID"),
        ajbh("AJBH","案件编号"),
        groupid("GROUPID","专案组ID"),
        pgroupid("PGROUPID","父专案组ID"),
        creator("CREATOR","创建人"),
        createtime("CREATETIME","创建时间"),
        deparmentcode("DEPARMENTCODE","创建人单位"),
        lastupdatetime("LASTUPDATETIME","修改时间"),
        deleteflag("DELETEFLAG","删除标识");

        private String fieldName;
        private String remark;

        AjgroupEnum(String fieldName,String remark){
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