<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/27
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加图书信息</title>
</head>
<body>
<p>请输入图书信息</p>
${messageOne}<br/>
<form action="add-book" method="post">
    <label>
        书号:
        <input type="text" name="isbn"/><br/>
    </label>
    <label>
        书名:
        <input type="text" name="title"/><br/>
    </label>
    <label>
        价格:
        <input type="text" name="price"/><br/>
    </label>
    <label>
        删除图书：<input type="text" name="delete"><br/></label>
    <label>
        <input type="submit" value="确定">
        <input type="reset" value="重置">
    </label><br/>
    ${messageTwo}<br/>
</form>
</body>
</html>
