package com.neusoft.emr.common.persistence;

import com.neusoft.emr.common.utils.IdGen;
import com.neusoft.emr.common.utils.UserUtils;
import com.neusoft.emr.modules.system.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础bean，
 * Created by Administrator on 2016/4/28 0028.
 */
public class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 删除标记（N：正常；Y：删除）
     */
    public static final String DEL_FLAG_NORMAL = "N";
    public static final String DEL_FLAG_DELETE = "Y";


    public BaseEntity(){
        this.scbzw = DEL_FLAG_NORMAL;
    }

    public BaseEntity(String guid) {
        this();
        this.guid = guid;
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    protected boolean isNewRecord = false;


    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @return
     */
    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getGuid());
    }

    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (!this.isNewRecord) {
            setGuid(IdGen.uuid());
        }
        User user = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getGuid())) {
            this.cjr = UserUtils.getUser();
        }
        this.zhxgsj = new Date();
        this.cjsj = this.zhxgsj;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate() {
        this.zhxgsj = new Date();
        this.zhxgr = UserUtils.getUser();
    }


    protected String guid;//id

    protected User cjr;//创建人

    protected User zhxgr;//最后修改人

    protected Date zhxgsj;//最后修改时间

    protected Date cjsj;//创建时间

    protected String scbzw;//删除标记位

    public String getScbzw() {
        return scbzw;
    }

    public void setScbzw(String scbzw) {
        this.scbzw = scbzw;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public User getCjr() {
        return cjr;
    }

    public void setCjr(User cjr) {
        this.cjr = cjr;
    }

    public User getZhxgr() {
        return zhxgr;
    }

    public void setZhxgr(User zhxgr) {
        this.zhxgr = zhxgr;
    }

    public Date getZhxgsj() {
        return zhxgsj;
    }

    public void setZhxgsj(Date zhxgsj) {
        this.zhxgsj = zhxgsj;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

}
