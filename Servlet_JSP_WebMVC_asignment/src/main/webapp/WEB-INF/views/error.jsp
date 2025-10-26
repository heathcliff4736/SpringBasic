<%--
  Created by IntelliJ IDEA.
  User: looko
  Date: 2025-10-26
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%-- error.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>오류 발생</title>
    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .container {
            width: 50%;
            margin: 100px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            padding: 40px;
            text-align: center;
        }

        h2 {
            color: #f44336;
            margin-bottom: 20px;
        }

        p {
            font-size: 1.1em;
            color: #333;
            margin-bottom: 30px;
        }

        a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: 0.2s;
        }

        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>오류가 발생했습니다</h2>
    <p>${errorMsg}</p>
    <a href="javascript:history.back()">뒤로가기</a>
</div>
</body>
</html>

