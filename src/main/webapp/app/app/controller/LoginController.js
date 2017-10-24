/**
 * 登录控制
 * Created by Administrator on 2016/6/3 0003.
 */
Ext.define('Emr.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',

    onLoginClick: function () {

        var form = this.lookupReference('form');
        var loginView = this;
        if (form.isValid()) {
            form.submit({
                success: function (form, action) {
                    //Ext.Msg.alert('Success', action);
                    // Remove Login Window

                    var result = action.result;
                    loginView.getView().destroy();
                    if (result.currRole) {
                        // Add the main view to the viewport
                        var myMask = new Ext.LoadMask({
                            msg: '登录成功，即将进入首页 ...',
                            target: document.body,
                            alwaysOnTop: true
                        });
                        view.destroy();
                        myMask.setPosition(500, 500, true);
                        myMask.show();

                        //todo 创建主页面
                        Ext.getBody().clean();
                        Ext.create('Emr.view.main.Main',{
                            rednerTo:Ext.getBody()
                        });
                    } else {
                        //选择角色
                        Ext.create('Emr.view.role.Roles', {
                            roles: result.roles
                        });

                    }

                }/*,
                 failure: function(form, action) {
                 Ext.Msg.alert('Failed', '访问地址失败。');
                 }*/
            });
        }

    },

    onClickButton: function () {
        // Remove the localStorage key/value
        localStorage.removeItem('TutorialLoggedIn');

        // Remove Main View
        this.getView().destroy();

        // Add the Login Window
        Ext.create({
            xtype: 'login'
        });
    }


});