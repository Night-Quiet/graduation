<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YeShenRen
  Date: 2022/2/17
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%
    //获取项目的url地址
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <title>教师</title>
    <link type="text/css" href="../static/css/main.css" rel="stylesheet"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="../static/js/echarts.min.js" ></script>
    <script type="text/javascript" src="../static/js/share.js"></script>
</head>
<body>
<div class="home">
    <div class="home-left">

        <div class="home-left-top"><p class="main-title">在线答疑</p></div>

        <div class="home-left-bottom">
            <a class="function" href="<%=basePath %>/question/toLogout.hml"><p>注销</p></a>
            <c:forEach items="${sessionScope.get('allFunction')}" var="function" varStatus="idx">
                <a class="function" href="<%=basePath %>${function.href}" target="content" onclick="activeShow(this)"><p>${function.message}</p></a>
            </c:forEach>
        </div>

    </div>

    <div class="home-right">

        <div class="home-right-top">
            <form action="<%=basePath %>/question/getSearchQuestion.hml" method="post" target="content">
                <input class="search-content" name="search" type="text" placeholder="search">
                <input class="search-submit" name="pointed" type="submit" value="搜索">
            </form>
            <div class="student-message">
                <p>${sessionScope.get("activeUser")}</p>
                <p>${sessionScope.get("activeClass")}</p>
                <p>${sessionScope.get("activeIdentify")}</p>
            </div>
        </div>

        <iframe class="home-right-middle" name="content" src="<%=basePath %>/question/toMain.hml" scrolling="auto" frameborder=0>
        </iframe>

        <div class="home-right-bottom"></div>
    </div>
</div>
</body>
</html>
