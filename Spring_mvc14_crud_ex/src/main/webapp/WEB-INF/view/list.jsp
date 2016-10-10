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
<table border="1">
	<tr><th>사번</th><th>이름</th><th>직급</th><th>부서명</th><th>관리고객</th></tr>
	<c:forEach items="${list }" var="f">
		<tr>
		<td>${f.sawon_no }</td>
		
		<c:if test="${f.gogek_ok == 'O' }">
		<td><a href="detail?id=${f.sawon_no }">${f.sawon_name }</a></td>
		</c:if>
		
		<c:if test="${f.gogek_ok == 'X' }">
		<td>${f.sawon_name }</td>
		</c:if>
		
		<td>${f.sawon_jik }</td>
		<td>${f.buser_name }</td>
		<td>${f.gogek_ok }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>