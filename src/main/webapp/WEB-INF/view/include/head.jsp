<%@ page import="java.io.File" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.neusoft.emr.common.utils.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--static--%>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/style/app.css"/>
<%--ext-libs--%>
<link rel="stylesheet" type="text/css" href="${ctxApp}/ext/classic/theme-admin/resources/Admin-all.css"/>
<script type="text/javascript" src="${ctxApp}/ext/ext-all-debug.js"></script>
<script type="text/javascript" src="${ctxApp}/ext/classic/theme-triton/theme-triton-debug.js"></script>
<script type="text/javascript" src="${ctxApp}/ext/classic/locale/locale-zh_CN.js"></script>


<%----%>
<%

    String path = request.getRealPath("/");
    File folder = new File(path + "/app/app");
    List<String> fileNames = new ArrayList<String>();
    StringUtils.listRelativePathOfAllFiles(folder,path,".js",fileNames);
    for(String fileName : fileNames) {
%>
<script type="text/javascript" src="${ctx}/<%=fileName%>"></script>
<%
    }
%>
