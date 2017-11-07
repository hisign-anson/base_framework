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
	 * 是否删除状态
	 */
	public static class IsDel{
		/** 未删除 **/
		public static final int DEL_0 = 0;
		/** 已删除 **/
		public static final int DEL_1 = 1;
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
	 * 时间类型
	 *
	 */
	public static class DateType{
		/** 月度 1 **/
		public static final Integer MONTH = 0;
		/** 季度 2 **/
		public static final Integer QUARTER = 1;
		/** 年度 3 **/
		public static final Integer YEAR = 2;
	}

	/**
	 * 系统参数
	 */
	public static Map<String, String> SYS_PARAM_MAP = new HashMap<String, String>();

	/** 非领导职务代码 **/
	public final static String FLDZWDM = "FLDZWDM";

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
		/**   3 动态信息提醒 **/
		public static final int TYPE_3 = 3;
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


	static public final byte HEX_DIGITS[] = {
			(byte) '0', (byte) '1', (byte) '2', (byte) '3',
			(byte) '4', (byte) '5', (byte) '6', (byte) '7',
			(byte) '8', (byte) '9', (byte) 'a', (byte) 'b',
			(byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f'
	};

	//极光版本号
	public static final int JM_VERSION = 1;

	//发送目标类型 single - 个人
	public static final String JM_TARGET_TYPE_SINGLE = "single";
	//发送目标类型 group - 群组
	public static final String JM_TARGET_TYPE_GROUP = "group";
	//发送消息者身份 当前只限admin用户
	public static final String JM_FROM_TYPE_ADMIN = "admin";

	//发送任务消息
	public static final String SEND_TASK_INFO = "send_task_info";
	//发送任务催办消息
	public static final String SEND_TASK_URGE_INFO = "send_task_urge_info";
	//发送任务反馈消息
	public static final String SEND_TASK_FEEDBACK_INFO = "send_task_feedback_info";
	//本人下发的任务移交
	public static final String SEND_TASK_MOVE_INFO = "send_task_move_info";

	//本人添加到专案组
	public static final String SEND_JOIN_GROUP_INFO = "send_join_group_info";
	//本人被专案组移除
	public static final String SEND_REMOVE_GROUP_INFO = "send_remove_group_info";
	//本人所在专案组关联案件
	public static final String SEND_CONNECT_CASE_INFO = "send_connect_case_info";
	//本人所在专案组移除案件
	public static final String SEND_REMOVE_CASE_INFO = "send_remove_case_info";
	//本人所在专案组归档
	public static final String SEND_GROUP_BACKUP_INFO = "send_group_backup_info";
	//本人所在专案组的广播信息
	public static final String SEND_GROUP_BROADCAST_INFO = "send_group_broadcast_info";



	//任务消息key
	public static final String TYPE_CUSTOM_KEY = "TYPE_CUSTOM_KEY";
	//自定义任务消息
	public static final String TYPE_CUSTOM_TASK = "TYPE_CUSTOM_TASK";
	//自定义反馈消息
	public static final String TYPE_CUSTOM_TASK_FEEDBACK = "TYPE_CUSTOM_TASK_FEEDBACK";
	//自定义催办消息
	public static final String TYPE_CUSTOM_TASK_URGE = "TYPE_CUSTOM_TASK_URGE";
	//任务内容key
	public static final String TYPE_CUSTOM_TASK_ID_KEY = "TYPE_CUSTOM_TASK_ID_KEY";
	//任务标题key
	public static final String TYPE_CUSTOM_TASK_TITLE_KEY = "TYPE_CUSTOM_TASK_TITLE_KEY";
	//任务内容key
	public static final String TYPE_CUSTOM_TASK_CONTENT_KEY = "TYPE_CUSTOM_TASK_CONTENT_KEY";
	//任务反馈时间key
	public static final String TYPE_CUSTOM_TASK_FEEDBACK_KEY = "TYPE_CUSTOM_TASK_FEEDBACK_KEY";
	//任务接收人IDkey
	public static final String TYPE_CUSTOM_TASK_RECEIVER_ID_KEY = "TYPE_CUSTOM_TASK_RECEIVER_ID_KEY";
	//任务接收人key
	public static final String TYPE_CUSTOM_TASK_RECEIVER_KEY = "TYPE_CUSTOM_TASK_RECEIVER_KEY";


	public static final String JM_PASSWORD="123456";

}
