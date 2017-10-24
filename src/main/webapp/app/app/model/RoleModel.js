/**
 * 角色数据模型
 * Created by zql on 2016/6/5 0005.
 */
Ext.define('Emr.view.model.RoleModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'glGuid', type: 'string'},
        {name: 'guid', type: 'string'},
        {name: 'jsksmc', type: 'string'},
        {name: 'jsm', type: 'string'},
        {name: 'ksmc', type: 'string'},
        {name: 'ksywm', type: 'string'},
        {name: 'iconCls', type: 'string'},
        {name: 'alive', type: 'boolean', defaultValue: true, convert: null}
    ]
});
