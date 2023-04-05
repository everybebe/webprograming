<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.prod.vo.prodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//controller에서 저장한 데이터 꺼내기

//vo에 없는 값들을 가져올때는 json으로 가져오고 vo에 있는 값들은 gson으로 가져올 수 있음
prodVO vo = (prodVO)request.getAttribute("prodvo");

Gson gson = new Gson();
String result = gson.toJson(vo);

out.print(result);
out.flush();

%>
<%-- 
{
	"id" : "<%= vo.getProd_id() %>",
	"lgu" : "<%= vo.getProd_lgu() %>",
	"name" : "<%= vo.getProd_name() %>",
	"price" : "<%= vo.getProd_price() %>",
	"detail" : "<%= vo.getProd_detail() %>",
	"cost" : "<%= vo.getProd_cost() %>",
	"buyer" : "<%= vo.getProd_buyer() %>",
	"sale" : "<%= vo.getProd_sale() %>",
	"outline" : "<%= vo.getProd_outline() %>"
} --%>