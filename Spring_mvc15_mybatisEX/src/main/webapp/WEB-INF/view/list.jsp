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
** 사원자료 출력 **
<table>
	<tr><th>사번</th><th>이름</th><th>부서</th><th>직급</th><th>입사시기</th></tr>
	<c:set var="count" value="${0}" />
	<c:forEach items="${data }" var="d">
		<c:set var="count" value="${count + 1}" />
		<tr>
		<td>${d.sawon_no }</td>
		<td>${d.sawon_name }</td>
		<td><a href="search?search=${d.buser_name }" target="iframe">${d.buser_name }</a></td>
		<td>${d.sawon_jik }</td>
		<c:if test="${d.sawon_m <= 3 }">
		<td>${d.sawon_y }년 1사분기</td>
		</c:if>
		<c:if test="${d.sawon_m > 3 && d.sawon_m <= 6 }">
		<td>${d.sawon_y }년 2사분기</td>
		</c:if>
		<c:if test="${d.sawon_m > 6 && d.sawon_m <= 9 }">
		<td>${d.sawon_y }년 3사분기</td>
		</c:if>
		<c:if test="${d.sawon_m > 9 && d.sawon_m <= 12 }">
		<td>${d.sawon_y }년 4사분기</td>
		</c:if>
		
		</tr>
	</c:forEach>
	<tr><td colspan="5">인원수 : ${count }</td></tr>
	<!-- 검색 -->
	<tr>
		<td colspan="4">
			<form action="search2" method="post">
			부서별자료보기 : 
			<select name="searchValue">
				<option>전체</option>
				<option>총무부</option>
				<option>영업부</option>
				<option>관리부</option>
				<option>전산부</option>
			</select>
			<input type="submit" value="검색">
			</form>
		</td>
	</tr>
</table>

<iframe name="iframe" width="1000"></iframe>
</body>
</html>