<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp" %>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <script>
        localStorage.setItem('ctx','${ctx}');
        localStorage.setItem('ctxStatic','${ctxStatic}');
        localStorage.setItem('ctxApp','${ctxApp}');
        Ext.onReady(function(){
            var main = Ext.create('Emr.view.main.Main');
        });
    </script>
</head>
<body>

</body>
</html>