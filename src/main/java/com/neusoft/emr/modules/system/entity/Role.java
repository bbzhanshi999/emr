package com.neusoft.emr.modules.system.entity;

import com.google.common.collect.Lists;
import com.neusoft.emr.common.persistence.BaseEntity;
import com.neusoft.emr.modules.basic.entity.Office;
import com.neusoft.emr.modules.basic.entity.Organization;

import java.util.List;

/**
 * 角色对象（表名emr_permission_js）
 * Created by zql on 2016/5/15 0015.
 */
public class Role extends BaseEntity<Role> {

    private static final long serialVersionUID = 1L;

    public static final String KEY_CURRROLE ="currRole";
    public static final String KEY_ROLES ="roles";
    public static final String KEY_HAS_DEFUALT="hasDefault";


    public static final String DEFAULT_ROLE_NOT = "N";
    public static final String DEFAULT_ROLE_IS = "Y";

    public static final String JSLB_LCYS = "1";//临床医生
    public static final String JSLB_ZKYS = "2";//质控医生
    public static final String JSLB_ADMIN = "3";//管理员

    private String jsm;//   角色名
    private String jslb;//  角色类别
    private String jsdh;//  角色代号
    private Organization ssjg;//  所属机构
    private String pyszm;// 拼音首字母

    private String mrbjw=DEFAULT_ROLE_NOT;//默认角色标记(如果不设置就为否)

    private List<PatientList> patientLists = Lists.newArrayList();//患者清单选项
    private List<Menu> menuList = Lists.newArrayList();//菜单权限list
    private List<Office> officeList = Lists.newArrayList();//科室数据范围

    public String getJsm() {
        return jsm;
    }

    public void setJsm(String jsm) {
        this.jsm = jsm;
    }

    public String getJslb() {
        return jslb;
    }

    public void setJslb(String jslb) {
        this.jslb = jslb;
    }

    public String getJsdh() {
        return jsdh;
    }

    public void setJsdh(String jsdh) {
        this.jsdh = jsdh;
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

    public List<PatientList> getPatientLists() {
        return patientLists;
    }

    public void setPatientLists(List<PatientList> patientLists) {
        this.patientLists = patientLists;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Office> getOfficeList() {
        return officeList;
    }

    public void setOfficeList(List<Office> officeList) {
        this.officeList = officeList;
    }

    public String getMrbjw() {
        return mrbjw;
    }

    public void setMrbjw(String mrbjw) {
        this.mrbjw = mrbjw;
    }
}
