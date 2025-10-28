<%--
  Created by IntelliJ IDEA.
  User: ehs
  Date: 2025-10-28
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원 등록</title>
</head>
<body>
<h2>회원 등록</h2>
<form action="/member/save" method="post">
    <div>
        <label for="mid">ID : </label>
        <input type="text" name="mid" id="mid" required />
    </div>
    <div>
        <label for="mpw">PASSWORD : </label>
        <input type="password" name="mpw" id="mpw" required />
    </div>
    <div>
        <label for="mname">NAME : </label>
        <input type="text" name="mname" id="mname" required />
    </div>
    <div>
        <button type="submit">Register</button>
    </div>
</form>
</body>
</html>
