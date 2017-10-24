package com.neusoft.emr.modules.system.service;

import com.neusoft.emr.common.utils.*;
import com.neusoft.emr.modules.basic.entity.UserInfo;
import com.neusoft.emr.modules.system.dao.UserDao;
import com.neusoft.emr.modules.system.entity.Role;
import com.neusoft.emr.modules.system.entity.User;
import com.neusoft.emr.modules.system.viewEntity.RoleQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、控制台菜单、患者清单
 * Created by zql on 2016/5/15 0015.
 */

@Service
@Transactional(readOnly = true)
public class SystemService {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserDao userDao;

    @Autowired
    PermissionService permissionService;

    /**
     * 登录权限判断
     * @param session
     * @param username
     * @param password
     * @param code
     * @return
     */
    public Map<String, Object> toLogin(HttpSession session, String username, String password, String code) {

        Map<String, Object> map = new HashMap<String, Object>();
        User user;


        if (session.getAttribute("validateCode").equals(code)) {
            user = userDao.get(new User(username));
            String pswd = user.getDlmm();
            boolean fl = false;
            if (StringUtils.isNotBlank(pswd)) {
                try {
                    fl = PasswordHash.validatePassword(password, pswd);
                } catch (NoSuchAlgorithmException e1) {
                    logger.error(Exceptions.getStackTraceAsString(e1));
                } catch (InvalidKeySpecException e1) {
                    logger.error(Exceptions.getStackTraceAsString(e1));
                }
            }

            if (fl) {
                map.put("username", username);
                if (user.getGuid()!=null) {
                    map.put("success", true);
                    UserInfo userInfo = userDao.getUserView(user.getGuid());
                    user.setUserInfo(userInfo);

                    //将user存入缓存session
                    UserUtils.addUser(user);

                    List<RoleQueryVo> rolesViews = permissionService.getRolesView(user);
                    if(rolesViews.size()>0){
                        Boolean hasDefault = false;
                        for(RoleQueryVo role:rolesViews){

                            //如果有默认角色，就直接进入首页
                            if(Role.DEFAULT_ROLE_IS.equals(role.getMrbjw())){
                                SessionCacheUtils.setCurrentRole(role,session);//存入缓存session
                                map.put(RoleQueryVo.KEY_CURRROLE,role);
                                hasDefault =true;
                                map.put(RoleQueryVo.KEY_HAS_DEFUALT,hasDefault);
                                break;
                            }
                        }

                        if(!hasDefault){
                            map.put(RoleQueryVo.KEY_ROLES,rolesViews);//用于前台展示所有角色，供用户选择
                        }

                        SessionCacheUtils.setRoles(rolesViews,session);//将用户角色信息存入session
                    }



                } else {
                    map.clear();
                    map.put("roleError", true);
                }
            } else {
                map.clear();
                map.put("accountError", true);
            }
        } else {
            map.clear();
            map.put("codeError", true);
        }

        return map;
    }


    /**
     * 更新密码
     * @param username
     * @param passWord
     * @return
     */
    public Map<String, Object> updatePassword(String username, String passWord) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user;
        user = userDao.get(new User(username));
        String pswd = user.getDlmm();
        boolean fl = false;
        if (StringUtils.isNotBlank(pswd)) {
            try {
                fl = PasswordHash.validatePassword(passWord, pswd);
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
                logger.error(Exceptions.getStackTraceAsString(e1));
            } catch (InvalidKeySpecException e1) {
                e1.printStackTrace();
                logger.error(Exceptions.getStackTraceAsString(e1));
            }
        }

        if (fl) {
            map.put("username", username);
            if (user.getGuid()!=null) {
                map.clear();
                map.put("success", true);
            }
        } else {
            map.clear();
            map.put("accountError", true);
        }

        return map;
    }


    /**
     * 修改密码
     * @param password
     * @param guid
     * @return
     */
    public Map<String, Object> changepwd(String password, String guid) {
        Map<String, Object> map = new HashMap<String, Object>();
        User userQuery = new User();
        userQuery.setGuid(guid);
        User user = userDao.get(userQuery);
        try {
            user.setDlmm(PasswordHash.createHash(password));

        } catch (NoSuchAlgorithmException e) {
            logger.error(Exceptions.getStackTraceAsString(e));
        } catch (InvalidKeySpecException e) {
            logger.error(Exceptions.getStackTraceAsString(e));
        }
        userDao.update(user);
        map.put("success", true);
        return map;
    }





}
