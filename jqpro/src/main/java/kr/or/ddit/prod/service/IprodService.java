package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.vo.prodVO;

public interface IprodService {


	public List<prodVO> getProdLgu(String prodLgu);
	
	public prodVO getProdId(String prodId);
}
