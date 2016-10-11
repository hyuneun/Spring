<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
글번호 : ${list.num } / 제목 : ${list.title } /&nbsp;&nbsp; 작성자 ${list.author }<br>
날짜 ${list.bwrite } / 조회수 ${list.readcnt }<br>
내용 : <br>
${list.content }<br>
<a href="update?num=${list.num }">수정</a>
<a href="delete?num=${list.num }">삭제</a>
</body>
</html>