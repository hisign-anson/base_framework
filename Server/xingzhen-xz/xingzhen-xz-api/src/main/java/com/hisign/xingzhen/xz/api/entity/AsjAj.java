
package com.hisign.xingzhen.xz.api.entity;

import java.io.Serializable;
import java.util.*;
import com.hisign.bfun.bannotation.*;
import com.hisign.xingzhen.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《案件》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "案件")
@Table(value="b_asj_aj")
public class AsjAj extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(value="ID")
	@ApiModelProperty(value = "系统编号")
	private String id; //系统编号

	@Column(value="AJBH")
	@ApiModelProperty(value = "案件编号")
	private String ajbh; //案件编号

	@Column(value="SLJSDW")
	@ApiModelProperty(value = "受理单位/接收单位-字典项＝06")
	private String sljsdw; //受理单位/接收单位-字典项＝06

	@Column(value="AJSTATE")
	@ApiModelProperty(value = "案件状态-字典项＝56")
	private String ajstate; //案件状态-字典项＝56

	@Column(value="ZAZT")
	@ApiModelProperty(value = "作案状态-字典项＝131")
	private String zazt; //作案状态-字典项＝131

	@Column(value="SL_BJSLH")
	@ApiModelProperty(value = "接警受理号")
	private String slBjslh; //接警受理号

	@Column(value="SL_JJFS")
	@ApiModelProperty(value = "接警方式-字典项＝81")
	private String slJjfs; //接警方式-字典项＝81

	@Column(value="AJLX")
	@ApiModelProperty(value = "案件类型-字典项＝44")
	private String ajlx; //案件类型-字典项＝44

	@Column(value="AB")
	@ApiModelProperty(value = "案别/案由-字典项＝24")
	private String ab; //案别/案由-字典项＝24

	@Column(value="ZABZ")
	@ApiModelProperty(value = "专案标识-字典项＝48")
	private String zabz; //专案标识-字典项＝48

	@Column(value="AJMC")
	@ApiModelProperty(value = "案件名称")
	private String ajmc; //案件名称

	@Column(value="AJWH")
	@ApiModelProperty(value = "案件号")
	private String ajwh; //案件号

	@Column(value="SLJJSJ")
	@ApiModelProperty(value = "报警时间")
	private Date sljjsj; //报警时间

	@Column(value="SLFXRQ")
	@ApiModelProperty(value = "发现时间")
	private Date slfxrq; //发现时间

	@Column(value="FASJCZ")
	@ApiModelProperty(value = "发案时间初值")
	private Date fasjcz; //发案时间初值

	@Column(value="FASJZZ")
	@ApiModelProperty(value = "发案时间终值")
	private Date fasjzz; //发案时间终值

	@Column(value="FADD_QX")
	@ApiModelProperty(value = "发案地点_区县-字典项＝07")
	private String faddQx; //发案地点_区县-字典项＝07

	@Column(value="FADD_JD")
	@ApiModelProperty(value = "发案地点_街道-字典项＝107")
	private String faddJd; //发案地点_街道-字典项＝107

	@Column(value="AJSSJQ")
	@ApiModelProperty(value = "所属警区-字典项＝108")
	private String ajssjq; //所属警区-字典项＝108

	@Column(value="FADD")
	@ApiModelProperty(value = "发案地点详址")
	private String fadd; //发案地点详址

	@Column(value="SSSQ")
	@ApiModelProperty(value = "所属社区-字典项＝109")
	private String sssq; //所属社区-字典项＝109

	@Column(value="FADY")
	@ApiModelProperty(value = "发案地域-字典项＝45")
	private String fady; //发案地域-字典项＝45

	@Column(value="SLFACS")
	@ApiModelProperty(value = "发案处所-字典项＝135")
	private String slfacs; //发案处所-字典项＝135

	@Column(value="FXXS")
	@ApiModelProperty(value = "发现形式-字典项＝46")
	private String fxxs; //发现形式-字典项＝46

	@Column(value="AJWHCD")
	@ApiModelProperty(value = "危害程度-字典项＝43")
	private String ajwhcd; //危害程度-字典项＝43

	@Column(value="BLYY")
	@ApiModelProperty(value = "补立原因-字典项＝55")
	private String blyy; //补立原因-字典项＝55

	@Column(value="ZYAQ")
	@ApiModelProperty(value = "简要案情")
	private String zyaq; //简要案情

	@Column(value="XZSJ")
	@ApiModelProperty(value = "作案时机-字典项＝29")
	private String xzsj; //作案时机-字典项＝29

	@Column(value="XZCS")
	@ApiModelProperty(value = "选择处所-字典项＝30")
	private String xzcs; //选择处所-字典项＝30

	@Column(value="XZDX")
	@ApiModelProperty(value = "选择对象-字典项＝31")
	private String xzdx; //选择对象-字典项＝31

	@Column(value="XZWP")
	@ApiModelProperty(value = "选择物品-字典项＝33")
	private String xzwp; //选择物品-字典项＝33

	@Column(value="ZAGJ")
	@ApiModelProperty(value = "作案工具-字典项＝33")
	private String zagj; //作案工具-字典项＝33

	@Column(value="XZBW")
	@ApiModelProperty(value = "选择部位-字典项＝30")
	private String xzbw; //选择部位-字典项＝30

	@Column(value="ZARS")
	@ApiModelProperty(value = "作案人数")
	private Integer zars; //作案人数

	@Column(value="SDTD")
	@ApiModelProperty(value = "作案手段特点-字典项＝36")
	private String sdtd; //作案手段特点-字典项＝36

	@Column(value="SWRS")
	@ApiModelProperty(value = "死亡人数")
	private Integer swrs; //死亡人数

	@Column(value="SSRS")
	@ApiModelProperty(value = "受伤人数")
	private Integer ssrs; //受伤人数

	@Column(value="SSJZ")
	@ApiModelProperty(value = "损失折款")
	private Double ssjz; //损失折款

	@Column(value="SAZZ")
	@ApiModelProperty(value = "涉案总值")
	private Double sazz; //涉案总值

	@Column(value="LASJ")
	@ApiModelProperty(value = "立案日期")
	private Date lasj; //立案日期

	@Column(value="PASJ")
	@ApiModelProperty(value = "破案时间")
	private Date pasj; //破案时间

	@Column(value="JA_JASJ")
	@ApiModelProperty(value = "结案时间")
	private Date jaJasj; //结案时间

	@Column(value="XA_XASJ")
	@ApiModelProperty(value = "销案时间")
	private Date xaXasj; //销案时间

	@Column(value="YSSJ")
	@ApiModelProperty(value = "移送时间")
	private Date yssj; //移送时间

	@Column(value="SLJJDW")
	@ApiModelProperty(value = "接警单位-字典项＝06")
	private String sljjdw; //接警单位-字典项＝06

	@Column(value="SL_LRR")
	@ApiModelProperty(value = "受理人")
	private String slLrr; //受理人

	@Column(value="SL_LRSJ")
	@ApiModelProperty(value = "受理时间")
	private Date slLrsj; //受理时间

	@Column(value="SLJJRY")
	@ApiModelProperty(value = "备用")
	private String sljjry; //备用

	@Column(value="SL_SLRXM")
	@ApiModelProperty(value = "填表人")
	private String slSlrxm; //填表人

	@Column(value="SL_SLSJ")
	@ApiModelProperty(value = "填表时间")
	private Date slSlsj; //填表时间

	@Column(value="SLFAQH")
	@ApiModelProperty(value = "发案地政区划")
	private String slfaqh; //发案地政区划

	@Column(value="LADW")
	@ApiModelProperty(value = "立案单位-字典项＝06")
	private String ladw; //立案单位-字典项＝06

	@Column(value="AJLARY")
	@ApiModelProperty(value = "立案人")
	private String ajlary; //立案人

	@Column(value="ZBDW")
	@ApiModelProperty(value = "主办单位")
	private String zbdw; //主办单位

	@Column(value="AJZBRY")
	@ApiModelProperty(value = "主要办案人")
	private String ajzbry; //主要办案人

	@Column(value="AJXBRY")
	@ApiModelProperty(value = "案件协办人")
	private String ajxbry; //案件协办人

	@Column(value="AJBARP")
	@ApiModelProperty(value = "办案人联系电话")
	private String ajbarp; //办案人联系电话

	@Column(value="LA_LRR")
	@ApiModelProperty(value = "立案录入人")
	private String laLrr; //立案录入人

	@Column(value="LA_LRSJ")
	@ApiModelProperty(value = "立案录入时间")
	private Date laLrsj; //立案录入时间

	@Column(value="LA_PZR")
	@ApiModelProperty(value = "立案批准人")
	private String laPzr; //立案批准人

	@Column(value="LA_PZSJ")
	@ApiModelProperty(value = "立案批时间")
	private Date laPzsj; //立案批时间

	@Column(value="LA_ZHXGR")
	@ApiModelProperty(value = "案后修改人")
	private String laZhxgr; //案后修改人

	@Column(value="LA_ZHXGSJ")
	@ApiModelProperty(value = "案最后修改时间")
	private Date laZhxgsj; //案最后修改时间

	@Column(value="LA_PSSTATE")
	@ApiModelProperty(value = "批示状态")
	private String laPsstate; //批示状态

	@Column(value="DBXX")
	@ApiModelProperty(value = "督办信息")
	private String dbxx; //督办信息

	@Column(value="AJLY")
	@ApiModelProperty(value = "案件来源")
	private String ajly; //案件来源

	@Column(value="BZ")
	@ApiModelProperty(value = "备注")
	private String bz; //备注

	@Column(value="YSSASJ")
	@ApiModelProperty(value = "")
	private Date yssasj; //

	@Column(value="YSTCSJ")
	@ApiModelProperty(value = "")
	private Date ystcsj; //

	@Column(value="WHSSJZ")
	@ApiModelProperty(value = "挽回损失价值")
	private Double whssjz; //挽回损失价值

	@Column(value="DBJB")
	@ApiModelProperty(value = "督办级别")
	private String dbjb; //督办级别

	@Column(value="JTAJLY")
	@ApiModelProperty(value = "具体案件来源")
	private String jtajly; //具体案件来源

	@Column(value="FZZTLX")
	@ApiModelProperty(value = "犯罪主体类型-字典项=JZ_03")
	private String fzztlx; //犯罪主体类型-字典项=JZ_03

	@Column(value="SFSW")
	@ApiModelProperty(value = "案情是否涉外")
	private String sfsw; //案情是否涉外

	@Column(value="SJGJDQ")
	@ApiModelProperty(value = "案情涉及国家地区")
	private String sjgjdq; //案情涉及国家地区

	@Column(value="YISHENSJ")
	@ApiModelProperty(value = "一审时间")
	private Date yishensj; //一审时间

	@Column(value="ESSJ")
	@ApiModelProperty(value = "二审时间")
	private Date essj; //二审时间

	@Column(value="YSDW")
	@ApiModelProperty(value = "移送单位")
	private String ysdw; //移送单位

	@Column(value="YSCBR")
	@ApiModelProperty(value = "移送承办人")
	private String yscbr; //移送承办人

	@Column(value="YSDWDH")
	@ApiModelProperty(value = "移送单位电话")
	private String ysdwdh; //移送单位电话

	@Column(value="YSDW_NEW")
	@ApiModelProperty(value = "移送单位（经侦并入派综后使用，原有不知何用，未使用）")
	private String ysdwNew; //移送单位（经侦并入派综后使用，原有不知何用，未使用）

	@Column(value="YSDWDH_NEW")
	@ApiModelProperty(value = "移送单位电话（经侦并入派综后使用，原有不知何用，未使用）")
	private String ysdwdhNew; //移送单位电话（经侦并入派综后使用，原有不知何用，未使用）

	@Column(value="YSCBR_NEW")
	@ApiModelProperty(value = "移送承办人（经侦并入派综后使用，原有不知何用，未使用）")
	private String yscbrNew; //移送承办人（经侦并入派综后使用，原有不知何用，未使用）

	@Column(value="YSSJ_NEW")
	@ApiModelProperty(value = "移送时间（经侦并入派综后使用，原有不知何用，未使用）")
	private Date yssjNew; //移送时间（经侦并入派综后使用，原有不知何用，未使用）

	@Column(value="DEPARTMENTCODE")
	@ApiModelProperty(value = "部门编号-字典项＝06")
	private String departmentcode; //部门编号-字典项＝06

	@Column(value="CREATOR")
	@ApiModelProperty(value = "创建者")
	private String creator; //创建者

	@Column(value="CREATEDTIME")
	@ApiModelProperty(value = "创建时间")
	private Date createdtime; //创建时间

	@Column(value="SECURITYGRADE")
	@ApiModelProperty(value = "密级")
	private String securitygrade; //密级

	@Column(value="LASTUPDATEDBY")
	@ApiModelProperty(value = "最终修改人")
	private String lastupdatedby; //最终修改人

	@Column(value="LASTUPDATEDTIME")
	@ApiModelProperty(value = "最后修改时间")
	private Date lastupdatedtime; //最后修改时间

	@Column(value="REFRESHTIME")
	@ApiModelProperty(value = "更新时间")
	private Date refreshtime; //更新时间

	@Column(value="UPLOADFLAG")
	@ApiModelProperty(value = "上传标志")
	private String uploadflag; //上传标志

	@Column(value="DOWNLOADFLAG")
	@ApiModelProperty(value = "下传标志")
	private String downloadflag; //下传标志

	@Column(value="DELETEFLAG")
	@ApiModelProperty(value = "删除标志")
	private String deleteflag; //删除标志

	@Column(value="RESERVATION01")
	@ApiModelProperty(value = "主办侦查员中文姓名")
	private String reservation01; //主办侦查员中文姓名

	@Column(value="RESERVATION02")
	@ApiModelProperty(value = "协办侦查员中文姓名")
	private String reservation02; //协办侦查员中文姓名

	@Column(value="RESERVATION03")
	@ApiModelProperty(value = "保留字段3")
	private String reservation03; //保留字段3

	@Column(value="RESERVATION04")
	@ApiModelProperty(value = "省")
	private String reservation04; //省

	@Column(value="RESERVATION05")
	@ApiModelProperty(value = "保留字段5")
	private String reservation05; //保留字段5

	@Column(value="RESERVATION06")
	@ApiModelProperty(value = "保字段6")
	private String reservation06; //保字段6

	@Column(value="RESERVATION07")
	@ApiModelProperty(value = "保留字段7")
	private String reservation07; //保留字段7

	@Column(value="RESERVATION08")
	@ApiModelProperty(value = "保留字段8")
	private String reservation08; //保留字段8

	@Column(value="RESERVATION09")
	@ApiModelProperty(value = "保留字段9")
	private String reservation09; //保留字段9

	@Column(value="RESERVATION10")
	@ApiModelProperty(value = "保留字段10")
	private String reservation10; //保留字段10

	@Column(value="RESERVATION11")
	@ApiModelProperty(value = "主案编号")
	private String reservation11; //主案编号

	@Column(value="RESERVATION12")
	@ApiModelProperty(value = "")
	private String reservation12; //

	@Column(value="RESERVATION13")
	@ApiModelProperty(value = "")
	private String reservation13; //

	@Column(value="RESERVATION14")
	@ApiModelProperty(value = "")
	private String reservation14; //

	@Column(value="RESERVATION15")
	@ApiModelProperty(value = "")
	private String reservation15; //

	@Column(value="RESERVATION16")
	@ApiModelProperty(value = "")
	private String reservation16; //

	@Column(value="RESERVATION17")
	@ApiModelProperty(value = "")
	private String reservation17; //

	@Column(value="RESERVATION18")
	@ApiModelProperty(value = "")
	private String reservation18; //

	@Column(value="RESERVATION19")
	@ApiModelProperty(value = "")
	private String reservation19; //

	@Column(value="RESERVATION20")
	@ApiModelProperty(value = "")
	private String reservation20; //

	@Column(value="RESERVATION21")
	@ApiModelProperty(value = "")
	private Date reservation21; //

	@Column(value="RESERVATION22")
	@ApiModelProperty(value = "")
	private Date reservation22; //

	@Column(value="RESERVATION23")
	@ApiModelProperty(value = "")
	private Date reservation23; //

	@Column(value="RESERVATION24")
	@ApiModelProperty(value = "")
	private Date reservation24; //

	@Column(value="RESERVATION25")
	@ApiModelProperty(value = "")
	private Date reservation25; //

	@Column(value="RESERVATION26")
	@ApiModelProperty(value = "")
	private Date reservation26; //

	@Column(value="RESERVATION27")
	@ApiModelProperty(value = "")
	private Date reservation27; //

	@Column(value="RESERVATION28")
	@ApiModelProperty(value = "")
	private Date reservation28; //

	@Column(value="RESERVATION29")
	@ApiModelProperty(value = "")
	private Integer reservation29; //

	@Column(value="RESERVATION30")
	@ApiModelProperty(value = "")
	private Integer reservation30; //

	@Column(value="RESERVATION31")
	@ApiModelProperty(value = "")
	private Integer reservation31; //

	@Column(value="RESERVATION32")
	@ApiModelProperty(value = "")
	private Integer reservation32; //

	@Column(value="RESERVATION33")
	@ApiModelProperty(value = "")
	private Integer reservation33; //

	@Column(value="RESERVATION34")
	@ApiModelProperty(value = "标识是否重新立案，0或null否，1是")
	private String reservation34; //标识是否重新立案，0或null否，1是

	@Column(value="RESERVATION35")
	@ApiModelProperty(value = "为了避免与派综案件编号重复，经侦案件的案件编号要重新存储")
	private String reservation35; //为了避免与派综案件编号重复，经侦案件的案件编号要重新存储

	@Column(value="RESERVATION36")
	@ApiModelProperty(value = "初查审核结果 字典项：JZ_06")
	private String reservation36; //初查审核结果 字典项：JZ_06

	@Column(value="RESERVATION37")
	@ApiModelProperty(value = "")
	private String reservation37; //

	@Column(value="RESERVATION38")
	@ApiModelProperty(value = "")
	private String reservation38; //

	@Column(value="RESERVATION39")
	@ApiModelProperty(value = "")
	private String reservation39; //

	@Column(value="RESERVATION40")
	@ApiModelProperty(value = "")
	private String reservation40; //

	@Column(value="RESERVATION41")
	@ApiModelProperty(value = "")
	private String reservation41; //

	@Column(value="RESERVATION42")
	@ApiModelProperty(value = "")
	private String reservation42; //

	@Column(value="RESERVATION43")
	@ApiModelProperty(value = "")
	private String reservation43; //

	@Column(value="RESERVATION44")
	@ApiModelProperty(value = "")
	private String reservation44; //

	@Column(value="RESERVATION45")
	@ApiModelProperty(value = "")
	private String reservation45; //

	@Column(value="RESERVATION46")
	@ApiModelProperty(value = "")
	private Integer reservation46; //

	@Column(value="RESERVATION47")
	@ApiModelProperty(value = "")
	private Integer reservation47; //

	@Column(value="RESERVATION48")
	@ApiModelProperty(value = "")
	private Integer reservation48; //

	@Column(value="RESERVATION49")
	@ApiModelProperty(value = "")
	private Integer reservation49; //

	@Column(value="RESERVATION50")
	@ApiModelProperty(value = "")
	private Integer reservation50; //

	@Column(value="RESERVATION51")
	@ApiModelProperty(value = "与经侦同步更新的时间，下次更新与此时间作比较")
	private Date reservation51; //与经侦同步更新的时间，下次更新与此时间作比较

	@Column(value="RESERVATION52")
	@ApiModelProperty(value = "")
	private Date reservation52; //

	@Column(value="RESERVATION53")
	@ApiModelProperty(value = "")
	private Date reservation53; //

	@Column(value="AJZBRY_NAME")
	@ApiModelProperty(value = "案件主办人")
	private String ajzbryName; //案件主办人

	@Column(value="AJXBRY_NAME")
	@ApiModelProperty(value = "案件协办人（多值）")
	private String ajxbryName; //案件协办人（多值）

	@Column(value="SL_LRR_NAME")
	@ApiModelProperty(value = "受理人")
	private String slLrrName; //受理人

	@Column(value="SL_SLRXM_NAME")
	@ApiModelProperty(value = "填表人")
	private String slSlrxmName; //填表人

	@Column(value="AJLARY_NAME")
	@ApiModelProperty(value = "立案人")
	private String ajlaryName; //立案人

	@Column(value="LA_LRR_NAME")
	@ApiModelProperty(value = "立案录入人")
	private String laLrrName; //立案录入人

	@Column(value="DEPARTMENTCODE_NAME")
	@ApiModelProperty(value = "部门名称")
	private String departmentcodeName; //部门名称

	@Column(value="ZBDW_NAME")
	@ApiModelProperty(value = "主办单位")
	private String zbdwName; //主办单位

	@Column(value="LADW_NAME")
	@ApiModelProperty(value = "立案单位")
	private String ladwName; //立案单位

	@Column(value="SLJJDW_NAME")
	@ApiModelProperty(value = "接警单位")
	private String sljjdwName; //接警单位

	@Column(value="SLJSDW_NAME")
	@ApiModelProperty(value = "受理单位")
	private String sljsdwName; //受理单位

	@Column(value="RESERVER38")
	@ApiModelProperty(value = "")
	private String reserver38; //

	@Column(value="RESERVER39")
	@ApiModelProperty(value = "")
	private String reserver39; //

	@Column(value="RESERVER40")
	@ApiModelProperty(value = "")
	private String reserver40; //

	@Column(value="RESERVER41")
	@ApiModelProperty(value = "")
	private String reserver41; //

	@Column(value="RESERVER42")
	@ApiModelProperty(value = "")
	private String reserver42; //

	@Column(value="RESERVER43")
	@ApiModelProperty(value = "")
	private String reserver43; //

	@Column(value="RESERVER44")
	@ApiModelProperty(value = "")
	private String reserver44; //

	@Column(value="RESERVER45")
	@ApiModelProperty(value = "")
	private String reserver45; //

	@Column(value="RESERVER46")
	@ApiModelProperty(value = "")
	private String reserver46; //

	@Column(value="RESERVER47")
	@ApiModelProperty(value = "")
	private String reserver47; //

	@Column(value="RESERVER48")
	@ApiModelProperty(value = "")
	private String reserver48; //

	@Column(value="RESERVER49")
	@ApiModelProperty(value = "")
	private String reserver49; //

	@Column(value="RESERVER50")
	@ApiModelProperty(value = "")
	private String reserver50; //

	@Column(value="RESERVER51")
	@ApiModelProperty(value = "")
	private String reserver51; //

	@Column(value="RESERVER52")
	@ApiModelProperty(value = "")
	private String reserver52; //

	@Column(value="RESERVER53")
	@ApiModelProperty(value = "")
	private String reserver53; //

	@Column(value="RESERVER54")
	@ApiModelProperty(value = "")
	private String reserver54; //

	@Column(value="RESERVER55")
	@ApiModelProperty(value = "")
	private String reserver55; //

	@Column(value="RESERVER56")
	@ApiModelProperty(value = "")
	private String reserver56; //

	@Column(value="RESERVER57")
	@ApiModelProperty(value = "")
	private String reserver57; //

	@Column(value="RESERVER58")
	@ApiModelProperty(value = "")
	private String reserver58; //

	@Column(value="RESERVER59")
	@ApiModelProperty(value = "")
	private String reserver59; //

	@Column(value="RESERVER60")
	@ApiModelProperty(value = "")
	private String reserver60; //

	@Column(value="RESERVER61")
	@ApiModelProperty(value = "")
	private Long reserver61; //

	@Column(value="RESERVER62")
	@ApiModelProperty(value = "")
	private Long reserver62; //

	@Column(value="RESERVER63")
	@ApiModelProperty(value = "")
	private Long reserver63; //

	@Column(value="RESERVER64")
	@ApiModelProperty(value = "")
	private Long reserver64; //

	@Column(value="RESERVER65")
	@ApiModelProperty(value = "")
	private Long reserver65; //

	@Column(value="RESERVER66")
	@ApiModelProperty(value = "")
	private Long reserver66; //

	@Column(value="RESERVER67")
	@ApiModelProperty(value = "")
	private Long reserver67; //

	@Column(value="RESERVER68")
	@ApiModelProperty(value = "")
	private Long reserver68; //

	@Column(value="RESERVER69")
	@ApiModelProperty(value = "")
	private Long reserver69; //

	@Column(value="RESERVER70")
	@ApiModelProperty(value = "")
	private Long reserver70; //

	@Column(value="RESERVER71")
	@ApiModelProperty(value = "")
	private Long reserver71; //

	@Column(value="RESERVER72")
	@ApiModelProperty(value = "")
	private Long reserver72; //

	@Column(value="RESERVER73")
	@ApiModelProperty(value = "")
	private Long reserver73; //

	@Column(value="RESERVER74")
	@ApiModelProperty(value = "")
	private Long reserver74; //

	@Column(value="RESERVER75")
	@ApiModelProperty(value = "")
	private Long reserver75; //

	@Column(value="RESERVER76")
	@ApiModelProperty(value = "")
	private Date reserver76; //

	@Column(value="RESERVER77")
	@ApiModelProperty(value = "")
	private Date reserver77; //

	@Column(value="RESERVER78")
	@ApiModelProperty(value = "")
	private Date reserver78; //

	@Column(value="RESERVER79")
	@ApiModelProperty(value = "")
	private Date reserver79; //

	@Column(value="RESERVER80")
	@ApiModelProperty(value = "")
	private Date reserver80; //

	@Column(value="RESERVER81")
	@ApiModelProperty(value = "")
	private Date reserver81; //

	@Column(value="RESERVER82")
	@ApiModelProperty(value = "")
	private Date reserver82; //

	@Column(value="RESERVER83")
	@ApiModelProperty(value = "")
	private Date reserver83; //

	@Column(value="RESERVER84")
	@ApiModelProperty(value = "")
	private Date reserver84; //

	@Column(value="RESERVER85")
	@ApiModelProperty(value = "")
	private Date reserver85; //

	@Column(value="RESERVER86")
	@ApiModelProperty(value = "")
	private Date reserver86; //

	@Column(value="RESERVER87")
	@ApiModelProperty(value = "")
	private Date reserver87; //

	@Column(value="RESERVER88")
	@ApiModelProperty(value = "")
	private Date reserver88; //

	@Column(value="RESERVER89")
	@ApiModelProperty(value = "")
	private Date reserver89; //

	@Column(value="RESERVER90")
	@ApiModelProperty(value = "")
	private Date reserver90; //

	@Column(value="RESERVER91")
	@ApiModelProperty(value = "")
	private String reserver91; //

	@Column(value="RESERVER92")
	@ApiModelProperty(value = "")
	private String reserver92; //

	@Column(value="RESERVER93")
	@ApiModelProperty(value = "")
	private String reserver93; //

	@Column(value="RESERVER94")
	@ApiModelProperty(value = "")
	private String reserver94; //

	@Column(value="RESERVER95")
	@ApiModelProperty(value = "")
	private String reserver95; //

	@Column(value="RESERVER96")
	@ApiModelProperty(value = "")
	private String reserver96; //

	@Column(value="RESERVER97")
	@ApiModelProperty(value = "")
	private String reserver97; //

	@Column(value="RESERVER98")
	@ApiModelProperty(value = "")
	private String reserver98; //

	@Column(value="RESERVER99")
	@ApiModelProperty(value = "")
	private String reserver99; //

	@Column(value="RESERVER100")
	@ApiModelProperty(value = "")
	private String reserver100; //

	@Column(value="RESERVER1")
	@ApiModelProperty(value = "")
	private String reserver1; //

	@Column(value="RESERVER2")
	@ApiModelProperty(value = "")
	private String reserver2; //

	@Column(value="RESERVER3")
	@ApiModelProperty(value = "X坐标")
	private String reserver3; //X坐标

	@Column(value="RESERVER4")
	@ApiModelProperty(value = "Y坐标")
	private String reserver4; //Y坐标

	@Column(value="RESERVER5")
	@ApiModelProperty(value = "")
	private String reserver5; //

	@Column(value="RESERVER6")
	@ApiModelProperty(value = "")
	private String reserver6; //

	@Column(value="RESERVER7")
	@ApiModelProperty(value = "")
	private String reserver7; //

	@Column(value="RESERVER8")
	@ApiModelProperty(value = "")
	private String reserver8; //

	@Column(value="RESERVER9")
	@ApiModelProperty(value = "")
	private String reserver9; //

	@Column(value="RESERVER10")
	@ApiModelProperty(value = "")
	private String reserver10; //

	@Column(value="RESERVER11")
	@ApiModelProperty(value = "")
	private String reserver11; //

	@Column(value="RESERVER12")
	@ApiModelProperty(value = "")
	private String reserver12; //

	@Column(value="RESERVER13")
	@ApiModelProperty(value = "")
	private String reserver13; //

	@Column(value="RESERVER14")
	@ApiModelProperty(value = "")
	private String reserver14; //

	@Column(value="RESERVER15")
	@ApiModelProperty(value = "")
	private String reserver15; //

	@Column(value="RESERVER16")
	@ApiModelProperty(value = "")
	private String reserver16; //

	@Column(value="RESERVER17")
	@ApiModelProperty(value = "")
	private String reserver17; //

	@Column(value="RESERVER18")
	@ApiModelProperty(value = "")
	private String reserver18; //

	@Column(value="RESERVER19")
	@ApiModelProperty(value = "")
	private String reserver19; //

	@Column(value="RESERVER20")
	@ApiModelProperty(value = "")
	private String reserver20; //

	@Column(value="RESERVER21")
	@ApiModelProperty(value = "")
	private String reserver21; //

	@Column(value="RESERVER22")
	@ApiModelProperty(value = "")
	private String reserver22; //

	@Column(value="RESERVER23")
	@ApiModelProperty(value = "")
	private String reserver23; //

	@Column(value="RESERVER24")
	@ApiModelProperty(value = "")
	private String reserver24; //

	@Column(value="RESERVER25")
	@ApiModelProperty(value = "")
	private String reserver25; //

	@Column(value="RESERVER26")
	@ApiModelProperty(value = "")
	private String reserver26; //

	@Column(value="RESERVER27")
	@ApiModelProperty(value = "")
	private String reserver27; //

	@Column(value="RESERVER28")
	@ApiModelProperty(value = "")
	private String reserver28; //

	@Column(value="RESERVER29")
	@ApiModelProperty(value = "")
	private String reserver29; //

	@Column(value="RESERVER30")
	@ApiModelProperty(value = "")
	private String reserver30; //

	@Column(value="RESERVER31")
	@ApiModelProperty(value = "")
	private String reserver31; //

	@Column(value="RESERVER32")
	@ApiModelProperty(value = "")
	private String reserver32; //

	@Column(value="RESERVER33")
	@ApiModelProperty(value = "")
	private String reserver33; //

	@Column(value="RESERVER34")
	@ApiModelProperty(value = "")
	private String reserver34; //

	@Column(value="RESERVER35")
	@ApiModelProperty(value = "")
	private String reserver35; //

	@Column(value="RESERVER36")
	@ApiModelProperty(value = "")
	private String reserver36; //

	@Column(value="RESERVER37")
	@ApiModelProperty(value = "")
	private String reserver37; //

	@Column(value="YYK_RKSJ")
	@ApiModelProperty(value = "")
	private Date yykRksj; //

	@Column(value="AB_CN")
	@ApiModelProperty(value = "")
	private String abCn; //

	@Column(value="AJSSJQ_CN")
	@ApiModelProperty(value = "")
	private String ajssjqCn; //

	@Column(value="AJSTATE_CN")
	@ApiModelProperty(value = "")
	private String ajstateCn; //

	@Column(value="AJWHCD_CN")
	@ApiModelProperty(value = "")
	private String ajwhcdCn; //

	@Column(value="BLYY_CN")
	@ApiModelProperty(value = "")
	private String blyyCn; //

	@Column(value="CREATOR_CN")
	@ApiModelProperty(value = "")
	private String creatorCn; //

	@Column(value="DATACHECK")
	@ApiModelProperty(value = "")
	private String datacheck; //

	@Column(value="DATASTATE")
	@ApiModelProperty(value = "")
	private String datastate; //

	@Column(value="DBJB_CN")
	@ApiModelProperty(value = "")
	private String dbjbCn; //

	@Column(value="DEPARTMENTCODE_CN")
	@ApiModelProperty(value = "")
	private String departmentcodeCn; //

	@Column(value="FADD_JD_CN")
	@ApiModelProperty(value = "")
	private String faddJdCn; //

	@Column(value="FADD_QX_CN")
	@ApiModelProperty(value = "")
	private String faddQxCn; //

	@Column(value="FADY_CN")
	@ApiModelProperty(value = "")
	private String fadyCn; //

	@Column(value="FXXS_CN")
	@ApiModelProperty(value = "")
	private String fxxsCn; //

	@Column(value="FZZTLX_CN")
	@ApiModelProperty(value = "")
	private String fzztlxCn; //

	@Column(value="JZBH")
	@ApiModelProperty(value = "")
	private String jzbh; //

	@Column(value="LASTUPDATEDBY_CN")
	@ApiModelProperty(value = "")
	private String lastupdatedbyCn; //

	@Column(value="QUERYID")
	@ApiModelProperty(value = "")
	private String queryid; //

	@Column(value="RESERVATION03_CN")
	@ApiModelProperty(value = "")
	private String reservation03Cn; //

	@Column(value="RESERVATION36_CN")
	@ApiModelProperty(value = "")
	private String reservation36Cn; //

	@Column(value="SDTD_CN")
	@ApiModelProperty(value = "")
	private String sdtdCn; //

	@Column(value="SECURITYGRADE_CN")
	@ApiModelProperty(value = "")
	private String securitygradeCn; //

	@Column(value="SFSW_CN")
	@ApiModelProperty(value = "")
	private String sfswCn; //

	@Column(value="SJGJDQ_CN")
	@ApiModelProperty(value = "")
	private String sjgjdqCn; //

	@Column(value="SLFACS_CN")
	@ApiModelProperty(value = "")
	private String slfacsCn; //

	@Column(value="SLJSDW_CN")
	@ApiModelProperty(value = "")
	private String sljsdwCn; //

	@Column(value="SL_JJFS_CN")
	@ApiModelProperty(value = "")
	private String slJjfsCn; //

	@Column(value="SL_SLRXM_CN")
	@ApiModelProperty(value = "")
	private String slSlrxmCn; //

	@Column(value="SSSQ_CN")
	@ApiModelProperty(value = "")
	private String sssqCn; //

	@Column(value="XZBW_CN")
	@ApiModelProperty(value = "")
	private String xzbwCn; //

	@Column(value="XZCS_CN")
	@ApiModelProperty(value = "")
	private String xzcsCn; //

	@Column(value="XZDX_CN")
	@ApiModelProperty(value = "")
	private String xzdxCn; //

	@Column(value="XZSJ_CN")
	@ApiModelProperty(value = "")
	private String xzsjCn; //

	@Column(value="ZABZ_CN")
	@ApiModelProperty(value = "")
	private String zabzCn; //

	@Column(value="ZAGJ_CN")
	@ApiModelProperty(value = "")
	private String zagjCn; //

	@Column(value="ZAZT_CN")
	@ApiModelProperty(value = "")
	private String zaztCn; //

	@Column(value="ZBDW_CN")
	@ApiModelProperty(value = "")
	private String zbdwCn; //

	@Column(value="RKGXSJ")
	@ApiModelProperty(value = "")
	private Date rkgxsj; //

	@Column(value="XLAB")
	@ApiModelProperty(value = "细类按别")
	private String xlab; //细类按别

	@Column(value="XLMC")
	@ApiModelProperty(value = "细类名称")
	private String xlmc; //细类名称

	@Column(value="YXLMC")
	@ApiModelProperty(value = "原细类名称")
	private String yxlmc; //原细类名称

	@Column(value="FASJ")
	@ApiModelProperty(value = "发案时间")
	private Date fasj; //发案时间

	@Column(value="SFBZ")
	@ApiModelProperty(value = "是否标注")
	private String sfbz; //是否标注

	@Column(value="ZYK_RKSJ")
	@ApiModelProperty(value = "")
	private Date zykRksj; //

	@Column(value="ZYK_GXSJ")
	@ApiModelProperty(value = "")
	private Date zykGxsj; //

	@Column(value="ZYK_SYSTEMID")
	@ApiModelProperty(value = "")
	private String zykSystemid; //

	@Column(value="CLBZ")
	@ApiModelProperty(value = "处理标志")
	private String clbz; //处理标志

	@Column(value="SFHL")
	@ApiModelProperty(value = "是否忽略，默认为0，0为未忽略，1为忽略")
	private String sfhl; //是否忽略，默认为0，0为未忽略，1为忽略

	@Column(value="AJBZRESERVER1")
	@ApiModelProperty(value = "涉及类别")
	private String ajbzreserver1; //涉及类别

	@Column(value="AJBZRESERVER2")
	@ApiModelProperty(value = "警情大类")
	private String ajbzreserver2; //警情大类

	@Column(value="AJBZRESERVER3")
	@ApiModelProperty(value = "警情一级细类")
	private String ajbzreserver3; //警情一级细类

	@Column(value="AJBZRESERVER4")
	@ApiModelProperty(value = "警情二级细类")
	private String ajbzreserver4; //警情二级细类

	@Column(value="AJBZRESERVER5")
	@ApiModelProperty(value = "警情三级细类")
	private String ajbzreserver5; //警情三级细类

	@Column(value="AJBZRESERVER6")
	@ApiModelProperty(value = "警情标注是新增还是修改，Y为修改,其他为新增")
	private String ajbzreserver6; //警情标注是新增还是修改，Y为修改,其他为新增

	@Column(value="AJBZRESERVER7")
	@ApiModelProperty(value = "涉及对象")
	private String ajbzreserver7; //涉及对象

	@Column(value="AJBZRESERVER8")
	@ApiModelProperty(value = "作案工具")
	private String ajbzreserver8; //作案工具

	@Column(value="AJBZRESERVER9")
	@ApiModelProperty(value = "发案地点")
	private String ajbzreserver9; //发案地点

	@Column(value="AJBZRESERVER10")
	@ApiModelProperty(value = "盗窃专项")
	private String ajbzreserver10; //盗窃专项

	@Column(value="AJBZRESERVER11")
	@ApiModelProperty(value = "保留未用")
	private String ajbzreserver11; //保留未用

	@Column(value="AJBZRESERVER12")
	@ApiModelProperty(value = "保留未用")
	private String ajbzreserver12; //保留未用

	@Column(value="AJBZRESERVER13")
	@ApiModelProperty(value = "保留未用")
	private String ajbzreserver13; //保留未用

	@Column(value="AJBZRESERVER14")
	@ApiModelProperty(value = "保留未用")
	private String ajbzreserver14; //保留未用

	@Column(value="AJBZRESERVER15")
	@ApiModelProperty(value = "保留未用")
	private String ajbzreserver15; //保留未用

	@Column(value="TRANSFER_TIME")
	@ApiModelProperty(value = "传输时间")
	private Date transferTime; //传输时间

	//-----------------------------------------接收字段
	@ApiModelProperty(value = "专案组ID")
	private String groupId;//专案组ID

	@ApiModelProperty(value = "专案组ID")
	private String pgroupId;//专案组ID

	@ApiModelProperty(value = "受理开始时间")
	private Date slStartTime;//受理开始时间

	@ApiModelProperty(value = "受理结束时间")
	private Date slEndTime;//受理结束时间
	
    
	/**
	 *默认空构造函数
	 */
	public AsjAj() {
		super();
	}
	 
	/**
	 * @return ID ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID ID
	 */
	public void setId(String id){
		this.id = id;
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
	 * @return SLJSDW 受理单位/接收单位-字典项＝06
	 */
	public String getSljsdw(){
		return this.sljsdw;
	}
	/**
	 * @param SLJSDW 受理单位/接收单位-字典项＝06
	 */
	public void setSljsdw(String sljsdw){
		this.sljsdw = sljsdw;
	}
	/**
	 * @return AJSTATE 案件状态-字典项＝56
	 */
	public String getAjstate(){
		return this.ajstate;
	}
	/**
	 * @param AJSTATE 案件状态-字典项＝56
	 */
	public void setAjstate(String ajstate){
		this.ajstate = ajstate;
	}
	/**
	 * @return ZAZT 作案状态-字典项＝131
	 */
	public String getZazt(){
		return this.zazt;
	}
	/**
	 * @param ZAZT 作案状态-字典项＝131
	 */
	public void setZazt(String zazt){
		this.zazt = zazt;
	}
	/**
	 * @return SL_BJSLH 接警受理号
	 */
	public String getSlBjslh(){
		return this.slBjslh;
	}
	/**
	 * @param SL_BJSLH 接警受理号
	 */
	public void setSlBjslh(String slBjslh){
		this.slBjslh = slBjslh;
	}
	/**
	 * @return SL_JJFS 接警方式-字典项＝81
	 */
	public String getSlJjfs(){
		return this.slJjfs;
	}
	/**
	 * @param SL_JJFS 接警方式-字典项＝81
	 */
	public void setSlJjfs(String slJjfs){
		this.slJjfs = slJjfs;
	}
	/**
	 * @return AJLX 案件类型-字典项＝44
	 */
	public String getAjlx(){
		return this.ajlx;
	}
	/**
	 * @param AJLX 案件类型-字典项＝44
	 */
	public void setAjlx(String ajlx){
		this.ajlx = ajlx;
	}
	/**
	 * @return AB 案别/案由-字典项＝24
	 */
	public String getAb(){
		return this.ab;
	}
	/**
	 * @param AB 案别/案由-字典项＝24
	 */
	public void setAb(String ab){
		this.ab = ab;
	}
	/**
	 * @return ZABZ 专案标识-字典项＝48
	 */
	public String getZabz(){
		return this.zabz;
	}
	/**
	 * @param ZABZ 专案标识-字典项＝48
	 */
	public void setZabz(String zabz){
		this.zabz = zabz;
	}
	/**
	 * @return AJMC 案件名称
	 */
	public String getAjmc(){
		return this.ajmc;
	}
	/**
	 * @param AJMC 案件名称
	 */
	public void setAjmc(String ajmc){
		this.ajmc = ajmc;
	}
	/**
	 * @return AJWH 案件号
	 */
	public String getAjwh(){
		return this.ajwh;
	}
	/**
	 * @param AJWH 案件号
	 */
	public void setAjwh(String ajwh){
		this.ajwh = ajwh;
	}
	/**
	 * @return SLJJSJ 报警时间
	 */
	public Date getSljjsj(){
		return this.sljjsj;
	}
	/**
	 * @param SLJJSJ 报警时间
	 */
	public void setSljjsj(Date sljjsj){
		this.sljjsj = sljjsj;
	}
	/**
	 * @return SLFXRQ 发现时间
	 */
	public Date getSlfxrq(){
		return this.slfxrq;
	}
	/**
	 * @param SLFXRQ 发现时间
	 */
	public void setSlfxrq(Date slfxrq){
		this.slfxrq = slfxrq;
	}
	/**
	 * @return FASJCZ 发案时间初值
	 */
	public Date getFasjcz(){
		return this.fasjcz;
	}
	/**
	 * @param FASJCZ 发案时间初值
	 */
	public void setFasjcz(Date fasjcz){
		this.fasjcz = fasjcz;
	}
	/**
	 * @return FASJZZ 发案时间终值
	 */
	public Date getFasjzz(){
		return this.fasjzz;
	}
	/**
	 * @param FASJZZ 发案时间终值
	 */
	public void setFasjzz(Date fasjzz){
		this.fasjzz = fasjzz;
	}
	/**
	 * @return FADD_QX 发案地点_区县-字典项＝07
	 */
	public String getFaddQx(){
		return this.faddQx;
	}
	/**
	 * @param FADD_QX 发案地点_区县-字典项＝07
	 */
	public void setFaddQx(String faddQx){
		this.faddQx = faddQx;
	}
	/**
	 * @return FADD_JD 发案地点_街道-字典项＝107
	 */
	public String getFaddJd(){
		return this.faddJd;
	}
	/**
	 * @param FADD_JD 发案地点_街道-字典项＝107
	 */
	public void setFaddJd(String faddJd){
		this.faddJd = faddJd;
	}
	/**
	 * @return AJSSJQ 所属警区-字典项＝108
	 */
	public String getAjssjq(){
		return this.ajssjq;
	}
	/**
	 * @param AJSSJQ 所属警区-字典项＝108
	 */
	public void setAjssjq(String ajssjq){
		this.ajssjq = ajssjq;
	}
	/**
	 * @return FADD 发案地点详址
	 */
	public String getFadd(){
		return this.fadd;
	}
	/**
	 * @param FADD 发案地点详址
	 */
	public void setFadd(String fadd){
		this.fadd = fadd;
	}
	/**
	 * @return SSSQ 所属社区-字典项＝109
	 */
	public String getSssq(){
		return this.sssq;
	}
	/**
	 * @param SSSQ 所属社区-字典项＝109
	 */
	public void setSssq(String sssq){
		this.sssq = sssq;
	}
	/**
	 * @return FADY 发案地域-字典项＝45
	 */
	public String getFady(){
		return this.fady;
	}
	/**
	 * @param FADY 发案地域-字典项＝45
	 */
	public void setFady(String fady){
		this.fady = fady;
	}
	/**
	 * @return SLFACS 发案处所-字典项＝135
	 */
	public String getSlfacs(){
		return this.slfacs;
	}
	/**
	 * @param SLFACS 发案处所-字典项＝135
	 */
	public void setSlfacs(String slfacs){
		this.slfacs = slfacs;
	}
	/**
	 * @return FXXS 发现形式-字典项＝46
	 */
	public String getFxxs(){
		return this.fxxs;
	}
	/**
	 * @param FXXS 发现形式-字典项＝46
	 */
	public void setFxxs(String fxxs){
		this.fxxs = fxxs;
	}
	/**
	 * @return AJWHCD 危害程度-字典项＝43
	 */
	public String getAjwhcd(){
		return this.ajwhcd;
	}
	/**
	 * @param AJWHCD 危害程度-字典项＝43
	 */
	public void setAjwhcd(String ajwhcd){
		this.ajwhcd = ajwhcd;
	}
	/**
	 * @return BLYY 补立原因-字典项＝55
	 */
	public String getBlyy(){
		return this.blyy;
	}
	/**
	 * @param BLYY 补立原因-字典项＝55
	 */
	public void setBlyy(String blyy){
		this.blyy = blyy;
	}
	/**
	 * @return ZYAQ 简要案情
	 */
	public String getZyaq(){
		return this.zyaq;
	}
	/**
	 * @param ZYAQ 简要案情
	 */
	public void setZyaq(String zyaq){
		this.zyaq = zyaq;
	}
	/**
	 * @return XZSJ 作案时机-字典项＝29
	 */
	public String getXzsj(){
		return this.xzsj;
	}
	/**
	 * @param XZSJ 作案时机-字典项＝29
	 */
	public void setXzsj(String xzsj){
		this.xzsj = xzsj;
	}
	/**
	 * @return XZCS 选择处所-字典项＝30
	 */
	public String getXzcs(){
		return this.xzcs;
	}
	/**
	 * @param XZCS 选择处所-字典项＝30
	 */
	public void setXzcs(String xzcs){
		this.xzcs = xzcs;
	}
	/**
	 * @return XZDX 选择对象-字典项＝31
	 */
	public String getXzdx(){
		return this.xzdx;
	}
	/**
	 * @param XZDX 选择对象-字典项＝31
	 */
	public void setXzdx(String xzdx){
		this.xzdx = xzdx;
	}
	/**
	 * @return XZWP 选择物品-字典项＝33
	 */
	public String getXzwp(){
		return this.xzwp;
	}
	/**
	 * @param XZWP 选择物品-字典项＝33
	 */
	public void setXzwp(String xzwp){
		this.xzwp = xzwp;
	}
	/**
	 * @return ZAGJ 作案工具-字典项＝33
	 */
	public String getZagj(){
		return this.zagj;
	}
	/**
	 * @param ZAGJ 作案工具-字典项＝33
	 */
	public void setZagj(String zagj){
		this.zagj = zagj;
	}
	/**
	 * @return XZBW 选择部位-字典项＝30
	 */
	public String getXzbw(){
		return this.xzbw;
	}
	/**
	 * @param XZBW 选择部位-字典项＝30
	 */
	public void setXzbw(String xzbw){
		this.xzbw = xzbw;
	}
	/**
	 * @return ZARS 作案人数
	 */
	public Integer getZars(){
		return this.zars;
	}
	/**
	 * @param ZARS 作案人数
	 */
	public void setZars(Integer zars){
		this.zars = zars;
	}
	/**
	 * @return SDTD 作案手段特点-字典项＝36
	 */
	public String getSdtd(){
		return this.sdtd;
	}
	/**
	 * @param SDTD 作案手段特点-字典项＝36
	 */
	public void setSdtd(String sdtd){
		this.sdtd = sdtd;
	}
	/**
	 * @return SWRS 死亡人数
	 */
	public Integer getSwrs(){
		return this.swrs;
	}
	/**
	 * @param SWRS 死亡人数
	 */
	public void setSwrs(Integer swrs){
		this.swrs = swrs;
	}
	/**
	 * @return SSRS 受伤人数
	 */
	public Integer getSsrs(){
		return this.ssrs;
	}
	/**
	 * @param SSRS 受伤人数
	 */
	public void setSsrs(Integer ssrs){
		this.ssrs = ssrs;
	}
	/**
	 * @return SSJZ 损失折款
	 */
	public Double getSsjz(){
		return this.ssjz;
	}
	/**
	 * @param SSJZ 损失折款
	 */
	public void setSsjz(Double ssjz){
		this.ssjz = ssjz;
	}
	/**
	 * @return SAZZ 涉案总值
	 */
	public Double getSazz(){
		return this.sazz;
	}
	/**
	 * @param SAZZ 涉案总值
	 */
	public void setSazz(Double sazz){
		this.sazz = sazz;
	}
	/**
	 * @return LASJ 立案日期
	 */
	public Date getLasj(){
		return this.lasj;
	}
	/**
	 * @param LASJ 立案日期
	 */
	public void setLasj(Date lasj){
		this.lasj = lasj;
	}
	/**
	 * @return PASJ 破案时间
	 */
	public Date getPasj(){
		return this.pasj;
	}
	/**
	 * @param PASJ 破案时间
	 */
	public void setPasj(Date pasj){
		this.pasj = pasj;
	}
	/**
	 * @return JA_JASJ 结案时间
	 */
	public Date getJaJasj(){
		return this.jaJasj;
	}
	/**
	 * @param JA_JASJ 结案时间
	 */
	public void setJaJasj(Date jaJasj){
		this.jaJasj = jaJasj;
	}
	/**
	 * @return XA_XASJ 销案时间
	 */
	public Date getXaXasj(){
		return this.xaXasj;
	}
	/**
	 * @param XA_XASJ 销案时间
	 */
	public void setXaXasj(Date xaXasj){
		this.xaXasj = xaXasj;
	}
	/**
	 * @return YSSJ 移送时间
	 */
	public Date getYssj(){
		return this.yssj;
	}
	/**
	 * @param YSSJ 移送时间
	 */
	public void setYssj(Date yssj){
		this.yssj = yssj;
	}
	/**
	 * @return SLJJDW 接警单位-字典项＝06
	 */
	public String getSljjdw(){
		return this.sljjdw;
	}
	/**
	 * @param SLJJDW 接警单位-字典项＝06
	 */
	public void setSljjdw(String sljjdw){
		this.sljjdw = sljjdw;
	}
	/**
	 * @return SL_LRR 受理人
	 */
	public String getSlLrr(){
		return this.slLrr;
	}
	/**
	 * @param SL_LRR 受理人
	 */
	public void setSlLrr(String slLrr){
		this.slLrr = slLrr;
	}
	/**
	 * @return SL_LRSJ 受理时间
	 */
	public Date getSlLrsj(){
		return this.slLrsj;
	}
	/**
	 * @param SL_LRSJ 受理时间
	 */
	public void setSlLrsj(Date slLrsj){
		this.slLrsj = slLrsj;
	}
	/**
	 * @return SLJJRY 备用
	 */
	public String getSljjry(){
		return this.sljjry;
	}
	/**
	 * @param SLJJRY 备用
	 */
	public void setSljjry(String sljjry){
		this.sljjry = sljjry;
	}
	/**
	 * @return SL_SLRXM 填表人
	 */
	public String getSlSlrxm(){
		return this.slSlrxm;
	}
	/**
	 * @param SL_SLRXM 填表人
	 */
	public void setSlSlrxm(String slSlrxm){
		this.slSlrxm = slSlrxm;
	}
	/**
	 * @return SL_SLSJ 填表时间
	 */
	public Date getSlSlsj(){
		return this.slSlsj;
	}
	/**
	 * @param SL_SLSJ 填表时间
	 */
	public void setSlSlsj(Date slSlsj){
		this.slSlsj = slSlsj;
	}
	/**
	 * @return SLFAQH 发案地政区划
	 */
	public String getSlfaqh(){
		return this.slfaqh;
	}
	/**
	 * @param SLFAQH 发案地政区划
	 */
	public void setSlfaqh(String slfaqh){
		this.slfaqh = slfaqh;
	}
	/**
	 * @return LADW 立案单位-字典项＝06
	 */
	public String getLadw(){
		return this.ladw;
	}
	/**
	 * @param LADW 立案单位-字典项＝06
	 */
	public void setLadw(String ladw){
		this.ladw = ladw;
	}
	/**
	 * @return AJLARY 立案人
	 */
	public String getAjlary(){
		return this.ajlary;
	}
	/**
	 * @param AJLARY 立案人
	 */
	public void setAjlary(String ajlary){
		this.ajlary = ajlary;
	}
	/**
	 * @return ZBDW 主办单位
	 */
	public String getZbdw(){
		return this.zbdw;
	}
	/**
	 * @param ZBDW 主办单位
	 */
	public void setZbdw(String zbdw){
		this.zbdw = zbdw;
	}
	/**
	 * @return AJZBRY 主要办案人
	 */
	public String getAjzbry(){
		return this.ajzbry;
	}
	/**
	 * @param AJZBRY 主要办案人
	 */
	public void setAjzbry(String ajzbry){
		this.ajzbry = ajzbry;
	}
	/**
	 * @return AJXBRY 案件协办人
	 */
	public String getAjxbry(){
		return this.ajxbry;
	}
	/**
	 * @param AJXBRY 案件协办人
	 */
	public void setAjxbry(String ajxbry){
		this.ajxbry = ajxbry;
	}
	/**
	 * @return AJBARP 办案人联系电话
	 */
	public String getAjbarp(){
		return this.ajbarp;
	}
	/**
	 * @param AJBARP 办案人联系电话
	 */
	public void setAjbarp(String ajbarp){
		this.ajbarp = ajbarp;
	}
	/**
	 * @return LA_LRR 立案录入人
	 */
	public String getLaLrr(){
		return this.laLrr;
	}
	/**
	 * @param LA_LRR 立案录入人
	 */
	public void setLaLrr(String laLrr){
		this.laLrr = laLrr;
	}
	/**
	 * @return LA_LRSJ 立案录入时间
	 */
	public Date getLaLrsj(){
		return this.laLrsj;
	}
	/**
	 * @param LA_LRSJ 立案录入时间
	 */
	public void setLaLrsj(Date laLrsj){
		this.laLrsj = laLrsj;
	}
	/**
	 * @return LA_PZR 立案批准人
	 */
	public String getLaPzr(){
		return this.laPzr;
	}
	/**
	 * @param LA_PZR 立案批准人
	 */
	public void setLaPzr(String laPzr){
		this.laPzr = laPzr;
	}
	/**
	 * @return LA_PZSJ 立案批时间
	 */
	public Date getLaPzsj(){
		return this.laPzsj;
	}
	/**
	 * @param LA_PZSJ 立案批时间
	 */
	public void setLaPzsj(Date laPzsj){
		this.laPzsj = laPzsj;
	}
	/**
	 * @return LA_ZHXGR 案后修改人
	 */
	public String getLaZhxgr(){
		return this.laZhxgr;
	}
	/**
	 * @param LA_ZHXGR 案后修改人
	 */
	public void setLaZhxgr(String laZhxgr){
		this.laZhxgr = laZhxgr;
	}
	/**
	 * @return LA_ZHXGSJ 案最后修改时间
	 */
	public Date getLaZhxgsj(){
		return this.laZhxgsj;
	}
	/**
	 * @param LA_ZHXGSJ 案最后修改时间
	 */
	public void setLaZhxgsj(Date laZhxgsj){
		this.laZhxgsj = laZhxgsj;
	}
	/**
	 * @return LA_PSSTATE 批示状态
	 */
	public String getLaPsstate(){
		return this.laPsstate;
	}
	/**
	 * @param LA_PSSTATE 批示状态
	 */
	public void setLaPsstate(String laPsstate){
		this.laPsstate = laPsstate;
	}
	/**
	 * @return DBXX 督办信息
	 */
	public String getDbxx(){
		return this.dbxx;
	}
	/**
	 * @param DBXX 督办信息
	 */
	public void setDbxx(String dbxx){
		this.dbxx = dbxx;
	}
	/**
	 * @return AJLY 案件来源
	 */
	public String getAjly(){
		return this.ajly;
	}
	/**
	 * @param AJLY 案件来源
	 */
	public void setAjly(String ajly){
		this.ajly = ajly;
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
	 * @return YSSASJ 
	 */
	public Date getYssasj(){
		return this.yssasj;
	}
	/**
	 * @param YSSASJ 
	 */
	public void setYssasj(Date yssasj){
		this.yssasj = yssasj;
	}
	/**
	 * @return YSTCSJ 
	 */
	public Date getYstcsj(){
		return this.ystcsj;
	}
	/**
	 * @param YSTCSJ 
	 */
	public void setYstcsj(Date ystcsj){
		this.ystcsj = ystcsj;
	}
	/**
	 * @return WHSSJZ 挽回损失价值
	 */
	public Double getWhssjz(){
		return this.whssjz;
	}
	/**
	 * @param WHSSJZ 挽回损失价值
	 */
	public void setWhssjz(Double whssjz){
		this.whssjz = whssjz;
	}
	/**
	 * @return DBJB 督办级别
	 */
	public String getDbjb(){
		return this.dbjb;
	}
	/**
	 * @param DBJB 督办级别
	 */
	public void setDbjb(String dbjb){
		this.dbjb = dbjb;
	}
	/**
	 * @return JTAJLY 具体案件来源
	 */
	public String getJtajly(){
		return this.jtajly;
	}
	/**
	 * @param JTAJLY 具体案件来源
	 */
	public void setJtajly(String jtajly){
		this.jtajly = jtajly;
	}
	/**
	 * @return FZZTLX 犯罪主体类型-字典项=JZ_03
	 */
	public String getFzztlx(){
		return this.fzztlx;
	}
	/**
	 * @param FZZTLX 犯罪主体类型-字典项=JZ_03
	 */
	public void setFzztlx(String fzztlx){
		this.fzztlx = fzztlx;
	}
	/**
	 * @return SFSW 案情是否涉外
	 */
	public String getSfsw(){
		return this.sfsw;
	}
	/**
	 * @param SFSW 案情是否涉外
	 */
	public void setSfsw(String sfsw){
		this.sfsw = sfsw;
	}
	/**
	 * @return SJGJDQ 案情涉及国家地区
	 */
	public String getSjgjdq(){
		return this.sjgjdq;
	}
	/**
	 * @param SJGJDQ 案情涉及国家地区
	 */
	public void setSjgjdq(String sjgjdq){
		this.sjgjdq = sjgjdq;
	}
	/**
	 * @return YISHENSJ 一审时间
	 */
	public Date getYishensj(){
		return this.yishensj;
	}
	/**
	 * @param YISHENSJ 一审时间
	 */
	public void setYishensj(Date yishensj){
		this.yishensj = yishensj;
	}
	/**
	 * @return ESSJ 二审时间
	 */
	public Date getEssj(){
		return this.essj;
	}
	/**
	 * @param ESSJ 二审时间
	 */
	public void setEssj(Date essj){
		this.essj = essj;
	}
	/**
	 * @return YSDW 移送单位
	 */
	public String getYsdw(){
		return this.ysdw;
	}
	/**
	 * @param YSDW 移送单位
	 */
	public void setYsdw(String ysdw){
		this.ysdw = ysdw;
	}
	/**
	 * @return YSCBR 移送承办人
	 */
	public String getYscbr(){
		return this.yscbr;
	}
	/**
	 * @param YSCBR 移送承办人
	 */
	public void setYscbr(String yscbr){
		this.yscbr = yscbr;
	}
	/**
	 * @return YSDWDH 移送单位电话
	 */
	public String getYsdwdh(){
		return this.ysdwdh;
	}
	/**
	 * @param YSDWDH 移送单位电话
	 */
	public void setYsdwdh(String ysdwdh){
		this.ysdwdh = ysdwdh;
	}
	/**
	 * @return YSDW_NEW 移送单位（经侦并入派综后使用，原有不知何用，未使用）
	 */
	public String getYsdwNew(){
		return this.ysdwNew;
	}
	/**
	 * @param YSDW_NEW 移送单位（经侦并入派综后使用，原有不知何用，未使用）
	 */
	public void setYsdwNew(String ysdwNew){
		this.ysdwNew = ysdwNew;
	}
	/**
	 * @return YSDWDH_NEW 移送单位电话（经侦并入派综后使用，原有不知何用，未使用）
	 */
	public String getYsdwdhNew(){
		return this.ysdwdhNew;
	}
	/**
	 * @param YSDWDH_NEW 移送单位电话（经侦并入派综后使用，原有不知何用，未使用）
	 */
	public void setYsdwdhNew(String ysdwdhNew){
		this.ysdwdhNew = ysdwdhNew;
	}
	/**
	 * @return YSCBR_NEW 移送承办人（经侦并入派综后使用，原有不知何用，未使用）
	 */
	public String getYscbrNew(){
		return this.yscbrNew;
	}
	/**
	 * @param YSCBR_NEW 移送承办人（经侦并入派综后使用，原有不知何用，未使用）
	 */
	public void setYscbrNew(String yscbrNew){
		this.yscbrNew = yscbrNew;
	}
	/**
	 * @return YSSJ_NEW 移送时间（经侦并入派综后使用，原有不知何用，未使用）
	 */
	public Date getYssjNew(){
		return this.yssjNew;
	}
	/**
	 * @param YSSJ_NEW 移送时间（经侦并入派综后使用，原有不知何用，未使用）
	 */
	public void setYssjNew(Date yssjNew){
		this.yssjNew = yssjNew;
	}
	/**
	 * @return DEPARTMENTCODE 部门编号-字典项＝06
	 */
	public String getDepartmentcode(){
		return this.departmentcode;
	}
	/**
	 * @param DEPARTMENTCODE 部门编号-字典项＝06
	 */
	public void setDepartmentcode(String departmentcode){
		this.departmentcode = departmentcode;
	}
	/**
	 * @return CREATOR 创建者
	 */
	public String getCreator(){
		return this.creator;
	}
	/**
	 * @param CREATOR 创建者
	 */
	public void setCreator(String creator){
		this.creator = creator;
	}
	/**
	 * @return CREATEDTIME 创建时间
	 */
	public Date getCreatedtime(){
		return this.createdtime;
	}
	/**
	 * @param CREATEDTIME 创建时间
	 */
	public void setCreatedtime(Date createdtime){
		this.createdtime = createdtime;
	}
	/**
	 * @return SECURITYGRADE 密级
	 */
	public String getSecuritygrade(){
		return this.securitygrade;
	}
	/**
	 * @param SECURITYGRADE 密级
	 */
	public void setSecuritygrade(String securitygrade){
		this.securitygrade = securitygrade;
	}
	/**
	 * @return LASTUPDATEDBY 最终修改人
	 */
	public String getLastupdatedby(){
		return this.lastupdatedby;
	}
	/**
	 * @param LASTUPDATEDBY 最终修改人
	 */
	public void setLastupdatedby(String lastupdatedby){
		this.lastupdatedby = lastupdatedby;
	}
	/**
	 * @return LASTUPDATEDTIME 最后修改时间
	 */
	public Date getLastupdatedtime(){
		return this.lastupdatedtime;
	}
	/**
	 * @param LASTUPDATEDTIME 最后修改时间
	 */
	public void setLastupdatedtime(Date lastupdatedtime){
		this.lastupdatedtime = lastupdatedtime;
	}
	/**
	 * @return REFRESHTIME 更新时间
	 */
	public Date getRefreshtime(){
		return this.refreshtime;
	}
	/**
	 * @param REFRESHTIME 更新时间
	 */
	public void setRefreshtime(Date refreshtime){
		this.refreshtime = refreshtime;
	}
	/**
	 * @return UPLOADFLAG 上传标志
	 */
	public String getUploadflag(){
		return this.uploadflag;
	}
	/**
	 * @param UPLOADFLAG 上传标志
	 */
	public void setUploadflag(String uploadflag){
		this.uploadflag = uploadflag;
	}
	/**
	 * @return DOWNLOADFLAG 下传标志
	 */
	public String getDownloadflag(){
		return this.downloadflag;
	}
	/**
	 * @param DOWNLOADFLAG 下传标志
	 */
	public void setDownloadflag(String downloadflag){
		this.downloadflag = downloadflag;
	}
	/**
	 * @return DELETEFLAG 删除标志
	 */
	public String getDeleteflag(){
		return this.deleteflag;
	}
	/**
	 * @param DELETEFLAG 删除标志
	 */
	public void setDeleteflag(String deleteflag){
		this.deleteflag = deleteflag;
	}
	/**
	 * @return RESERVATION01 主办侦查员中文姓名
	 */
	public String getReservation01(){
		return this.reservation01;
	}
	/**
	 * @param RESERVATION01 主办侦查员中文姓名
	 */
	public void setReservation01(String reservation01){
		this.reservation01 = reservation01;
	}
	/**
	 * @return RESERVATION02 协办侦查员中文姓名
	 */
	public String getReservation02(){
		return this.reservation02;
	}
	/**
	 * @param RESERVATION02 协办侦查员中文姓名
	 */
	public void setReservation02(String reservation02){
		this.reservation02 = reservation02;
	}
	/**
	 * @return RESERVATION03 保留字段3
	 */
	public String getReservation03(){
		return this.reservation03;
	}
	/**
	 * @param RESERVATION03 保留字段3
	 */
	public void setReservation03(String reservation03){
		this.reservation03 = reservation03;
	}
	/**
	 * @return RESERVATION04 省
	 */
	public String getReservation04(){
		return this.reservation04;
	}
	/**
	 * @param RESERVATION04 省
	 */
	public void setReservation04(String reservation04){
		this.reservation04 = reservation04;
	}
	/**
	 * @return RESERVATION05 保留字段5
	 */
	public String getReservation05(){
		return this.reservation05;
	}
	/**
	 * @param RESERVATION05 保留字段5
	 */
	public void setReservation05(String reservation05){
		this.reservation05 = reservation05;
	}
	/**
	 * @return RESERVATION06 保字段6
	 */
	public String getReservation06(){
		return this.reservation06;
	}
	/**
	 * @param RESERVATION06 保字段6
	 */
	public void setReservation06(String reservation06){
		this.reservation06 = reservation06;
	}
	/**
	 * @return RESERVATION07 保留字段7
	 */
	public String getReservation07(){
		return this.reservation07;
	}
	/**
	 * @param RESERVATION07 保留字段7
	 */
	public void setReservation07(String reservation07){
		this.reservation07 = reservation07;
	}
	/**
	 * @return RESERVATION08 保留字段8
	 */
	public String getReservation08(){
		return this.reservation08;
	}
	/**
	 * @param RESERVATION08 保留字段8
	 */
	public void setReservation08(String reservation08){
		this.reservation08 = reservation08;
	}
	/**
	 * @return RESERVATION09 保留字段9
	 */
	public String getReservation09(){
		return this.reservation09;
	}
	/**
	 * @param RESERVATION09 保留字段9
	 */
	public void setReservation09(String reservation09){
		this.reservation09 = reservation09;
	}
	/**
	 * @return RESERVATION10 保留字段10
	 */
	public String getReservation10(){
		return this.reservation10;
	}
	/**
	 * @param RESERVATION10 保留字段10
	 */
	public void setReservation10(String reservation10){
		this.reservation10 = reservation10;
	}
	/**
	 * @return RESERVATION11 主案编号
	 */
	public String getReservation11(){
		return this.reservation11;
	}
	/**
	 * @param RESERVATION11 主案编号
	 */
	public void setReservation11(String reservation11){
		this.reservation11 = reservation11;
	}
	/**
	 * @return RESERVATION12 
	 */
	public String getReservation12(){
		return this.reservation12;
	}
	/**
	 * @param RESERVATION12 
	 */
	public void setReservation12(String reservation12){
		this.reservation12 = reservation12;
	}
	/**
	 * @return RESERVATION13 
	 */
	public String getReservation13(){
		return this.reservation13;
	}
	/**
	 * @param RESERVATION13 
	 */
	public void setReservation13(String reservation13){
		this.reservation13 = reservation13;
	}
	/**
	 * @return RESERVATION14 
	 */
	public String getReservation14(){
		return this.reservation14;
	}
	/**
	 * @param RESERVATION14 
	 */
	public void setReservation14(String reservation14){
		this.reservation14 = reservation14;
	}
	/**
	 * @return RESERVATION15 
	 */
	public String getReservation15(){
		return this.reservation15;
	}
	/**
	 * @param RESERVATION15 
	 */
	public void setReservation15(String reservation15){
		this.reservation15 = reservation15;
	}
	/**
	 * @return RESERVATION16 
	 */
	public String getReservation16(){
		return this.reservation16;
	}
	/**
	 * @param RESERVATION16 
	 */
	public void setReservation16(String reservation16){
		this.reservation16 = reservation16;
	}
	/**
	 * @return RESERVATION17 
	 */
	public String getReservation17(){
		return this.reservation17;
	}
	/**
	 * @param RESERVATION17 
	 */
	public void setReservation17(String reservation17){
		this.reservation17 = reservation17;
	}
	/**
	 * @return RESERVATION18 
	 */
	public String getReservation18(){
		return this.reservation18;
	}
	/**
	 * @param RESERVATION18 
	 */
	public void setReservation18(String reservation18){
		this.reservation18 = reservation18;
	}
	/**
	 * @return RESERVATION19 
	 */
	public String getReservation19(){
		return this.reservation19;
	}
	/**
	 * @param RESERVATION19 
	 */
	public void setReservation19(String reservation19){
		this.reservation19 = reservation19;
	}
	/**
	 * @return RESERVATION20 
	 */
	public String getReservation20(){
		return this.reservation20;
	}
	/**
	 * @param RESERVATION20 
	 */
	public void setReservation20(String reservation20){
		this.reservation20 = reservation20;
	}
	/**
	 * @return RESERVATION21 
	 */
	public Date getReservation21(){
		return this.reservation21;
	}
	/**
	 * @param RESERVATION21 
	 */
	public void setReservation21(Date reservation21){
		this.reservation21 = reservation21;
	}
	/**
	 * @return RESERVATION22 
	 */
	public Date getReservation22(){
		return this.reservation22;
	}
	/**
	 * @param RESERVATION22 
	 */
	public void setReservation22(Date reservation22){
		this.reservation22 = reservation22;
	}
	/**
	 * @return RESERVATION23 
	 */
	public Date getReservation23(){
		return this.reservation23;
	}
	/**
	 * @param RESERVATION23 
	 */
	public void setReservation23(Date reservation23){
		this.reservation23 = reservation23;
	}
	/**
	 * @return RESERVATION24 
	 */
	public Date getReservation24(){
		return this.reservation24;
	}
	/**
	 * @param RESERVATION24 
	 */
	public void setReservation24(Date reservation24){
		this.reservation24 = reservation24;
	}
	/**
	 * @return RESERVATION25 
	 */
	public Date getReservation25(){
		return this.reservation25;
	}
	/**
	 * @param RESERVATION25 
	 */
	public void setReservation25(Date reservation25){
		this.reservation25 = reservation25;
	}
	/**
	 * @return RESERVATION26 
	 */
	public Date getReservation26(){
		return this.reservation26;
	}
	/**
	 * @param RESERVATION26 
	 */
	public void setReservation26(Date reservation26){
		this.reservation26 = reservation26;
	}
	/**
	 * @return RESERVATION27 
	 */
	public Date getReservation27(){
		return this.reservation27;
	}
	/**
	 * @param RESERVATION27 
	 */
	public void setReservation27(Date reservation27){
		this.reservation27 = reservation27;
	}
	/**
	 * @return RESERVATION28 
	 */
	public Date getReservation28(){
		return this.reservation28;
	}
	/**
	 * @param RESERVATION28 
	 */
	public void setReservation28(Date reservation28){
		this.reservation28 = reservation28;
	}
	/**
	 * @return RESERVATION29 
	 */
	public Integer getReservation29(){
		return this.reservation29;
	}
	/**
	 * @param RESERVATION29 
	 */
	public void setReservation29(Integer reservation29){
		this.reservation29 = reservation29;
	}
	/**
	 * @return RESERVATION30 
	 */
	public Integer getReservation30(){
		return this.reservation30;
	}
	/**
	 * @param RESERVATION30 
	 */
	public void setReservation30(Integer reservation30){
		this.reservation30 = reservation30;
	}
	/**
	 * @return RESERVATION31 
	 */
	public Integer getReservation31(){
		return this.reservation31;
	}
	/**
	 * @param RESERVATION31 
	 */
	public void setReservation31(Integer reservation31){
		this.reservation31 = reservation31;
	}
	/**
	 * @return RESERVATION32 
	 */
	public Integer getReservation32(){
		return this.reservation32;
	}
	/**
	 * @param RESERVATION32 
	 */
	public void setReservation32(Integer reservation32){
		this.reservation32 = reservation32;
	}
	/**
	 * @return RESERVATION33 
	 */
	public Integer getReservation33(){
		return this.reservation33;
	}
	/**
	 * @param RESERVATION33 
	 */
	public void setReservation33(Integer reservation33){
		this.reservation33 = reservation33;
	}
	/**
	 * @return RESERVATION34 标识是否重新立案，0或null否，1是
	 */
	public String getReservation34(){
		return this.reservation34;
	}
	/**
	 * @param RESERVATION34 标识是否重新立案，0或null否，1是
	 */
	public void setReservation34(String reservation34){
		this.reservation34 = reservation34;
	}
	/**
	 * @return RESERVATION35 为了避免与派综案件编号重复，经侦案件的案件编号要重新存储
	 */
	public String getReservation35(){
		return this.reservation35;
	}
	/**
	 * @param RESERVATION35 为了避免与派综案件编号重复，经侦案件的案件编号要重新存储
	 */
	public void setReservation35(String reservation35){
		this.reservation35 = reservation35;
	}
	/**
	 * @return RESERVATION36 初查审核结果 字典项：JZ_06
	 */
	public String getReservation36(){
		return this.reservation36;
	}
	/**
	 * @param RESERVATION36 初查审核结果 字典项：JZ_06
	 */
	public void setReservation36(String reservation36){
		this.reservation36 = reservation36;
	}
	/**
	 * @return RESERVATION37 
	 */
	public String getReservation37(){
		return this.reservation37;
	}
	/**
	 * @param RESERVATION37 
	 */
	public void setReservation37(String reservation37){
		this.reservation37 = reservation37;
	}
	/**
	 * @return RESERVATION38 
	 */
	public String getReservation38(){
		return this.reservation38;
	}
	/**
	 * @param RESERVATION38 
	 */
	public void setReservation38(String reservation38){
		this.reservation38 = reservation38;
	}
	/**
	 * @return RESERVATION39 
	 */
	public String getReservation39(){
		return this.reservation39;
	}
	/**
	 * @param RESERVATION39 
	 */
	public void setReservation39(String reservation39){
		this.reservation39 = reservation39;
	}
	/**
	 * @return RESERVATION40 
	 */
	public String getReservation40(){
		return this.reservation40;
	}
	/**
	 * @param RESERVATION40 
	 */
	public void setReservation40(String reservation40){
		this.reservation40 = reservation40;
	}
	/**
	 * @return RESERVATION41 
	 */
	public String getReservation41(){
		return this.reservation41;
	}
	/**
	 * @param RESERVATION41 
	 */
	public void setReservation41(String reservation41){
		this.reservation41 = reservation41;
	}
	/**
	 * @return RESERVATION42 
	 */
	public String getReservation42(){
		return this.reservation42;
	}
	/**
	 * @param RESERVATION42 
	 */
	public void setReservation42(String reservation42){
		this.reservation42 = reservation42;
	}
	/**
	 * @return RESERVATION43 
	 */
	public String getReservation43(){
		return this.reservation43;
	}
	/**
	 * @param RESERVATION43 
	 */
	public void setReservation43(String reservation43){
		this.reservation43 = reservation43;
	}
	/**
	 * @return RESERVATION44 
	 */
	public String getReservation44(){
		return this.reservation44;
	}
	/**
	 * @param RESERVATION44 
	 */
	public void setReservation44(String reservation44){
		this.reservation44 = reservation44;
	}
	/**
	 * @return RESERVATION45 
	 */
	public String getReservation45(){
		return this.reservation45;
	}
	/**
	 * @param RESERVATION45 
	 */
	public void setReservation45(String reservation45){
		this.reservation45 = reservation45;
	}
	/**
	 * @return RESERVATION46 
	 */
	public Integer getReservation46(){
		return this.reservation46;
	}
	/**
	 * @param RESERVATION46 
	 */
	public void setReservation46(Integer reservation46){
		this.reservation46 = reservation46;
	}
	/**
	 * @return RESERVATION47 
	 */
	public Integer getReservation47(){
		return this.reservation47;
	}
	/**
	 * @param RESERVATION47 
	 */
	public void setReservation47(Integer reservation47){
		this.reservation47 = reservation47;
	}
	/**
	 * @return RESERVATION48 
	 */
	public Integer getReservation48(){
		return this.reservation48;
	}
	/**
	 * @param RESERVATION48 
	 */
	public void setReservation48(Integer reservation48){
		this.reservation48 = reservation48;
	}
	/**
	 * @return RESERVATION49 
	 */
	public Integer getReservation49(){
		return this.reservation49;
	}
	/**
	 * @param RESERVATION49 
	 */
	public void setReservation49(Integer reservation49){
		this.reservation49 = reservation49;
	}
	/**
	 * @return RESERVATION50 
	 */
	public Integer getReservation50(){
		return this.reservation50;
	}
	/**
	 * @param RESERVATION50 
	 */
	public void setReservation50(Integer reservation50){
		this.reservation50 = reservation50;
	}
	/**
	 * @return RESERVATION51 与经侦同步更新的时间，下次更新与此时间作比较
	 */
	public Date getReservation51(){
		return this.reservation51;
	}
	/**
	 * @param RESERVATION51 与经侦同步更新的时间，下次更新与此时间作比较
	 */
	public void setReservation51(Date reservation51){
		this.reservation51 = reservation51;
	}
	/**
	 * @return RESERVATION52 
	 */
	public Date getReservation52(){
		return this.reservation52;
	}
	/**
	 * @param RESERVATION52 
	 */
	public void setReservation52(Date reservation52){
		this.reservation52 = reservation52;
	}
	/**
	 * @return RESERVATION53 
	 */
	public Date getReservation53(){
		return this.reservation53;
	}
	/**
	 * @param RESERVATION53 
	 */
	public void setReservation53(Date reservation53){
		this.reservation53 = reservation53;
	}
	/**
	 * @return AJZBRY_NAME 案件主办人
	 */
	public String getAjzbryName(){
		return this.ajzbryName;
	}
	/**
	 * @param AJZBRY_NAME 案件主办人
	 */
	public void setAjzbryName(String ajzbryName){
		this.ajzbryName = ajzbryName;
	}
	/**
	 * @return AJXBRY_NAME 案件协办人（多值）
	 */
	public String getAjxbryName(){
		return this.ajxbryName;
	}
	/**
	 * @param AJXBRY_NAME 案件协办人（多值）
	 */
	public void setAjxbryName(String ajxbryName){
		this.ajxbryName = ajxbryName;
	}
	/**
	 * @return SL_LRR_NAME 受理人
	 */
	public String getSlLrrName(){
		return this.slLrrName;
	}
	/**
	 * @param SL_LRR_NAME 受理人
	 */
	public void setSlLrrName(String slLrrName){
		this.slLrrName = slLrrName;
	}
	/**
	 * @return SL_SLRXM_NAME 填表人
	 */
	public String getSlSlrxmName(){
		return this.slSlrxmName;
	}
	/**
	 * @param SL_SLRXM_NAME 填表人
	 */
	public void setSlSlrxmName(String slSlrxmName){
		this.slSlrxmName = slSlrxmName;
	}
	/**
	 * @return AJLARY_NAME 立案人
	 */
	public String getAjlaryName(){
		return this.ajlaryName;
	}
	/**
	 * @param AJLARY_NAME 立案人
	 */
	public void setAjlaryName(String ajlaryName){
		this.ajlaryName = ajlaryName;
	}
	/**
	 * @return LA_LRR_NAME 立案录入人
	 */
	public String getLaLrrName(){
		return this.laLrrName;
	}
	/**
	 * @param LA_LRR_NAME 立案录入人
	 */
	public void setLaLrrName(String laLrrName){
		this.laLrrName = laLrrName;
	}
	/**
	 * @return DEPARTMENTCODE_NAME 部门名称
	 */
	public String getDepartmentcodeName(){
		return this.departmentcodeName;
	}
	/**
	 * @param DEPARTMENTCODE_NAME 部门名称
	 */
	public void setDepartmentcodeName(String departmentcodeName){
		this.departmentcodeName = departmentcodeName;
	}
	/**
	 * @return ZBDW_NAME 主办单位
	 */
	public String getZbdwName(){
		return this.zbdwName;
	}
	/**
	 * @param ZBDW_NAME 主办单位
	 */
	public void setZbdwName(String zbdwName){
		this.zbdwName = zbdwName;
	}
	/**
	 * @return LADW_NAME 立案单位
	 */
	public String getLadwName(){
		return this.ladwName;
	}
	/**
	 * @param LADW_NAME 立案单位
	 */
	public void setLadwName(String ladwName){
		this.ladwName = ladwName;
	}
	/**
	 * @return SLJJDW_NAME 接警单位
	 */
	public String getSljjdwName(){
		return this.sljjdwName;
	}
	/**
	 * @param SLJJDW_NAME 接警单位
	 */
	public void setSljjdwName(String sljjdwName){
		this.sljjdwName = sljjdwName;
	}
	/**
	 * @return SLJSDW_NAME 受理单位
	 */
	public String getSljsdwName(){
		return this.sljsdwName;
	}
	/**
	 * @param SLJSDW_NAME 受理单位
	 */
	public void setSljsdwName(String sljsdwName){
		this.sljsdwName = sljsdwName;
	}
	/**
	 * @return RESERVER38 
	 */
	public String getReserver38(){
		return this.reserver38;
	}
	/**
	 * @param RESERVER38 
	 */
	public void setReserver38(String reserver38){
		this.reserver38 = reserver38;
	}
	/**
	 * @return RESERVER39 
	 */
	public String getReserver39(){
		return this.reserver39;
	}
	/**
	 * @param RESERVER39 
	 */
	public void setReserver39(String reserver39){
		this.reserver39 = reserver39;
	}
	/**
	 * @return RESERVER40 
	 */
	public String getReserver40(){
		return this.reserver40;
	}
	/**
	 * @param RESERVER40 
	 */
	public void setReserver40(String reserver40){
		this.reserver40 = reserver40;
	}
	/**
	 * @return RESERVER41 
	 */
	public String getReserver41(){
		return this.reserver41;
	}
	/**
	 * @param RESERVER41 
	 */
	public void setReserver41(String reserver41){
		this.reserver41 = reserver41;
	}
	/**
	 * @return RESERVER42 
	 */
	public String getReserver42(){
		return this.reserver42;
	}
	/**
	 * @param RESERVER42 
	 */
	public void setReserver42(String reserver42){
		this.reserver42 = reserver42;
	}
	/**
	 * @return RESERVER43 
	 */
	public String getReserver43(){
		return this.reserver43;
	}
	/**
	 * @param RESERVER43 
	 */
	public void setReserver43(String reserver43){
		this.reserver43 = reserver43;
	}
	/**
	 * @return RESERVER44 
	 */
	public String getReserver44(){
		return this.reserver44;
	}
	/**
	 * @param RESERVER44 
	 */
	public void setReserver44(String reserver44){
		this.reserver44 = reserver44;
	}
	/**
	 * @return RESERVER45 
	 */
	public String getReserver45(){
		return this.reserver45;
	}
	/**
	 * @param RESERVER45 
	 */
	public void setReserver45(String reserver45){
		this.reserver45 = reserver45;
	}
	/**
	 * @return RESERVER46 
	 */
	public String getReserver46(){
		return this.reserver46;
	}
	/**
	 * @param RESERVER46 
	 */
	public void setReserver46(String reserver46){
		this.reserver46 = reserver46;
	}
	/**
	 * @return RESERVER47 
	 */
	public String getReserver47(){
		return this.reserver47;
	}
	/**
	 * @param RESERVER47 
	 */
	public void setReserver47(String reserver47){
		this.reserver47 = reserver47;
	}
	/**
	 * @return RESERVER48 
	 */
	public String getReserver48(){
		return this.reserver48;
	}
	/**
	 * @param RESERVER48 
	 */
	public void setReserver48(String reserver48){
		this.reserver48 = reserver48;
	}
	/**
	 * @return RESERVER49 
	 */
	public String getReserver49(){
		return this.reserver49;
	}
	/**
	 * @param RESERVER49 
	 */
	public void setReserver49(String reserver49){
		this.reserver49 = reserver49;
	}
	/**
	 * @return RESERVER50 
	 */
	public String getReserver50(){
		return this.reserver50;
	}
	/**
	 * @param RESERVER50 
	 */
	public void setReserver50(String reserver50){
		this.reserver50 = reserver50;
	}
	/**
	 * @return RESERVER51 
	 */
	public String getReserver51(){
		return this.reserver51;
	}
	/**
	 * @param RESERVER51 
	 */
	public void setReserver51(String reserver51){
		this.reserver51 = reserver51;
	}
	/**
	 * @return RESERVER52 
	 */
	public String getReserver52(){
		return this.reserver52;
	}
	/**
	 * @param RESERVER52 
	 */
	public void setReserver52(String reserver52){
		this.reserver52 = reserver52;
	}
	/**
	 * @return RESERVER53 
	 */
	public String getReserver53(){
		return this.reserver53;
	}
	/**
	 * @param RESERVER53 
	 */
	public void setReserver53(String reserver53){
		this.reserver53 = reserver53;
	}
	/**
	 * @return RESERVER54 
	 */
	public String getReserver54(){
		return this.reserver54;
	}
	/**
	 * @param RESERVER54 
	 */
	public void setReserver54(String reserver54){
		this.reserver54 = reserver54;
	}
	/**
	 * @return RESERVER55 
	 */
	public String getReserver55(){
		return this.reserver55;
	}
	/**
	 * @param RESERVER55 
	 */
	public void setReserver55(String reserver55){
		this.reserver55 = reserver55;
	}
	/**
	 * @return RESERVER56 
	 */
	public String getReserver56(){
		return this.reserver56;
	}
	/**
	 * @param RESERVER56 
	 */
	public void setReserver56(String reserver56){
		this.reserver56 = reserver56;
	}
	/**
	 * @return RESERVER57 
	 */
	public String getReserver57(){
		return this.reserver57;
	}
	/**
	 * @param RESERVER57 
	 */
	public void setReserver57(String reserver57){
		this.reserver57 = reserver57;
	}
	/**
	 * @return RESERVER58 
	 */
	public String getReserver58(){
		return this.reserver58;
	}
	/**
	 * @param RESERVER58 
	 */
	public void setReserver58(String reserver58){
		this.reserver58 = reserver58;
	}
	/**
	 * @return RESERVER59 
	 */
	public String getReserver59(){
		return this.reserver59;
	}
	/**
	 * @param RESERVER59 
	 */
	public void setReserver59(String reserver59){
		this.reserver59 = reserver59;
	}
	/**
	 * @return RESERVER60 
	 */
	public String getReserver60(){
		return this.reserver60;
	}
	/**
	 * @param RESERVER60 
	 */
	public void setReserver60(String reserver60){
		this.reserver60 = reserver60;
	}
	/**
	 * @return RESERVER61 
	 */
	public Long getReserver61(){
		return this.reserver61;
	}
	/**
	 * @param RESERVER61 
	 */
	public void setReserver61(Long reserver61){
		this.reserver61 = reserver61;
	}
	/**
	 * @return RESERVER62 
	 */
	public Long getReserver62(){
		return this.reserver62;
	}
	/**
	 * @param RESERVER62 
	 */
	public void setReserver62(Long reserver62){
		this.reserver62 = reserver62;
	}
	/**
	 * @return RESERVER63 
	 */
	public Long getReserver63(){
		return this.reserver63;
	}
	/**
	 * @param RESERVER63 
	 */
	public void setReserver63(Long reserver63){
		this.reserver63 = reserver63;
	}
	/**
	 * @return RESERVER64 
	 */
	public Long getReserver64(){
		return this.reserver64;
	}
	/**
	 * @param RESERVER64 
	 */
	public void setReserver64(Long reserver64){
		this.reserver64 = reserver64;
	}
	/**
	 * @return RESERVER65 
	 */
	public Long getReserver65(){
		return this.reserver65;
	}
	/**
	 * @param RESERVER65 
	 */
	public void setReserver65(Long reserver65){
		this.reserver65 = reserver65;
	}
	/**
	 * @return RESERVER66 
	 */
	public Long getReserver66(){
		return this.reserver66;
	}
	/**
	 * @param RESERVER66 
	 */
	public void setReserver66(Long reserver66){
		this.reserver66 = reserver66;
	}
	/**
	 * @return RESERVER67 
	 */
	public Long getReserver67(){
		return this.reserver67;
	}
	/**
	 * @param RESERVER67 
	 */
	public void setReserver67(Long reserver67){
		this.reserver67 = reserver67;
	}
	/**
	 * @return RESERVER68 
	 */
	public Long getReserver68(){
		return this.reserver68;
	}
	/**
	 * @param RESERVER68 
	 */
	public void setReserver68(Long reserver68){
		this.reserver68 = reserver68;
	}
	/**
	 * @return RESERVER69 
	 */
	public Long getReserver69(){
		return this.reserver69;
	}
	/**
	 * @param RESERVER69 
	 */
	public void setReserver69(Long reserver69){
		this.reserver69 = reserver69;
	}
	/**
	 * @return RESERVER70 
	 */
	public Long getReserver70(){
		return this.reserver70;
	}
	/**
	 * @param RESERVER70 
	 */
	public void setReserver70(Long reserver70){
		this.reserver70 = reserver70;
	}
	/**
	 * @return RESERVER71 
	 */
	public Long getReserver71(){
		return this.reserver71;
	}
	/**
	 * @param RESERVER71 
	 */
	public void setReserver71(Long reserver71){
		this.reserver71 = reserver71;
	}
	/**
	 * @return RESERVER72 
	 */
	public Long getReserver72(){
		return this.reserver72;
	}
	/**
	 * @param RESERVER72 
	 */
	public void setReserver72(Long reserver72){
		this.reserver72 = reserver72;
	}
	/**
	 * @return RESERVER73 
	 */
	public Long getReserver73(){
		return this.reserver73;
	}
	/**
	 * @param RESERVER73 
	 */
	public void setReserver73(Long reserver73){
		this.reserver73 = reserver73;
	}
	/**
	 * @return RESERVER74 
	 */
	public Long getReserver74(){
		return this.reserver74;
	}
	/**
	 * @param RESERVER74 
	 */
	public void setReserver74(Long reserver74){
		this.reserver74 = reserver74;
	}
	/**
	 * @return RESERVER75 
	 */
	public Long getReserver75(){
		return this.reserver75;
	}
	/**
	 * @param RESERVER75 
	 */
	public void setReserver75(Long reserver75){
		this.reserver75 = reserver75;
	}
	/**
	 * @return RESERVER76 
	 */
	public Date getReserver76(){
		return this.reserver76;
	}
	/**
	 * @param RESERVER76 
	 */
	public void setReserver76(Date reserver76){
		this.reserver76 = reserver76;
	}
	/**
	 * @return RESERVER77 
	 */
	public Date getReserver77(){
		return this.reserver77;
	}
	/**
	 * @param RESERVER77 
	 */
	public void setReserver77(Date reserver77){
		this.reserver77 = reserver77;
	}
	/**
	 * @return RESERVER78 
	 */
	public Date getReserver78(){
		return this.reserver78;
	}
	/**
	 * @param RESERVER78 
	 */
	public void setReserver78(Date reserver78){
		this.reserver78 = reserver78;
	}
	/**
	 * @return RESERVER79 
	 */
	public Date getReserver79(){
		return this.reserver79;
	}
	/**
	 * @param RESERVER79 
	 */
	public void setReserver79(Date reserver79){
		this.reserver79 = reserver79;
	}
	/**
	 * @return RESERVER80 
	 */
	public Date getReserver80(){
		return this.reserver80;
	}
	/**
	 * @param RESERVER80 
	 */
	public void setReserver80(Date reserver80){
		this.reserver80 = reserver80;
	}
	/**
	 * @return RESERVER81 
	 */
	public Date getReserver81(){
		return this.reserver81;
	}
	/**
	 * @param RESERVER81 
	 */
	public void setReserver81(Date reserver81){
		this.reserver81 = reserver81;
	}
	/**
	 * @return RESERVER82 
	 */
	public Date getReserver82(){
		return this.reserver82;
	}
	/**
	 * @param RESERVER82 
	 */
	public void setReserver82(Date reserver82){
		this.reserver82 = reserver82;
	}
	/**
	 * @return RESERVER83 
	 */
	public Date getReserver83(){
		return this.reserver83;
	}
	/**
	 * @param RESERVER83 
	 */
	public void setReserver83(Date reserver83){
		this.reserver83 = reserver83;
	}
	/**
	 * @return RESERVER84 
	 */
	public Date getReserver84(){
		return this.reserver84;
	}
	/**
	 * @param RESERVER84 
	 */
	public void setReserver84(Date reserver84){
		this.reserver84 = reserver84;
	}
	/**
	 * @return RESERVER85 
	 */
	public Date getReserver85(){
		return this.reserver85;
	}
	/**
	 * @param RESERVER85 
	 */
	public void setReserver85(Date reserver85){
		this.reserver85 = reserver85;
	}
	/**
	 * @return RESERVER86 
	 */
	public Date getReserver86(){
		return this.reserver86;
	}
	/**
	 * @param RESERVER86 
	 */
	public void setReserver86(Date reserver86){
		this.reserver86 = reserver86;
	}
	/**
	 * @return RESERVER87 
	 */
	public Date getReserver87(){
		return this.reserver87;
	}
	/**
	 * @param RESERVER87 
	 */
	public void setReserver87(Date reserver87){
		this.reserver87 = reserver87;
	}
	/**
	 * @return RESERVER88 
	 */
	public Date getReserver88(){
		return this.reserver88;
	}
	/**
	 * @param RESERVER88 
	 */
	public void setReserver88(Date reserver88){
		this.reserver88 = reserver88;
	}
	/**
	 * @return RESERVER89 
	 */
	public Date getReserver89(){
		return this.reserver89;
	}
	/**
	 * @param RESERVER89 
	 */
	public void setReserver89(Date reserver89){
		this.reserver89 = reserver89;
	}
	/**
	 * @return RESERVER90 
	 */
	public Date getReserver90(){
		return this.reserver90;
	}
	/**
	 * @param RESERVER90 
	 */
	public void setReserver90(Date reserver90){
		this.reserver90 = reserver90;
	}
	/**
	 * @return RESERVER91 
	 */
	public String getReserver91(){
		return this.reserver91;
	}
	/**
	 * @param RESERVER91 
	 */
	public void setReserver91(String reserver91){
		this.reserver91 = reserver91;
	}
	/**
	 * @return RESERVER92 
	 */
	public String getReserver92(){
		return this.reserver92;
	}
	/**
	 * @param RESERVER92 
	 */
	public void setReserver92(String reserver92){
		this.reserver92 = reserver92;
	}
	/**
	 * @return RESERVER93 
	 */
	public String getReserver93(){
		return this.reserver93;
	}
	/**
	 * @param RESERVER93 
	 */
	public void setReserver93(String reserver93){
		this.reserver93 = reserver93;
	}
	/**
	 * @return RESERVER94 
	 */
	public String getReserver94(){
		return this.reserver94;
	}
	/**
	 * @param RESERVER94 
	 */
	public void setReserver94(String reserver94){
		this.reserver94 = reserver94;
	}
	/**
	 * @return RESERVER95 
	 */
	public String getReserver95(){
		return this.reserver95;
	}
	/**
	 * @param RESERVER95 
	 */
	public void setReserver95(String reserver95){
		this.reserver95 = reserver95;
	}
	/**
	 * @return RESERVER96 
	 */
	public String getReserver96(){
		return this.reserver96;
	}
	/**
	 * @param RESERVER96 
	 */
	public void setReserver96(String reserver96){
		this.reserver96 = reserver96;
	}
	/**
	 * @return RESERVER97 
	 */
	public String getReserver97(){
		return this.reserver97;
	}
	/**
	 * @param RESERVER97 
	 */
	public void setReserver97(String reserver97){
		this.reserver97 = reserver97;
	}
	/**
	 * @return RESERVER98 
	 */
	public String getReserver98(){
		return this.reserver98;
	}
	/**
	 * @param RESERVER98 
	 */
	public void setReserver98(String reserver98){
		this.reserver98 = reserver98;
	}
	/**
	 * @return RESERVER99 
	 */
	public String getReserver99(){
		return this.reserver99;
	}
	/**
	 * @param RESERVER99 
	 */
	public void setReserver99(String reserver99){
		this.reserver99 = reserver99;
	}
	/**
	 * @return RESERVER100 
	 */
	public String getReserver100(){
		return this.reserver100;
	}
	/**
	 * @param RESERVER100 
	 */
	public void setReserver100(String reserver100){
		this.reserver100 = reserver100;
	}
	/**
	 * @return RESERVER1 
	 */
	public String getReserver1(){
		return this.reserver1;
	}
	/**
	 * @param RESERVER1 
	 */
	public void setReserver1(String reserver1){
		this.reserver1 = reserver1;
	}
	/**
	 * @return RESERVER2 
	 */
	public String getReserver2(){
		return this.reserver2;
	}
	/**
	 * @param RESERVER2 
	 */
	public void setReserver2(String reserver2){
		this.reserver2 = reserver2;
	}
	/**
	 * @return RESERVER3 X坐标
	 */
	public String getReserver3(){
		return this.reserver3;
	}
	/**
	 * @param RESERVER3 X坐标
	 */
	public void setReserver3(String reserver3){
		this.reserver3 = reserver3;
	}
	/**
	 * @return RESERVER4 Y坐标
	 */
	public String getReserver4(){
		return this.reserver4;
	}
	/**
	 * @param RESERVER4 Y坐标
	 */
	public void setReserver4(String reserver4){
		this.reserver4 = reserver4;
	}
	/**
	 * @return RESERVER5 
	 */
	public String getReserver5(){
		return this.reserver5;
	}
	/**
	 * @param RESERVER5 
	 */
	public void setReserver5(String reserver5){
		this.reserver5 = reserver5;
	}
	/**
	 * @return RESERVER6 
	 */
	public String getReserver6(){
		return this.reserver6;
	}
	/**
	 * @param RESERVER6 
	 */
	public void setReserver6(String reserver6){
		this.reserver6 = reserver6;
	}
	/**
	 * @return RESERVER7 
	 */
	public String getReserver7(){
		return this.reserver7;
	}
	/**
	 * @param RESERVER7 
	 */
	public void setReserver7(String reserver7){
		this.reserver7 = reserver7;
	}
	/**
	 * @return RESERVER8 
	 */
	public String getReserver8(){
		return this.reserver8;
	}
	/**
	 * @param RESERVER8 
	 */
	public void setReserver8(String reserver8){
		this.reserver8 = reserver8;
	}
	/**
	 * @return RESERVER9 
	 */
	public String getReserver9(){
		return this.reserver9;
	}
	/**
	 * @param RESERVER9 
	 */
	public void setReserver9(String reserver9){
		this.reserver9 = reserver9;
	}
	/**
	 * @return RESERVER10 
	 */
	public String getReserver10(){
		return this.reserver10;
	}
	/**
	 * @param RESERVER10 
	 */
	public void setReserver10(String reserver10){
		this.reserver10 = reserver10;
	}
	/**
	 * @return RESERVER11 
	 */
	public String getReserver11(){
		return this.reserver11;
	}
	/**
	 * @param RESERVER11 
	 */
	public void setReserver11(String reserver11){
		this.reserver11 = reserver11;
	}
	/**
	 * @return RESERVER12 
	 */
	public String getReserver12(){
		return this.reserver12;
	}
	/**
	 * @param RESERVER12 
	 */
	public void setReserver12(String reserver12){
		this.reserver12 = reserver12;
	}
	/**
	 * @return RESERVER13 
	 */
	public String getReserver13(){
		return this.reserver13;
	}
	/**
	 * @param RESERVER13 
	 */
	public void setReserver13(String reserver13){
		this.reserver13 = reserver13;
	}
	/**
	 * @return RESERVER14 
	 */
	public String getReserver14(){
		return this.reserver14;
	}
	/**
	 * @param RESERVER14 
	 */
	public void setReserver14(String reserver14){
		this.reserver14 = reserver14;
	}
	/**
	 * @return RESERVER15 
	 */
	public String getReserver15(){
		return this.reserver15;
	}
	/**
	 * @param RESERVER15 
	 */
	public void setReserver15(String reserver15){
		this.reserver15 = reserver15;
	}
	/**
	 * @return RESERVER16 
	 */
	public String getReserver16(){
		return this.reserver16;
	}
	/**
	 * @param RESERVER16 
	 */
	public void setReserver16(String reserver16){
		this.reserver16 = reserver16;
	}
	/**
	 * @return RESERVER17 
	 */
	public String getReserver17(){
		return this.reserver17;
	}
	/**
	 * @param RESERVER17 
	 */
	public void setReserver17(String reserver17){
		this.reserver17 = reserver17;
	}
	/**
	 * @return RESERVER18 
	 */
	public String getReserver18(){
		return this.reserver18;
	}
	/**
	 * @param RESERVER18 
	 */
	public void setReserver18(String reserver18){
		this.reserver18 = reserver18;
	}
	/**
	 * @return RESERVER19 
	 */
	public String getReserver19(){
		return this.reserver19;
	}
	/**
	 * @param RESERVER19 
	 */
	public void setReserver19(String reserver19){
		this.reserver19 = reserver19;
	}
	/**
	 * @return RESERVER20 
	 */
	public String getReserver20(){
		return this.reserver20;
	}
	/**
	 * @param RESERVER20 
	 */
	public void setReserver20(String reserver20){
		this.reserver20 = reserver20;
	}
	/**
	 * @return RESERVER21 
	 */
	public String getReserver21(){
		return this.reserver21;
	}
	/**
	 * @param RESERVER21 
	 */
	public void setReserver21(String reserver21){
		this.reserver21 = reserver21;
	}
	/**
	 * @return RESERVER22 
	 */
	public String getReserver22(){
		return this.reserver22;
	}
	/**
	 * @param RESERVER22 
	 */
	public void setReserver22(String reserver22){
		this.reserver22 = reserver22;
	}
	/**
	 * @return RESERVER23 
	 */
	public String getReserver23(){
		return this.reserver23;
	}
	/**
	 * @param RESERVER23 
	 */
	public void setReserver23(String reserver23){
		this.reserver23 = reserver23;
	}
	/**
	 * @return RESERVER24 
	 */
	public String getReserver24(){
		return this.reserver24;
	}
	/**
	 * @param RESERVER24 
	 */
	public void setReserver24(String reserver24){
		this.reserver24 = reserver24;
	}
	/**
	 * @return RESERVER25 
	 */
	public String getReserver25(){
		return this.reserver25;
	}
	/**
	 * @param RESERVER25 
	 */
	public void setReserver25(String reserver25){
		this.reserver25 = reserver25;
	}
	/**
	 * @return RESERVER26 
	 */
	public String getReserver26(){
		return this.reserver26;
	}
	/**
	 * @param RESERVER26 
	 */
	public void setReserver26(String reserver26){
		this.reserver26 = reserver26;
	}
	/**
	 * @return RESERVER27 
	 */
	public String getReserver27(){
		return this.reserver27;
	}
	/**
	 * @param RESERVER27 
	 */
	public void setReserver27(String reserver27){
		this.reserver27 = reserver27;
	}
	/**
	 * @return RESERVER28 
	 */
	public String getReserver28(){
		return this.reserver28;
	}
	/**
	 * @param RESERVER28 
	 */
	public void setReserver28(String reserver28){
		this.reserver28 = reserver28;
	}
	/**
	 * @return RESERVER29 
	 */
	public String getReserver29(){
		return this.reserver29;
	}
	/**
	 * @param RESERVER29 
	 */
	public void setReserver29(String reserver29){
		this.reserver29 = reserver29;
	}
	/**
	 * @return RESERVER30 
	 */
	public String getReserver30(){
		return this.reserver30;
	}
	/**
	 * @param RESERVER30 
	 */
	public void setReserver30(String reserver30){
		this.reserver30 = reserver30;
	}
	/**
	 * @return RESERVER31 
	 */
	public String getReserver31(){
		return this.reserver31;
	}
	/**
	 * @param RESERVER31 
	 */
	public void setReserver31(String reserver31){
		this.reserver31 = reserver31;
	}
	/**
	 * @return RESERVER32 
	 */
	public String getReserver32(){
		return this.reserver32;
	}
	/**
	 * @param RESERVER32 
	 */
	public void setReserver32(String reserver32){
		this.reserver32 = reserver32;
	}
	/**
	 * @return RESERVER33 
	 */
	public String getReserver33(){
		return this.reserver33;
	}
	/**
	 * @param RESERVER33 
	 */
	public void setReserver33(String reserver33){
		this.reserver33 = reserver33;
	}
	/**
	 * @return RESERVER34 
	 */
	public String getReserver34(){
		return this.reserver34;
	}
	/**
	 * @param RESERVER34 
	 */
	public void setReserver34(String reserver34){
		this.reserver34 = reserver34;
	}
	/**
	 * @return RESERVER35 
	 */
	public String getReserver35(){
		return this.reserver35;
	}
	/**
	 * @param RESERVER35 
	 */
	public void setReserver35(String reserver35){
		this.reserver35 = reserver35;
	}
	/**
	 * @return RESERVER36 
	 */
	public String getReserver36(){
		return this.reserver36;
	}
	/**
	 * @param RESERVER36 
	 */
	public void setReserver36(String reserver36){
		this.reserver36 = reserver36;
	}
	/**
	 * @return RESERVER37 
	 */
	public String getReserver37(){
		return this.reserver37;
	}
	/**
	 * @param RESERVER37 
	 */
	public void setReserver37(String reserver37){
		this.reserver37 = reserver37;
	}
	/**
	 * @return YYK_RKSJ 
	 */
	public Date getYykRksj(){
		return this.yykRksj;
	}
	/**
	 * @param YYK_RKSJ 
	 */
	public void setYykRksj(Date yykRksj){
		this.yykRksj = yykRksj;
	}
	/**
	 * @return AB_CN 
	 */
	public String getAbCn(){
		return this.abCn;
	}
	/**
	 * @param AB_CN 
	 */
	public void setAbCn(String abCn){
		this.abCn = abCn;
	}
	/**
	 * @return AJSSJQ_CN 
	 */
	public String getAjssjqCn(){
		return this.ajssjqCn;
	}
	/**
	 * @param AJSSJQ_CN 
	 */
	public void setAjssjqCn(String ajssjqCn){
		this.ajssjqCn = ajssjqCn;
	}
	/**
	 * @return AJSTATE_CN 
	 */
	public String getAjstateCn(){
		return this.ajstateCn;
	}
	/**
	 * @param AJSTATE_CN 
	 */
	public void setAjstateCn(String ajstateCn){
		this.ajstateCn = ajstateCn;
	}
	/**
	 * @return AJWHCD_CN 
	 */
	public String getAjwhcdCn(){
		return this.ajwhcdCn;
	}
	/**
	 * @param AJWHCD_CN 
	 */
	public void setAjwhcdCn(String ajwhcdCn){
		this.ajwhcdCn = ajwhcdCn;
	}
	/**
	 * @return BLYY_CN 
	 */
	public String getBlyyCn(){
		return this.blyyCn;
	}
	/**
	 * @param BLYY_CN 
	 */
	public void setBlyyCn(String blyyCn){
		this.blyyCn = blyyCn;
	}
	/**
	 * @return CREATOR_CN 
	 */
	public String getCreatorCn(){
		return this.creatorCn;
	}
	/**
	 * @param CREATOR_CN 
	 */
	public void setCreatorCn(String creatorCn){
		this.creatorCn = creatorCn;
	}
	/**
	 * @return DATACHECK 
	 */
	public String getDatacheck(){
		return this.datacheck;
	}
	/**
	 * @param DATACHECK 
	 */
	public void setDatacheck(String datacheck){
		this.datacheck = datacheck;
	}
	/**
	 * @return DATASTATE 
	 */
	public String getDatastate(){
		return this.datastate;
	}
	/**
	 * @param DATASTATE 
	 */
	public void setDatastate(String datastate){
		this.datastate = datastate;
	}
	/**
	 * @return DBJB_CN 
	 */
	public String getDbjbCn(){
		return this.dbjbCn;
	}
	/**
	 * @param DBJB_CN 
	 */
	public void setDbjbCn(String dbjbCn){
		this.dbjbCn = dbjbCn;
	}
	/**
	 * @return DEPARTMENTCODE_CN 
	 */
	public String getDepartmentcodeCn(){
		return this.departmentcodeCn;
	}
	/**
	 * @param DEPARTMENTCODE_CN 
	 */
	public void setDepartmentcodeCn(String departmentcodeCn){
		this.departmentcodeCn = departmentcodeCn;
	}
	/**
	 * @return FADD_JD_CN 
	 */
	public String getFaddJdCn(){
		return this.faddJdCn;
	}
	/**
	 * @param FADD_JD_CN 
	 */
	public void setFaddJdCn(String faddJdCn){
		this.faddJdCn = faddJdCn;
	}
	/**
	 * @return FADD_QX_CN 
	 */
	public String getFaddQxCn(){
		return this.faddQxCn;
	}
	/**
	 * @param FADD_QX_CN 
	 */
	public void setFaddQxCn(String faddQxCn){
		this.faddQxCn = faddQxCn;
	}
	/**
	 * @return FADY_CN 
	 */
	public String getFadyCn(){
		return this.fadyCn;
	}
	/**
	 * @param FADY_CN 
	 */
	public void setFadyCn(String fadyCn){
		this.fadyCn = fadyCn;
	}
	/**
	 * @return FXXS_CN 
	 */
	public String getFxxsCn(){
		return this.fxxsCn;
	}
	/**
	 * @param FXXS_CN 
	 */
	public void setFxxsCn(String fxxsCn){
		this.fxxsCn = fxxsCn;
	}
	/**
	 * @return FZZTLX_CN 
	 */
	public String getFzztlxCn(){
		return this.fzztlxCn;
	}
	/**
	 * @param FZZTLX_CN 
	 */
	public void setFzztlxCn(String fzztlxCn){
		this.fzztlxCn = fzztlxCn;
	}
	/**
	 * @return JZBH 
	 */
	public String getJzbh(){
		return this.jzbh;
	}
	/**
	 * @param JZBH 
	 */
	public void setJzbh(String jzbh){
		this.jzbh = jzbh;
	}
	/**
	 * @return LASTUPDATEDBY_CN 
	 */
	public String getLastupdatedbyCn(){
		return this.lastupdatedbyCn;
	}
	/**
	 * @param LASTUPDATEDBY_CN 
	 */
	public void setLastupdatedbyCn(String lastupdatedbyCn){
		this.lastupdatedbyCn = lastupdatedbyCn;
	}
	/**
	 * @return QUERYID 
	 */
	public String getQueryid(){
		return this.queryid;
	}
	/**
	 * @param QUERYID 
	 */
	public void setQueryid(String queryid){
		this.queryid = queryid;
	}
	/**
	 * @return RESERVATION03_CN 
	 */
	public String getReservation03Cn(){
		return this.reservation03Cn;
	}
	/**
	 * @param RESERVATION03_CN 
	 */
	public void setReservation03Cn(String reservation03Cn){
		this.reservation03Cn = reservation03Cn;
	}
	/**
	 * @return RESERVATION36_CN 
	 */
	public String getReservation36Cn(){
		return this.reservation36Cn;
	}
	/**
	 * @param RESERVATION36_CN 
	 */
	public void setReservation36Cn(String reservation36Cn){
		this.reservation36Cn = reservation36Cn;
	}
	/**
	 * @return SDTD_CN 
	 */
	public String getSdtdCn(){
		return this.sdtdCn;
	}
	/**
	 * @param SDTD_CN 
	 */
	public void setSdtdCn(String sdtdCn){
		this.sdtdCn = sdtdCn;
	}
	/**
	 * @return SECURITYGRADE_CN 
	 */
	public String getSecuritygradeCn(){
		return this.securitygradeCn;
	}
	/**
	 * @param SECURITYGRADE_CN 
	 */
	public void setSecuritygradeCn(String securitygradeCn){
		this.securitygradeCn = securitygradeCn;
	}
	/**
	 * @return SFSW_CN 
	 */
	public String getSfswCn(){
		return this.sfswCn;
	}
	/**
	 * @param SFSW_CN 
	 */
	public void setSfswCn(String sfswCn){
		this.sfswCn = sfswCn;
	}
	/**
	 * @return SJGJDQ_CN 
	 */
	public String getSjgjdqCn(){
		return this.sjgjdqCn;
	}
	/**
	 * @param SJGJDQ_CN 
	 */
	public void setSjgjdqCn(String sjgjdqCn){
		this.sjgjdqCn = sjgjdqCn;
	}
	/**
	 * @return SLFACS_CN 
	 */
	public String getSlfacsCn(){
		return this.slfacsCn;
	}
	/**
	 * @param SLFACS_CN 
	 */
	public void setSlfacsCn(String slfacsCn){
		this.slfacsCn = slfacsCn;
	}
	/**
	 * @return SLJSDW_CN 
	 */
	public String getSljsdwCn(){
		return this.sljsdwCn;
	}
	/**
	 * @param SLJSDW_CN 
	 */
	public void setSljsdwCn(String sljsdwCn){
		this.sljsdwCn = sljsdwCn;
	}
	/**
	 * @return SL_JJFS_CN 
	 */
	public String getSlJjfsCn(){
		return this.slJjfsCn;
	}
	/**
	 * @param SL_JJFS_CN 
	 */
	public void setSlJjfsCn(String slJjfsCn){
		this.slJjfsCn = slJjfsCn;
	}
	/**
	 * @return SL_SLRXM_CN 
	 */
	public String getSlSlrxmCn(){
		return this.slSlrxmCn;
	}
	/**
	 * @param SL_SLRXM_CN 
	 */
	public void setSlSlrxmCn(String slSlrxmCn){
		this.slSlrxmCn = slSlrxmCn;
	}
	/**
	 * @return SSSQ_CN 
	 */
	public String getSssqCn(){
		return this.sssqCn;
	}
	/**
	 * @param SSSQ_CN 
	 */
	public void setSssqCn(String sssqCn){
		this.sssqCn = sssqCn;
	}
	/**
	 * @return XZBW_CN 
	 */
	public String getXzbwCn(){
		return this.xzbwCn;
	}
	/**
	 * @param XZBW_CN 
	 */
	public void setXzbwCn(String xzbwCn){
		this.xzbwCn = xzbwCn;
	}
	/**
	 * @return XZCS_CN 
	 */
	public String getXzcsCn(){
		return this.xzcsCn;
	}
	/**
	 * @param XZCS_CN 
	 */
	public void setXzcsCn(String xzcsCn){
		this.xzcsCn = xzcsCn;
	}
	/**
	 * @return XZDX_CN 
	 */
	public String getXzdxCn(){
		return this.xzdxCn;
	}
	/**
	 * @param XZDX_CN 
	 */
	public void setXzdxCn(String xzdxCn){
		this.xzdxCn = xzdxCn;
	}
	/**
	 * @return XZSJ_CN 
	 */
	public String getXzsjCn(){
		return this.xzsjCn;
	}
	/**
	 * @param XZSJ_CN 
	 */
	public void setXzsjCn(String xzsjCn){
		this.xzsjCn = xzsjCn;
	}
	/**
	 * @return ZABZ_CN 
	 */
	public String getZabzCn(){
		return this.zabzCn;
	}
	/**
	 * @param ZABZ_CN 
	 */
	public void setZabzCn(String zabzCn){
		this.zabzCn = zabzCn;
	}
	/**
	 * @return ZAGJ_CN 
	 */
	public String getZagjCn(){
		return this.zagjCn;
	}
	/**
	 * @param ZAGJ_CN 
	 */
	public void setZagjCn(String zagjCn){
		this.zagjCn = zagjCn;
	}
	/**
	 * @return ZAZT_CN 
	 */
	public String getZaztCn(){
		return this.zaztCn;
	}
	/**
	 * @param ZAZT_CN 
	 */
	public void setZaztCn(String zaztCn){
		this.zaztCn = zaztCn;
	}
	/**
	 * @return ZBDW_CN 
	 */
	public String getZbdwCn(){
		return this.zbdwCn;
	}
	/**
	 * @param ZBDW_CN 
	 */
	public void setZbdwCn(String zbdwCn){
		this.zbdwCn = zbdwCn;
	}
	/**
	 * @return RKGXSJ 
	 */
	public Date getRkgxsj(){
		return this.rkgxsj;
	}
	/**
	 * @param RKGXSJ 
	 */
	public void setRkgxsj(Date rkgxsj){
		this.rkgxsj = rkgxsj;
	}
	/**
	 * @return XLAB 细类按别
	 */
	public String getXlab(){
		return this.xlab;
	}
	/**
	 * @param XLAB 细类按别
	 */
	public void setXlab(String xlab){
		this.xlab = xlab;
	}
	/**
	 * @return XLMC 细类名称
	 */
	public String getXlmc(){
		return this.xlmc;
	}
	/**
	 * @param XLMC 细类名称
	 */
	public void setXlmc(String xlmc){
		this.xlmc = xlmc;
	}
	/**
	 * @return YXLMC 原细类名称
	 */
	public String getYxlmc(){
		return this.yxlmc;
	}
	/**
	 * @param YXLMC 原细类名称
	 */
	public void setYxlmc(String yxlmc){
		this.yxlmc = yxlmc;
	}
	/**
	 * @return FASJ 发案时间
	 */
	public Date getFasj(){
		return this.fasj;
	}
	/**
	 * @param FASJ 发案时间
	 */
	public void setFasj(Date fasj){
		this.fasj = fasj;
	}
	/**
	 * @return SFBZ 是否标注
	 */
	public String getSfbz(){
		return this.sfbz;
	}
	/**
	 * @param SFBZ 是否标注
	 */
	public void setSfbz(String sfbz){
		this.sfbz = sfbz;
	}
	/**
	 * @return ZYK_RKSJ 
	 */
	public Date getZykRksj(){
		return this.zykRksj;
	}
	/**
	 * @param ZYK_RKSJ 
	 */
	public void setZykRksj(Date zykRksj){
		this.zykRksj = zykRksj;
	}
	/**
	 * @return ZYK_GXSJ 
	 */
	public Date getZykGxsj(){
		return this.zykGxsj;
	}
	/**
	 * @param ZYK_GXSJ 
	 */
	public void setZykGxsj(Date zykGxsj){
		this.zykGxsj = zykGxsj;
	}
	/**
	 * @return ZYK_SYSTEMID 
	 */
	public String getZykSystemid(){
		return this.zykSystemid;
	}
	/**
	 * @param ZYK_SYSTEMID 
	 */
	public void setZykSystemid(String zykSystemid){
		this.zykSystemid = zykSystemid;
	}
	/**
	 * @return CLBZ 处理标志
	 */
	public String getClbz(){
		return this.clbz;
	}
	/**
	 * @param CLBZ 处理标志
	 */
	public void setClbz(String clbz){
		this.clbz = clbz;
	}
	/**
	 * @return SFHL 是否忽略，默认为0，0为未忽略，1为忽略
	 */
	public String getSfhl(){
		return this.sfhl;
	}
	/**
	 * @param SFHL 是否忽略，默认为0，0为未忽略，1为忽略
	 */
	public void setSfhl(String sfhl){
		this.sfhl = sfhl;
	}
	/**
	 * @return AJBZRESERVER1 涉及类别
	 */
	public String getAjbzreserver1(){
		return this.ajbzreserver1;
	}
	/**
	 * @param AJBZRESERVER1 涉及类别
	 */
	public void setAjbzreserver1(String ajbzreserver1){
		this.ajbzreserver1 = ajbzreserver1;
	}
	/**
	 * @return AJBZRESERVER2 警情大类
	 */
	public String getAjbzreserver2(){
		return this.ajbzreserver2;
	}
	/**
	 * @param AJBZRESERVER2 警情大类
	 */
	public void setAjbzreserver2(String ajbzreserver2){
		this.ajbzreserver2 = ajbzreserver2;
	}
	/**
	 * @return AJBZRESERVER3 警情一级细类
	 */
	public String getAjbzreserver3(){
		return this.ajbzreserver3;
	}
	/**
	 * @param AJBZRESERVER3 警情一级细类
	 */
	public void setAjbzreserver3(String ajbzreserver3){
		this.ajbzreserver3 = ajbzreserver3;
	}
	/**
	 * @return AJBZRESERVER4 警情二级细类
	 */
	public String getAjbzreserver4(){
		return this.ajbzreserver4;
	}
	/**
	 * @param AJBZRESERVER4 警情二级细类
	 */
	public void setAjbzreserver4(String ajbzreserver4){
		this.ajbzreserver4 = ajbzreserver4;
	}
	/**
	 * @return AJBZRESERVER5 警情三级细类
	 */
	public String getAjbzreserver5(){
		return this.ajbzreserver5;
	}
	/**
	 * @param AJBZRESERVER5 警情三级细类
	 */
	public void setAjbzreserver5(String ajbzreserver5){
		this.ajbzreserver5 = ajbzreserver5;
	}
	/**
	 * @return AJBZRESERVER6 警情标注是新增还是修改，Y为修改,其他为新增
	 */
	public String getAjbzreserver6(){
		return this.ajbzreserver6;
	}
	/**
	 * @param AJBZRESERVER6 警情标注是新增还是修改，Y为修改,其他为新增
	 */
	public void setAjbzreserver6(String ajbzreserver6){
		this.ajbzreserver6 = ajbzreserver6;
	}
	/**
	 * @return AJBZRESERVER7 涉及对象
	 */
	public String getAjbzreserver7(){
		return this.ajbzreserver7;
	}
	/**
	 * @param AJBZRESERVER7 涉及对象
	 */
	public void setAjbzreserver7(String ajbzreserver7){
		this.ajbzreserver7 = ajbzreserver7;
	}
	/**
	 * @return AJBZRESERVER8 作案工具
	 */
	public String getAjbzreserver8(){
		return this.ajbzreserver8;
	}
	/**
	 * @param AJBZRESERVER8 作案工具
	 */
	public void setAjbzreserver8(String ajbzreserver8){
		this.ajbzreserver8 = ajbzreserver8;
	}
	/**
	 * @return AJBZRESERVER9 发案地点
	 */
	public String getAjbzreserver9(){
		return this.ajbzreserver9;
	}
	/**
	 * @param AJBZRESERVER9 发案地点
	 */
	public void setAjbzreserver9(String ajbzreserver9){
		this.ajbzreserver9 = ajbzreserver9;
	}
	/**
	 * @return AJBZRESERVER10 盗窃专项
	 */
	public String getAjbzreserver10(){
		return this.ajbzreserver10;
	}
	/**
	 * @param AJBZRESERVER10 盗窃专项
	 */
	public void setAjbzreserver10(String ajbzreserver10){
		this.ajbzreserver10 = ajbzreserver10;
	}
	/**
	 * @return AJBZRESERVER11 保留未用
	 */
	public String getAjbzreserver11(){
		return this.ajbzreserver11;
	}
	/**
	 * @param AJBZRESERVER11 保留未用
	 */
	public void setAjbzreserver11(String ajbzreserver11){
		this.ajbzreserver11 = ajbzreserver11;
	}
	/**
	 * @return AJBZRESERVER12 保留未用
	 */
	public String getAjbzreserver12(){
		return this.ajbzreserver12;
	}
	/**
	 * @param AJBZRESERVER12 保留未用
	 */
	public void setAjbzreserver12(String ajbzreserver12){
		this.ajbzreserver12 = ajbzreserver12;
	}
	/**
	 * @return AJBZRESERVER13 保留未用
	 */
	public String getAjbzreserver13(){
		return this.ajbzreserver13;
	}
	/**
	 * @param AJBZRESERVER13 保留未用
	 */
	public void setAjbzreserver13(String ajbzreserver13){
		this.ajbzreserver13 = ajbzreserver13;
	}
	/**
	 * @return AJBZRESERVER14 保留未用
	 */
	public String getAjbzreserver14(){
		return this.ajbzreserver14;
	}
	/**
	 * @param AJBZRESERVER14 保留未用
	 */
	public void setAjbzreserver14(String ajbzreserver14){
		this.ajbzreserver14 = ajbzreserver14;
	}
	/**
	 * @return AJBZRESERVER15 保留未用
	 */
	public String getAjbzreserver15(){
		return this.ajbzreserver15;
	}
	/**
	 * @param AJBZRESERVER15 保留未用
	 */
	public void setAjbzreserver15(String ajbzreserver15){
		this.ajbzreserver15 = ajbzreserver15;
	}
	/**
	 * @return TRANSFER_TIME 传输时间
	 */
	public Date getTransferTime(){
		return this.transferTime;
	}
	/**
	 * @param TRANSFER_TIME 传输时间
	 */
	public void setTransferTime(Date transferTime){
		this.transferTime = transferTime;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public static String getTbName() {
		return "b_asj_aj";
	}

	public String getPgroupId() {
		return pgroupId;
	}

	public void setPgroupId(String pgroupId) {
		this.pgroupId = pgroupId;
	}

	public Date getSlStartTime() {
		return slStartTime;
	}

	public void setSlStartTime(Date slStartTime) {
		this.slStartTime = slStartTime;
	}

	public Date getSlEndTime() {
		return slEndTime;
	}

	public void setSlEndTime(Date slEndTime) {
		this.slEndTime = slEndTime;
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("AsjAj [")
		.append("id=").append(this.getId())
		.append(",ajbh=").append(this.getAjbh())
		.append(",sljsdw=").append(this.getSljsdw())
		.append(",ajstate=").append(this.getAjstate())
		.append(",zazt=").append(this.getZazt())
		.append(",slBjslh=").append(this.getSlBjslh())
		.append(",slJjfs=").append(this.getSlJjfs())
		.append(",ajlx=").append(this.getAjlx())
		.append(",ab=").append(this.getAb())
		.append(",zabz=").append(this.getZabz())
		.append(",ajmc=").append(this.getAjmc())
		.append(",ajwh=").append(this.getAjwh())
		.append(",sljjsj=").append(this.getSljjsj())
		.append(",slfxrq=").append(this.getSlfxrq())
		.append(",fasjcz=").append(this.getFasjcz())
		.append(",fasjzz=").append(this.getFasjzz())
		.append(",faddQx=").append(this.getFaddQx())
		.append(",faddJd=").append(this.getFaddJd())
		.append(",ajssjq=").append(this.getAjssjq())
		.append(",fadd=").append(this.getFadd())
		.append(",sssq=").append(this.getSssq())
		.append(",fady=").append(this.getFady())
		.append(",slfacs=").append(this.getSlfacs())
		.append(",fxxs=").append(this.getFxxs())
		.append(",ajwhcd=").append(this.getAjwhcd())
		.append(",blyy=").append(this.getBlyy())
		.append(",zyaq=").append(this.getZyaq())
		.append(",xzsj=").append(this.getXzsj())
		.append(",xzcs=").append(this.getXzcs())
		.append(",xzdx=").append(this.getXzdx())
		.append(",xzwp=").append(this.getXzwp())
		.append(",zagj=").append(this.getZagj())
		.append(",xzbw=").append(this.getXzbw())
		.append(",zars=").append(this.getZars())
		.append(",sdtd=").append(this.getSdtd())
		.append(",swrs=").append(this.getSwrs())
		.append(",ssrs=").append(this.getSsrs())
		.append(",ssjz=").append(this.getSsjz())
		.append(",sazz=").append(this.getSazz())
		.append(",lasj=").append(this.getLasj())
		.append(",pasj=").append(this.getPasj())
		.append(",jaJasj=").append(this.getJaJasj())
		.append(",xaXasj=").append(this.getXaXasj())
		.append(",yssj=").append(this.getYssj())
		.append(",sljjdw=").append(this.getSljjdw())
		.append(",slLrr=").append(this.getSlLrr())
		.append(",slLrsj=").append(this.getSlLrsj())
		.append(",sljjry=").append(this.getSljjry())
		.append(",slSlrxm=").append(this.getSlSlrxm())
		.append(",slSlsj=").append(this.getSlSlsj())
		.append(",slfaqh=").append(this.getSlfaqh())
		.append(",ladw=").append(this.getLadw())
		.append(",ajlary=").append(this.getAjlary())
		.append(",zbdw=").append(this.getZbdw())
		.append(",ajzbry=").append(this.getAjzbry())
		.append(",ajxbry=").append(this.getAjxbry())
		.append(",ajbarp=").append(this.getAjbarp())
		.append(",laLrr=").append(this.getLaLrr())
		.append(",laLrsj=").append(this.getLaLrsj())
		.append(",laPzr=").append(this.getLaPzr())
		.append(",laPzsj=").append(this.getLaPzsj())
		.append(",laZhxgr=").append(this.getLaZhxgr())
		.append(",laZhxgsj=").append(this.getLaZhxgsj())
		.append(",laPsstate=").append(this.getLaPsstate())
		.append(",dbxx=").append(this.getDbxx())
		.append(",ajly=").append(this.getAjly())
		.append(",bz=").append(this.getBz())
		.append(",yssasj=").append(this.getYssasj())
		.append(",ystcsj=").append(this.getYstcsj())
		.append(",whssjz=").append(this.getWhssjz())
		.append(",dbjb=").append(this.getDbjb())
		.append(",jtajly=").append(this.getJtajly())
		.append(",fzztlx=").append(this.getFzztlx())
		.append(",sfsw=").append(this.getSfsw())
		.append(",sjgjdq=").append(this.getSjgjdq())
		.append(",yishensj=").append(this.getYishensj())
		.append(",essj=").append(this.getEssj())
		.append(",ysdw=").append(this.getYsdw())
		.append(",yscbr=").append(this.getYscbr())
		.append(",ysdwdh=").append(this.getYsdwdh())
		.append(",ysdwNew=").append(this.getYsdwNew())
		.append(",ysdwdhNew=").append(this.getYsdwdhNew())
		.append(",yscbrNew=").append(this.getYscbrNew())
		.append(",yssjNew=").append(this.getYssjNew())
		.append(",departmentcode=").append(this.getDepartmentcode())
		.append(",creator=").append(this.getCreator())
		.append(",createdtime=").append(this.getCreatedtime())
		.append(",securitygrade=").append(this.getSecuritygrade())
		.append(",lastupdatedby=").append(this.getLastupdatedby())
		.append(",lastupdatedtime=").append(this.getLastupdatedtime())
		.append(",refreshtime=").append(this.getRefreshtime())
		.append(",uploadflag=").append(this.getUploadflag())
		.append(",downloadflag=").append(this.getDownloadflag())
		.append(",deleteflag=").append(this.getDeleteflag())
		.append(",reservation01=").append(this.getReservation01())
		.append(",reservation02=").append(this.getReservation02())
		.append(",reservation03=").append(this.getReservation03())
		.append(",reservation04=").append(this.getReservation04())
		.append(",reservation05=").append(this.getReservation05())
		.append(",reservation06=").append(this.getReservation06())
		.append(",reservation07=").append(this.getReservation07())
		.append(",reservation08=").append(this.getReservation08())
		.append(",reservation09=").append(this.getReservation09())
		.append(",reservation10=").append(this.getReservation10())
		.append(",reservation11=").append(this.getReservation11())
		.append(",reservation12=").append(this.getReservation12())
		.append(",reservation13=").append(this.getReservation13())
		.append(",reservation14=").append(this.getReservation14())
		.append(",reservation15=").append(this.getReservation15())
		.append(",reservation16=").append(this.getReservation16())
		.append(",reservation17=").append(this.getReservation17())
		.append(",reservation18=").append(this.getReservation18())
		.append(",reservation19=").append(this.getReservation19())
		.append(",reservation20=").append(this.getReservation20())
		.append(",reservation21=").append(this.getReservation21())
		.append(",reservation22=").append(this.getReservation22())
		.append(",reservation23=").append(this.getReservation23())
		.append(",reservation24=").append(this.getReservation24())
		.append(",reservation25=").append(this.getReservation25())
		.append(",reservation26=").append(this.getReservation26())
		.append(",reservation27=").append(this.getReservation27())
		.append(",reservation28=").append(this.getReservation28())
		.append(",reservation29=").append(this.getReservation29())
		.append(",reservation30=").append(this.getReservation30())
		.append(",reservation31=").append(this.getReservation31())
		.append(",reservation32=").append(this.getReservation32())
		.append(",reservation33=").append(this.getReservation33())
		.append(",reservation34=").append(this.getReservation34())
		.append(",reservation35=").append(this.getReservation35())
		.append(",reservation36=").append(this.getReservation36())
		.append(",reservation37=").append(this.getReservation37())
		.append(",reservation38=").append(this.getReservation38())
		.append(",reservation39=").append(this.getReservation39())
		.append(",reservation40=").append(this.getReservation40())
		.append(",reservation41=").append(this.getReservation41())
		.append(",reservation42=").append(this.getReservation42())
		.append(",reservation43=").append(this.getReservation43())
		.append(",reservation44=").append(this.getReservation44())
		.append(",reservation45=").append(this.getReservation45())
		.append(",reservation46=").append(this.getReservation46())
		.append(",reservation47=").append(this.getReservation47())
		.append(",reservation48=").append(this.getReservation48())
		.append(",reservation49=").append(this.getReservation49())
		.append(",reservation50=").append(this.getReservation50())
		.append(",reservation51=").append(this.getReservation51())
		.append(",reservation52=").append(this.getReservation52())
		.append(",reservation53=").append(this.getReservation53())
		.append(",ajzbryName=").append(this.getAjzbryName())
		.append(",ajxbryName=").append(this.getAjxbryName())
		.append(",slLrrName=").append(this.getSlLrrName())
		.append(",slSlrxmName=").append(this.getSlSlrxmName())
		.append(",ajlaryName=").append(this.getAjlaryName())
		.append(",laLrrName=").append(this.getLaLrrName())
		.append(",departmentcodeName=").append(this.getDepartmentcodeName())
		.append(",zbdwName=").append(this.getZbdwName())
		.append(",ladwName=").append(this.getLadwName())
		.append(",sljjdwName=").append(this.getSljjdwName())
		.append(",sljsdwName=").append(this.getSljsdwName())
		.append(",reserver38=").append(this.getReserver38())
		.append(",reserver39=").append(this.getReserver39())
		.append(",reserver40=").append(this.getReserver40())
		.append(",reserver41=").append(this.getReserver41())
		.append(",reserver42=").append(this.getReserver42())
		.append(",reserver43=").append(this.getReserver43())
		.append(",reserver44=").append(this.getReserver44())
		.append(",reserver45=").append(this.getReserver45())
		.append(",reserver46=").append(this.getReserver46())
		.append(",reserver47=").append(this.getReserver47())
		.append(",reserver48=").append(this.getReserver48())
		.append(",reserver49=").append(this.getReserver49())
		.append(",reserver50=").append(this.getReserver50())
		.append(",reserver51=").append(this.getReserver51())
		.append(",reserver52=").append(this.getReserver52())
		.append(",reserver53=").append(this.getReserver53())
		.append(",reserver54=").append(this.getReserver54())
		.append(",reserver55=").append(this.getReserver55())
		.append(",reserver56=").append(this.getReserver56())
		.append(",reserver57=").append(this.getReserver57())
		.append(",reserver58=").append(this.getReserver58())
		.append(",reserver59=").append(this.getReserver59())
		.append(",reserver60=").append(this.getReserver60())
		.append(",reserver61=").append(this.getReserver61())
		.append(",reserver62=").append(this.getReserver62())
		.append(",reserver63=").append(this.getReserver63())
		.append(",reserver64=").append(this.getReserver64())
		.append(",reserver65=").append(this.getReserver65())
		.append(",reserver66=").append(this.getReserver66())
		.append(",reserver67=").append(this.getReserver67())
		.append(",reserver68=").append(this.getReserver68())
		.append(",reserver69=").append(this.getReserver69())
		.append(",reserver70=").append(this.getReserver70())
		.append(",reserver71=").append(this.getReserver71())
		.append(",reserver72=").append(this.getReserver72())
		.append(",reserver73=").append(this.getReserver73())
		.append(",reserver74=").append(this.getReserver74())
		.append(",reserver75=").append(this.getReserver75())
		.append(",reserver76=").append(this.getReserver76())
		.append(",reserver77=").append(this.getReserver77())
		.append(",reserver78=").append(this.getReserver78())
		.append(",reserver79=").append(this.getReserver79())
		.append(",reserver80=").append(this.getReserver80())
		.append(",reserver81=").append(this.getReserver81())
		.append(",reserver82=").append(this.getReserver82())
		.append(",reserver83=").append(this.getReserver83())
		.append(",reserver84=").append(this.getReserver84())
		.append(",reserver85=").append(this.getReserver85())
		.append(",reserver86=").append(this.getReserver86())
		.append(",reserver87=").append(this.getReserver87())
		.append(",reserver88=").append(this.getReserver88())
		.append(",reserver89=").append(this.getReserver89())
		.append(",reserver90=").append(this.getReserver90())
		.append(",reserver91=").append(this.getReserver91())
		.append(",reserver92=").append(this.getReserver92())
		.append(",reserver93=").append(this.getReserver93())
		.append(",reserver94=").append(this.getReserver94())
		.append(",reserver95=").append(this.getReserver95())
		.append(",reserver96=").append(this.getReserver96())
		.append(",reserver97=").append(this.getReserver97())
		.append(",reserver98=").append(this.getReserver98())
		.append(",reserver99=").append(this.getReserver99())
		.append(",reserver100=").append(this.getReserver100())
		.append(",reserver1=").append(this.getReserver1())
		.append(",reserver2=").append(this.getReserver2())
		.append(",reserver3=").append(this.getReserver3())
		.append(",reserver4=").append(this.getReserver4())
		.append(",reserver5=").append(this.getReserver5())
		.append(",reserver6=").append(this.getReserver6())
		.append(",reserver7=").append(this.getReserver7())
		.append(",reserver8=").append(this.getReserver8())
		.append(",reserver9=").append(this.getReserver9())
		.append(",reserver10=").append(this.getReserver10())
		.append(",reserver11=").append(this.getReserver11())
		.append(",reserver12=").append(this.getReserver12())
		.append(",reserver13=").append(this.getReserver13())
		.append(",reserver14=").append(this.getReserver14())
		.append(",reserver15=").append(this.getReserver15())
		.append(",reserver16=").append(this.getReserver16())
		.append(",reserver17=").append(this.getReserver17())
		.append(",reserver18=").append(this.getReserver18())
		.append(",reserver19=").append(this.getReserver19())
		.append(",reserver20=").append(this.getReserver20())
		.append(",reserver21=").append(this.getReserver21())
		.append(",reserver22=").append(this.getReserver22())
		.append(",reserver23=").append(this.getReserver23())
		.append(",reserver24=").append(this.getReserver24())
		.append(",reserver25=").append(this.getReserver25())
		.append(",reserver26=").append(this.getReserver26())
		.append(",reserver27=").append(this.getReserver27())
		.append(",reserver28=").append(this.getReserver28())
		.append(",reserver29=").append(this.getReserver29())
		.append(",reserver30=").append(this.getReserver30())
		.append(",reserver31=").append(this.getReserver31())
		.append(",reserver32=").append(this.getReserver32())
		.append(",reserver33=").append(this.getReserver33())
		.append(",reserver34=").append(this.getReserver34())
		.append(",reserver35=").append(this.getReserver35())
		.append(",reserver36=").append(this.getReserver36())
		.append(",reserver37=").append(this.getReserver37())
		.append(",yykRksj=").append(this.getYykRksj())
		.append(",abCn=").append(this.getAbCn())
		.append(",ajssjqCn=").append(this.getAjssjqCn())
		.append(",ajstateCn=").append(this.getAjstateCn())
		.append(",ajwhcdCn=").append(this.getAjwhcdCn())
		.append(",blyyCn=").append(this.getBlyyCn())
		.append(",creatorCn=").append(this.getCreatorCn())
		.append(",datacheck=").append(this.getDatacheck())
		.append(",datastate=").append(this.getDatastate())
		.append(",dbjbCn=").append(this.getDbjbCn())
		.append(",departmentcodeCn=").append(this.getDepartmentcodeCn())
		.append(",faddJdCn=").append(this.getFaddJdCn())
		.append(",faddQxCn=").append(this.getFaddQxCn())
		.append(",fadyCn=").append(this.getFadyCn())
		.append(",fxxsCn=").append(this.getFxxsCn())
		.append(",fzztlxCn=").append(this.getFzztlxCn())
		.append(",jzbh=").append(this.getJzbh())
		.append(",lastupdatedbyCn=").append(this.getLastupdatedbyCn())
		.append(",queryid=").append(this.getQueryid())
		.append(",reservation03Cn=").append(this.getReservation03Cn())
		.append(",reservation36Cn=").append(this.getReservation36Cn())
		.append(",sdtdCn=").append(this.getSdtdCn())
		.append(",securitygradeCn=").append(this.getSecuritygradeCn())
		.append(",sfswCn=").append(this.getSfswCn())
		.append(",sjgjdqCn=").append(this.getSjgjdqCn())
		.append(",slfacsCn=").append(this.getSlfacsCn())
		.append(",sljsdwCn=").append(this.getSljsdwCn())
		.append(",slJjfsCn=").append(this.getSlJjfsCn())
		.append(",slSlrxmCn=").append(this.getSlSlrxmCn())
		.append(",sssqCn=").append(this.getSssqCn())
		.append(",xzbwCn=").append(this.getXzbwCn())
		.append(",xzcsCn=").append(this.getXzcsCn())
		.append(",xzdxCn=").append(this.getXzdxCn())
		.append(",xzsjCn=").append(this.getXzsjCn())
		.append(",zabzCn=").append(this.getZabzCn())
		.append(",zagjCn=").append(this.getZagjCn())
		.append(",zaztCn=").append(this.getZaztCn())
		.append(",zbdwCn=").append(this.getZbdwCn())
		.append(",rkgxsj=").append(this.getRkgxsj())
		.append(",xlab=").append(this.getXlab())
		.append(",xlmc=").append(this.getXlmc())
		.append(",yxlmc=").append(this.getYxlmc())
		.append(",fasj=").append(this.getFasj())
		.append(",sfbz=").append(this.getSfbz())
		.append(",zykRksj=").append(this.getZykRksj())
		.append(",zykGxsj=").append(this.getZykGxsj())
		.append(",zykSystemid=").append(this.getZykSystemid())
		.append(",clbz=").append(this.getClbz())
		.append(",sfhl=").append(this.getSfhl())
		.append(",ajbzreserver1=").append(this.getAjbzreserver1())
		.append(",ajbzreserver2=").append(this.getAjbzreserver2())
		.append(",ajbzreserver3=").append(this.getAjbzreserver3())
		.append(",ajbzreserver4=").append(this.getAjbzreserver4())
		.append(",ajbzreserver5=").append(this.getAjbzreserver5())
		.append(",ajbzreserver6=").append(this.getAjbzreserver6())
		.append(",ajbzreserver7=").append(this.getAjbzreserver7())
		.append(",ajbzreserver8=").append(this.getAjbzreserver8())
		.append(",ajbzreserver9=").append(this.getAjbzreserver9())
		.append(",ajbzreserver10=").append(this.getAjbzreserver10())
		.append(",ajbzreserver11=").append(this.getAjbzreserver11())
		.append(",ajbzreserver12=").append(this.getAjbzreserver12())
		.append(",ajbzreserver13=").append(this.getAjbzreserver13())
		.append(",ajbzreserver14=").append(this.getAjbzreserver14())
		.append(",ajbzreserver15=").append(this.getAjbzreserver15())
		.append(",transferTime=").append(this.getTransferTime())
		.append("]");
		return builder.toString();
	}
	
	public static enum AsjAjEnum{
		id("ID","ID"),
		ajbh("AJBH","案件编号"),
		sljsdw("SLJSDW","受理单位/接收单位-字典项＝06"),
		ajstate("AJSTATE","案件状态-字典项＝56"),
		zazt("ZAZT","作案状态-字典项＝131"),
		slBjslh("SL_BJSLH","接警受理号"),
		slJjfs("SL_JJFS","接警方式-字典项＝81"),
		ajlx("AJLX","案件类型-字典项＝44"),
		ab("AB","案别/案由-字典项＝24"),
		zabz("ZABZ","专案标识-字典项＝48"),
		ajmc("AJMC","案件名称"),
		ajwh("AJWH","案件号"),
		sljjsj("SLJJSJ","报警时间"),
		slfxrq("SLFXRQ","发现时间"),
		fasjcz("FASJCZ","发案时间初值"),
		fasjzz("FASJZZ","发案时间终值"),
		faddQx("FADD_QX","发案地点_区县-字典项＝07"),
		faddJd("FADD_JD","发案地点_街道-字典项＝107"),
		ajssjq("AJSSJQ","所属警区-字典项＝108"),
		fadd("FADD","发案地点详址"),
		sssq("SSSQ","所属社区-字典项＝109"),
		fady("FADY","发案地域-字典项＝45"),
		slfacs("SLFACS","发案处所-字典项＝135"),
		fxxs("FXXS","发现形式-字典项＝46"),
		ajwhcd("AJWHCD","危害程度-字典项＝43"),
		blyy("BLYY","补立原因-字典项＝55"),
		zyaq("ZYAQ","简要案情"),
		xzsj("XZSJ","作案时机-字典项＝29"),
		xzcs("XZCS","选择处所-字典项＝30"),
		xzdx("XZDX","选择对象-字典项＝31"),
		xzwp("XZWP","选择物品-字典项＝33"),
		zagj("ZAGJ","作案工具-字典项＝33"),
		xzbw("XZBW","选择部位-字典项＝30"),
		zars("ZARS","作案人数"),
		sdtd("SDTD","作案手段特点-字典项＝36"),
		swrs("SWRS","死亡人数"),
		ssrs("SSRS","受伤人数"),
		ssjz("SSJZ","损失折款"),
		sazz("SAZZ","涉案总值"),
		lasj("LASJ","立案日期"),
		pasj("PASJ","破案时间"),
		jaJasj("JA_JASJ","结案时间"),
		xaXasj("XA_XASJ","销案时间"),
		yssj("YSSJ","移送时间"),
		sljjdw("SLJJDW","接警单位-字典项＝06"),
		slLrr("SL_LRR","受理人"),
		slLrsj("SL_LRSJ","受理时间"),
		sljjry("SLJJRY","备用"),
		slSlrxm("SL_SLRXM","填表人"),
		slSlsj("SL_SLSJ","填表时间"),
		slfaqh("SLFAQH","发案地政区划"),
		ladw("LADW","立案单位-字典项＝06"),
		ajlary("AJLARY","立案人"),
		zbdw("ZBDW","主办单位"),
		ajzbry("AJZBRY","主要办案人"),
		ajxbry("AJXBRY","案件协办人"),
		ajbarp("AJBARP","办案人联系电话"),
		laLrr("LA_LRR","立案录入人"),
		laLrsj("LA_LRSJ","立案录入时间"),
		laPzr("LA_PZR","立案批准人"),
		laPzsj("LA_PZSJ","立案批时间"),
		laZhxgr("LA_ZHXGR","案后修改人"),
		laZhxgsj("LA_ZHXGSJ","案最后修改时间"),
		laPsstate("LA_PSSTATE","批示状态"),
		dbxx("DBXX","督办信息"),
		ajly("AJLY","案件来源"),
		bz("BZ","备注"),
		yssasj("YSSASJ",""),
		ystcsj("YSTCSJ",""),
		whssjz("WHSSJZ","挽回损失价值"),
		dbjb("DBJB","督办级别"),
		jtajly("JTAJLY","具体案件来源"),
		fzztlx("FZZTLX","犯罪主体类型-字典项=JZ_03"),
		sfsw("SFSW","案情是否涉外"),
		sjgjdq("SJGJDQ","案情涉及国家地区"),
		yishensj("YISHENSJ","一审时间"),
		essj("ESSJ","二审时间"),
		ysdw("YSDW","移送单位"),
		yscbr("YSCBR","移送承办人"),
		ysdwdh("YSDWDH","移送单位电话"),
		ysdwNew("YSDW_NEW","移送单位（经侦并入派综后使用，原有不知何用，未使用）"),
		ysdwdhNew("YSDWDH_NEW","移送单位电话（经侦并入派综后使用，原有不知何用，未使用）"),
		yscbrNew("YSCBR_NEW","移送承办人（经侦并入派综后使用，原有不知何用，未使用）"),
		yssjNew("YSSJ_NEW","移送时间（经侦并入派综后使用，原有不知何用，未使用）"),
		departmentcode("DEPARTMENTCODE","部门编号-字典项＝06"),
		creator("CREATOR","创建者"),
		createdtime("CREATEDTIME","创建时间"),
		securitygrade("SECURITYGRADE","密级"),
		lastupdatedby("LASTUPDATEDBY","最终修改人"),
		lastupdatedtime("LASTUPDATEDTIME","最后修改时间"),
		refreshtime("REFRESHTIME","更新时间"),
		uploadflag("UPLOADFLAG","上传标志"),
		downloadflag("DOWNLOADFLAG","下传标志"),
		deleteflag("DELETEFLAG","删除标志"),
		reservation01("RESERVATION01","主办侦查员中文姓名"),
		reservation02("RESERVATION02","协办侦查员中文姓名"),
		reservation03("RESERVATION03","保留字段3"),
		reservation04("RESERVATION04","省"),
		reservation05("RESERVATION05","保留字段5"),
		reservation06("RESERVATION06","保字段6"),
		reservation07("RESERVATION07","保留字段7"),
		reservation08("RESERVATION08","保留字段8"),
		reservation09("RESERVATION09","保留字段9"),
		reservation10("RESERVATION10","保留字段10"),
		reservation11("RESERVATION11","主案编号"),
		reservation12("RESERVATION12",""),
		reservation13("RESERVATION13",""),
		reservation14("RESERVATION14",""),
		reservation15("RESERVATION15",""),
		reservation16("RESERVATION16",""),
		reservation17("RESERVATION17",""),
		reservation18("RESERVATION18",""),
		reservation19("RESERVATION19",""),
		reservation20("RESERVATION20",""),
		reservation21("RESERVATION21",""),
		reservation22("RESERVATION22",""),
		reservation23("RESERVATION23",""),
		reservation24("RESERVATION24",""),
		reservation25("RESERVATION25",""),
		reservation26("RESERVATION26",""),
		reservation27("RESERVATION27",""),
		reservation28("RESERVATION28",""),
		reservation29("RESERVATION29",""),
		reservation30("RESERVATION30",""),
		reservation31("RESERVATION31",""),
		reservation32("RESERVATION32",""),
		reservation33("RESERVATION33",""),
		reservation34("RESERVATION34","标识是否重新立案，0或null否，1是"),
		reservation35("RESERVATION35","为了避免与派综案件编号重复，经侦案件的案件编号要重新存储"),
		reservation36("RESERVATION36","初查审核结果 字典项：JZ_06"),
		reservation37("RESERVATION37",""),
		reservation38("RESERVATION38",""),
		reservation39("RESERVATION39",""),
		reservation40("RESERVATION40",""),
		reservation41("RESERVATION41",""),
		reservation42("RESERVATION42",""),
		reservation43("RESERVATION43",""),
		reservation44("RESERVATION44",""),
		reservation45("RESERVATION45",""),
		reservation46("RESERVATION46",""),
		reservation47("RESERVATION47",""),
		reservation48("RESERVATION48",""),
		reservation49("RESERVATION49",""),
		reservation50("RESERVATION50",""),
		reservation51("RESERVATION51","与经侦同步更新的时间，下次更新与此时间作比较"),
		reservation52("RESERVATION52",""),
		reservation53("RESERVATION53",""),
		ajzbryName("AJZBRY_NAME","案件主办人"),
		ajxbryName("AJXBRY_NAME","案件协办人（多值）"),
		slLrrName("SL_LRR_NAME","受理人"),
		slSlrxmName("SL_SLRXM_NAME","填表人"),
		ajlaryName("AJLARY_NAME","立案人"),
		laLrrName("LA_LRR_NAME","立案录入人"),
		departmentcodeName("DEPARTMENTCODE_NAME","部门名称"),
		zbdwName("ZBDW_NAME","主办单位"),
		ladwName("LADW_NAME","立案单位"),
		sljjdwName("SLJJDW_NAME","接警单位"),
		sljsdwName("SLJSDW_NAME","受理单位"),
		reserver38("RESERVER38",""),
		reserver39("RESERVER39",""),
		reserver40("RESERVER40",""),
		reserver41("RESERVER41",""),
		reserver42("RESERVER42",""),
		reserver43("RESERVER43",""),
		reserver44("RESERVER44",""),
		reserver45("RESERVER45",""),
		reserver46("RESERVER46",""),
		reserver47("RESERVER47",""),
		reserver48("RESERVER48",""),
		reserver49("RESERVER49",""),
		reserver50("RESERVER50",""),
		reserver51("RESERVER51",""),
		reserver52("RESERVER52",""),
		reserver53("RESERVER53",""),
		reserver54("RESERVER54",""),
		reserver55("RESERVER55",""),
		reserver56("RESERVER56",""),
		reserver57("RESERVER57",""),
		reserver58("RESERVER58",""),
		reserver59("RESERVER59",""),
		reserver60("RESERVER60",""),
		reserver61("RESERVER61",""),
		reserver62("RESERVER62",""),
		reserver63("RESERVER63",""),
		reserver64("RESERVER64",""),
		reserver65("RESERVER65",""),
		reserver66("RESERVER66",""),
		reserver67("RESERVER67",""),
		reserver68("RESERVER68",""),
		reserver69("RESERVER69",""),
		reserver70("RESERVER70",""),
		reserver71("RESERVER71",""),
		reserver72("RESERVER72",""),
		reserver73("RESERVER73",""),
		reserver74("RESERVER74",""),
		reserver75("RESERVER75",""),
		reserver76("RESERVER76",""),
		reserver77("RESERVER77",""),
		reserver78("RESERVER78",""),
		reserver79("RESERVER79",""),
		reserver80("RESERVER80",""),
		reserver81("RESERVER81",""),
		reserver82("RESERVER82",""),
		reserver83("RESERVER83",""),
		reserver84("RESERVER84",""),
		reserver85("RESERVER85",""),
		reserver86("RESERVER86",""),
		reserver87("RESERVER87",""),
		reserver88("RESERVER88",""),
		reserver89("RESERVER89",""),
		reserver90("RESERVER90",""),
		reserver91("RESERVER91",""),
		reserver92("RESERVER92",""),
		reserver93("RESERVER93",""),
		reserver94("RESERVER94",""),
		reserver95("RESERVER95",""),
		reserver96("RESERVER96",""),
		reserver97("RESERVER97",""),
		reserver98("RESERVER98",""),
		reserver99("RESERVER99",""),
		reserver100("RESERVER100",""),
		reserver1("RESERVER1",""),
		reserver2("RESERVER2",""),
		reserver3("RESERVER3","X坐标"),
		reserver4("RESERVER4","Y坐标"),
		reserver5("RESERVER5",""),
		reserver6("RESERVER6",""),
		reserver7("RESERVER7",""),
		reserver8("RESERVER8",""),
		reserver9("RESERVER9",""),
		reserver10("RESERVER10",""),
		reserver11("RESERVER11",""),
		reserver12("RESERVER12",""),
		reserver13("RESERVER13",""),
		reserver14("RESERVER14",""),
		reserver15("RESERVER15",""),
		reserver16("RESERVER16",""),
		reserver17("RESERVER17",""),
		reserver18("RESERVER18",""),
		reserver19("RESERVER19",""),
		reserver20("RESERVER20",""),
		reserver21("RESERVER21",""),
		reserver22("RESERVER22",""),
		reserver23("RESERVER23",""),
		reserver24("RESERVER24",""),
		reserver25("RESERVER25",""),
		reserver26("RESERVER26",""),
		reserver27("RESERVER27",""),
		reserver28("RESERVER28",""),
		reserver29("RESERVER29",""),
		reserver30("RESERVER30",""),
		reserver31("RESERVER31",""),
		reserver32("RESERVER32",""),
		reserver33("RESERVER33",""),
		reserver34("RESERVER34",""),
		reserver35("RESERVER35",""),
		reserver36("RESERVER36",""),
		reserver37("RESERVER37",""),
		yykRksj("YYK_RKSJ",""),
		abCn("AB_CN",""),
		ajssjqCn("AJSSJQ_CN",""),
		ajstateCn("AJSTATE_CN",""),
		ajwhcdCn("AJWHCD_CN",""),
		blyyCn("BLYY_CN",""),
		creatorCn("CREATOR_CN",""),
		datacheck("DATACHECK",""),
		datastate("DATASTATE",""),
		dbjbCn("DBJB_CN",""),
		departmentcodeCn("DEPARTMENTCODE_CN",""),
		faddJdCn("FADD_JD_CN",""),
		faddQxCn("FADD_QX_CN",""),
		fadyCn("FADY_CN",""),
		fxxsCn("FXXS_CN",""),
		fzztlxCn("FZZTLX_CN",""),
		jzbh("JZBH",""),
		lastupdatedbyCn("LASTUPDATEDBY_CN",""),
		queryid("QUERYID",""),
		reservation03Cn("RESERVATION03_CN",""),
		reservation36Cn("RESERVATION36_CN",""),
		sdtdCn("SDTD_CN",""),
		securitygradeCn("SECURITYGRADE_CN",""),
		sfswCn("SFSW_CN",""),
		sjgjdqCn("SJGJDQ_CN",""),
		slfacsCn("SLFACS_CN",""),
		sljsdwCn("SLJSDW_CN",""),
		slJjfsCn("SL_JJFS_CN",""),
		slSlrxmCn("SL_SLRXM_CN",""),
		sssqCn("SSSQ_CN",""),
		xzbwCn("XZBW_CN",""),
		xzcsCn("XZCS_CN",""),
		xzdxCn("XZDX_CN",""),
		xzsjCn("XZSJ_CN",""),
		zabzCn("ZABZ_CN",""),
		zagjCn("ZAGJ_CN",""),
		zaztCn("ZAZT_CN",""),
		zbdwCn("ZBDW_CN",""),
		rkgxsj("RKGXSJ",""),
		xlab("XLAB","细类按别"),
		xlmc("XLMC","细类名称"),
		yxlmc("YXLMC","原细类名称"),
		fasj("FASJ","发案时间"),
		sfbz("SFBZ","是否标注"),
		zykRksj("ZYK_RKSJ",""),
		zykGxsj("ZYK_GXSJ",""),
		zykSystemid("ZYK_SYSTEMID",""),
		clbz("CLBZ","处理标志"),
		sfhl("SFHL","是否忽略，默认为0，0为未忽略，1为忽略"),
		ajbzreserver1("AJBZRESERVER1","涉及类别"),
		ajbzreserver2("AJBZRESERVER2","警情大类"),
		ajbzreserver3("AJBZRESERVER3","警情一级细类"),
		ajbzreserver4("AJBZRESERVER4","警情二级细类"),
		ajbzreserver5("AJBZRESERVER5","警情三级细类"),
		ajbzreserver6("AJBZRESERVER6","警情标注是新增还是修改，Y为修改,其他为新增"),
		ajbzreserver7("AJBZRESERVER7","涉及对象"),
		ajbzreserver8("AJBZRESERVER8","作案工具"),
		ajbzreserver9("AJBZRESERVER9","发案地点"),
		ajbzreserver10("AJBZRESERVER10","盗窃专项"),
		ajbzreserver11("AJBZRESERVER11","保留未用"),
		ajbzreserver12("AJBZRESERVER12","保留未用"),
		ajbzreserver13("AJBZRESERVER13","保留未用"),
		ajbzreserver14("AJBZRESERVER14","保留未用"),
		ajbzreserver15("AJBZRESERVER15","保留未用"),
		transferTime("TRANSFER_TIME","传输时间");
		
		private String fieldName;
		private String remark;
		
		AsjAjEnum(String fieldName,String remark){
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
