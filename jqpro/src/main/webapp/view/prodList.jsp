<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.or.ddit.prod.vo.prodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//controller에서 저장된 결과값 꺼내기

List<prodVO> list = (List<prodVO>)request.getAttribute("abc");
//vo에 없는 값들을 가져올때는 json으로 가져오고 vo에 있는 값들은 gson으로 가져올 수 있음

JsonObject obj = new JsonObject();

if(list !=null && list.size() > 0) {
	obj.addProperty("flag", "ok");
	
	Gson gson = new Gson();
	JsonElement jele = gson.toJsonTree(list);
	
	obj.add("datas", jele);
	
} else {
	obj.addProperty("flag", "no");	
}
	
out.print(obj);
out.flush();

%>
<%-- {
	"flag" : "ok",
	"datas" :
[
<%
	for(int i=0; i<list.size(); i++) {
		prodVO vo = list.get(i);
		if(i > 0) out.print(",");
%>
	{
		"id" : "<%= vo.getProd_id()%>",
		"name" : "<%= vo.getProd_name()%>"		
	}

<% 
	}
%>	
 ]
}
<%
}else {
%>	
	{
		"flag" : "no"
	}
<%
}
%> 
--%>