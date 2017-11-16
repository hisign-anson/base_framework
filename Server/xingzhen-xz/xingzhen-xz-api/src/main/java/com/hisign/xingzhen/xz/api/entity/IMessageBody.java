package com.hisign.xingzhen.xz.api.entity;

import java.util.Map;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 17:17 2017/11/16
 */
public class IMessageBody {

    private String text;
    private String media_id;
    private Long media_crc32;
    private Integer width;
    private Integer height;
    private String format;
    private Integer fsize;
    private Integer duration = Integer.valueOf(-1);
    private String hash;
    private Map<String, String> extras;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Long getMedia_crc32() {
        return media_crc32;
    }

    public void setMedia_crc32(Long media_crc32) {
        this.media_crc32 = media_crc32;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getFsize() {
        return fsize;
    }

    public void setFsize(Integer fsize) {
        this.fsize = fsize;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Map<String, String> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, String> extras) {
        this.extras = extras;
    }
}
