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
		${article.num }
		${article.name }
		${article.kor }
		${article.eng }
		<a href="delete?num=${article.num }">삭제</a>
		<a href="modify?num=${article.num }&name=${article.name}&kor=${article.kor}&eng=${article.eng}">수정</a>
		<hr/>
	</c:forEach>
</body>
</html>