package com.neusoft.emr.modules.system.dao;

import com.neusoft.emr.common.annotation.MyBatisDao;
import com.neusoft.emr.common.persistence.BaseDao;
import com.neusoft.emr.modules.system.entity.PatientList;

import java.util.List;

/**
 * 患者清单dao
 * Created by zql on 2016/5/24 0024.
 */
@MyBatisDao
public interface PatientListDao extends BaseDao<PatientList>{

    List<PatientList> findList(String roleId);
}
