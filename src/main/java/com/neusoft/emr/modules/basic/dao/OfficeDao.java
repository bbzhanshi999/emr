package com.neusoft.emr.modules.basic.dao;

import com.neusoft.emr.common.annotation.MyBatisDao;
import com.neusoft.emr.common.persistence.BaseDao;
import com.neusoft.emr.modules.basic.entity.Office;

import java.util.List;
import java.util.Map;

/**
 * 科室dao
 * Created by zql on 2016/5/17 0017.
 */
@MyBatisDao
public interface OfficeDao extends BaseDao<Office> {


    List<Office> getOfficesByUser(Map<String, Object> officeQuery);
}
