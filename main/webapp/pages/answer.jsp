<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YeShenRen
  Date: 2022/3/9
  Time: 17:24
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
        <meta charset="utf-8">
        <title>回答</title>
        <link type="text/css" href="../static/css/answer.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="../static/js/share.js"></script>
    </head>
    <body>
        <div class="home">
            <div class="home-top">

                <div class="function">
                    <button class="button" onClick="window.location.href='<%=basePath %>/question/toDetail.hml'">返回</button>
                    <button class="button" onClick="formSubmit(3)">上传答案</button>
                </div>

                <div class="funny" id="funny" onMouseOver="ballColor(1)" onMouseOut="ballColor(2)" onmousedown="ballColor(3)" onmouseup="ballColor(4)" onClick="funnyTest()">
                </div>

            </div>
            <div class="home-bottom">
                <div class="home-bottom-left">

                    <form class="a-form" id="formSubmit" action="<%=basePath %>/detail/answerQuestion.hml" method="post" enctype="multipart/form-data">
                        <div class="answer">
                            <textarea class="a-content" name="answer" placeholder="请描述你的回答"></textarea>
                        </div>

                        <div class="a-pic">
                            <input type="file" name="picName1"><br />
                            <input type="file" name="picName2"><br />
                            <input type="file" name="picName3">
                        </div>
                        <div class="a-video">
                            <input type="file" name="videoName">
                        </div>
                    </form>

                </div>
                <div class="home-bottom-right">

                    <div class="question">
                        ${sessionScope.get("question")}
                    </div>

                    <div class="q-pic">
                        <c:forEach items="${sessionScope.get('q_picPath')}" var="path" varStatus="idx">
                            <img class="q-pic-slice" src="${path}" onClick="changeBig(this)">
                        </c:forEach>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
