package com.hisign.framework.sys.controller;

import com.hisign.framework.common.model.JsonResult;
import com.hisign.framework.common.model.UploadFile;
import com.hisign.framework.common.tfs.FileUploadToolkits;
import com.hisign.framework.common.util.JsonResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(description="文件上传")
@RequestMapping("/sys/file")
@RestController
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@Autowired
    private FileUploadToolkits fileUploadToolkits;

    @ApiOperation(value = "上传",httpMethod ="GET",response = JsonResult.class)
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
