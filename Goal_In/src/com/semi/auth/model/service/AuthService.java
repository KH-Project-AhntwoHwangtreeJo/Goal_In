package com.semi.auth.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.auth.model.dao.AuthDAO;
import com.semi.auth.model.vo.Auth;


public class AuthService {
	private Connection con;
	private AuthDAO aDAO = new AuthDAO();
	
	// 인증하기 메소드
	public int insertAuth(Auth a) {
		con = getConnection();
		
		int result = aDAO.insertAuth(con, a);
		
		if( result>0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	// 골 디테일 페이지 하단에 최신 인증 이미지 6개 
	public ArrayList<Auth> detailImgTop6(int gno) {
		con = getConnection();
		
		ArrayList<Auth> alist = aDAO.detailImgTop6(con, gno);
		
		close(con);
		
		return alist;
	}

	// 골안에 인증한 이미지 전체 가져오기
	public ArrayList<Auth> authImgAllList(int gno) {
		con = getConnection();
		
		ArrayList<Auth> allalist = aDAO.authImgAllList(con, gno);
		
		System.out.println("서비스임 : " + allalist);
		
		close(con);
		
		
		return allalist;
	}

	// 인증 신고하기 
	public int authDeclaration(int signnsum, String userid) {
		con = getConnection();
		int result = aDAO.authDeclaration(con, signnsum, userid );
		
		if (result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	// 인증 중복 확인
	public int authDeclarationSelect(int signnum, String userid) {
		con = getConnection();
		
		int result = aDAO.authDeclarationSelect(con, signnum, userid);
		
		close(con);
		
		return result;
	}
	

}
