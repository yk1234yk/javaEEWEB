<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/19
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*,javax.sql.*" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table border="1">
    <caption>商品表中信息</caption>
    <tr>
        <td>商品号</td>
        <td>商品名</td>
        <td>品牌</td>
        <td>价格</td>
        <td>库存</td>
    </tr>
    <c:forEach var="prouduct" items="${applicationScope.productList}" varStatus="status">
        <%--        为奇数行和偶数行设置不同的背景颜色--%>
        <c:if test="${status.count%2==0}">
            <tr style="background: #eeeeff">
        </c:if>
        <c:if test="${status.count%2!=0}">
            <tr style="background: #dedeff">
        </c:if>
        <%--用EL访问作用域变量的成员--%>
        <td>${prouduct.id}</td>
        <td>${prouduct.pname}</td>
        <td>${prouduct.brand}</td>
        <td>${prouduct.price}</td>
        <td>${prouduct.stock}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
