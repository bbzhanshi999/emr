/**
 * 选择角色控制
 * Created by Administrator on 2016/6/6 0006.
 */
Ext.define('Emr.view.role.RoleController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.role',


    onSelectedClick: function (e) {

        var currRoleId = this.getView().getCurrRoleId();
        var glGuid = e.getGlGuid();
        var roleList = this.getView().query('rolecell');
        for (var i = 0; i < roleList.length; i++) {
            roleList[i].setStyle('backgroundColor', '#5fa2dd');
            this.getView().setCurrRoleId(undefined);
        }
        if (currRoleId !== glGuid) {
            this.getView().setCurrRoleId(glGuid);
            e.setStyle('backgroundColor', '#5897ce');
        }


    },

    onSubmitClick: function () {
        var view = this.getView();
        var glGuid = view.getCurrRoleId();

        location.href = localStorage.getItem('ctx') + '/main/mainView?glGuid=' + glGuid;

       /* Ext.Ajax.request({
            url: localStorage.getItem('ctx') + '/main/mainView?glGuid=' + glGuid,
            success: function (response, opts) {
                var data = Ext.JSON.decode(response.responseText);
                if (data.success) {

                    view.destroy();
                    //todo 创建主页面
                  /!*  Ext.create('Ext.panel.Panel', {
                        renderTo: Ext.getBody(),
                        layout:'fit',
                        items: [
                            {
                                // Explicitly define the xtype of this Component configuration.
                                // This tells the Container (the tab panel in this case)
                                // to instantiate a Ext.panel.Panel when it deems necessary
                                xtype: 'panel',
                                title: 'Tab One',
                                html: 'The first tab'
                            }
                        ]
                    });*!/

                    var main = Ext.create('Emr.view.main.Main');
                    main.render(Ext.getBody());
                }
            },
        });*/
    }
})