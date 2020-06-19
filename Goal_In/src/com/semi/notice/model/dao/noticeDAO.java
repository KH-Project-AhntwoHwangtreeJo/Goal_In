package com.semi.notice.model.dao;

import static com.semi.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.semi.notice.model.vo.notice;

public class noticeDAO {
	private Properties prop;
	
	public noticeDAO() {
		prop = new Properties();
		
		String filePath =noticeDAO.class
						 .getResource("/config/notice.properties")
						 .getPath();
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<notice> selectList(Connection con) {
		ArrayList<notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<notice>();
			
			while(rset.next()) {
				notice n = new notice();
				
				n.setNno(rset.getInt("nno"));
				n.setNtitle(rset.getString("ntitle"));
				n.setNcontent(rset.getString("ncontent"));
				n.setNwriter(rset.getString("nwriter"));
				n.setNdate(rset.getDate("ndate"));
				n.setNcount(rset.getInt("ncount"));
				n.setNstatus(rset.getString("status"));
				
				list.add(n);
			}
			
			System.out.println(list);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return list;
	}

	public notice selectOne(Connection con, int nno) {
		notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				n = new notice();
				
				n.setNno(rset.getInt("nno"));
				n.setNtitle(rset.getString("ntitle"));
				n.setNcontent(rset.getString("ncontent"));
				n.setNwriter(rset.getString("nwriter"));
				n.setNdate(rset.getDate("ndate"));
				n.setNcount(rset.getInt("ncount"));
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return n;
	}

	public int updateReadCount(Connection con, int nno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReadCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertNotice(Connection con, notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, n.getNtitle());
			pstmt.setString(2, n.getNwriter());
			pstmt.setString(3, n.getNcontent());
			pstmt.setDate(4, n.getNdate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		
		return result;
	}

	// 기본 데이터 이동 경로 
	//                       ┌--.getParameter()            ┌-- SQL 담당
	// View(.jsp) --> Controller(Servlet) --> Service --> DAO --> DB 
	//										   └-- DAO 메소드 호출 
	//                                             Commit & Rollback
	public int updateNotice(Connection con, notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n.getNtitle());
			pstmt.setString(2, n.getNcontent());
			pstmt.setInt(3, n.getNno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		
		return result;
	}
	
	public int deleteNotice(Connection con, int nno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<notice> searchList(Connection con, String condition, String keyword) {
		ArrayList<notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		switch(condition) {
		case "writer" : // 작성자로 검색할 경우
			sql = prop.getProperty("searchWriterNotice");
			break;
		case "title" : // 제목으로 검색할 경우
			sql = prop.getProperty("searchTitleNotice");
			break;
		case "content" : // 내용으로 검색할 경우
			sql = prop.getProperty("searchContentNotice");
			break;
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<notice>();

			while(rset.next()) {
				notice n = new notice();
				
				n.setNno(rset.getInt(1));
				n.setNtitle(rset.getString(2));
				n.setNcontent(rset.getString(3));
				n.setNwriter(rset.getString(4));
				n.setNcount(rset.getInt(5));
				n.setNdate(rset.getDate(6));
				
				list.add(n);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return list;
	}

	// 일반 유저 공지사항 리스트 화면
	public ArrayList<notice> userNoticeList(Connection con) {
		ArrayList<notice> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectUserList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<notice>();
			
			while(rset.next()) {
				notice n = new notice();
				
				n.setNno(rset.getInt("nno"));
				n.setNtitle(rset.getString("ntitle"));
				n.setNcontent(rset.getString("ncontent"));
				n.setNwriter(rset.getString("nwriter"));
				n.setNdate(rset.getDate("ndate"));
				n.setNcount(rset.getInt("ncount"));
				n.setNstatus(rset.getString("status"));
				
				list.add(n);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return list;
	}
}







