<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
부서정보 : <br>
<c:forEach items="${data }" var="d">
부서번호 : ${d.buser_no } /
부서명 : ${d.buser_name } /
부서전화 : ${d.buser_tel } /
부서위치 : ${d.buser_loc }

</c:forEach>
</body>
</html>