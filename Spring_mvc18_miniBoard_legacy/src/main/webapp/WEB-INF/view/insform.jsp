<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 인서트 **<br>
<form action="insert" method="post" commandName="command">
작성자 : <input type="text" name="author"><br>
제목 : <input type="text" name="title"><br>
내용 : <input type="text" name="content" size="100px"><br>
<input type="submit" value="등록">
</form>

</body>
</html>