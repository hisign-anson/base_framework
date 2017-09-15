package com.hisign.shuwu.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 流水号生成器
 * @author lqf
 * @Date 2017年4月10日
 */
public class SerialNumGenerater {

    private static SerialNumGenerater serialNumGenerater = null;
 
    private SerialNumGenerater() {
    	
    }
 
    /**
     * 取得SerialNumGenerater的单例实现
     *
     * @return
     */
    public static SerialNumGenerater getInstance() {
        if (serialNumGenerater == null) {
            synchronized (SerialNumGenerater.class) {
                if (serialNumGenerater == null) {
                    serialNumGenerater = new SerialNumGenerater();
                }
            }
        }
        return serialNumGenerater;
    }
 
    /**
     * 生成下一个编号
     */
    public synchronized String getNextNumber(String sno,int length) {
        String id = null;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        DecimalFormat df = new DecimalFormat(sb.toString());
        if (sno == null || "".equals(sno)) {
            id = formatter.format(date) + df.format(1 + Integer.parseInt(sb.toString()));
        } else {
            id = formatter.format(date)+ df.format(1 + Integer.parseInt(sno.substring(8, 8+length)));
        }
        return id;
    }
    
}
