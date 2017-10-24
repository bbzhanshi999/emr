package com.neusoft.emr.common.service;

import com.neusoft.emr.common.persistence.BaseDao;
import com.neusoft.emr.common.persistence.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * Created by Administrator on 2016/4/28 0028.
 */

@Transactional(readOnly = true)
public class BaseService<D extends BaseDao<T>,T extends BaseEntity<T>> {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;


    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(String id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public T get(T entity) {
        return dao.get(entity);
    }

    /**
     * 查询列表数据
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return dao.findList(entity);
    }


    /**
     * 保存数据（插入或更新）
     * @param entity
     */
    @Transactional(readOnly = false)
    public void save(T entity) {
        if (entity.getIsNewRecord()){
            entity.preInsert();
            dao.insert(entity);
        }else{
            entity.preUpdate();
            dao.update(entity);
        }
    }


    /**
     * 新增或修改记录
     * @param entity
     */
    public void upsert(T entity){
        dao.upsert(entity);
    }

    /**
     * 删除数据
     * @param entity
     */
    @Transactional(readOnly = false)
    public void delete(T entity) {
        dao.delete(entity);
    }
}
