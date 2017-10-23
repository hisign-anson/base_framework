package com.hisign.xingzhen.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量类
 *
 * @author Hong
 */
public class Constants {

	/**
	 * 是否代码：是
	 */
	public static final String SFDM_S = "1";

	/**
	 * 是否代码：否
	 */
	public static final String SFDM_F = "0";

	/**
	 * 删除标识：是
	 */
	public static final String DELETE_TRUE = "1";

	/**
	 * 删除标识：否
	 */
	public static final String DELETE_FALSE = "0";

	/**
	 * 成功
	 */
	public static final String SUCCESS = "success";

	/**
	 * 失败
	 */
	public static final String ERROR = "error";


	public static final String NO = "0";

	public static final String YES = "1";



	/**
	 * token名
	 */
	public static final String TOKEN = "token";

	/**
	 * 需要局审批的最大总价
	 */
	public static final int NEED_JU_APPLY_MAX_AMOUNT = 2000;

	/**
	 *
	 * 日志类型
	 *
	 */
	public static class XZLogType{
		/** 专案组 1 **/
		public static final String GROUP = "1";
		/** 任务 2 **/
		public static final String TASK = "2";
		/** 登录 3 **/
		public static final String LOGIN = "3";
		/** 聊天 4 **/
		public static final String CHAT = "4";
	}

	/**
	 *
	 * 时间类型
	 *
	 */
	public static class DateType{
		/** 月度 5 **/
		public static final Integer MONTH = 5;
		/** 季度 6 **/
		public static final Integer QUARTER = 6;
		/** 年度 7 **/
		public static final Integer YEAR = 7;
	}

	/**
	 *
	 * 车辆状态
	 */
	public static class CarInfoStatus{

		/** 可用  1**/
		public static final Integer AVAILABLE = 1;
		/** 维修中  2**/
		public static final Integer MAINTAINING = 2;
		/** 出车中 3 **/
		public static final Integer OUTSIDE = 3;
	}
	/**
	 *
	 * 车辆申请状态
	 */
	public static class CarApplyStatus{

		/** 0 暂存 **/
		public static final Integer STATUS_0 = 0;
		/** 1 待科领导审批 **/
		public static final Integer STATUS_1 = 1;
		/** 2 待处领导审批 **/
		public static final Integer STATUS_2 = 2;
		/** 3 待决策处领导审批 **/
		public static final Integer STATUS_3 = 3;
		/** 4 待局领导审批 **/
		public static final Integer STATUS_4 = 4;
		/** 5待派车 **/
		public static final Integer STATUS_5 = 5;
		/** 6待回车 **/
		public static final Integer STATUS_6 = 6;
		/** 7已回车 **/
		public static final Integer STATUS_7 = 7;

		/** -1 科领导审批不通过 **/
		public static final Integer STATUS_1_ = -1;
		/** -2 处领导审批不通过 **/
		public static final Integer STATUS_2_ = -2;
		/** -3 决策处领导不通过 **/
		public static final Integer STATUS_3_ = -3;
		/** -4 局领导审批不通过 **/
		public static final Integer STATUS_4_ = -4;
	}

	/**
	 *
	 * 领物申领状态
	 */
	public static class ItemApplyStatus{

		/** 0 暂存 **/
		public static final Integer STATUS_0 = 0;
		/** 1 待科领导审批 **/
		public static final Integer STATUS_1 = 1;
		/** 2  待处内勤汇总 **/
		public static final Integer STATUS_2 = 2;
		/** 3 待处领导审批  **/
		public static final Integer STATUS_3 = 3;
		/** 4 对策处审批  **/
		public static final Integer STATUS_4 = 4;
		/** 5待局领导审批  **/
		public static final Integer STATUS_5 = 5;
		/** 6 审批通过待领物  **/
		public static final Integer STATUS_6 = 6;
		/** 7已领物 **/
		public static final Integer STATUS_7 = 7;

		/** -1 科领导审批不通过 **/
		public static final Integer STATUS_1_ = -1;
		/** -3 处领导审批不通过 **/
		public static final Integer STATUS_3_ = -3;
		/** -4 对策处领导不通过  **/
		public static final Integer STATUS_4_ = -4;
		/** -5 局领导审批不通过   **/
		public static final Integer STATUS_5_ = -5;
	}

	/**
	 *
	 * 领物申领申领汇总状态
	 */
	public static class ItemApplySumStatus{

		/** 3 待处领导审批  **/
		public static final Integer STATUS_3 = 3;
		/** 4 对策处审批  **/
		public static final Integer STATUS_4 = 4;
		/** 5待局领导审批  **/
		public static final Integer STATUS_5 = 5;
		/** 6 审批通过待领物  **/
		public static final Integer STATUS_6 = 6;
		/** 7已领物 **/
		public static final Integer STATUS_7 = 7;

