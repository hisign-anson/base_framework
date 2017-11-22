package com.hisign.xingzhen.common.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 16:41 2017/11/17
 */
public class ValidatorUtils {
    /**
     * 正则表达式:验证手机号
     */
    public static final String REGEX_MOBILE = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
    /**
     * 正则表达式:验证身份证
     */
    public static final String REGEX_ID_CARD = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)";
    /**
     * 车牌号格式：汉字 + A-Z + 5位A-Z或0-9
     * （只包括了普通车牌号，教练车和部分部队车等车牌号不包括在内）
     */
    public static final String REGEX_CAR_NUM = "[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}";
    /**
     * 匹配url
     */
    public static final String REGEX_URL = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";

    /**
     * 校验是否存在手机号
     *
     * @param content
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isContainMobile(String content) {
        Pattern p = Pattern.compile(REGEX_MOBILE);
        Matcher m = p.matcher(content);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 校验是否存在身份证
     *
     * @param content
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isContainIDCard(String content) {
        Pattern p = Pattern.compile(REGEX_ID_CARD);
        Matcher m = p.matcher(content);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 校验是否存在车牌号
     *
     * @param content
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isContainCarNum(String content) {
        Pattern p = Pattern.compile(REGEX_CAR_NUM);
        Matcher m = p.matcher(content);
        if (m.find()) {
            return true;
        }
        return false;
    }


    /**
     * 校验是否存在url
     *
     * @param content
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isContainUrl(String content) {
        Pattern p = Pattern.compile(REGEX_URL);
        Matcher m = p.matcher(content);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否是图片后缀名
     *
     * @param content
     * @return
     */
    public static boolean isPhoto(String content) {
        String imgExt = "jpeg|bmp|jpg|png|tiff|gif|pcx|tga|exif|fpx|svg|psd|cdr|pcd|dxf|ufo|eps|ai|raw|wmf";
        return imgExt.contains(content.toLowerCase(Locale.CHINA));
    }

    /**
     * 判断是否是视频后缀名
     *
     * @param content
     * @return
     */
    public static boolean isVideo(String content) {
        String imgExt = "aiff|mpg|mpeg|rm|rmvb|wmv|avi|mp4|3gp|mkv";
        return imgExt.contains(content.toLowerCase(Locale.CHINA));
    }

    /**
     * 判断是否是音频后缀名
     *
     * @param content
     * @return
     */
    public static boolean isAudio(String content) {
        String imgExt = "mp3|amr|wma|flac|aac|mmf|m4a|m4r|ogg|mp2|wav|wv";
        return imgExt.contains(content.toLowerCase(Locale.CHINA));
    }
}

