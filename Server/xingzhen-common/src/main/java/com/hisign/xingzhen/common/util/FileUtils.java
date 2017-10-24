package com.hisign.xingzhen.common.util;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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
    public static void downloadFile(String fileName, HttpServletResponse response) throws IOException {
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
            bis.close();
            if (bos != null)  bos.close();
        }
    }

}
