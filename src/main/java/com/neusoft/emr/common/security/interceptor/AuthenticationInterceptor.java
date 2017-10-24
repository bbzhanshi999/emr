package com.neusoft.emr.common.security.interceptor;


import com.neusoft.emr.modules.system.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制拦截器
 * Created by Administrator on 2016/5/13 0013.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        User user = (User) request.getSession().getAttribute("user");

        if(user!=null){
            return true;
        }

        //request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/sys/logout");
        return false;
    }
}
