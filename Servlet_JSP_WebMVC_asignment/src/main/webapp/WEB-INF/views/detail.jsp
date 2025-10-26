<%-- 게시글 상세 보기 JSP (detail.jsp) --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>${dto.title}</title>
    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .container {
            width: 60%;
            margin: 50px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .info {
            color: #666;
            font-size: 0.9em;
            margin-bottom: 15px;
            text-align: right;
        }

        .content {
            border: 1px solid #ddd;
            padding: 15px;
            border-radius: 5px;
            background: #fafafa;
            min-height: 150px;
            white-space: pre-wrap;
            margin-bottom: 25px;
        }

        .buttons {
            display: flex;
            gap: 10px;
        }

        .btn {
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            border: none;
            font-size: 1em;
            cursor: pointer;
            transition: 0.2s;
        }

        .btn-edit {
            background-color: #4CAF50;
            color: white;
        }

        .btn-edit:hover {
            background-color: #45a049;
        }

        .btn-delete {
            background-color: #f44336;
            color: white;
        }

        .btn-delete:hover {
            background-color: #e53935;
        }

        .btn-list {
            background-color: #ccc;
            color: black;
        }

        .btn-list:hover {
            background-color: #bbb;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>${dto.title}</h2>
    <div class="info">
        작성자: ${dto.writer} |
        작성일: <fmt:formatDate value="${dto.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/> |
        수정일: <fmt:formatDate value="${dto.updatedAt}" pattern="yyyy-MM-dd HH:mm:ss"/>
    </div>
    <div class="content">${dto.content}</div>

    <div class="buttons">
        <a href="/posts/edit?id=${dto.postId}" class="btn btn-edit">수정</a>

        <form method="post" action="/posts/delete" style="display:inline;">
            <input type="hidden" name="postId" value="${dto.postId}"/>
            <input type="hidden" name="passphrase" value="${dto.passphrase}"/>
            <button type="submit" class="btn btn-delete" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</button>
        </form>

        <a href="/posts" class="btn btn-list">목록</a>
    </div>
</div>

</body>
</html>
