package com.neusoft.emr.modules.system.dao;

import com.neusoft.emr.common.annotation.MyBatisDao;
import com.neusoft.emr.common.persistence.BaseDao;
import com.neusoft.emr.modules.basic.entity.UserInfo;
import com.neusoft.emr.modules.system.entity.User;

/**
 * 用户dao
 * Created by zql on 2016/5/16 0016.
 */
@MyBatisDao
public interface UserDao extends BaseDao<User> {


    UserInfo getUserView(String guid);
}
