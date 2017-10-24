package com.hisign.xingzhen.common.util;

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
    
}
