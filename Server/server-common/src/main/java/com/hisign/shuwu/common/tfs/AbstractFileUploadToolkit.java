package com.hisign.shuwu.common.tfs;

import com.hisign.shuwu.common.model.UploadFile;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;

/**
 * 实现
 * 
 * @author Administrator
 */
public abstract class AbstractFileUploadToolkit implements FileUploadToolkit {
	/* logger */
	protected static final Logger LOGGER = LoggerFactory.getLogger(FileUploadToolkit.class);
	private static final int BUFFER_SIZE = 16 * 1024;
	/* 文件上传配置 */
	protected FileUploadConfig fileUploadConfig;
	
	public AbstractFileUploadToolkit(FileUploadConfig fileUploadConfig) {
		this.fileUploadConfig = fileUploadConfig;
	}

	/**
	 * 返回保存的上传文件对象
	 * 
	 * @param file
	 * @return
	 */
	protected File getStoreUploadFile(UploadFile file) {
		String ext = FilenameUtils.getExtension(file.getMultipartFile().getOriginalFilename());; // 获取文件名后缀
		FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd");
		String today = fdf.format(new Date());
		String path = StringUtils.replace(today, "-", File.separator);
		CreateRandomFile RandomFile = new CreateRandomFile();
		File storeFile = RandomFile.create2(path, ext);
		LOGGER.info("生成随机命名的文件, storeFile={0}", storeFile);
		return storeFile;
	}

	protected void copy(byte[] src, File dst) {
		try {
			File mkdirs = new File(dst.getParent());
			if (!mkdirs.exists()) {
				mkdirs.mkdirs();
			}
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new ByteArrayInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
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
