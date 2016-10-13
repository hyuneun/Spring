<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 답글달기 **<br>
<form action="reinsert" method="post" commandName="command">
작성자 : <input type="text" name="author"><br>
제목 : <input type="text" name="title"><br>
내용 : <input type="text" name="content" style="width: 250px; height: 120px;"><br>
<input type="hidden" value="${num }" name="gnum">
<input type="submit" value="등록">
</form>

</body>
</html>