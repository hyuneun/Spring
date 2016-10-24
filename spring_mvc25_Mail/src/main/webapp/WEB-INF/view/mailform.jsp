<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><!-- html5 -->
2메일보내기~
<form action="send" method="post">			<!-- 예시보여주는거 -->
받는사람 : <input type="email" placeholder="abc@abc.com" name="receiver"><br>
글제목 : <input type="text" name="subject"><br>
내용 : <textarea rows="5" cols="50" name="content"></textarea><br>
<input type="submit">
</form>
</body>
</html>