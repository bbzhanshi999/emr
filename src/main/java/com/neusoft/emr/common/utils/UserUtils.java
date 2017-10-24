package com.neusoft.emr.common.utils;

import com.google.common.collect.Maps;
import com.neusoft.emr.modules.basic.entity.UserInfo;
import com.neusoft.emr.modules.system.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户工具类
 * Created by Administrator on 2016/5/3 0003.
 */
public class UserUtils {

    public static final String KEY_ACTIVE_USERS = "activeUsers";

    protected static Logger logger = LoggerFactory.getLogger(UserUtils.class);





    /**
     * 从当前线程当中获取线程user
     * @return
     */
    public static User getUser() {



        User user = (User)((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getAttribute("user");
        return user;
    }

    /**
     * 从当前线程当中获取线程userInfo
     * @return
     */
    public static UserInfo getUserInfo() {

        UserInfo userInfo = (UserInfo)((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession().getAttribute("userInfo");
        return userInfo;
    }

    /**
     * 根据guid获取在线用户
     * @param guid
     * @return
     */
    public static User getActiveUser(String guid){

        User user =null ;
        try {
            user = (User)JedisUtils.hget(KEY_ACTIVE_USERS,guid);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        return user;
    }


    /**
     * 根据guid获取在线用户信息
     * @param guid
     * @return
     */
    public static UserInfo getUserInfo(String guid){

        User user =null ;
        UserInfo userInfo = null;
        try {
            user = (User)JedisUtils.hget(KEY_ACTIVE_USERS,guid);
            userInfo = user.getUserInfo();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        return userInfo;
    }

    /**
     * 验证用户是否在线
     * @param guid
     * @return
     */
    public static boolean exists(String guid){
        return JedisUtils.hexists(KEY_ACTIVE_USERS,guid);
    }

    /**
     * 移除当前在线用户
     */
    public static void logoutUser(){

        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        String userid = getUser().getGuid();
        JedisUtils.hdel(KEY_ACTIVE_USERS,userid);
        session.removeAttribute("user");
        session.removeAttribute("userInfo");
        session.invalidate();

    }

    /**
     * 移除指定用户
     * @param guid
     */
    public static void logoutUser(String guid,String sessionId){

        JedisUtils.hdel(KEY_ACTIVE_USERS,guid);

        // TODO: 2016/5/19 0019 指定用户退出在线状态(根据sessionid找到session并使其失效)
    }

    /**
     * 获取所有在线用户
     * @return
     */
    public static Map<String, Object> getActiveUsers() {


        Map<String, Object> activeUsers = JedisUtils.getObjectMap(KEY_ACTIVE_USERS);
        return activeUsers;
    }


    /**
     * 添加在线用户
     * @param user
     */
    public static void addUser(User user){

        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        session.setAttribute("user", user);
        session.setAttribute("userInfo", user.getUserInfo());

        long result = JedisUtils.hset(KEY_ACTIVE_USERS,user.getGuid(),user);
        logger.debug("addUser {},{}",user.getGuid(),String.valueOf(result));
    }







}
