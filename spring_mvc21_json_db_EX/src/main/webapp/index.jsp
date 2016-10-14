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

	//$("#showData").empty();
	
	
function startXhr(){
	$.ajax({
		type:"get",
		url:"index",
		dataType:"json",
		data:{"gogek_no":$("#gogek_no").val(),"gogek_name":$("#gogek_name").val()},
		success:function(sangpumData){
			var ss = "<table border='1'>";
			var list = sangpumData.datas;
			$(list).each(function(index,objArr){
				ss += "<tr>";
				ss +="<td>" + objArr["sawon_name"] + "</td>"
				ss +="<td>" + objArr["sawon_jik"] + "</td>"
				ss +="<td>" + objArr["buser_name"] + "</td>"
				ss +="<td>" + objArr["buser_tel"] + "</td>"
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

</script>
	</head> 
	<body>
	
		
		관리고객 찾기<br>
		고객번호 : <input type="text" id="gogek_no">
		고객명 : <input type="text" id="gogek_name">
		<input type="button" value="확인" id="btnok"></input>
		
		<br>
		<div id="showData">요기출력</div>
	</body>
</html>
