<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/mystyle.css">
<script src="../js/jquery-3.6.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$('#Lprod').on('click', function(){
		
		$.ajax({
			url : 'http://localhost/jqpro/0324/LprodController.jsp',
			type : 'get',
			success : function(res){
				//alert("성공");
				code = "<table border='1'>";
				code += "<tr><td>아이디</td><td>품번</td>";
				code += "<td>상품명</td></tr>";
				
				$.each(res, function(i, v){
					code += "<tr><td>" + v.lprod_id + "</td><td>" + v.lprod_gu + "</td><td>" + v.lprod_nm + "</td>";
				})
				
				code += "</table>"
				
				$('#result1').html(code);
				
			},
			
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
			
		})		
	})	
	
	

})
</script>
</head>
<body>
<div class="box">
		<p></p>
	
		<input type="button" value="LPROD리스트" id="Lprod"> 
		<br><br>

		<div class="result" id="result1"></div>
	</div>
	
	
	<div class="box">
		<p></p>
	
		<input type="button" value="buyer리스트" id="Buyer"> 
		<br><br>

		<div class="result" id="result2"></div>
	</div>
</body>
</html>