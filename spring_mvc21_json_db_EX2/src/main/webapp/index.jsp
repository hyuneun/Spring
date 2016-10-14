<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	document.getElementById("btnok").addEventListener("click", startXhr, false);
	
	function startXhr(){
	$.ajax({
		type:"get",
		url:"index",
		dataType:"json",
		data:{"buser_name":$("#buser_name").val()},
		success:function(sangpumData){
			var ss = "<table border='1'>";
			var list = sangpumData.datas;
			ss += "<tr><th>직원번호</th><th>직원명</th><th>부서전화</th><th>직급</th><th>관리고객</th></tr>"
			$(list).each(function(index,objArr){
				ss += "<tr>";
				ss +="<td>" + objArr["sawon_no"] + "</td>"
				if(objArr["sawon_count"] > 0){
				ss +="<td><a href='#' onclick=theFunc('"+ objArr["sawon_name"]  +"')>" + objArr["sawon_name"] + "</a></td>"	
				}else{
				ss +="<td>" + objArr["sawon_name"] + "</td>"
				}
				ss +="<td>" + objArr["buser_tel"] + "</td>"
				ss +="<td>" + objArr["sawon_jik"] + "</td>"
				ss +="<td>" + objArr["sawon_count"] + "</td>"
				ss += "</tr>";
			})
				ss +="</table>"
			$("#showData").append(ss);
				
		},
		error:function(){
			$("#showData").html("에러발생");
		}
	})
}

});
function theFunc(a){
	$.ajax({
		type:"get",
		url:"index2",
		dataType:"json",
		data:{"sawon_name":a},
		success:function(sangpumData2){
			var ss = "<table border='1'>";
			var list = sangpumData2.datas2;
			ss += "<tr><th>번호</th><th>이름</th><th>전화</th></tr>"
			$(list).each(function(index,objArr){
				ss += "<tr>";
				ss +="<td>" + objArr["gogek_no"] + "</td>"
				ss +="<td title='" + objArr["gogek_jumin"] + "'>" + objArr["gogek_name"] + "</td>"
				ss +="<td>" + objArr["gogek_tel"] + "</td>"
				ss += "</tr>";
			})
				ss +="</table>"
			$("#showData2").append(ss);
				
		},
		error:function(){
			$("#showData2").html("에러발생");
		}
	})
	
}

</script>
	</head> 
	<body>
		부서명 : <input type="text" id="buser_name">
		<input type="button" value="확인" id="btnok"></input>
		<br>
		<div id="showData"></div><br><br>
		<div id="showData2"></div>
		
	</body>
</html>
