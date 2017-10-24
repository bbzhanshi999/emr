/**
 * Created by Administrator on 2016/6/3 0003.
 */
Ext.define('Emr.view.role.Roles', {
    extend: 'Ext.window.Window',
    xtype:'roles',
    requires:[
        'Emr.view.role.RoleCell',
        'Emr.view.main.Main'
    ],
    controller:'role',
    xtype: 'selectrole',
    bodyPadding: 10,
    title: '请选择角色',//标题
    closable: false,//窗口是否可关闭
    autoShow: true,//是否自动显示，也就是一旦create就显示
    width:500,
    height:500,
    config: {
        roles: [],
        currRoleId:'',
        items:undefined
    },

    applyItems:function (items) {
        if(items&&items.length>0){
            return items;
        }else{
            if(this.roles&&this.roles.length>0){
                var items = [],roles = this.roles;
                for(var i = 0;i<roles.length;i++){
                    var ksmc=roles[i].ksmc?'('+roles[i].ksmc+")":' ',
                        glGuid =roles[i].glGuid ,
                        jsm = roles[i].jsm,
                        iconCls = roles[i].iconCls?roles[i].iconCls+' fa-4x':undefined;
                    var button = Ext.create('Emr.view.role.RoleCell',{
                        glGuid:glGuid,
                        jsm:jsm,
                        ksmc:ksmc,
                        iconCls: iconCls,
                        html: '<span style="display: block;margin-top: 10px;width: 80px;overflow: hidden ;">' + jsm + '</span>' +
                        '<span style="display: block;width: 80px;overflow: hidden ;">' + ksmc + '</span>',
                        listeners: {
                            click: 'onSelectedClick'
                        }
                    });
                    items.push(button);
                }
                return items;
            }
        }
    },
    buttonAlign:'center',
    buttons:[
        {
            text:'选择',
            listeners: {
                click: 'onSubmitClick'
            }
        }
    ]

   /* listeners: {
        afterrender: function () {
            roles = this.getRoles();
            for (var i = 0; i < this.getRoles().length; i++) {
                this.add({
                    xtype:'button',
                    text:roles[i].jsksmc
                })
            }
        }
    }*/

});