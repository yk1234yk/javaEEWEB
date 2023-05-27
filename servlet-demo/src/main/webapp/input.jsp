<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/25
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="first_servlet" method="post">
        学号:<input type="text" name="sno" size="15"><br/>
        姓名:<input type="text" name="sname" size="15"><br/>
        <input type="submit" value="登录">
        <input type="reset" value="取消">
    </form>
</body>
</html>
