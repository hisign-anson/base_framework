package com.hisign.xingzhen.sys.controller;

import com.hisign.xingzhen.common.model.JsonResult;
import com.hisign.xingzhen.common.model.UploadFile;
import com.hisign.xingzhen.common.tfs.FileUploadToolkits;
import com.hisign.xingzhen.common.util.JsonResultUtil;
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

    @ApiOperation(value = "上传",httpMethod ="POST",response = JsonResult.class)
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
