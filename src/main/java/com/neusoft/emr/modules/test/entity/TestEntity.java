package com.neusoft.emr.modules.test.entity;

import com.neusoft.emr.common.persistence.BaseEntity;

/**
 *
 * Created by Administrator on 2016/5/11 0011.
 */
public class TestEntity extends BaseEntity<TestEntity> {


    private String name;//测试数据

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
