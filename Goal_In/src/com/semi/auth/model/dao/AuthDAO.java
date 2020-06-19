package com.semi.auth.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.auth.model.vo.Auth;

public class AuthDAO {
	private Properties prop;
	
	// 기본 DAO
	public AuthDAO() {
			prop = new Properties();
		
		String filePath = AuthDAO.class
				                  .getResource("/config/auth.properties")
				                  .getPath();
				try {
					
					prop.load(new FileReader(filePath));
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	
	// 인증하기 만들기
	public int insertAuth(Connection con, Auth a) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String sql = prop.getProperty("insertAuth");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, a.getUserid());
			pstmt.setInt(2, a.getGno());
			pstmt.setString(3, a.getSigncf());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 골 디테일 페이지 하단에 최신 인증 이미지 6개 
	public ArrayList<Auth> detailImgTop6(Connection con, int gno) {
		ArrayList<Auth> alist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("goalDetailImgTop6");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gno);
			
			rset = pstmt.executeQuery();
			
			alist = new ArrayList<Auth>();
			
			while(rset.next()) {
				Auth a = new Auth();
				
				a.setSigncf(rset.getString("GOAL_CF"));
				
				alist.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return alist;
	}
	
	// 골안에 인증한 이미지 전체 가져오기
	public ArrayList<Auth> authImgAllList(Connection con, int gno) {
		ArrayList<Auth> allalist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("authImgAllList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gno);
			
			rset = pstmt.executeQuery();
			
			allalist = new ArrayList<Auth>();
			
			while(rset.next()) {
				Auth a = new Auth();
				a.setSignnum(rset.getInt("SIGN_NB"));
				a.setGno(rset.getInt("GNO"));
				a.setSigncf(rset.getString("GOAL_CF"));
				a.setUserid(rset.getString("MEMBER_ID"));
				a.setSigndate(rset.getDate("GOAL_DATE"));
				
				allalist.add(a);
			} System.out.println("다오임 : " + allalist);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return allalist;
	}

	// 인증 신고 정보 가져오기
	public int authDeclaration(Connection con, int signnsum, String userid) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("authDeclaration");  // auth.properies에서 작성후 가져올것
		
		try {
			pstmt = con.prepareStatement(sql);

			
			pstmt.setInt(1, signnsum );
			pstmt.setString(2, userid);
			
			result = pstmt.executeUpdate();
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;

	}

	// 인증 신고 중복 확인하는 메소드
	public int authDeclarationSelect(Connection con, int signnum, String userid) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("authDeclarationSelect");
		
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, signnum );
			pstmt.setString(2, userid);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {  // 있기만하면
				result =rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
		
	}

}
