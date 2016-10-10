<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 회원 상세보기 **
<table>
	<tr><td>id</td><td>${member.id }</td></tr>
	<tr><td>name</td><td>${member.name }</td></tr>
	<tr><td>passwd</td><td>${member.passwd }</td></tr>
	<tr><td>reg_date</td><td>${member.reg_date }</td></tr>
	<tr>
		<td colspan="2">
			<a href="list">목록</a>
			<a href="update?id=${member.id }">수정</a>
			<a href="delete?id=${member.id }">삭제</a>
		</td>
	</tr>
</table>
</body>
</html>