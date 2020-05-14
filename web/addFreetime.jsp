<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2020/5/2
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>导师添加空闲时间</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>

<body>
<div class="container">
    <center><h3>添加导师空闲时间</h3></center>
    <form action="${pageContext.request.contextPath}/addFreetimeServlet" method="post">

        <div class="form-group ">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" name="name"  placeholder="请输入名字">
        </div>

        <div class="form-group">
            <label for="college">学院</label>
            <input type="text" class="form-control" id="college" name="college"   placeholder="请输入所在学院">
        </div>


        <div class="form-group">
            <label for="starttime">空闲开始时间</label>
            <input type="datetime-local" class="form-control" id="starttime" name="starttime" placeholder="请输入空闲开始时间">
        </div>
        <div class="form-group">
            <label for="endtime">空闲结束时间</label>
            <input type="datetime-local" class="form-control" id="endtime" name="starttime" placeholder="请输入空闲结束时间">
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="添加">
            <input class="btn btn-default" type="reset" value="重置">
            <input class="btn btn-default" type="button" value="返回">
        </div>
    </form>
</div>
</body>
</html>
