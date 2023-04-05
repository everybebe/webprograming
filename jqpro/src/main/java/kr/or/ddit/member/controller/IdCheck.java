package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
	
		
		//요청시 전송데이터 받기 -id
		String uId = request.getParameter("id");
		
		//service 객체 얻기
		IMemberService service = MemberServiceImpl.getService();
		
		//service 메소드 호출 - 결과값 받기
		String id = service.idCheck(uId);
		//a001 입력시 a001를 리턴
		//korea 입력시 null를 리턴
		
				
		
		//result에 결과값 저장
		request.setAttribute("idcheck", id);
		
		//view페이지로 이동
		request.getRequestDispatcher("/view/idcheck.jsp").forward(request, response);
	}

}
