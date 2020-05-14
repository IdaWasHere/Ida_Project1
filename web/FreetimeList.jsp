<%@ page import="java.util.List" %>
<%@ page import="com.Ida.www.po.TeacherMsg" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>导师见面预约系统</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
    <script>
        function deleteFreetime(id) {
            //用户安全提示
            if(confirm("确定删除吗？")){
            location.href="${pageContext.request.contextPath}/delFreeServlet?id="+id;
            }
        }
        
        window.onload = function ( ) { 
            //给删除选中的按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定删除选中条目吗？")) {
                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementById("t_id");
                    for (var i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        //有条目，则表单提交
                        document.getElementById("form").submit();
                    }
                }
            }
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function () {
                //2.获取下边列表中所有的cb
                var cbs = document.getElementById("t_id");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的Checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>
</head>

<body>
<div class="container">
    <h3 style="text-align: center">导师空闲时间列表</h3>

    <div style="float: left">
        <form class="form-inline">
            <div class="form-group">
                <label for="selfname">姓名</label>
                <input type="text" class="form-control" id="selfname" placeholder="按导师自己姓名查找">
            </div>
            <button type="submit" class="btn btn-default">查找</button>
        </form>
    </div>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/addFreetime.jsp">添加空闲时间</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb" ></th>
          <th>编号</th>
          <th>姓名</th>
          <th>学院</th>
          <th>开始时间</th>
          <th>结束时间</th>
          <th>操作</th>
        </tr>

        <c:forEach items="${teacherMsgs}" var="teacherMsg" varStatus="s">
            <tr>
                <td><input type="checkbox" name="t_id" value="${teacherMsg.id}"></td>
                <td>${teacherMsg.id}</td>
                <td>${teacherMsg.name}</td>
                <td>${teacherMsg.college}</td>
                <td>${teacherMsg.starttime}</td>
                <td>${teacherMsg.endtime}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findFreeServlet?id=${teacherMsg.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:deleteFreetime(${teacherMsg.id});">删除</a> </td>
            </tr>
        </c:forEach>
    </table>
    </form>

</div>
</body>
</html>