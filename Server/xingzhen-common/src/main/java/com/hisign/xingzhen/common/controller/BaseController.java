package com.hisign.xingzhen.common.controller;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseController {

    public static ThreadLocal<HttpServletRequest> Thread_Local_Request = new ThreadLocal<HttpServletRequest>();
    public static ThreadLocal<HttpServletResponse> Thread_Local_Response = new ThreadLocal<HttpServletResponse>();

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

    public static HttpServletRequest getRequest() {

        return Thread_Local_Request.get();
    }

    public static void setRequest(HttpServletRequest request) {

        Thread_Local_Request.set(request);
    }

    public static void removeRequest() {

        Thread_Local_Request.remove();
    }

    public static HttpServletResponse getResponse() {

        return Thread_Local_Response.get();
    }

    public static void setResponse(HttpServletResponse response) {

        Thread_Local_Response.set(response);
    }

    public static void removeResponse() {

        Thread_Local_Response.remove();
    }
}
