package kr.or.ddit.prod.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IprodService;
import kr.or.ddit.prod.service.prodServiceImpl;
import kr.or.ddit.prod.vo.prodVO;

/**
 * Servlet implementation class ProdDetail
 */
@WebServlet("/ProdDetail.do")
public class ProdDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청시 전송 데이터
		String prodId = request.getParameter("prodId");  //ajax data에서 준 이름과 같게  //ajax에서 가져온 데이터를 prodId에 대입하여 호출
		
		//service객체 얻기
		IprodService service = prodServiceImpl.getService();
		
		//service메소드 호출 - 결과값 받기
		prodVO vo = service.getProdId(prodId);   //요청시 전송 데이터 변수명을 줘야함
		
		//결과값 저장
		request.setAttribute("prodvo", vo);
		
		//view 페이지로 이동
		request.getRequestDispatcher("/view/prodDetail.jsp").forward(request, response);
		
		
			
	}

}
