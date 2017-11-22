package com.hisign.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hisign.xingzhen.common.util.StringUtils;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 18:21 2017/11/17
 */
public class Test1 {

    public static void main(String[] args) {
        String regex18 = "[1-9][0-9]{5}(18|19|([23][0-9]))[0-9]{2}((0[1-9])|[10-12])(([0-2][1-9])|10|20|30|31)[0-9]{3}[0-9Xx]";
        String regex15 = "[1-9][0-9]{5}[0-9]{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)[0-9]{2}[0-9Xx]";
        String phoneNumber = "(([0-9]{3,4}-)?[0-9]{7,8})|(13[0-9]{9})";
        String carNum = "[\\u4e00-\\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}";
        boolean ret = "粤A55555".matches(carNum);
        System.out.println(ret);
    }
}
