package com.semi.point.model.dao;

import static com.semi.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.point.model.vo.GetPoint;
import com.semi.point.model.vo.Point;



public class PointDAO {
	private Properties prop;
	
	public PointDAO() {
		prop = new Properties();
		
		String filePath =PointDAO.class
				 .getResource("/config/point.properties")
				 .getPath();
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertPoint(Connection con, Point p) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPoint");
		
		try {
			pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, p.getUserid());
			pstmt.setInt(2, p.getPrice());
			pstmt.setInt(3, p.getpBalance());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		
		return result;
	}

	public int getPointListCount(Connection con, String userid) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("pointListCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return result;
	}
	
	public ArrayList<Point> selectList(Connection con, String userid, int startRow, int endRow) {
		ArrayList<Point> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("pointList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3,  startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Point>();
			
			while(rset.next()) {
				Point p = new Point();
				
				p.setUserid(rset.getString(2));
				p.setPaydate(rset.getDate(3));
				p.setPrice(rset.getInt(4));
				p.setMethod(rset.getString(5));
				p.setpBalance(rset.getInt(6));			
				
				list.add(p);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return list;
	}

	public int getUsedPointListCount(Connection con, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("pointUsedListCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return result;
	}

	public ArrayList<GetPoint> selectUsedList(Connection con, String userid, int startRow, int endRow) {
		ArrayList<GetPoint> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("pointUsedList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3,  startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<GetPoint>();
			
			while(rset.next()) {
				GetPoint p = new GetPoint();
				
				
				p.setGno(rset.getInt(2));
				p.setmYn(rset.getString(3));
				p.setmDate(rset.getDate(4));
				p.setmPoint(rset.getInt(5));
				p.setjStatus(rset.getString(6));	
				p.setRatio(rset.getInt(7));	
				p.setCalc(rset.getInt(8));	
				p.setErn(rset.getInt(9));	
				
				
				list.add(p);
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
