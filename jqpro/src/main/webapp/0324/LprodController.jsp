<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.lprod.service.LprodServiceImpl"%>
<%@page import="kr.or.ddit.lprod.service.ILprodService"%>
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

	//요청 데이터
	
	//service 객체를 얻어오기
	ILprodService service = LprodServiceImpl.getService();
	//service 메소드 호출 - 결과값 받기 
	List<LprodVO> list = service.selectAll();
	//결과값을 request에 저장
	request.setAttribute("dddd",list);
	//view 페이지로 이동
	RequestDispatcher fasdfasfa = request.getRequestDispatcher("/view/LprodList.jsp");
	fasdfasfa.forward(request, response);

%>
</body>
</html>