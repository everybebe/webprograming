package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.mybatis.config.MybatisSqlSessionFactory;


/*
 * 자신의 객체를 생성해서 리턴하는 메소드 
 * mapper에 접근하여 sql문을 실행 - SqlSession 객체가 필요 - SqlSessionFactory이 생성
 */

public class MemberDaoImpl implements IMemberDao{

	private SqlSessionFactory sessionFactory;
	private static IMemberDao dao;
	
	//생성자
	private MemberDaoImpl() {
		sessionFactory = MybatisSqlSessionFactory.getSessionFactory();
	}
	
	//자기자신 객체를 리턴
	public static IMemberDao getDao() {
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
			//SqlSession 객체가 필요
			
			//SqlSession session = sessionFactory.openSession(true);  //오토 커밋
			SqlSession session = null;
			List<MemberVO> list = null;
		
		try {
			 session = MybatisSqlSessionFactory.getSqlSession();
			 list = session.selectList("member.getAllMember");
		}finally {
			session.close();
		}
		return list;
	}

	public int insertMember(MemberVO vo) {
		int cnt = 0;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			
			cnt = session.insert("member.insertMember",vo);
			
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public String idCheck(String id) {
		
		String res = null;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			res = session.selectOne("member.idCheck",id);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {

		List<ZipVO> list = null;
		
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		try {
			list = session.selectList("member.selectByDong", dong);
		} finally {
			session.commit();
			session.close();
		}
			
		return list;
	}


}
