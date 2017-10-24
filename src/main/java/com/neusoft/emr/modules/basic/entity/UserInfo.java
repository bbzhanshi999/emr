package com.neusoft.emr.modules.basic.entity;

import com.neusoft.emr.common.persistence.BaseEntity;
import com.neusoft.emr.modules.system.entity.User;

/**
 * 用户基本信息（表名emr_basic_ygjbxx）
 * Created by Administrator on 2016/5/13 0013.
 */
public class UserInfo extends BaseEntity<UserInfo> {

    // TODO: 2016/5/19 0019 将ssjg，ssks，ssbq修改成对象 
    private static final long serialVersionUID = 1L;
    private String ssjg;//所属机构
    private String ssks;//所属科室
    private String ssbq;//所属病区
    private String zc;//职称
    private String yglx;//员工类型
    private String xm;//姓名
    private String xb;//性别
    private String sfzhm;//身份证号码
    private String lxdh;//联系电话
    private String ygbh;//员工编号
    private String pyszm;//拼音首字母
    private User user;//员工登录信息

    public String getSsjg() {
        return ssjg;
    }

    public void setSsjg(String ssjg) {
        this.ssjg = ssjg;
    }

    public String getSsks() {
        return ssks;
    }

    public void setSsks(String ssks) {
        this.ssks = ssks;
    }

    public String getSsbq() {
        return ssbq;
    }

    public void setSsbq(String ssbq) {
        this.ssbq = ssbq;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    public String getYglx() {
        return yglx;
    }

    public void setYglx(String yglx) {
        this.yglx = yglx;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getSfzhm() {
        return sfzhm;
    }

    public void setSfzhm(String sfzhm) {
        this.sfzhm = sfzhm;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getPyszm() {
        return pyszm;
    }

    public void setPyszm(String pyszm) {
        this.pyszm = pyszm;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getYgbh() {
        return ygbh;
    }

    public void setYgbh(String ygbh) {
        this.ygbh = ygbh;
    }
}
