package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.prodVO;

public interface IprodDao {

	public List<prodVO> getProdLgu(String prodLgu);
	
	public prodVO getProdId(String prodId);
}
