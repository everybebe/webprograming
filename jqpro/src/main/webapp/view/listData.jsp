<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//Controller에서 저장된 처리결과 값을 꺼낸다.

//vo에 없는 값들을 가져올때는 json으로 가져오고 vo에 있는 값들은 gson으로 가져올 수 있음
 List<MemberVO> varlist = (List<MemberVO>)request.getAttribute("listvalue");
 
 Gson gson = new Gson();
 String result = gson.toJson(varlist);
 	
 	out.print(result);
 	out.flush();
 	
 	
%>
<%-- [
	
	<%
		for(int i=0; i<varlist.size(); i++){
			MemberVO vo = varlist.get(i);
    		if(i > 0) out.print(",");
    %>			
		{	
		"id"   : "<%= vo.getMem_id() %>",
		"name" : "<%= vo.getMem_name() %>",
		"tel"  : "<%= vo.getMem_hp() %>",
		"mail" : "<%= vo.getMem_mail() %>"
		}
	<% 	
		}
	%>
]

 --%>