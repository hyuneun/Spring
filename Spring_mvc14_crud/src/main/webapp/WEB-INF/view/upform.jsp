<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sfrom" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 회원자료 수정 **
<sfrom:form commandName="upcommand">
아이디 : ${update.id }
비번 : <sfrom:input path="passwd"/>
회원이름 : <sfrom:input path="name"/>
<input type="submit" value="수정">
</sfrom:form>
</body>
</html>