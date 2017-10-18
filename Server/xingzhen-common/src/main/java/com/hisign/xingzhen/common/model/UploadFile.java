package com.hisign.xingzhen.common.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 上传文件
 * 
 * @author Administrator
 */
public class UploadFile{


	/* 文件路径 */
	private String path;

	private MultipartFile multipartFile;

	/* 附加属性映射 */
	private Map<String, Object> attributes;
	
	/** 是否生成缩略图**/
    private boolean isResize = false;

	/**
	 * 构造函数
	 */
	public UploadFile() {
	}

	/**
	 * Getter method for property <tt>path</tt>.
	 * 
	 * @return property value of path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Setter method for property <tt>path</tt>.
	 * 
	 * @param path
	 *            value to be assigned to property path
	 */
	public void setPath(String path) {
		this.path = path;
	}



	

	/**
	 * 添加属性
	 * 
	 * @param name
	 * @param attri
	 */
	public void addAttribute(String name, Object attri) {
		if (attributes == null) {
			attributes = new HashMap<String, Object>();
		}
		attributes.put(name, attri);
	}

	/**
	 * 返回制定名称的附加属性值
	 * 
	 * @param name
	 * @return
	 */
	public Object getAttribute(String name) {
		if (attributes != null) {
			return attributes.get(name);
		}
		return null;
	}
	

	/**
	 * @return the attributes
	 */
	public Map<String, Object> getAttributes() {
		return attributes;
	}


	/**
	 * @return the multipartFile
	 */
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}




	/**
	 * @param multipartFile the multipartFile to set
	 */
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public boolean isResize() {
		return isResize;
	}

	public void setResize(boolean isResize) {
		this.isResize = isResize;
	}

	
	
}
