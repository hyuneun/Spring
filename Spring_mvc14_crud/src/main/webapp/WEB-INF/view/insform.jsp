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
** 회원자료 추가 **
<sfrom:form commandName="command">
아이디 : <sfrom:input path="id"/>
비번 : <sfrom:input path="passwd"/>
회원이름 : <sfrom:input path="name"/>
<input type="submit" value="츄우가">
<input type="reset" value="처기화">
</sfrom:form>
</body>
</html>