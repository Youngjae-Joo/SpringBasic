<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수정하기
	<form action="modifyThis" method="post">
		번호 : <input type="text" name="num" value="${num}" readonly="readonly"/><br/> 
		이름 : <input type="text" name="name" placeholder="${name}"/><br/>
		국어 : <input type="number" name="kor" placeholder="${kor}"/><br/>
		영어 : <input type="number" name="eng" placeholder="${eng}"/><br/>
		<input type="submit" value="수정"/>
	</form>
</body>
</html>