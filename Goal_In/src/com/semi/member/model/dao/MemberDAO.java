package com.semi.member.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.member.exception.MemberException;
import com.semi.member.model.vo.Member;

public class MemberDAO {
	// SQL을 별도로 보관하는 Properties 객체 생성하기
	private Properties prop;

	public MemberDAO() {
		prop = new Properties();

		String filePath = MemberDAO.class.getResource("/config/member.properties").getPath();

		// System.out.println(filePath);

		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 회원 가입 
	public int insertMember(Connection con, Member m) throws MemberException {
		// 결과 확인을 위한 변수 result 생성
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertMember");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, m.getUserid());
			pstmt.setString(2, m.getUserpwd());
			pstmt.setString(3, m.getUsername());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getNickname());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getMimage());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new MemberException("[DAO 에러] : " + e.getMessage());

		} finally {
			close(pstmt);
		}

		return result;
	}
	// 회원 탈퇴
	public int deleteMember(Connection con, String userid, String userpwd) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userid); 
			pstmt.setString(2, userpwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			throw new MemberException("[DAO 에러 발생] : " + e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	// 회원 로그인
	public Member selectMember(Connection con, Member m) throws MemberException {
		// 1. 사용할 변수 선언
		Member result = null; // 결과를 담을 객체
		PreparedStatement pstmt = null; // 쿼리 실행할 객체
		ResultSet rset = null; // Select 결과를 받아 올 객체

		String sql = prop.getProperty("selectMember");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, m.getUserid());
			pstmt.setString(2, m.getUserpwd());

			rset = pstmt.executeQuery();

			System.out.println("result 조회 전 : " + result);

			if (rset.next()) {
				result = new Member();

				result.setUserid(m.getUserid());
				result.setUserpwd(m.getUserpwd());
				result.setUsername(rset.getString("MEMBER_NM"));
				result.setPhone(rset.getString("MEMBER_PH"));
				result.setAddress(rset.getString("MEMBER_AD"));
				result.setEmail(rset.getString("MEMBER_EM"));
				result.setNickname(rset.getString("MEMBER_NN"));
				result.setBalance(rset.getInt("MEMBER_PT"));
				result.setMimage(rset.getString("M_IMAGE"));
			}

			System.out.println("result 조회 후 : " + result);

		} catch (SQLException e) {

			e.printStackTrace();

			throw new MemberException("[DAo 에러 발생] : " + e.getMessage());

		} finally {
			close(rset);
			close(pstmt);
		}

		return result; // 실수 많이 하니까 주의하기! ㅇㅁㅇ)/
	}
	
	
	// 회원 정보 수정
	public int updateMember(Connection con, Member m) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");

		try {
			pstmt = con.prepareStatement(sql); // query

			pstmt.setString(1, m.getMimage());
			pstmt.setString(2, m.getUserpwd());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getNickname());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getUserid()); // where

			result = pstmt.executeUpdate(); // SQL 실행

		} catch (SQLException e) {
			e.printStackTrace();

			throw new MemberException("[DAO 에러 발생] :" + e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	
	
	// 아이디 중복체크 
	public int idDupCheck(Connection con, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idDupCheck");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}
	
	// 관리자 회원 정보 전체 조회
	public ArrayList<Member> selectList(Connection con) {
		ArrayList<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");

		try {
			pstmt = con.prepareStatement(sql);

			rset = pstmt.executeQuery();

			list = new ArrayList<Member>();

			while (rset.next()) {
				Member n = new Member();

				n.setUserid(rset.getString(1));
				n.setUserpwd(rset.getString(2));
				n.setUsername(rset.getString(3));
				n.setAddress(rset.getString(4));
				n.setNickname(rset.getString(5));
				n.setEmail(rset.getString(6));
				n.setPhone(rset.getString(7));
				n.setBalance(rset.getInt(8));
				n.setEnrollDate(rset.getDate(9));
				n.setmStatus(rset.getString(10));
				n.setMimage(rset.getString(11));

				list.add(n);
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	
	// 관리자 회원 비활성화
	public int updateStatus(Connection con, String userId, String status) {
		int result  = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("statusUpdate");
		if(status.equals("false")) {
			status = "N";
		} else {
			status = "Y";
		}
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, status);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
	}
	
	
	
}
