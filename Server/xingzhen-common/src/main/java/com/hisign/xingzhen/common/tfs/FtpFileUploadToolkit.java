package com.hisign.xingzhen.common.tfs;

import java.io.File;
import java.io.OutputStream;

import com.hisign.xingzhen.common.model.UploadFile;
import com.hisign.xingzhen.common.util.FtpUtils;
import net.coobird.thumbnailator.Thumbnailator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;


/**
 * FTP模式的上传文件组件实现
 * 
 * @author Administrator
 */
public class FtpFileUploadToolkit extends AbstractFileUploadToolkit {

	public FtpFileUploadToolkit(FileUploadConfig fileUploadConfig) {
		super(fileUploadConfig);
	}
	
	@Override
	public UploadFile upload(UploadFile file) throws FileUploadException {
		boolean result = false;
		// 获取存储的文件句柄对象
		File storeFile = getStoreUploadFile(file,null);

		// 设置属性
		file.setPath(storeFile.getPath());

		String host = fileUploadConfig.getHost();
        String port = fileUploadConfig.getPort();
        String userName = fileUploadConfig.getUser();
        String password = fileUploadConfig.getPassword();
        String rootPath = StringUtils.isBlank(fileUploadConfig.getRootPath())?File.separator:fileUploadConfig.getRootPath();
		FtpUtils ftpUtils = FtpUtils.getInstance(host, port, userName, password, rootPath);

		// 连接服务器
		result = ftpUtils.connect();
		if(!result){
			throw new FileUploadException("连接服务器异常");
		}

		// 登录服务器
		result = ftpUtils.login();
		if(!result){
			throw new FileUploadException("登录服务器异常");
		}
		try {
			if (file.getMultipartFile()!= null && ! file.getMultipartFile().isEmpty()){
				LOGGER.info("ftpstartTime："+System.currentTimeMillis());
				result = ftpUtils.uploadFile(file.getMultipartFile().getInputStream(), file.getPath());
				if(!result){
					throw new FileUploadException(FileUploadErrorCode.SAVE_UPLOAD_FILE_FAIL_DESC);
				}
				LOGGER.info("ftpendTime："+System.currentTimeMillis());
			}
			
			String filePath = file.getPath();
		
			file.addAttribute("source",filePath);
			file.addAttribute("oldName",file.getMultipartFile().getOriginalFilename());
			if(file.isResize()){//是否生成缩略图
				int thumbWidth = fileUploadConfig.getThumbWidth();
				int thumbHeight = fileUploadConfig.getThumbHeight();
				String[] s = filePath.split("\\.");
				String thumb = thumbWidth+"_"+thumbHeight;
				File outFile = new File(s[0]+thumb+"."+s[1]);
				file.addAttribute("p"+thumb,outFile.getPath());
				OutputStream os = FileUtils.openOutputStream(outFile);
	        	Thumbnailator.createThumbnail(file.getMultipartFile().getInputStream(), os, thumbWidth, thumbHeight);
	        	// 连接服务器
	        	result = ftpUtils.connect();
	    		if(!result){
	    			throw new FileUploadException("连接服务器异常");
	    		}
	    		// 登录服务器
	    		result = ftpUtils.login();
	    		if(!result){
	    			throw new FileUploadException("登录服务器异常");
	    		}
	    		result = ftpUtils.uploadFile(FileUtils.openInputStream(outFile),outFile.getPath());
				if(!result){
					throw new FileUploadException(FileUploadErrorCode.SAVE_UPLOAD_FILE_FAIL_DESC);
				}
				if(outFile.exists()){
					os.close();
					FileUtils.deleteQuietly(outFile);
				}
				
			}
			if(storeFile.exists()){
				FileUtils.deleteQuietly(storeFile);
			}
			
		} catch (Exception ex) {
			LOGGER.error("上传文件时发生异常", ex);
			file.addAttribute("resultMessage","error");
		}
      return file;  
	}

	@Override
	public void delete(UploadFile file) {
		String host = fileUploadConfig.getHost();
        String port = fileUploadConfig.getPort();
        String userName = fileUploadConfig.getUser();
        String password = fileUploadConfig.getPassword();
        String rootPath = StringUtils.isBlank(fileUploadConfig.getRootPath())?File.separator:fileUploadConfig.getRootPath();
		FtpUtils ftpUtils = FtpUtils.getInstance(host, port, userName, password, rootPath);

		// 连接服务器
		ftpUtils.connect();

		// 登录服务器
		ftpUtils.login();

		// 删除文件
		ftpUtils.deleteFile(file.getPath());
		
		String filePath = file.getPath();
		int thumbWidth = fileUploadConfig.getThumbWidth();
		int thumbHeight = fileUploadConfig.getThumbHeight();
		String[] s = filePath.split("\\.");
		String thumb = s[0]+thumbWidth+"_"+thumbHeight+"."+s[1];
		ftpUtils.deleteFile(thumb);
		
	}

}
