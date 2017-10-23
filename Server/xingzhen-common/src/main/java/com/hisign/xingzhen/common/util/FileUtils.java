package com.hisign.xingzhen.common.util;

import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hisign on 2017/10/23.
 */
public class FileUtils {

    /**
     * 下载文件
     * @param fileName
     * @param response
     * @throws IOException
     */
    public void downloadFile(String fileName, HttpServletResponse response) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));

        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }

    /**
     * 打包下载 zip
     * @param fileName
     * @param response
     * @throws IOException
     */
    /*public void downloadZipFile(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ZipUtil zu = new ZipUtil();
        zu.setComment("压缩文件");
        String outputDir = "";
        String zipFilename = request.getRealPath("/"+projectName+".zip");
        List<String> filter = new ArrayList<String>();
        if("packModule".equals(method)){
            for(Entry<String,OutputModel> entry : omMap.entrySet()){
                if(entry.getValue().getType()==InOutType.FILE){
                    String f1 = entry.getValue().getOutput().replace("\\", "/").toLowerCase().replace(outputDir.replace("\\", "/").toLowerCase(), "");
                    if(f1.startsWith("/")){
                        f1= f1.substring(1);
                    }
                    filter.add(f1);
                }
            }
        }
        zu.zip(outputDir, zipFilename, filter);
    }*/
}
