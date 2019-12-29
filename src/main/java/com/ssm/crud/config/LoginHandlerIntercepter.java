package com.ssm.crud.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */

public class LoginHandlerIntercepter implements HandlerInterceptor {

    //方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        System.out.println(username == null);
        if (username == null){
            //未登录
            System.out.println(request.getServletPath());
            request.setAttribute("msg","没有权限登录");
            request.getRequestDispatcher("/").forward(request,response);
            System.out.println("拦截....");
            return false;
        }else {
            //以登录
            return true;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
