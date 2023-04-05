<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장한 데이터 꺼내기

//vo에 없는 값들을 가져올때는 json으로 가져오고 vo에 있는 값들은 gson으로 가져올 수 있음
  List<LprodVO> aaaaa = (List<LprodVO>)request.getAttribute("dddd");
  
  Gson gson = new Gson();
  
  String result = gson.toJson(aaaaa);
  
  out.print(result);
  out.flush();

%>
<%-- [
 <%
 	for(int i=0; i<aaaaa.size(); i++) {
 		LprodVO vo = aaaaa.get(i);
 		if(i > 0) out.print(",");
 %>		
 	{
    	"id" : "<%= vo.getLprod_id() %>",
    	"gu" : "<%= vo.getLprod_gu() %>",
    	"nm" : "<%= vo.getLprod_nm() %>"
 	}
 <% 	
 	}
 %>
]
 --%>