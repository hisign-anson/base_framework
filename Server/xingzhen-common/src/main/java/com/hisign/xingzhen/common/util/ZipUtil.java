package com.hisign.xingzhen.common.util;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;


public class ZipUtil {   
    private String comment = "";
      
    public void setComment(String comment) {
        this.comment = comment;  
    }  
  
      
    @SuppressWarnings("rawtypes")
	public void zip(String src, String dest, List filter) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(dest));
        File srcFile = new File(src);
        zip(out,srcFile,"",filter);  
        out.close();  
    }  
      
      
    @SuppressWarnings("rawtypes")
	public void zip(ZipOutputStream out, File srcFile, String base, List filter) throws Exception {
        if(!srcFile.exists()) {
            throw new Exception("源文件不存在");
        }  
          
        if(srcFile.isDirectory()) {  
            File[] files = srcFile.listFiles();
            base = base.length() == 0 ? "" : base + "/";  
            if (isExist(base, filter)&&!"".equals(base)) {
                out.putNextEntry(new ZipEntry(base));  
            }  
            for(File f:files) {
                zip(out,f,base + f.getName(),filter);
            }  
        } else {  
            if (isExist(base, filter)) {  
                base = base.length() == 0 ? srcFile.getName() : base ;  
                ZipEntry zipEntry = new ZipEntry(base);  
                zipEntry.setComment(comment);  
                out.putNextEntry(zipEntry);  
                FileInputStream in = new FileInputStream(srcFile);
                int length = 0;  
                byte[] b = new byte[1024];  
                while((length=in.read(b,0,1024))!=-1) {  
                    out.write(b,0,length);  
                }  
                in.close();  
            }  
        }  
    }  
      
      
    @SuppressWarnings("rawtypes")
	public boolean isExist(String base, List list) {
        if (list != null && !list.isEmpty()) {  
            for (int i = 0; i < list.size(); i++) {  
            	String f1 = base.replace("\\", "/").toLowerCase();
            	String f2 = ((String) list.get(i)).replace("\\", "/").toLowerCase();
            	System.out.println(f1+"="+f2);
                if (f1.contains(f2)) {
                    return true;  
                }  
            }  
            return false;
        }else{
        	return true;
        }
    }  
      
      
    @SuppressWarnings("rawtypes")
	public void unZip(String srcFile, String dest, boolean deleteFile)  throws Exception {
        File file = new File(srcFile);
        if(!file.exists()) {  
            throw new Exception("文件不存在!");
        }  
        ZipFile zipFile = new ZipFile(file);  
        Enumeration e = zipFile.getEntries();
        while(e.hasMoreElements()) {  
            ZipEntry zipEntry = (ZipEntry)e.nextElement();  
            if(zipEntry.isDirectory()) {  
                String name = zipEntry.getName();
                name = name.substring(0,name.length()-1);  
                File f = new File(dest + name);
                f.mkdirs();  
            } else {  
                File f = new File(dest + zipEntry.getName());
                f.getParentFile().mkdirs();  
                f.createNewFile();  
                InputStream is = zipFile.getInputStream(zipEntry);
                FileOutputStream fos = new FileOutputStream(f);
                int length = 0;  
                byte[] b = new byte[1024];  
                while((length=is.read(b, 0, 1024))!=-1) {  
                    fos.write(b, 0, length);  
                }  
                is.close();  
                fos.close();  
            }  
        }

        zipFile.close();

        if(deleteFile) {  
            file.deleteOnExit();  
        }  
    }  
      
      
    @SuppressWarnings("rawtypes")
	public static String getZipComment(String srcFile) {
        String comment = "";
        try {  
            ZipFile zipFile = new ZipFile(srcFile);  
            Enumeration e = zipFile.getEntries();
  
            while (e.hasMoreElements()) {  
                ZipEntry ze = (ZipEntry) e.nextElement();  
  
                comment = ze.getComment();  
                if (comment != null && !"".equals(comment)
                        && !"null".equals(comment)) {
                    break;  
                }  
            }  
  
            zipFile.close();  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
  
        return comment;  
    }  

}  

