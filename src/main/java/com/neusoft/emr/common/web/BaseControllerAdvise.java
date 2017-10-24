package com.neusoft.emr.common.web;

import com.neusoft.emr.modules.system.entity.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;



/**
 * controller共用数据注入
 * Created by Administrator on 2016/5/13 0013.
 */
//@ControllerAdvice
public class BaseControllerAdvise {


    /**
     * 获取当前用户，并添加入model
     * @param session
     * @return
     */
    @ModelAttribute
    public User getCurrentUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        user = user==null?new User():user;
        return user;
    }




}
