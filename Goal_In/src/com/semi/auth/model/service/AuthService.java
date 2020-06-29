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

	// 인증하기 메소드  2020-06-29 (개인 달성률 서비스)
	public int insertAuth(Auth a) {
		con = getConnection();
		// 인증하기 클릭시 SIGN 테이블 추가
	
		int result = aDAO.insertAuth(con, a);
		
		
		if (result > 0) { // 인증하기 추가 성공
			 aDAO.updatepercent(con, a); // 달성율 증가시키는 쿼리
			commit(con);
			
			// 달성율 업데이트 해야하나?  확인
			// 1이면 오늘 인등 처음 등록 / 1이상 : 오늘 그 갯수만큼 인증 한 것
			int dupresult = aDAO.authDeclarationSelect(con,a.getSignnum(), a.getUserid());
			if  (dupresult == 1) { // 오늘 처음 인증 한거 / 당성률을 증가
				
		}else
			rollback(con);
		}
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
		int result = aDAO.authDeclaration(con, signnsum, userid);

		if (result > 0)
			commit(con);
		else
			rollback(con);

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

	// 달성율 추가를 업데이트
	public int updatepercent(Auth a) {
		con = getConnection();
		int result = aDAO.updatepercent(con, a);

		close(con);
		return result;
	}

}