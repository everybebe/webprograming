package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IprodService;
import kr.or.ddit.prod.service.prodServiceImpl;
import kr.or.ddit.prod.vo.prodVO;

/**
 * Servlet implementation class ProdNames
 */
@WebServlet("/ProdNames.do")
public class ProdNames extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//요청 시 전송데이터 받기 - lprod_gu
		String lgu =  request.getParameter("guvalue");
		
		//service객체 얻어오기
		IprodService service = prodServiceImpl.getService();
		
		//service 메소드 호출 - 결과값 받는다
		List<prodVO> list = service.getProdLgu(lgu);
		
		//결과값을 저장 
		request.setAttribute("abc", list);
		
		//view페이지로 이동 
		request.getRequestDispatcher("/view/prodList.jsp").forward(request, response);
		
	}

}
