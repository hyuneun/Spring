<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#showData").empty();
	$.ajax({
		type:"get",
		url:"sangpum",
		data:{"name":"tom"},
		dataType:"json",
		success:function(sangpumData){
			var ss = "<table border='1'>";
			var list = sangpumData.datas;
			$(list).each(function(index,objArr){
				ss += "<tr>";
				ss +="<td>" + objArr["code"] + "</td>"
				ss +="<td>" + objArr["sang"] + "</td>"
				ss +="<td>" + objArr["su"] + "</td>"
				ss +="<td>" + objArr["dan"] + "</td>"
				ss += "</tr>";
			})
				ss +="</table>"
			$("#showData").append(ss);
		},
		error:function(){
			$("#showData").html("에러발생");
		}
	})
});
</script>
</head>
<body>
<div id="showData">요ㅕ기룣ㄹ</div>
</body>
</html>