package com.neusoft.emr.modules.system.viewEntity;

import com.neusoft.emr.modules.basic.entity.Office;
import com.neusoft.emr.modules.system.entity.Role;
import com.neusoft.emr.modules.system.entity.User;

/**
 * 用户角色数据展示查询Bean
 * Created by zql on 2016/5/17 0017.
 */
public class RoleQueryVo extends Role {

    private static final long serialVersionUID = 1L;




    private String glGuid;//科室角色员工关联id

    public String getGlGuid() {
        return glGuid;
    }

    public void setGlGuid(String glGuid) {
        this.glGuid = glGuid;
    }

    private String jsksmc;//角色科室名称
    private String iconCls;//图标class
    private String ks_guid;//科室id
    private String ksmc;//科室名称
    private String ksbh;//科室编号
    private String ksywm;//科室英文名
    private String ksfzr;//科室负责人

    private String belongUser_guid;//员工id

    private User belongUser;//角色所属用户
    private Office ks;//科室



    public String getKsmc() {
        return ksmc;
    }

    public String getKs_guid() {
        return ks_guid;
    }

    public void setKs_guid(String ks_guid) {
        this.ks_guid = ks_guid;
    }

    public String getBelongUser_guid() {
        return belongUser_guid;
    }

    public void setBelongUser_guid(String belongUser_guid) {
        this.belongUser_guid = belongUser_guid;
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

    public User getBelongUser() {
        return belongUser;
    }

    public void setBelongUser(User belongUser) {
        this.belongUser = belongUser;
    }

    public Office getKs() {
        return ks;
    }

    public void setKs(Office ks) {
        this.ks = ks;
    }

    public String getJsksmc() {
        return jsksmc;
    }

    public void setJsksmc(String jsksmc) {
        this.jsksmc = jsksmc;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
}
