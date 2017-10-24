/**
 * 显示每个role
 * Created by Administrator on 2016/6/5 0005.
 */
Ext.define('Emr.view.role.RoleCell', {
    extend: 'Ext.button.Button',
    margin: '10,10,10,10',
    xtype:'rolecell',
    width: 100,
    height: 100,
    iconAlign: 'top',
    //iconCls:'x-fa  fa-user-md fa-4x',
    style: {
        paddingTop: '20px',
        borderRadius:'5px'
    },
    config: {
        glGuid: '',
        jsm: '',
        ksmc: '',
        iconCls:'x-fa  fa-user-md fa-4x'
    },




  /*  html: '<span style="display: block;margin-top: 10px;width: 80px;overflow: hidden ;">' + this.width + '</span>' +
    '<span style="display: block;width: 80px;overflow: hidden ;">' + this.height + '</span>'*/
});