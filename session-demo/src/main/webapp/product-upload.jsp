<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/26
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品上传</title>
</head>
<body>
<p>商品上传</p>
<form action="product-upload" enctype="multipart/form-data" method="post">
    <label>商品号:<input type="text" name="id"></label>
    <label>商品名:<input type="text" name="name"></label>
    <label>价格:<input type="text" name="price"></label>
    <label>图片:<input type="file" name="photo"></label>
    <label><input type="submit" value="提交"></label>
</form>
</body>
</html>
