package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.prod.vo.prodVO;

public interface IMemberDao {

	//MemberList
	public List<MemberVO> getAllMember();
	
	//가입(저장)하기
	public int insertMember(MemberVO vo);
	
	//id 중복 검사
	public String idCheck(String id);
	
	//우편번호 찾기
	public List<ZipVO> selectByDong(String dong);
	
	
}
