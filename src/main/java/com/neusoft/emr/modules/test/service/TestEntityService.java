package com.neusoft.emr.modules.test.service;

import com.neusoft.emr.common.service.BaseService;
import com.neusoft.emr.modules.test.dao.TestDao;
import com.neusoft.emr.modules.test.entity.TestEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试用service
 * Created by Administrator on 2016/5/12 0012.
 */
@Service
@Transactional(readOnly = true)
public class TestEntityService extends BaseService<TestDao,TestEntity> {


    public void testSave(TestEntity te){

        te.preInsert();
        System.out.println(te.getCjr().getDlm());

    }

}
