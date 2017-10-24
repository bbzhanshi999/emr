<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <script>
        $(function () {

            var ctx = $('#ctx').val(), ctxStatic = $('#ctxStatic').val();

            $('body').layout();

            $('body').layout('add', {
                id: 'west',
                region: 'west',
                width: 250,
                expandMode: null,
                hideCollapsedContent: false
            });

            //设置head
            $('body').layout('add', {
                region: 'north',
                id: 'north',
                border: false,
                height: '60px',
                content: '<div class="headmenu">' +
                '<ul><li><a class="gurl" data-url="tab/index">主页</a></li>' +
                '<li><a class="gurl" data-url="tab/index">信息提醒</a></li>' +
                '<li><a class="gurl" data-url="tab/index">质量监控</a></li>' +
                '<li><a class="gurl" data-url="tab/index">数据参考</a></li>' +
                '<li><a class="gurl" data-url="tab/index">显示痕迹</a></li>' +
                '</ul></div>'+'<div class="user_Information"><span>用户信息：</span>' +
                '${currRole.ksmc}/' + '${currRole.jsm} /' + '${user.userInfo.xm}' +
                '【<a href="#" class="changeRole">身份切换</a>】' +
                '【<a href="#" onclick="doPretect()">屏保</a>】' +
                '【<a href="#" onclick="exit()">退出</a>】' +
                '</div>'
            });

            //设置页脚
            $('body').layout('add', {
                region: 'south',
                id: 'south',
                border: false,
                cls: 'container-shadow-top',
                height: '30px',
                content: '<span class="foot">neusoft\'s copyright © 2013-2014 </span>'
            });

            $('body').layout('add', {
                region: 'center',
                id: 'center'
            });


            /*改变缩放样式*/
            $("#west").append('<div class="collapse-west"><i class="fa fa-chevron-left"></i></div>');
            $("#west").append('<div id="leftTabs"></div>');


            $('#leftTabs').tabs({
                fit: true,
                narrow: true,
                justified: true,
                plain: true,
                border: false,
                expandMode: 'null'
            });

            $("#west").find('.collapse-west i').on('click', function () {
                $('body').layout('collapse', 'west');
            });

            $('#center').append('<div id="centerTabs"></div>');

            $('#centerTabs').tabs({
                fit: true,
                plain: true,
                border: false
            });

            //添加首页内容
            $('#centerTabs').tabs('add', {
                title: '<i class="fa fa-calendar-o"></i>&nbsp;首页',
                id: 'tab_index',
                content: '<a class="gurl" data-url="br/zaa/bl/566">测试通用url</a>'//测试通用url规则
            });


            //获取患者清单，并针对每个患者清单选项生成病人树
            $.get(ctx + '/main/patientList', function (message) {

                var patientList;
                if (message && message.patientList.length > 0) {//message.patientListshi是角色拥有的患者清单快捷查询方式的种类
                    patientList = message.patientList;
                    $('#leftTabs').tabs('add', {
                        id: 'patients',
                        title: '病人列表',
                        content: '<div id="patientList"></div>'
                    });
                    $('#patientList').accordion({fit: true});
                    (function () {
                        for (var i = 0; i < patientList.length; i++) {
                            $("#patientList").accordion('add', {
                                title: patientList[0].xxmc,
                                id: patientList[0].xxdh,
                                content: '<ul id="' + patientList[0].xxdh + '"></ul>'
                            });

                            //创建病人树
                            $('#' + patientList[0].xxdh).tree({
                                url: ctx + '/tree/brTree',
                                animate: true,
                                queryParams: {xxdh: patientList[0].xxdh},//附加查询条件
                                onClick: function (node) {

                                    if (node.attributes && node.attributes.brid) {
                                        upsertTabPanel('br', node.attributes.brid, 'bl', 'ryxx');//默认打开病案首页入院信息
                                    }
                                }
                            });
                        }
                    })();
                }
            },'json');

            /*增加控制台页*/
            $('#leftTabs').tabs('add', {
                id: 'menu',
                title: '控制台',
                content: '<ul id="menu"></ul>',
                selected: true
            });

            /*生成控制台树*/
            $('#menu').tree({
                url: ctx + '/tree/menuTree',
                animate: true,
                onClick: function (node) {
                    if (node.attributes && node.attributes.kt) {
                        upsertTabPanel('kzt', node.attributes.jddh);
                    }
                }
            });


            /**
             * 通用url监听方法
             */
            $('.gurl').on('click', function (e) {
                var url = $(this).data('url');
                var urlArray = url.split('/');
                switch (urlArray.length) {
                    case 4://如果为主tab页
                        upsertTabPanel(urlArray[0], urlArray[1], urlArray[2], urlArray[3]);
                        break;
                    case 2://如果为子tab页
                        upsertTabPanel(urlArray[0], urlArray[1]);
                        break;
                }
            });


            /**
             * 增加或更新主tab页通用方法
             * @param key 组装url的请求位置
             * @param value 请求值
             * @param subKey 子tab页url请求位置
             * @param subValue 子tab页请求值
             * @pa
             */
            function upsertTabPanel(key, value, subKey, subValue) {
                var $tabs = $('#centerTabs'), $subTab, subTabs,
                        tabs = $tabs.tabs('tabs'), hasPanel, hasSubPanel, data = {}, subData = {};
                for (var i = 0; i < tabs.length; i++) {
                    if (tabs[i].panel('options').id == key + '_' + value) {
                        $tabs.tabs('select', i);
                        hasPanel = true;
                        break;
                    }
                }

                if (!hasPanel) {
                    hasSubPanel = false;
                    $.get(ctx + '/' + key + '/' + value, function (message) {
                        data = message;

                        switch (key) {
                            case 'br':
                                $tabs.brPanel(data); //增加病人页，
                                break;
                            case 'kzt':
                                $tabs.kztPanel(data);//增加控制台页
                                break;
                                //todo 其他种类的页码待开发

                        }


                        //如果有子tab页参数，就创建子tab页
                        if (subKey && subValue) {
                            newSubPanel(ctx + '/' + key + '/' + value + '/' + subKey + '/' + subValue, subKey, 'subTabs_' + data.id);
                        }

                    },'json');


                } else if (subKey && subValue) { //如果有主tab页，并且有子tab参数，
                    $subTab = $('#subTabs_' + key + '_' + value);
                    subTabs = $subTab.tabs('tabs');
                    for (var j = 0; j < subTabs.length; j++) {
                        if (subTabs[j].panel('options').id == key + '_' + value + '_' + subKey + '_' + subValue) {
                            //如果有子tab页就进行选择
                            $tabs.tabs('select', j);
                            hasSubPanel = true;
                            break;
                        }
                    }

                    //如果子tab不存在，就创建子tab页
                    if (!hasSubPanel) {
                        newSubPanel(ctx + '/' + key + '/' + value + '/' + subKey + '/' + subValue, subKey, '#subTabs_' + key + '_' + value);
                    }

                }

            }


            /**
             * 创建新子tab页
             * @param url
             * @param subKey
             * @param tabsId
             */
            function newSubPanel(url, subKey, tabsId) {
                $.get(url, function (message) {
                    var subData = message;

                    switch (subKey) {
                        case 'bl':
                            $('#' + tabsId).blPanel(subData);//增加病历子页
                            break;
                            //todo 其他子页内容根据需求开发
                    }


                },'json');
            }

            /**
             * 切换角色
             */
            $('.changeRole').on('click',function() {
                $.get(ctx + '/sys/getRoles', function (data) {
                    var flag, content='', subContent, roles;
                    if (data.roles && data.roles.length > 0) {
                        roles = data.roles;
                        (function () {
                            for (var i = 0; i < roles.length; i++) {
                                var iconClass;
                                switch (roles[i].jslb) {
                                    case '1':
                                        iconClass = 'fa-stethoscope';
                                        break;
                                    case '2':
                                        iconClass = 'fa-pencil';
                                        break;
                                    case '3':
                                        iconClass = 'fa-cog';
                                        break;
                                }
                                roles[i].ksmc = roles[i].ksmc ? roles[i].ksmc : '';

                                subContent = '<a data-glguid="' + roles[i].glGuid + '" class="roleSelection"><i class="fa ' + iconClass + ' fa-3x"></i>' +
                                        '<span>' + roles[i].jsm + '<br/>' + roles[i].ksmc + '</span></a>';
                                content = content + subContent;
                            }
                        })();
                        $('#roleDialog').dialog({
                            title: '请选择角色',
                            width: 480,
                            height: 300,
                            shadow: true,
                            modal: true,
                            content: content,
                            buttons: [{
                                text: '选择',
                                onClick: function (e) {
                                    location.href = ctx + "/main/mainView?glGuid=" + flag;
                                }
                            }]
                        });

                        $('.roleSelection').on('click', function (e) {
                            if ($(this).hasClass('selected')) {
                                $(this).removeClass('selected');

                            } else {
                                $('.roleSelection').removeClass('selected');
                                $(this).addClass('selected');
                                flag = $(this).data('glguid');
                            }
                        });
                    }
                }, 'json');
            })
        })

    </script>
</head>
<body style="font-family: 'Helvetica Neue', Helvetica, 'Microsoft Yahei', 'Hiragino Sans GB', 'WenQuanYi Micro Hei', sans-serif;">
<div id="roleDialog"></div>

</body>
</html>
