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
	
	request : <%= request.getAttribute("test") %><br>
	el : ${ test}<br>
	str : ${str[0]},  ${str[1]},  ${str[2]}
	<hr>
	<c:forEach var="s" items="${str }">
		<b>${s }</b> <br>
	</c:forEach>
	
	<h3>로그인</h3>
	<a href="http://localhost:8085/mvc/index">index</a>
	<a href="http://localhost:8085/mvc/logout">로그아웃</a>
</body>
</html>