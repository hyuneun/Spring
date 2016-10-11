<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 회원자료를 봅니다 **(@mvc-mybatis crud)<br>
<a href="insert">추가</a><br>
<table border="1">
	<tr><th>num</th><th>name</th><th>addr</th><th>optuion</th></tr>
	<c:forEach items="${list }" var="m">
	<tr>
		<td>${m.num }</td>
		<td>${m.name}</td>
		<td>${m.addr}</td>
		<td>
			<a href="update?num=${m.num }">수정</a>
			<a href="delete?num=${m.num }">삭제</a>
		</td>

	</tr>
	</c:forEach>
</table>
</body>
</html>