package com.neusoft.emr.modules.basic.entity;

/**
 * 病区对象
 * Created by zql on 2016/5/19 0019.
 */
public class WardArea {

    private static final long serialVersionUID = 1L;

    private String bqmc;//病区名称
    private String bqbh;//病区编号
    private Organization ssjg;//所属机构
    private Office ssks;//所属科室
    private String bqfzr;//病区负责人
    private String pyszm;//拼音首字母

    public String getBqmc() {
        return bqmc;
    }

    public void setBqmc(String bqmc) {
        this.bqmc = bqmc;
    }

    public String getBqbh() {
        return bqbh;
    }

    public void setBqbh(String bqbh) {
        this.bqbh = bqbh;
    }

    public Organization getSsjg() {
        return ssjg;
    }

    public void setSsjg(Organization ssjg) {
        this.ssjg = ssjg;
    }

    public Office getSsks() {
        return ssks;
    }

    public void setSsks(Office ssks) {
        this.ssks = ssks;
    }

    public String getBqfzr() {
        return bqfzr;
    }

    public void setBqfzr(String bqfzr) {
        this.bqfzr = bqfzr;
    }

    public String getPyszm() {
        return pyszm;
    }

    public void setPyszm(String pyszm) {
        this.pyszm = pyszm;
    }
}
