package com.neusoft.emr.modules.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.neusoft.emr.common.persistence.BaseEntity;

import java.util.List;

/**
 * 控制台菜单（表名emr_system_kzt）
 * Created by Administrator on 2016/5/15 0015.
 */
public class Menu extends BaseEntity<Menu> {

    private static final long serialVersionUID = 1L;

    private String jdmc;//节点名称
    private String jddh;//节点代号
    private String pid;//直接父节点id
    private String pids;//所有父节点id
    private String href;//访问地址
    private String pyszm;//拼音首字母
    private Integer sort;//排序号
    private Menu parent;//父节点对象

    private List<Operation> operations = Lists.newArrayList();//按钮级操作权限列表

    public String getJdmc() {
        return jdmc;
    }

    public void setJdmc(String jdmc) {
        this.jdmc = jdmc;
    }

    public String getJddh() {
        return jddh;
    }

    public void setJddh(String jddh) {
        this.jddh = jddh;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPyszm() {
        return pyszm;
    }

    public void setPyszm(String pyszm) {
        this.pyszm = pyszm;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @JsonIgnore
    public static String getRootId(){
        return "1";
    }

    /**
     *筛选父节点的子节点
     **/
    @JsonIgnore
    public static void sortList(List<Menu> list, List<Menu> sourcelist, String parentId, boolean cascade){
        for (int i=0; i<sourcelist.size(); i++){
            Menu e = sourcelist.get(i);
            if (e.getPid()!=null && e.getParent().getGuid()!=null
                    && e.getParent().getGuid().equals(parentId)){
                list.add(e);
                if (cascade){
                    // 判断是否还有子节点, 有则继续获取子节点
                    for (int j=0; j<sourcelist.size(); j++){
                        Menu child = sourcelist.get(j);
                        if (child.getParent()!=null && child.getParent().getGuid()!=null
                                && child.getParent().getGuid().equals(e.getGuid())){
                            sortList(list, sourcelist, e.getGuid(), true);
                            break;
                        }
                    }
                }
            }
        }
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }
}
