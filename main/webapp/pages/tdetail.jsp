<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YeShenRen
  Date: 2022/3/9
  Time: 17:20
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
        <title>问题详情</title>
        <link type="text/css" href="../static/css/tdetail.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="../static/js/share.js"></script>
    </head>
    <body>
        <div class="home">
            <div class="home-top">

                <div class="function">
                    <button class="button" onClick="window.location.href='<%=basePath %>/question/toMain.hml'">返回</button>
                    <button class="button" onClick="window.location.href='<%=basePath %>/question/toAnswer.hml'">修改答案</button>
                    <button class="button" onClick="window.location.href='<%=basePath %>/question/deleteQuestion.hml'">删除问题</button>
                </div>

                <div class="funny" id="funny" onMouseOver="ballColor(1)" onMouseOut="ballColor(2)" onmousedown="ballColor(3)" onmouseup="ballColor(4)" onClick="funnyTest()">
                </div>

            </div>
            <div class="home-bottom">
                <div class="home-bottom-left">

                    <div class="answer">
                        ${sessionScope.get("answer")}
                    </div>

                    <div class="a-pic">
                        <c:forEach items="${sessionScope.get('a_picPath')}" var="path" varStatus="idx">
                            <img class="a-pic-slice" src="${path}" onClick="changeBig(this)">
                        </c:forEach>
                    </div>

                    <div class="a-video">
                        <c:forEach items="${sessionScope.get('a_videoPath')}" var="path" varStatus="idx">
                            <video class="a-video-slice" controls poster>
                                <source src="${path}">
                            </video>
                        </c:forEach>
                    </div>

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
        <div class="comment">
            <div class="comment-write">
                <form class="comment-form" action="<%=basePath %>/comment/addComment.hml" method="post">
                    <textarea class="comment-content" name="comment" placeholder="可以对问题以及答案进行评论" required></textarea>
                    <button class="comment-submit" type="submit">发表<br>评论</button>
                </form>
            </div>
            <c:forEach items="${sessionScope.get('comment')}" var="comment" varStatus="idex">
                <div class="comment-show">
                    <div class="main-comment">
                        <p>${comment.get("user_main")}(${comment.get("identify")}): </p><p>${comment.get("user_main_comment")}</p>
                        <button class="delete" onClick="window.location.href='<%=basePath %>/comment/deleteComment.hml?id_comment=${comment.get("id_comment")}'">删除评论</button>
                        <button class="reply-function" onClick="replyAppear(this, '${comment.get("user_main")}')">回复</button>
                        <button class="all-reply" onClick="allReplyAppear(this)">收起回复</button>
                    </div>
                    <div class="reply">
                        <div class="reply-main">
                            <div class="reply-write reply-hidden">
                                <form class="reply-form" action="<%=basePath %>/reply/addReply.hml?id_comment=${comment.get("id_comment")}" method="post">
                                    <textarea class="reply-content" name="reply" placeholder="可以对评论进行追评" required></textarea>
                                    <button class="reply-submit" type="submit">发表<br>评论</button>
                                </form>
                            </div>
                            <div class="reply-show">
                                <c:forEach items="${comment.get('reply')}" var="reply" varStatus="idex">
                                    <p>${reply.get("user_other")}(${reply.get("identify")}): </p><p>${reply.get("user_other_reply")}</p>
                                    <button class="delete" onClick="window.location.href='<%=basePath %>/reply/deleteReply.hml?id_reply=${reply.get("id_reply")}'">删除回复</button><br>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
