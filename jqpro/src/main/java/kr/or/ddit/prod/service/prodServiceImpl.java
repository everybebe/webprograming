package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.prod.dao.IprodDao;
import kr.or.ddit.prod.dao.prodDaoImpl;
import kr.or.ddit.prod.vo.prodVO;

public class prodServiceImpl implements IprodService {
	private IprodDao dao;
	private static IprodService service;
	

	private prodServiceImpl() {
		dao = prodDaoImpl.getDao();
	}
	
	public static IprodService getService() {
		if(service == null) service = new prodServiceImpl();
		
		return service;
	}


	
	@Override
	public List<prodVO> getProdLgu(String prodLgu) {
		return dao.getProdLgu(prodLgu);
	}

	@Override
	public prodVO getProdId(String prodId) {
		return dao.getProdId(prodId);
	}


}
