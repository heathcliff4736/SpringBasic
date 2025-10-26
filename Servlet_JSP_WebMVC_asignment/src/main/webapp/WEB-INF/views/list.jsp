<%-- 게시글 목록 JSP (list.jsp) --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Post List</title>
    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background-color: #fafafa;
        }

        table {
            width: 85%;
            margin: 30px auto;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background: #fff;
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
            transition: 0.2s ease-in;
        }

        a {
            color: #2a7ae2;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        .actions {
            width: 85%;
            margin: 20px auto;
            text-align: right;
        }

        .btn {
            display: inline-block;
            padding: 8px 16px;
            background: #4CAF50;
            color: white;
            border-radius: 5px;
            text-decoration: none;
            transition: 0.2s;
        }

        .btn:hover {
            background: #45a049;
        }
    </style>
</head>
<body>
<h2 style="text-align:center; margin-top:20px;">게시글 목록</h2>

<table>
    <thead>
    <tr>
        <th>No</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일시</th>
        <th>수정일시</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dtoList}" var="dto" varStatus="status">
        <tr>
            <td>${status.count}</td>

            <td>
                <a href="/posts/view?id=${dto.postId}">${dto.title}</a>
            </td>

            <td>${dto.writer}</td>
            <td>${dto.createdAtStr}</td>
            <td>${dto.updatedAtStr}</td>
        </tr>
    </c:forEach>

    <c:if test="${empty dtoList}">
        <tr>
            <td colspan="5">등록된 게시글이 없습니다.</td>
        </tr>
    </c:if>
    </tbody>
</table>

<div class="actions">
    <a href="/posts/new" class="btn">글쓰기</a>
</div>
</body>
</html>
