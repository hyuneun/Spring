<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 회원자료 수정 **
<s:form action="${dto.no }" method="put">
번호 : <input type="text" name="no" value="${dto.no }">
이름 : <input type="text" name="name" value="${dto.name }">
나이 : <input type="text" name="age" value="${dto.age }">
전화 : <input type="text" name="tel" value="${dto.tel }">
<button type="submit">등록</button>
</s:form>
</body>
</html>