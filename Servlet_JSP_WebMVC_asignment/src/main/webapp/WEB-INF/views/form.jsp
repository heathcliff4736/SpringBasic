<%-- 게시글 작성/수정 공용 폼 JSP (form.jsp) --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>${empty dto ? "글쓰기" : "게시글 수정"}</title>
    <style>
        body {
            font-family: "Segoe UI", Arial, sans-serif;
            background-color: #fafafa;
        }

        .container {
            width: 60%;
            margin: 50px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            padding: 30px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
        }

        textarea {
            resize: vertical;
            min-height: 150px;
        }

        .buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
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

        .btn-save {
            background-color: #4CAF50;
            color: white;
        }

        .btn-save:hover {
            background-color: #45a049;
        }

        .btn-cancel {
            background-color: #ccc;
            color: black;
        }

        .btn-cancel:hover {
            background-color: #bbb;
        }

        .btn-delete {
            background-color: #f44336;
            color: white;
        }

        .btn-delete:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>${empty dto ? "글쓰기" : "게시글 수정"}</h2>

    <form method="post" action="${empty dto ? '/posts/save' : '/posts/update'}">
        <input type="hidden" name="postId" value="${dto.postId}" />

        <label for="title">제목</label>
        <input type="text" id="title" name="title" value="${dto.title}" required />

        <label for="content">내용</label>
        <textarea id="content" name="content" required>${dto.content}</textarea>

        <label for="writer">작성자</label>
        <input type="text" id="writer" name="writer" value="${dto.writer}" readonly required />

        <label for="passphrase">비밀번호</label>
        <input type="password" id="passphrase" name="passphrase" required />

        <div class="buttons">
            <!-- 수정 버튼: form action 그대로 POST /posts/update -->
            <button type="submit" class="btn btn-save">수정</button>

            <!-- 삭제 버튼: form action 변경 후 POST /posts/delete -->
            <button type="submit" class="btn btn-delete"
                    formaction="/posts/delete"
                    onclick="return confirm('정말 삭제하시겠습니까?');">삭제</button>

            <a href="/posts" class="btn btn-cancel">취소</a>
        </div>

        <!-- 삭제 실패 메시지 표시 -->
        <c:if test="${not empty errorMsg}">
            <div style="color:red; font-weight:bold; margin-top:15px;">
                    ${errorMsg}
            </div>
        </c:if>
    </form>
</div>

</body>
</html>
