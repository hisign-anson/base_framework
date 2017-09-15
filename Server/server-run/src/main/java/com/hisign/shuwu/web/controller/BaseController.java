package com.hisign.shuwu.web.controller;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;


public class BaseController {

	public static JsonResult success(long totalCount, Object data) {
		JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag(JsonResultUtil.SUCCESS);
        jsonResult.setTotalCount(totalCount);
        jsonResult.setData(data);
        return jsonResult;
    }

    /**
     * 成功返回结果
     *
     * @param data
     * @return
     */
    public static JsonResult success(Object data) {
    	JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag(JsonResultUtil.SUCCESS);
        jsonResult.setData(data);
        return jsonResult;
    }

    /**
     * 成功返回结果
     *
     * @return
     */
    public static JsonResult success() {
    	JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag(JsonResultUtil.SUCCESS);
        return jsonResult;
    }

    /**
     * 失败返回结果
     *
     * @param msg
     * @return
     */
    public static JsonResult error(String msg) {
    	JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag(JsonResultUtil.ERROR);
        jsonResult.setMsg(msg);
        return jsonResult;
    }
}
