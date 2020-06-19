package com.semi.love.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.goal.model.vo.Goal;
import com.semi.love.model.vo.Love;

public class LoveDAO {
	private Properties prop;
	
	public LoveDAO() {
		prop = new Properties();
		
		String filePath = LoveDAO.class
				          .getResource("/config/goal.properties")
				          .getPath();
		
		// System.out.println(filePath);
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<Love> selectList(Connection con, String userid) {
		ArrayList<Love> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myLoveList");
		
		System.out.println(userid);// userid는 잘 받아옴
		System.out.println(sql);
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Love>();
			
			while(rset.next()) {
				Love l = new Love();
				
				l.setUserid(rset.getString(1));
				l.setGno(rset.getInt(2));

				
				list.add(l);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}

	public ArrayList<Goal> selectMyGoalList(Connection con, String userid) {
		ArrayList<Goal> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myLoveGoalList");  //goal.properties 에서 가져옴
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Goal>();
			
			while(rset.next()) {
				Goal g = new Goal();
				
				g.setGno(rset.getInt("GNO"));
				g.setGcategory(rset.getString("GCATEGORY"));
				g.setGoalname(rset.getString("GOALNAME"));
				g.setGcontent(rset.getString("GCONTENT"));
				g.setGoalinone(rset.getString("GOALINONE"));
				g.setGmaxnum(rset.getInt("GMAXNUM"));
				g.setGcurrnum(rset.getInt("GCURRNUM"));
				g.setGspoint(rset.getInt("GSPOINT"));
				g.setEnrolldate(rset.getDate("ENROLL_DATE"));
				g.setStartdate(rset.getDate("START_DATE"));
				g.setEnddate(rset.getDate("END_DATE"));
				g.setPercent(rset.getInt("PERCENT"));
				g.setGstatus(rset.getString("GSTATUS"));
				g.setGimg(rset.getString("GIMG"));
				g.setGwriter(rset.getString("GWRITER"));
	
				list.add(g);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println(list);
		
		return list;
	}

	public int selectMyGoal(Connection con, Love l) {
		int result =0; // 리턴할 값
		ResultSet rset=null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectMyGoal"); // goal.properties 에서 작성후 가져올것
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, l.getUserid());
			pstmt.setInt(2, l.getGno());

			rset = pstmt.executeQuery();// DB 실행 안함
			
			if(rset.next()) {
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

	public int insertJoin(Connection con, Love l) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("loveInsert"); // goal.properties 에서 작성후 가져올것
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, l.getUserid());
			pstmt.setInt(2, l.getGno());
			
			
			result= pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteLove(Connection con, Love l) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteLove"); // goal.properties 에서 작성후 가져올것
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, l.getUserid());
			pstmt.setInt(2, l.getGno());
			
			
			result= pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
