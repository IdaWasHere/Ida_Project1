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
    <title>学生申请预约</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>

<body>
   <form action="submitServlet" method="post">
       <div class="form-group">
           <label for="teacherName">导师姓名</label>
           <input type="text"  class="form-group" id="teacherName" value="${teacherName}" name="teacherName" placeholder="请输入导师姓名">
       </div>

       <div class="form-group">
           <label for="studentName">学生姓名</label>
           <input type="text"  class="form-group" id="studentName"  name="studentName" placeholder="请输入您的姓名">
       </div>

       <div class="form-group">
           <label for="studentCollege">学生学院</label>
           <input type="text"  class="form-group" id="studentCollege"  name="studentCollege" placeholder="请输入您所在学院">
       </div>

       <div class="form-group">
           <label for="time">预约时间始末</label>
           <input type="text"  class="form-group" id="time"  name="time" placeholder="请输入预约时间始末">
       </div>

       <input type="submit" class="btn btn-success" value="确定">
   </form>
</body>
</html>
