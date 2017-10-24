package com.neusoft.emr.modules.system.entity;

import com.google.common.collect.Lists;
import com.neusoft.emr.common.persistence.BaseEntity;
import com.neusoft.emr.modules.basic.entity.UserInfo;

import java.util.List;

/**
 * 用户（表名emr_system_ygdlxx）
 * Created by zql on 2016/5/3 0003.
 */
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;
    private String dlm;//登录名
    private String dlmm;//登录密码
    private String yxdz;//邮箱地址
    private String gh ;//工号
    private UserInfo userInfo;//员工基本信息
    private List<Role> roles = Lists.newArrayList();//员工角色列表

    public User(){super();}

    public User(String dlm){
        super();
        this.dlm = dlm;
    }


    public String getDlm() {
        return dlm;
    }

    public void setDlm(String dlm) {
        this.dlm = dlm;
    }

    public String getDlmm() {
        return dlmm;
    }

    public void setDlmm(String dlmm) {
        this.dlmm = dlmm;
    }

    public String getYxdz() {
        return yxdz;
    }

    public void setYxdz(String yxdz) {
        this.yxdz = yxdz;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
