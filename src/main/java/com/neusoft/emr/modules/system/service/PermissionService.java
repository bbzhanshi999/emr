package com.neusoft.emr.modules.system.service;

import com.neusoft.emr.common.utils.SessionCacheUtils;
import com.neusoft.emr.common.utils.UserUtils;
import com.neusoft.emr.modules.basic.dao.OfficeDao;
import com.neusoft.emr.modules.system.dao.RoleDao;
import com.neusoft.emr.modules.system.entity.User;
import com.neusoft.emr.modules.system.viewEntity.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 权限相关服务
 * Created by zql on 2016/5/17 0017.
 */
@Service
@Transactional(readOnly = true)
public class PermissionService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    OfficeDao officeDao;




    /**
     * 首页角色数据生成
     * @param user
     * @return
     */
    public List<RoleQueryVo> getRolesView(User user){

        RoleQueryVo roleQueryVo = new RoleQueryVo();
        roleQueryVo.setBelongUser_guid(user.getGuid());

        List<RoleQueryVo> roleViews = roleDao.getViewList(roleQueryVo);


        return roleViews;
    }


    /**
     * 获得角色信息
     * @param glGuid
     * @return
     */
    public RoleQueryVo getRoleView(String glGuid){
        RoleQueryVo result=null;
        HttpSession session = SessionCacheUtils.getSession();

        //从缓存中获取
        List<RoleQueryVo>roles = (List<RoleQueryVo>) session.getAttribute(RoleQueryVo.KEY_ROLES);
        if(roles!=null){
            for(RoleQueryVo role:roles){
                if(glGuid.equals(role.getGlGuid())){
                    result = role;
                    break;
                }
            }
        }

        //从数据库中获取
        if(result==null){
            result = roleDao.getRoleView(glGuid);
        }

        return result;
    }



}
