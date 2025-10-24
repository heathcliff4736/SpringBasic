<%--
  Created by IntelliJ IDEA.
  User: ehs
  Date: 2025-10-23
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Page</h1>

<ul>
    <c:forEach var="dto" items="${dtoList}">
        <li><a href="/todo/read?tno=${dto.tno}">${dto.tno} ${dto.title} ${dto.dueDate} ${dto.finished}</a></li>
<%--        <li>${dto}</li>--%>
    </c:forEach>
</ul>
</body>
</html>

