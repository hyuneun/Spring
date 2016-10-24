<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원자료등럭럭럭ㄹ걸걸거</h3>
<table border="1">
	<tr><th>ㅂ</th><th>ㅇ</th><th>ㄴ</th><th>ㅈ</th><th>d</th></tr>
	<c:forEach items="${list }" var="f">
		<tr>
			<td>${f.no }</td>
			<td><a href="member/${f.no }">${f.name }</a> 수정</td>
			<td>${f.age }</td>
			<td>${f.tel }</td>
			<td>
			<s:form action="member/${f.no }" method="delete">
				<a href="javascript:" onclick="parentElement.submit()">del</a>
			</s:form>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>