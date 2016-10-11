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
** 상품자료 출력 **
<table>
	<tr><th>c</th><th>sa</th><th>su</th><th>d</th></tr>
	<c:forEach items="${data }" var="d">
		<tr>
		<td>${d.code }</td><td>${d.sang }</td><td>${d.su }</td><td>${d.dan }</td>
		</tr>
	</c:forEach>
	<!-- 검색 -->
	<tr>
		<td colspan="4">
			<form action="search" method="post">
			상품명 : <input type="text" name="searchValue">
			<input type="submit" value="검색">
			</form>
		</td>
	</tr>
</table>
</body>
</html>