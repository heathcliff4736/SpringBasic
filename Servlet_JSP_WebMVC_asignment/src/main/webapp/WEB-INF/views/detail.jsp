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
            align-items: center; /* 버튼과 폼 정렬 */
        }

        .buttons form {
            display: flex; /* form 안도 flex */
            margin: 0; /* 불필요한 여백 제거 */
        }

        .btn {
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            border: none;
            font-size: 1em;
            cursor: pointer;
            transition: 0.2s;
            display: inline-flex;
            align-items: center;
            justify-content: center;
        }

        .btn-edit-delete {
            background-color: #4CAF50;
            color: white;
        }

        .btn-edit-delete:hover {
            background-color: #45a049;
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
        작성일: ${dto.createdAtStr} |
        수정일: ${dto.updatedAtStr}
    </div>
    <div class="content">
        <c:out value="${dto.content}" />
    </div>
    <div class="buttons">
        <!-- 수정/삭제 버튼 클릭 시 form.jsp로 이동 -->
        <a href="/posts/edit?id=${dto.postId}" class="btn btn-edit-delete">수정/삭제</a>
        <a href="/posts" class="btn btn-list">목록</a>

        <!-- 삭제 실패 메시지 표시 -->
        <c:if test="${not empty errorMsg}">
            <div style="color:red; font-weight:bold; margin-top:15px;">
                    ${errorMsg}
            </div>
<%--            ${errorMsg}에 따옴표, 줄바꿈, 특수문자가 들어가면 alert가 깨질 수 있음.--%>
            <script type="text/javascript">
                alert('<c:out value="${errorMsg}" />');
            </script>
        </c:if>
    </div>
</div>

</body>
</html>
