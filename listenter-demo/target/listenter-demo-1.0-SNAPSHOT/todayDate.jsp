<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/19
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<%! LocalDate date = null;%>
<html>
<head>
    <title>当前日期</title>
</head>
<body>
<%
    date = LocalDate.now();//创建一个LocalDate对象
%>
今天的日期是:<%=date.toString()%>
</body>
</html>
