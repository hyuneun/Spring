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
	$("#btnOk1").click(function(){
		$("#showData").html("")
		$.ajax({
			type:"get",
			url:"list",
			data:{"name":"tom"},
			dataType:"json",
			success:function(data){
				var ss = "";
				ss+= data.name; + "<br>"
				ss+= data.skills[0]; + "<br>"
				ss+= data.skills[1]; + "<br>"
				ss+= data.skills[2]; + "<br>"
				$("#showData").html(ss);
			},
			error:function(){
				$("#showData").html("에러발생");
			}
		})
	})
	
	$("#btnOk2").click(function(){

		$("#showData").html("")
		$.ajax({
			type:"get",
			url:"list2",
			dataType:"json",
			success:function(data){
				var ss = "<table border='1'>";
				var list = data.datas;
				$(list).each(function(index,objArr){
					ss += "<tr>";
					ss +="<td>" + objArr["name"] + "</td>"
					ss +="<td>" + objArr["age"] + "</td>"
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
});
</script>
</head>
<body>
json 읽기<br>
<input type="button" value="자료읽기" id="btnOk1"><br>
<input type="button" value="다수의 자료읽기" id="btnOk2">
<hr>
<div id="showData"></div>
</body>
</html>