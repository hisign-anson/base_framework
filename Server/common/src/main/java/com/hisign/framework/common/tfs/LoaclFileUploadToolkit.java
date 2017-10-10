package com.hisign.framework.common.tfs;

import com.hisign.framework.common.model.UploadFile;
import net.coobird.thumbnailator.Thumbnailator;
import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * 本地文件上传组件实现
 * 
 * @author Administrator
 */
public class LoaclFileUploadToolkit extends AbstractFileUploadToolkit {

	public LoaclFileUploadToolkit(FileUploadConfig fileUploadConfig) {
		super(fileUploadConfig);
	}

	@Override
	public UploadFile upload(UploadFile file)  throws FileUploadException{
		// 获取存储的文件句柄对象
		File storeFile = getStoreUploadFile(file);

		// 设置属性
		file.setPath(storeFile.getPath());

		// 保存
		try {
			if (file.getMultipartFile() != null && ! file.getMultipartFile().isEmpty()){
				FileUtils.copyInputStreamToFile(file.getMultipartFile().getInputStream(), storeFile);
			}
			file.addAttribute("resultMessage","success");
			String filePath = storeFile.getPath();
			
			file.addAttribute("source",filePath);
			
			if(file.isResize()){//是否生成缩略图
				
				int thumbWidth = fileUploadConfig.getThumbWidth();
				int thumbHeight = fileUploadConfig.getThumbHeight();
				String[] s = filePath.split("\\.");
				String thumb = thumbWidth+"_"+thumbHeight;
				File outFile = new File(s[0]+thumb+"."+s[1]);
				file.addAttribute("p"+thumb,outFile.getPath());
	        	Thumbnailator.createThumbnail(storeFile, outFile, thumbWidth, thumbHeight);
			}
		} catch (Exception ex) {
			LOGGER.error("保存文件时发生异常", ex);
			file.addAttribute("resultMessage","error");
		}
		return file;
	}
	

	@Override
	public void delete(UploadFile file) {
		// 获取完整路径的存储文件句柄
		File diskFile = new File(fileUploadConfig.getRootPath(), file.getPath());
		if(diskFile.exists()){
			if(FileUtils.deleteQuietly(diskFile)){
				String filePath = diskFile.getPath();
				String[] s=filePath.split("\\.");
				File thumbFile = new File( s[0]+"_thumb."+s[1]);
				if(thumbFile.exists()){
					FileUtils.deleteQuietly(thumbFile);
				}
			}
		}
	}

}
