<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2020/5/3
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改导师信息</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>

<body>
<div class="container" style="text-align: center">
    <h3 align="center">修改导师空闲时间</h3>
    <form action="updateFreeServlet" method="post">
        <!-- 隐藏域 提交id   也可以直接在上面action后面带参传输-->
        <input type="hidden" name="id" value="${teacherMsg.id}">

        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" value="${teacherMsg.name}" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label for="college">学院</label>
            <select name="college"  id="college" class="form-control">
                <c:if test="${teacherMsg.college == '格兰芬多'}">
                    <option value="格兰芬多" selected>格兰芬多</option>
                    <option value="赫奇帕奇">赫奇帕奇</option>
                    <option value="拉文克劳">拉文克劳</option>
                    <option value="斯莱特林">斯莱特林</option>
                </c:if>
                <c:if test="${teacherMsg.college == '赫奇帕奇'}">
                    <option value="格兰芬多">格兰芬多</option>
                    <option value="赫奇帕奇" selected>赫奇帕奇</option>
                    <option value="拉文克劳">拉文克劳</option>
                    <option value="斯莱特林">斯莱特林</option>
                </c:if>
                <c:if test="${teacherMsg.college == '拉文克劳'}">
                    <option value="格兰芬多">格兰芬多</option>
                    <option value="赫奇帕奇">赫奇帕奇</option>
                    <option value="拉文克劳" selected>拉文克劳</option>
                    <option value="斯莱特林">斯莱特林</option>
                </c:if>
                <c:if test="${teacherMsg.college == '斯莱特林'}">
                    <option value="格兰芬多">格兰芬多</option>
                    <option value="赫奇帕奇">赫奇帕奇</option>
                    <option value="拉文克劳">拉文克劳</option>
                    <option value="斯莱特林" selected>斯莱特林</option>
                </c:if>
            </select>
        </div>

        <div class="form-group">
            <label for="starttime">空闲时间</label>
            <input type="datetime-local" class="form-control" id="starttime" name="starttime" placeholder="请输入空闲开始时间">
        </div>

        <div class="form-group">
            <label for="endtime">空闲时间</label>
            <input type="datetime-local" class="form-control" id="endtime" name="endtime" placeholder="请输入空闲结束时间">
        </div>

        <input type="submit" class="btn btn-success" value="修改 ">
    </form>
</div>
</body>
</html>
