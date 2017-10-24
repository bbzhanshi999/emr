package com.neusoft.emr.modules.system.entity;

import com.neusoft.emr.common.persistence.BaseEntity;
import com.neusoft.emr.common.utils.Reflections;
import com.neusoft.emr.common.utils.StringUtils;
import org.hibernate.validator.constraints.Length;

/**
 * 地区表（emr_system_dq）
 * Created by zql on 2016/5/15 0015.
 */
public class Area extends BaseEntity<Area> {

    private static final long serialVersionUID = 1L;
	private String pids; // 所有父级编号
    private Area parent;//父节点对象
    private String pid; // 父级编号
    private String dqbm;    // 区域编码
    private String dm; 	// 区域名称
    private Integer sort;		// 排序
    private String zl;    // 区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）




    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        if (parent != null) {
            pid = (String) Reflections.getFieldValue(parent, "guid");
        }
        return StringUtils.isNotBlank(pid) ? pid : "0";
    }


    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }


    public Area() {
        super();
        this.sort = 30;
    }

    public Area(String id) {
        super(id);
    }

    //	@JsonBackReference
//	@NotNull
    public Area getParent() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }


    @Length(min = 1, max = 1)
    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl;
    }

    @Length(min = 0, max = 100)
    public String getDqbm() {
        return dqbm;
    }

    public void setDqbm(String dqbm) {
        this.dqbm = dqbm;
    }

    @Override
    public String toString() {
        return dm;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }



}
