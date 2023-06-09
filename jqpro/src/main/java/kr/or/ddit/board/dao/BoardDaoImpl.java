package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.mybatis.config.MybatisSqlSessionFactory;

public class BoardDaoImpl implements IBoardDao {

	//자신의 객체
	private static IBoardDao dao;
	
	
	//자신의 객체를 생성하고 리턴하는 메소드
	public static IBoardDao getDao() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertBoard(BoardVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("board.insertBoard",vo);
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int num) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.delete("board.deleteBoard",num);
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}


	@Override
	public int updateBoard(BoardVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("board.updateBoard",vo);
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}


	@Override
	public int updateHit(int num) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
			
		try {
			cnt = session.update("board.updateHit",num);
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}


	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
        SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		List<BoardVO> list = null;
		
		try {
			list = session.selectList("board.selectByPage",map);
		} finally {
			session.commit();
			session.close();
		}
		
		return list;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("board.ReplyVO",vo);
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}


	@Override
	public int deleteReply(int renum) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.delete("board.deleteReply",renum);
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("board.updateReply",vo);
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.selectOne("board.totalCount",map);
		} finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

}
