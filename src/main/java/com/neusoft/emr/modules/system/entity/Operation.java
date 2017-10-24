package com.neusoft.emr.modules.system.entity;

import com.neusoft.emr.common.persistence.BaseEntity;

/**
 * 操作对象,如插入，修改，删除，审核等
 * Created by zql on 2016/5/15 0015.
 */
public class Operation extends BaseEntity<Operation> {

    private static final long serialVersionUID = 1L;

    private String kjmc;//控件名称
    private String kjlx;//控件类型
    private String kjbh;//控件编号
    private String icon;//控件图标

    public String getKjmc() {
        return kjmc;
    }

    public void setKjmc(String kjmc) {
        this.kjmc = kjmc;
    }

    public String getKjlx() {
        return kjlx;
    }

    public void setKjlx(String kjlx) {
        this.kjlx = kjlx;
    }

    public String getKjbh() {
        return kjbh;
    }

    public void setKjbh(String kjbh) {
        this.kjbh = kjbh;
    }

    public String getPyszm() {
        return pyszm;
    }

    public void setPyszm(String pyszm) {
        this.pyszm = pyszm;
    }

    private String pyszm;


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
