<%--
  Created by IntelliJ IDEA.
  User: ehs
  Date: 2025-10-23
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Register Page</title>
</head>
<body>
<form action="/todo/register" method="post">
    <input type="text" name="title" placeholder="INSERT TITLE"><br>
    <input type="date" name="dueDate"><br>
<button type="reset">RESET</button>
<button type="submit">REGISTER</button>
</form>
</body>
</html>
