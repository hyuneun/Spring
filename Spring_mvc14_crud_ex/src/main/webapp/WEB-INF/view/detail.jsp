<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 회원 상세보기 **<br>
<table border="1">
<c:forEach items="${member }" var="f">
	${f.sawon_name } ${f.sawon_jik } 님의 관리고객
</c:forEach>
<tr><th>고객번호</th><th>고객이름</th><th>성별</th><th>나이</th><th>전화</th></tr>
<c:forEach items="${member }" var="f">
	<tr>
		<td>${f.gogek_no }</td>
		<td>${f.gogek_name }</td>
		<td>${f.gogek_gen }</td>
		<td>${f.gogek_age }</td>
		<td>${f.gogek_tel }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>