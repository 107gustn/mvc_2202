<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table border="1">
		<tr>
			<th>이름</th><th>나이</th><th>주소</th>
		</tr>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.name }</td> <td>${dto.age }</td> <td>${dto.addr }</td>
		</tr>
		</c:forEach>
	</table>
	<a href="/mvc/m_index">index</a>
</body>
</html>