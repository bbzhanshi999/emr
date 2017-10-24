package com.neusoft.emr.modules.basic.service;

import com.neusoft.emr.modules.basic.dao.OfficeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 基础数据服务
 * Created by zql on 2016/5/18 0018.
 */
@Service
public class BasicService {

    @Autowired
    OfficeDao officeDao;



}
