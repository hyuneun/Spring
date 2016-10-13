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
** 미니계시판(전통적디비연결) **
<a href="insert">글쓰기</a>
<table border="1">
	<tr><th>번호</th><th>글제목</th><th>작성자</th><th>조회수</th></tr>
	<c:forEach items="${list }" var="d">
		<tr>
			<td>${ d.num}</td>
			<td><a href="detail?num=${d.num }&page=${currentPage}" commandName="command">${ d.title}</a></td>
			<td>${ d.author}</td>
			<td>${ d.readcnt}</td>
		</tr>
	</c:forEach>
	<!-- pagelink -->
 	<tr>
		<td colspan="4" style="text-align: center; height: 30px;">
		<c:set var="pagecount" value="${(count - 1) / pagesize + 1}" />
		<c:forEach var="p" begin="1" end="${pagecount }">
			<c:if test="${currentPage == p }">[${p }]</c:if>
			<c:if test="${currentPage != p }">
				<a href="search?pagenum=${p }">[${p }]</a>
			</c:if>
		</c:forEach>
		</td>
	</tr>
	<!-- 검색  -->
	<tr>
		<td colspan="4">
		<form action="search" method="post">
			<select name="searchName">
				<option value="author" >작성자</option>
				<option value="title">제목</option>
			</select>
			<input type="text" name="searchValue">
			<input type="submit" value="검색">
		</form>
		</td>
	</tr>
</table>
</body>
</html>