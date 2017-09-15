package com.hisign.shuwu.web.controller.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hisign.shuwu.common.model.JsonResult;
import com.hisign.shuwu.common.model.UploadFile;
import com.hisign.shuwu.common.tfs.FileUploadToolkits;
import com.hisign.shuwu.common.util.JsonResultUtil;

@RequestMapping("/sys/file")
@RestController
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@Autowired
    private FileUploadToolkits fileUploadToolkits;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult upload(@RequestParam("file") MultipartFile file,@RequestParam(value="isResize",required=false,defaultValue="true") Boolean isResize) {
        if (!file.isEmpty()) {
            try {
            	UploadFile uploadFile = new UploadFile();
            	uploadFile.setMultipartFile(file);
            	uploadFile.setResize(isResize);
                uploadFile = fileUploadToolkits.getFileUploadToolkit().upload(uploadFile);
            	return JsonResultUtil.success(uploadFile.getAttributes());
            } catch (Exception e) {
            	logger.error("上传失败", e);
                return JsonResultUtil.error("上传失败," + e.getMessage());
            }
        } else {
            return JsonResultUtil.error("上传文件为空");
        }
    }
	
}
