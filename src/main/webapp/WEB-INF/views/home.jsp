<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  111111111111111111
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

path : <%= request.getContextPath() %><br> <!-- 현재에 대한 contextPath를 얻어옴 -->

path : ${pageContext.request.contextPath }<br>

<c:set var="contextPath" value="<%= request.getContextPath() %>" />

<img src="${contextPath }/resources/images/pet4.jpg" width="100" height="100">
<img src='<c:url value="/img/pet4.jpg" />' width="100" height="100">
</body>
</html>
