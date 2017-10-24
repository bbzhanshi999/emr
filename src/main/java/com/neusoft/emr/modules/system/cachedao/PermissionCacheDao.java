package com.neusoft.emr.modules.system.cachedao;

import com.neusoft.emr.common.utils.JedisUtils;
import com.neusoft.emr.modules.system.dao.PatientListDao;
import com.neusoft.emr.modules.system.entity.Menu;
import com.neusoft.emr.modules.system.entity.PatientList;
import com.neusoft.emr.modules.system.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 权限相关类缓存获取dao
 * Created by zql on 2016/5/19 0019.
 */
public class PermissionCacheDao {

    public static String KEY_ROLE_INFO = "roleInfo";

    protected static Logger logger = LoggerFactory.getLogger(PermissionCacheDao.class);

    @Autowired
    private PatientListDao patientListDao;

    


    /**
     * 获得角色患者清单
     * @param roleId
     * @return
     */
    public static List<PatientList>  getPatientLists(String roleId){
        List<PatientList> patientLists= null;
        try {
            Role role = (Role) JedisUtils.hget(KEY_ROLE_INFO,roleId);
            patientLists = role.getPatientLists();
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return patientLists;

    }


    /**
     * 获得角色的菜单权限
     * @param roleId
     * @return
     */
    public static List<Menu> getMenus(String roleId){
        List<Menu>  menus = null;
        try {
            Role role = (Role) JedisUtils.hget(KEY_ROLE_INFO,roleId);
            menus = role.getMenuList();
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return menus;
    }
}
