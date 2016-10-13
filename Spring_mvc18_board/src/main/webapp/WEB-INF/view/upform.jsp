<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
번호 : ${dto.num }<br>
<input type="hidden" name="num" value="${dto.num }">
작성자 : <input type="text" name="author" value="${dto.author }"><br>
제목 : <input type="text" name="title" value="${dto.title }"><br>
내용 : <input type="text" name="content" value="${dto.content }"><br>
<input type="submit" value="수정">
</form>
</body>
</html>