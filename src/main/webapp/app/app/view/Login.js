/**
 * 控制登录
 * Created by Administrator on 2016/6/1 0001.
 */
Ext.define('Emr.view.login.Login',{
    extend:'Ext.window.Window',
    xtype:'login',
    controller:'login',
    bodyPadding:10,
    title:'登录界面',//标题
    closable:true,//窗口是否可关闭
    autoShow:true,//是否自动显示，也就是一旦create就显示
    
    items: {
        xtype: 'form',
        reference: 'form',
        url:localStorage.getItem('ctx')+'/sys/login',
        items: [{
            xtype: 'textfield',
            name: 'username',
            fieldLabel: '用户名',
            allowBlank: false
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: '密码',
            allowBlank: false
        }, { xtype: 'textfield',
            anchor: '50%',
            name: 'code',
            fieldLabel: '验证码：',
            allowBlank: false
        }, {
            xtype: 'imagecomponent',
            width: 80,
            height: 25,
            margin:'0 0 10 0',//top left bottom right
            padding:'0 0 0 0',
            src:localStorage.getItem('ctx')+'/sys/getvcode?r='+ Math.random(),
            listeners:{
                afterrender: function() {
                    this.getEl().on('click',function(){
                        this.setSrc(localStorage.getItem('ctx')+'/sys/getvcode?r='+ Math.random());
                    },this);
                }
            }

        }],
        buttons: [{
            text: '登录',
            formBind: true,
            tooltip:'请点击登录',
            listeners: {
                click: 'onLoginClick'
            }
        }]
    }
});


