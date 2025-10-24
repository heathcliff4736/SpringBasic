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
    <title>Read</title>
</head>
<body>
<input type="text" name="tno" value="${dto.tno}" readonly><br>
<input type="text" name="title" value="${dto.title}" readonly><br>
<input type="date" name="dueDate" value="${dto.dueDate}" readonly><br>
<input type="checkbox" name="finished" value="${dto.finished}" readonly><br>
<button><a href="/todo/modify?tno=${dto.tno}">Modify</a></button>
<button><a href="/todo/remove?tno=${dto.tno}">Remove</a></button>
<button><a href="/todo/list">List</a></button>

</body>
</html>
