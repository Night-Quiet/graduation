<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YeShenRen
  Date: 2022/3/16
  Time: 17:28
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
    <link type="text/css" href="../static/css/qtable.css" rel="stylesheet"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="../static/js/share.js"></script>
</head>
<body>
<div class="home">

    <div class="home-main">
        <div class="table-question">
            <c:forEach items="${sessionScope.get('allQuestion')}" var="question" varStatus="idx">
                <a class="detail-all" href="<%=basePath %>/detail/questionDetail.hml?questionid=${question.id_question}" target="content">
                    <table>
                        <tr>
                            <td class="detail-1">
                                <p>${question.id_question}</p>
                            </td>
                            <td class="detail-2">
                                <p>${question.keyword}</p>
                            </td>
                            <td class="detail-3">
                                <p>${question.datenow}</p>
                            </td>
                        </tr>
                    </table>
                </a>
            </c:forEach>
        </div>
    </div>

</div>
</body>
</html>
