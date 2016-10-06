<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>결과</h2>
		${data }<br>
		뷰에서 커맨드 객체 접근이 가능 : ${sangpumBean.sang }<br>
		뷰에서 커맨드 객체 별명으로 접근이 가능 : ${my.sang}<br>
		뷰에직접 전달되는 모델 자료 출력하기
		<%
		ArrayList<String> list = (ArrayList)request.getAttribute("mylist");
		for(String s:list){
			out.print(s + "--");
		}
		%>
		<br>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:forEach var="s" items="${mylist }">
			${s }--
		</c:forEach>
	</body>
</html>
