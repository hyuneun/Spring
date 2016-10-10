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
<%-- <table>
	<tr><td colspan="2"><a href="insert">추가</a></td></tr>
	<tr><th>아디</th><th>이름</th></tr>
	<c:forEach items="${list }" var="f">
		<tr>
		<td>${f.id }</td>
		<td><a href="detail?id=${f.id }">${f.name }</a></td>
		</tr>
	</c:forEach>
</table> --%>

<c:if test="${count ==0 }">
출력자료가 없다<a href="insert">추가하러가기</a>
</c:if>

<c:if test="${count > 0 }">
<table>
	<tr><td colspan="2"><a href="insert">추가</a></td></tr>
	<tr><th>아디</th><th>이름</th></tr>
	<c:forEach items="${list }" var="f">
		<tr>
		<td>${f.id }</td>
		<td><a href="detail?id=${f.id }">${f.name }</a></td>
		</tr>
	</c:forEach>
	<!-- pagelink -->
	<tr>
		<td colspan="2" style="text-align: center; height: 30px;">
		<c:set var="pagecount" value="${(count - 1) / pagesize + 1}" />
		<c:forEach var="p" begin="1" end="${pagecount }">
			<c:if test="${currentPage == p }">${p }</c:if>
			<c:if test="${currentPage != p }">
				<a href="list?pagenum=${p }">${p }</a>
			</c:if>
		</c:forEach>
		</td>
	</tr>
</table>
</c:if>
</body>
</html>