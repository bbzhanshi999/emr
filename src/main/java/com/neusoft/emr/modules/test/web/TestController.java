package com.neusoft.emr.modules.test.web;

import com.neusoft.emr.common.web.BaseController;
import com.neusoft.emr.modules.test.entity.TestEntity;
import com.neusoft.emr.modules.test.service.TestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试用controller
 * Created by Administrator on 2016/5/12 0012.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    TestEntityService service;


    @ResponseBody
    @RequestMapping(value = "/getTest")
    public String getTest(String guid) {

        return null;
    }

    @RequestMapping(value = "/save")
    public void save(){
        service.testSave(new TestEntity());

    }
}
