<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/25
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<html>
<head>
    <title>显示日期</title>
</head>
<%
    LocalDate today = LocalDate.now();
%>
<body>
今天的日期是: <%=today%>
</body>
</html>
