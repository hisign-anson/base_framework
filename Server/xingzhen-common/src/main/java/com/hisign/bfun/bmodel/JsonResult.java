package com.hisign.bfun.bmodel;

import com.alibaba.fastjson.JSONObject;
import com.hisign.bfun.butils.JsonResultUtil;

import java.io.Serializable;


/**
 * @author liangqifu
 *
 * 2017年3月29日
 */
public class JsonResult implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7340315340554307697L;

	/**
     * 返回信息标志
     */
    private int flag;
    
    /**
     * 返回错误码
     */
    private int code;

    /**
     * 返回总条数
     */
    private long totalCount;
    
    /**
     * 错误信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public int getFlag() {
        return flag;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess(){
        return this.flag== JsonResultUtil.SUCCESS;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
