package com.hisign.xingzhen.interceptor;

import com.hisign.bfun.bif.BaseRest;
import com.hisign.xingzhen.common.controller.BaseController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hisign on 2017/10/23.
 */
public class RequestInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        BaseController.setRequest(request);
        BaseController.setResponse(response);
        BaseRest.setRequest(request);
        BaseRest.setResponse(response);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseController.removeRequest();
        BaseController.removeResponse();
        BaseRest.removeRequest();
        BaseRest.removeResponse();
    }
}
