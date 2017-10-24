package com.neusoft.emr.modules.system.service;

import com.neusoft.emr.common.service.BaseService;
import com.neusoft.emr.modules.system.dao.MenuDao;
import com.neusoft.emr.modules.system.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 控制台菜单service
 * Created by zql on 2016/5/17 0017.
 */
@Service
@Transactional(readOnly = true)
public class MenuService extends BaseService<MenuDao,Menu> {

    @Autowired
    private MenuDao menuDao;



}
