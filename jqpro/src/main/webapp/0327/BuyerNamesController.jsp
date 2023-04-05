<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<%
	//요청 데이터 받기

	//service 객체를 얻어오기
 	IBuyerService service = BuyerServiceImpl.getService();

	//service 메소드 호출 - 결과값 받기 
	
	List<BuyerVO> list = service.selectIdName();
	
	//결과값을 request에 저장
	request.setAttribute("a",list);
	
	//view 페이지로 이동
	RequestDispatcher rd = request.getRequestDispatcher("/view/BuyerList.jsp");
	rd.forward(request, response);



%>
</body>
</html>