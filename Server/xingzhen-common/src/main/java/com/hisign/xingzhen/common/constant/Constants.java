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


}
