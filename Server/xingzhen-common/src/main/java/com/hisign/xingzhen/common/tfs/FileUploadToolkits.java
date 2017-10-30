package com.hisign.xingzhen.common.tfs;

import java.util.HashMap;
import java.util.Map;

import com.hisign.xingzhen.common.model.enums.UploadMode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;


/**
 * 上传文件工具箱实例生成器实现
 * 
 * @author Administrator
 */
public class FileUploadToolkits implements InitializingBean {
	/* logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadToolkits.class);

	/* 工具箱映射 */
	private Map<String, FileUploadToolkit> toolkits;

	
	/* 上传配置 */
	private FileUploadConfig fileUploadConfig;
	
	public FileUploadToolkits(){
		
	}
	public FileUploadToolkits(FileUploadConfig fileUploadConfig){
		this.fileUploadConfig = fileUploadConfig;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (toolkits == null) {
			this.toolkits = new HashMap<String, FileUploadToolkit>();
		}
		// 加入默认的上传文件工具箱组件
		this.toolkits.put(UploadMode.LOCAL.name(), new LoaclFileUploadToolkit(fileUploadConfig));
		this.toolkits.put(UploadMode.FTP.name(), new FtpFileUploadToolkit(fileUploadConfig));
	}

	public FileUploadToolkit getFileUploadToolkit() {
		LOGGER.info("返回上传文件组件, mode={0}", fileUploadConfig.getMode());
		if (StringUtils.isBlank(fileUploadConfig.getMode())) {
			return toolkits.get(UploadMode.LOCAL.name());
		}
		return toolkits.get(fileUploadConfig.getMode());
	}

	public FileUploadToolkit getFileUploadToolkit(String mode) {
		return toolkits.get(mode);
	}

	/**
	 * Setter method for property <tt>toolkits</tt>.
	 * 
	 * @param toolkits
	 *            value to be assigned to property toolkits
	 */
	public void setToolkits(Map<String, FileUploadToolkit> toolkits) {
		this.toolkits = toolkits;
	}


	/**
	 * @return the fileUploadConfig
	 */
	public FileUploadConfig getFileUploadConfig() {
		return fileUploadConfig;
	}

	/**
	 * @param fileUploadConfig the fileUploadConfig to set
	 */
	public void setFileUploadConfig(FileUploadConfig fileUploadConfig) {
		this.fileUploadConfig = fileUploadConfig;
	}
	
	
}
