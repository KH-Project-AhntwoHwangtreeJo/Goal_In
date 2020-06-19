package com.semi.member.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.member.exception.MemberException;
import com.semi.member.model.dao.MemberDAO;
import com.semi.member.model.vo.Member;

public class MemberService {
	private Connection con;
	private MemberDAO mDAO = new MemberDAO();
	
	// 정보 추가
	public int insertMember(Member m) throws MemberException {
		con = getConnection();
		int result = mDAO.insertMember(con, m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}
	// 회원 로그인
	public Member selectMember(Member m) throws MemberException {
		con = getConnection();
		Member result = mDAO.selectMember(con, m);
		
		close(con);
		
		if(result == null) throw new MemberException("[Service에러] : 로그인 실패!");
		
		return result;
	}
	// 회원정보 수정
	public int updateMember(Member m) throws MemberException{
		con = getConnection();
		
		int result = mDAO.updateMember(con, m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	// 회원 탈퇴
	public int deleteMember(String userid, String userpwd) throws MemberException{
		// TODO Auto-generated method stub
		con = getConnection();
		
		int result = mDAO.deleteMember(con, userid, userpwd);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	// 아이디 중복체크
	public int idDupCheck(String id) {
		con = getConnection();
		
		int result = mDAO.idDupCheck(con, id);
		
		close(con);
		System.out.println("값?"+ result);
		return result;
	}
	// 관리자 회원 조회
	public ArrayList<Member> selectList() throws MemberException {
		con = getConnection();

		ArrayList<Member> list = mDAO.selectList(con);

		close(con);

		return list;
	}
	
	// 관리자 회원 삭제(비활성화)
	public int updateStatus(String userId, String status) {
		con = getConnection();

		int result = mDAO.updateStatus(con, userId, status);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	
}