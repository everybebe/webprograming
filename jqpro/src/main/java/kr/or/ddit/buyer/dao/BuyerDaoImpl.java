package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.mybatis.config.MybatisSqlSessionFactory;

public class BuyerDaoImpl implements IBuyerDao {

	private static IBuyerDao dao;
	
	//자신의 객체 생성 리턴
	public static IBuyerDao getDao() {
		if(dao == null) dao = new BuyerDaoImpl();
		
		return dao;
	} 
	
	@Override
	public List<BuyerVO> selectIdName() {
	
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();

		List<BuyerVO> list = null;
		
		try {
			list = session.selectList("buyer.selectIdName");
		}
		finally {
			session.commit();
			session.close();
		}
		return list;
	}

	@Override
	public BuyerVO selectById(String id) {
	
		SqlSession session = MybatisSqlSessionFactory.getSqlSession(); 
		BuyerVO vo = null;
		try {
		
		vo = session.selectOne("buyer.selectById",id);
		
		}finally {
			session.commit();
			session.close();
		}
		
		
		return vo;
	}

	


}
