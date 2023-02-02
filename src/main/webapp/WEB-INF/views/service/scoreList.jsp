<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>목록화면</h3>
	
	<c:forEach var="article" items="${list }" varStatus="num">
		${num.index }
		${article.name }
		${article.kor }
		${article.eng }
		<a href="delete?num=${num.index }">삭제</a>
		<hr/>
	</c:forEach>
</body>
</html>