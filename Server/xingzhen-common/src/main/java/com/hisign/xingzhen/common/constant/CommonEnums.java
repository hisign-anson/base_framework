package com.hisign.xingzhen.common.constant;

/**
 *  常用枚举
 * @author 何建辉
 *
 */
public class CommonEnums {

	/**
	 * 车辆使用统计维度枚举
	 * @author 何建辉
	 *
	 */
	public enum CarUseStatDimensionEnum{
		ORG("org"),
		CAR("car");
		
		private String name; 
		
		CarUseStatDimensionEnum(String name){
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	/**
	 * 错误枚举
	 * @author 何建辉
	 *
	 */
	public enum ErrorEnum{
		
		NOT_EXISTS(100001,"对不起,该记录不存在,请刷新页面再试"),
		PARAM_ERROR(100001,"对不起,提交参数错误,请刷新页面再试");
		
		private int code;
		private String msg;
		
		private ErrorEnum(int code,String msg){
			this.code = code;
			this.msg = msg;
		}

		public int code() {
			return code;
		}
		
		public String msg() {
			return msg;
		}
	}
}
