package com.neusoft.emr.modules.basic.entity;

import com.neusoft.emr.common.persistence.BaseEntity;

/**
 * 职称对象
 * Created by zql on 2016/5/17 0017.
 */
public class JobTitle extends BaseEntity<JobTitle> {

    private static final long serialVersionUID = 1L;

    private String zcmc;//职称名称
    private String zcbh;//职称编号
    private String pyszm;//拼音首字母

    public String getZcmc() {
        return zcmc;
    }

    public void setZcmc(String zcmc) {
        this.zcmc = zcmc;
    }

    public String getZcbh() {
        return zcbh;
    }

    public void setZcbh(String zcbh) {
        this.zcbh = zcbh;
    }

    public String getPyszm() {
        return pyszm;
    }

    public void setPyszm(String pyszm) {
        this.pyszm = pyszm;
    }

    public Integer getZcjb() {
        return zcjb;
    }

    public void setZcjb(Integer zcjb) {
        this.zcjb = zcjb;
    }

    private Integer zcjb;//职称级别
}
