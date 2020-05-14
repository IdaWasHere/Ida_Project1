<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2020/5/9
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>学生预约申请列表</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        window.onload = function () {
            //给删除选中的按钮添加单击事件
            document.getElementById("refuseApplySelected").onclick = function () {
              //表单提交
                document.getElementById("form").submit();
            }
        }
    </script>
</head>

<body>
<div class="container">
    <h3 style="text-align: center">学生预约申请列表</h3>



    <form id="form" action="${pageContext.request.contextPath}/readApplySelectedServlet?dealstate=${state}" method="post">
        <div style="float: right;margin: 5px;">
            <a class="btn btn-primary" href="javascript:void(0);" id="refuseApplySelected">批量处理选中预约</a>
            <input type="text" name="dealstate"  class="form-control">
        </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" ></th>
            <th>编号</th>
            <th>预约导师</th>
            <th>学生姓名</th>
            <th>学生学院</th>
            <th>预约时间</th>
            <th>预约状态</th>
            <th>操作(不通过/通过)</th>
        </tr>

        <c:forEach items="${applys}" var="apply" varStatus="s">
            <tr>
                <td><input type="checkbox" name="uid" value="${apply.id}"></td>
                <td>${apply.id}</td>
                <td>${apply.teaName}</td>
                <td>${apply.stuName}</td>
                <td>${apply.stuCollege}</td>
                <td>${apply.time}</td>
                <td>${apply.state}</td>
                <td>
                  <form action="refuseApplyServlet" method="post" >
                      <input type="hidden" name="id" value="${apply.id}">
                      <input type="text" name="state" size="3">
                      <input type="submit" value="处理">
                  </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
</div>

</body>
</html>