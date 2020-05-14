<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2020/5/14
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>私聊页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src ="js/jquery-1.11.2.min.js"></script>

    <script type="text/javascript">
        function getContent(){
            $.get("chatServlet?action=get&nocache"+new Date().getTime(),function(data){
                $("#div1").html(data);
            })
        }

        $(document).ready(function(){
            getContent();
            setInterval("getContent()",1000);
        });

        $(document).ready(function(){
            $("#btn").click(function(){
                if($("#user").val() != ""){
                    if($("#speak").val() != ""){
                        $.post("chatServlet?action=send",{  //$.post(url,data,success())方法
                            user:$("#user").val(),
                            speak:$("#speak").val()});


                        $("#speak").val("") ; //清空说话文本内容
                        $("#speak").focus();

                    }else {
                        alert("聊天内容不能为空");
                    }
                }else {
                    alert("用户名不能为空");
                }
            });
        });

    </script>
</head>
　　　　
<body>

<div id = "div1" style = "height: 135px;background:#ffe2e9 ;overflow:hidden"> 欢迎光临聊天室</div>

<form action="" method = "post" name = "form1">
    <input name = "user" type = "text" size = "20" id = "user">说：
    <input name = "speak" type = "text" size = "50" id = "speak">
    <input name = "btn" type = "button" id = "btn" value ="发送">
</form>

</body>
</html>

