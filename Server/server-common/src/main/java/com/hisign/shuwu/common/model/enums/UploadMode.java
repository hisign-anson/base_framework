package com.hisign.shuwu.common.model.enums;

import org.apache.commons.lang.StringUtils;


/**
 * 上传模型的枚举
 * 
 * @author Administrator
 */
public enum UploadMode {
	/* 本地文件模式 */
	LOCAL("LOCAL"),

	/* FTP模式 */
	FTP("FTP"),

	;

	/** 常量描述 */
	private String description;

	/**
	 * 构造方法
	 * 
	 * @param description
	 */
	UploadMode(String description) {
		this.description = description;
	}

	/**
	 * Getter method for property <tt>description</tt>.
	 * 
	 * @return property value of description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 根据名称返回枚举类型
	 * 
	 * @param name
	 * @return
	 */
	public static UploadMode getEnums(String name) {
		for (UploadMode enums : values()) {
			if (StringUtils.equalsIgnoreCase(name, enums.name())) {
				return enums;
			}
		}
		return null;
	}
}
