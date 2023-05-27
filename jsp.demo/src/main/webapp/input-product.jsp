<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/25
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入商品信息</title>
</head>
<body>
<h4>输入商品信息</h4>
<form action="product-servlet" method="post">
    <label>商品号:<input type="text" name="id"></label><br/>
    <label>商品名:<input type="text" name="name"></label><br/>
    <label>价格:<input type="text" name="price"></label><br/>
    <label><input type="submit" value="确定">
    <input type="reset" value="重置"></label>
</form>
</body>
</html>
