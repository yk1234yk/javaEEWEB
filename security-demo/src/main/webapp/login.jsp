<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/19
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body bgcolor="white">
<p>请你输入用户名和口令:</p>
<form method="post" action="j_security_check">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="j_username"></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码</td>
            <td><input type="password" name="j_password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