		/** -1 科领导审批不通过 **/
		public static final Integer STATUS_1_ = -1;
		/** -3 处领导审批不通过 **/
		public static final Integer STATUS_3_ = -3;
		/** -4 对策处领导不通过  **/
		public static final Integer STATUS_4_ = -4;
		/** -5局领导审批不通过   **/
		public static final Integer STATUS_5_ = -5;
	}

	/**
	 *
	 * 项目开支申请状态
	 */
	public static class ExesApplyStatus{

		/** 0 暂存 **/
		public static final Integer STATUS_0 = 0;
		/** 1 待科领导审批 **/
		public static final Integer STATUS_1 = 1;
		/** 2 待处领导审批  **/
		public static final Integer STATUS_2 = 2;
		/** 3待局领导审批  **/
		public static final Integer STATUS_3 = 3;
		/** 4对策处审批  **/
		public static final Integer STATUS_4 = 4;
		/** 6 审批通过  **/
		public static final Integer STATUS_6 = 6;

		/** -1 科领导审批不通过 **/
		public static final Integer STATUS_1_ = -1;
		/** -2 处领导审批不通过 **/
		public static final Integer STATUS_2_ = -2;
		/** -3 局领导审批不通过   **/
		public static final Integer STATUS_3_ = -3;
		/** -4 对策处审批审批不通过   **/
		public static final Integer STATUS_4_ = -4;
	}






	/**
	 *
	 * 车辆维修申请状态
	 */
	public static class CarMaintainStatus{

		/** 暂存  0 **/
		public static final int UNCOMMIT = 0;
		/** 提交 1**/
		public static final int COMMIT = 1;
		/** 已登记 2 **/
		public static final int REGED = 2;
	}


	/**
	 * 用户信息状态
	 */
	public final static class UserInfoStatus{

		/** 0 正常**/
		public final static int NORMAL = 0;
		/** 1 删除**/
		public final static int DELETE = 1;
	}
	/**
	 *
	 * 任务状态
	 */
	public static class TasksStatus{

		/**   0 未完成 **/
		public static final int STATUS_0 = 0;
		/**  1 已完成**/
		public static final int STATUS_1 = 1;
	}

	/**
	 *
	 * 项目状态
	 */
	public static class ProjectInfoStatus{

		/**   0 未启动 **/
		public static final int STATUS_0 = 0;
		/**  1 已启动**/
		public static final int STATUS_1 = 1;
		/**  99  已结束**/
		public static final int STATUS_99 = 99;
	}

	/** 非领导职务代码 **/
	public final static String FLDZWDM = "FLDZWDM";


	/**
	 * 系统参数
	 */
	public static Map<String, String> SYS_PARAM_MAP = new HashMap<String, String>();

	/**
	 *
	 * 消息类型
	 *
	 */
	public static class MessageType{
		/**   1 通知公告 **/
		public static final int TYPE_1 = 1;
		/**   2 规章制度 **/
		public static final int TYPE_2 = 2;
		/**   3 表格下载 **/
		public static final int TYPE_3 = 3;
	}


	/**
	 *
	 * 接收消息类型
	 *
	 */
	public static class ReceiveMessageType{
		/**   1 通知公告 **/
		public static final int TYPE_1 = 1;
		/**   2 系统推送消息 **/
		public static final int TYPE_2 = 2;
	}


	/**
	 *
	 * 消息等级
	 *
	 */
	public static class MessageLevel{
		/**   1 普通 **/
		public static final String LEVEL_1 = "1";
		/**   2 加急 **/
		public static final String LEVEL_2 = "2";
		/**   3 特急 **/
		public static final String LEVEL_3 = "3";
	}

	/**
	 *
	 * 消息状态
	 *
	 */
	public static class MessageStatus{
		/**   0 未读 **/
		public static final int STATUS_0 = 0;
		/**   1 已读 **/
		public static final int STATUS_1 = 1;
	}

	/**
	 *
	 * 消息状态
	 *
	 */
	public static class IsPublish{
		/**   0 未发布 **/
		public static final int STATUS_0 = 0;
		/**   1 已发布 **/
		public static final int STATUS_1 = 1;
	}

	/**
	 *
	 * 是否删除状态
	 */
	public static class IsDel{
		/** 未删除 **/
		public static final int DEL_0 = 0;
		/** 已删除 **/
		public static final int DEL_1 = 1;
	}

	/**
	 * 上传类型
	 * @author 何建辉
	 *
	 */
	public static class UploadType{
		/** img **/
		public static final String IMG = "img";
		/** word **/
		public static final String WORD = "word";
	}
	/**
	 * 审批类型
	 *
	 */
	public static class AuditType{
		/** 1财务 **/
		public static final int TYPE_1 = 1;
		/** 2车辆 **/
		public static final int TYPE_2 = 2;
		/** 3物品 **/
		public static final int TYPE_3 = 3;
	}




	static public final byte HEX_DIGITS[] = {
			(byte) '0', (byte) '1', (byte) '2', (byte) '3',
			(byte) '4', (byte) '5', (byte) '6', (byte) '7',
			(byte) '8', (byte) '9', (byte) 'a', (byte) 'b',
			(byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f'
	};


}
