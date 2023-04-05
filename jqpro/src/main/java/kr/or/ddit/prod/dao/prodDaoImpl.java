package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisSqlSessionFactory;
import kr.or.ddit.prod.vo.prodVO;

public class prodDaoImpl implements IprodDao{

	private static IprodDao dao;
	
	public static IprodDao getDao() {
		if(dao ==null) dao = new prodDaoImpl();
		
		return dao;
	} 
	

	@Override
	public List<prodVO> getProdLgu(String prodLgu) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		List<prodVO> vo = null;
		
		try {
			vo = session.selectList("prod.getProdLgu",prodLgu);
		} finally {
			session.commit();
			session.close();
		}
		return vo;
	}


	@Override
	public prodVO getProdId(String prodId) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		prodVO vo = null;
		
		try {
			vo = session.selectOne("prod.getProdId",prodId);
		} finally {
			session.commit();
			session.close();
		}
		return vo;
	}




}
