<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2020/4/22
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册页面</title>
  </head>
  <body>
     <h2>注册</h2><hr>
     <form action="studentRegServlet" method="post">
       用户名：
       <br><input type="text" name="username" placeholder="请输入用户名"><br>
       密码：
       <br><input type="text" name="password" placeholder="请输入密码"><br>
       <input type="submit" value="注册">
     </form>
  </body>
</html>
