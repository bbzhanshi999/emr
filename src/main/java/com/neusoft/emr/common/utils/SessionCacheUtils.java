package com.neusoft.emr.common.utils;

import com.neusoft.emr.modules.system.viewEntity.RoleQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * session缓存读取工具,获取权限个人信息的简单封装
 * Created by zql on 2016/5/19 0019.
 */
public class SessionCacheUtils {


    protected static Logger logger = LoggerFactory.getLogger(SessionCacheUtils.class);



    /**
     * 获得当前线程的session
     * @return
     */
    public static HttpSession getSession(){

        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
    }


    /**
     * 获取当前角色
     * @return
     */
    public static RoleQueryVo getCurrentRole(){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        RoleQueryVo roleQueryVo = (RoleQueryVo) session.getAttribute(RoleQueryVo.KEY_CURRROLE);
        return roleQueryVo;
    }

    /**
     * 获取当前角色
     * @param session
     * @return
     */
    public static RoleQueryVo getCurrentRole(HttpSession session){
        RoleQueryVo roleQueryVo = (RoleQueryVo) session.getAttribute(RoleQueryVo.KEY_CURRROLE);
        return roleQueryVo;
    }

    /**
     * 获取当前用户的角色列表
     * @return
     */
    public static List<RoleQueryVo> getRoles(){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        List<RoleQueryVo> roles = (List<RoleQueryVo>)session.getAttribute(RoleQueryVo.KEY_ROLES);
        return roles;
    }

    /**
     * 获取当前用户的角色列表,传入session
     * @param session
     * @return
     */
    public static List<RoleQueryVo> getRoles(HttpSession session){
        List<RoleQueryVo> roles = (List<RoleQueryVo>)session.getAttribute(RoleQueryVo.KEY_ROLES);
        return roles;
    }

    /**
     * 设置当前角色
     */
    public static void setCurrentRole(RoleQueryVo role){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.setAttribute(RoleQueryVo.KEY_CURRROLE,role);
    }

    /**
     * 设置当前角色
     */
    public static void setCurrentRole(RoleQueryVo role,HttpSession session){
        session.setAttribute(RoleQueryVo.KEY_CURRROLE,role);
    }

    /**
     * 设置角色组
     * @param roles
     */
    public static void setRoles(List<RoleQueryVo> roles){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.setAttribute(RoleQueryVo.KEY_ROLES,roles);

    }

    /**
     * 设置角色组
     * @param roles
     */
    public static void setRoles(List<RoleQueryVo> roles,HttpSession session){
        session.setAttribute(RoleQueryVo.KEY_ROLES,roles);

    }

}
