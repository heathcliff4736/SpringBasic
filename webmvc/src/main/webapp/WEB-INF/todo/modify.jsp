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
    <title>Modify</title>
</head>
<body>
<h1>Modify Page</h1>
${dto.tno} <br>${dto.title} <br>${dto.dueDate} <br>${dto.finished}<br>
<button><a href="/todo/modify?tno=${dto.tno}">Modify</a></button>
<button><a href="/todo/remove?tno=${dto.tno}">Remove</a></button>
</body>
</html>
