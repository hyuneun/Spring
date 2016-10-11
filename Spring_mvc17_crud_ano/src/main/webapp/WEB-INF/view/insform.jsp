<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 회원 입서트 **<br>
<form action="insert" method="post" commandName="command">
번호 : <input type="text" name="num"><br>
이름 : <input type="text" name="name"><br>
주소 : <input type="text" name="addr" size="100px"><br>
<input type="submit" value="등록">
</form>

</body>
</html>