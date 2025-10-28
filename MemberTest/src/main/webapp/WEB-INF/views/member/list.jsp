<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원 목록</title>
</head>
<body>
<h2>회원 목록</h2>

<table border="1" cellspacing="0" cellpadding="8">
    <thead>
    <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty memberList}">
            <c:forEach var="member" items="${memberList}">
                <tr>
                    <td><c:out value="${member.mid}" /></td>
                    <td><c:out value="${member.mpw}" /></td>
                    <td><c:out value="${member.mname}" /></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="3" style="text-align:center;">등록된 회원이 없습니다.</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>

<br>
<a href="${pageContext.request.contextPath}/member/register">회원 등록</a>
</body>
</html>
