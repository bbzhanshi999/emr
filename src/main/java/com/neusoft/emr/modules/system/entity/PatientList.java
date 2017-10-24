package com.neusoft.emr.modules.system.entity;

import com.neusoft.emr.common.persistence.BaseEntity;

/**
 * 患者清单（emr_system_kzqd）
 * Created by zql on 2016/5/15 0015.
 */
public class PatientList extends BaseEntity<PatientList> {

    private static final long serialVersionUID = 1L;

    private String xxmc;//选项代号
    private String xxdh;//选项名称
    private String pyszm;//拼音首字母

    

    public String getXxmc() {
        return xxmc;
    }

    public void setXxmc(String xxmc) {
        this.xxmc = xxmc;
    }

    public String getXxdh() {
        return xxdh;
    }

    public void setXxdh(String xxdh) {
        this.xxdh = xxdh;
    }

    public String getPyszm() {
        return pyszm;
    }

    public void setPyszm(String pyszm) {
        this.pyszm = pyszm;
    }
}
