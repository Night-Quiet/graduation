<%--
  Created by IntelliJ IDEA.
  User: YeShenRen
  Date: 16/02/2022
  Time: 00:04
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
        <title>智能答疑系统</title>
        <link rel="stylesheet" type="text/css" href="../static/css/login.css" />
        <script type="text/javascript" src="../static/js/login.js"></script>
    </head>
    <body>
    <div class="control">
        <div class="item">

            <div class="active">登录</div><div>注册</div>

        </div>
        <div class="content">

            <div class="login">
                <form action="<%=basePath %>/user/login.hml" method="post">
                    <p>用户名</p>
                    <input name="username" type="text" placeholder="username">
                    <p>密码</p>
                    <input name="password" type="password" placeholder="password">
                    <p></p>
                    <select name="identify_select">
                        <option value=0>学生</option>
                        <option value=1>教师</option>
                    </select>
                    <p></p>
                    <select name="class_select">
                        <option value=1>计算机网络</option>
                        <option value=2>软件工程实践</option>
                        <option value=3>计算机组成与原理</option>
                    </select>
                    <span class="message">${sessionScope.get("message")}</span>
                    <br/>
                    <input value="登录" type="submit">
                </form>
            </div>

            <div class="register">
                <form action="<%=basePath %>/user/register.hml" method="post">
                    <p>用户名</p>
                    <input name="username" type="text" placeholder="username" />
                    <p>密码</p>
                    <input name="password1" type="text" placeholder="password" />
                    <p>确认密码</p>
                    <input name="password2" type="text" placeholder="reconfirm" />
                    <p></p>
                    <select name="identify_select">
                        <option value=0>学生</option>
                        <option value=1>教师</option>
                    </select>
                    <p></p>
                    <select name="class_select">
                        <option value=1>计算机一班</option>
                        <option value=2>计算机二班</option>
                        <option value=3>计算机三班</option>
                    </select>
                    <br/>
                    <input type="submit" value="注册" />
                </form>
            </div>

        </div>
    </div>
    </body>
</html>


