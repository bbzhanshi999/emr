package com.neusoft.emr.modules.system.dao;

import com.neusoft.emr.common.annotation.MyBatisDao;
import com.neusoft.emr.common.persistence.BaseDao;
import com.neusoft.emr.modules.system.entity.Role;
import com.neusoft.emr.modules.system.viewEntity.RoleQueryVo;

import java.util.List;

/**
 * 角色dao
 * Created by zql on 2016/5/17 0017.
 */
@MyBatisDao
public interface RoleDao extends BaseDao<Role> {

    List<Role> findRolesByUserId(String guid);


    List<RoleQueryVo> getViewList(RoleQueryVo role);

    RoleQueryVo getRoleView(String glGuid);
}
