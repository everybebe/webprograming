<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//controller에서 저장한 데이터 꺼내기

//vo에 없는 값들을 가져올때는 json으로 가져오고 vo에 있는 값들은 gson으로 가져올 수 있음
List<BuyerVO> buylist = (List<BuyerVO>)request.getAttribute("a"); //컨트롤러에서 저장한 값을 입력해줘야함

Gson gson = new Gson();

String result = gson.toJson(buylist);

out.print(result);
out.flush();


%>
<%-- 
[

<% 

 for(int i =0; i<buylist.size(); i++){
	 BuyerVO vo = buylist.get(i);
	 if(i > 0) out.print(",");

%>
 {
 
		"name" : "<%= vo.getBuyer_name() %>",
 		"id"   : "<%= vo.getBuyer_id() %>"
 }
,
{
	    "lgu"  : "<%= vo.getBuyer_lgu() %>",
		"bank" : "<%= vo.getBuyer_bank() %>",
		"bankno" : "<%= vo.getBuyer_bankno() %>",
		"bankname" :"<%= vo.getBuyer_bankname() %>",
		"zip" : "<%= vo.getBuyer_zip() %>",
		"add1" : "<%= vo.getBuyer_add1() %>",
		"add2" : "<%= vo.getBuyer_add2() %>",
		"mail" : "<%= vo.getBuyer_mail() %>"
}

 <%
 }
 %>

]     --%>