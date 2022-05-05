<%--
  Created by IntelliJ IDEA.
  User: YeShenRen
  Date: 2022/3/15
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%
    //获取项目的url地址
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    request.setAttribute("basePath", basePath);
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>统计</title>
    <link type="text/css" href="../static/css/statistics.css" rel="stylesheet"/>
    <script src="../static/js/echarts.min.js"></script>
    <script type="text/javascript" src="../static/js/share.js"></script>
    <script type="text/javascript" src="../static/js/statistics.js"></script>

</head>

<body>
<div class="home">
    <div class="home-left">
        <button class="button" onClick="window.location.href='<%=basePath %>/question/toMain.hml'">返回</button>
        <button class="button active" onClick="showPic(0, this)">浏览统计</button>
        <button class="button" onClick="showPic(1, this)">提问统计</button>
        <button class="button" onClick="showPic(2, this)">评论统计</button>
        <button class="button" onClick="showPic(3, this)">回复统计</button>
    </div>
    <div class="home-right">
        <div id="show-1" class="show-1">
        </div>
    </div>
</div>
</body>
</html>
