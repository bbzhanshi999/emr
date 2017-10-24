package com.neusoft.emr.modules.basic.entity;

import com.neusoft.emr.common.persistence.BaseEntity;

/**
 * 机构对象（表名emr_basic_jgxx）
 * Created by zql on 2016/5/15 0015.
 */
public class Organization extends BaseEntity<Organization> {

    private static final long serialVersionUID = 1L;

    private String sjjgid;//上级机构id
    private String jgmc;//机构名称
    private String jgjc;//机构简称
    private String jgywm;//机构英文名
    private String jgywjc;//机构英文简称
    private String jgjb;//机构级别
    private String jgdz;//机构地址
    private String zzjgdm;//组织机构代码
    private String logourl;//logo图片url
    private String jgbh;//机构编号
    private String pyszm;//拼音首字母
    private Organization sjjg;//上级机构

    public Organization getSjjg() {
        return sjjg;
    }

    public void setSjjg(Organization sjjg) {
        this.sjjg = sjjg;
    }

    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }

    public String getJgjc() {
        return jgjc;
    }

    public void setJgjc(String jgjc) {
        this.jgjc = jgjc;
    }

    public String getJgywm() {
        return jgywm;
    }

    public void setJgywm(String jgywm) {
        this.jgywm = jgywm;
    }

    public String getJgywjc() {
        return jgywjc;
    }

    public void setJgywjc(String jgywjc) {
        this.jgywjc = jgywjc;
    }

    public String getJgjb() {
        return jgjb;
    }

    public void setJgjb(String jgjb) {
        this.jgjb = jgjb;
    }

    public String getJgdz() {
        return jgdz;
    }

    public void setJgdz(String jgdz) {
        this.jgdz = jgdz;
    }

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    public String getJgbh() {
        return jgbh;
    }

    public void setJgbh(String jgbh) {
        this.jgbh = jgbh;
    }

    public String getPyszm() {
        return pyszm;
    }

    public void setPyszm(String pyszm) {
        this.pyszm = pyszm;
    }


    public String getSjjgid() {
        return sjjgid;
    }

    public void setSjjgid(String sjjgid) {
        this.sjjgid = sjjgid;
    }
}
