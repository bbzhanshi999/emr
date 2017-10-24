package com.neusoft.emr.modules.basic.entity;

import com.neusoft.emr.common.persistence.BaseEntity;

/**
 * 科室信息表（emr_basic_ksxx）
 * Created by zql on 2016/5/15 0015.
 */
public class Office extends BaseEntity<Office> {

    private static final long serialVersionUID = 1L;

    private String ksmc;//科室名称
    private String ksbh;//科室编号
    private String ksywm;//科室英文名
    private String ksfzr;//科室负责人
    private String pyszm;//拼音首字母

    private Organization ssjg;//所属机构

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getKsbh() {
        return ksbh;
    }

    public void setKsbh(String ksbh) {
        this.ksbh = ksbh;
    }

    public String getKsywm() {
        return ksywm;
    }

    public void setKsywm(String ksywm) {
        this.ksywm = ksywm;
    }

    public String getKsfzr() {
        return ksfzr;
    }

    public void setKsfzr(String ksfzr) {
        this.ksfzr = ksfzr;
    }

    public String getPyszm() {
        return pyszm;
    }

    public void setPyszm(String pyszm) {
        this.pyszm = pyszm;
    }

    public Organization getSsjg() {
        return ssjg;
    }

    public void setSsjg(Organization ssjg) {
        this.ssjg = ssjg;
    }
}
