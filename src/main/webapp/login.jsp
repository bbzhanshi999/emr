<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ include file="/WEB-INF/view/include/head.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>login</title>
    <script>
        localStorage.setItem('ctx','${ctx}');
        localStorage.setItem('ctxStatic','${ctxStatic}');
        localStorage.setItem('ctxApp','${ctxApp}');
        Ext.onReady(function(){
            <c:choose>
            <c:when test="${!empty errMsg}">
            Ext.MessageBox.show({
                title: 'Icon Support',
                msg: '${errMsg}',
                buttons: Ext.MessageBox.OK,
                icon: Ext.MessageBox.ERROR,
                fn:function () {
                    Ext.create({
                        xtype: 'login'
                    });
                }
            });

            </c:when>
            <c:otherwise>
                Ext.create({
                    xtype: 'login'
                });
            </c:otherwise>
            </c:choose>
        });
    </script>
</head>
<body>

</body>
</html>