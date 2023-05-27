<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/25
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="product" class="com.demo.Product" scope="request"/>

<html>
<head>
    <title>商品信息</title>
</head>
<body>
<table border="1">
    <caption>商品信息如下</caption>
    <tr>
        <td>商品号:</td>
        <td>
            <jsp:getProperty name="product" property="id"/>
        </td>
    </tr>
    <tr>
        <td>商品名:</td>
        <td>
            <jsp:getProperty name="product" property="name"/>
        </td>
    </tr>
    <tr>
        <td>价格:</td>
        <td>
            <jsp:getProperty name="product" property="price"/>
        </td>
    </tr>
</table>
</body>
</html>
