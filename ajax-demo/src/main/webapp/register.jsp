<%--
  Created by IntelliJ IDEA.
  User: 吨吨吨
  Date: 2023/5/19
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户注册</title>
    <script type="text/javascript">
        var xmlHttp;

        function createXMLHttpRequest() {
            if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } else if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            }
        }

        function validate() {
            createXMLHttpRequest();
            var myemail = document.getElementById("myemail");
            var url = "validation.do?myemail=" + escape(myemail.value);
            xmlHttp.open("GET", url, true);
            xmlHttp.onreadystatechange = handleStateChange;
            xmlHttp.send(null);
        }

        function handleStateChange() {
            if (xmlHttp.readyState == 4) {
                if (xmlHttp.status == 200) {
                    var message = xmlHttp.responseXML.getElementsByTagName("message")[0].firstChild.data;
                    var messageArea = document.getElementById("results");
                    messageArea.innerHTML = "<p>" + message + "</p>";
                }
            }
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/validation.do" method="post">
    <p>个人用户注册</p>
    <table>
        <tr>
            <td>*我的邮箱:</td>
            <td><input type="text" id="myemail" size="20" onblur="validate();"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <div id="results">请输入邮箱地址作为登录账号</div>
            </td>
        </tr>
        <tr>
            <td>*请输入密码:</td>
            <td><input type="text" id="password" size="20"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="提交"></td>
            <td><input type="reset" name="reset" value="重置"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
