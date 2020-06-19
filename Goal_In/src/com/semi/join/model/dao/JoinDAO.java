package com.semi.join.model.dao;

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
import com.semi.join.model.vo.Join;



public class JoinDAO {
	private Properties prop;
	
	public JoinDAO() {
		prop = new Properties();
		
		String filePath = JoinDAO.class
				          .getResource("/config/goal.properties")
				          .getPath();
		
		// System.out.println(filePath);
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 
	public ArrayList<Join> selectList(Connection con, String userid) {
		ArrayList<Join> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myJoinList");
		
		System.out.println(userid);// userid는 잘 받아옴
		System.out.println(sql);
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Join>();
			
			while(rset.next()) {
				Join j = new Join();
				
				j.setUserid(rset.getString(1));
				j.setGno(rset.getInt(2));
				j.setSuccess(rset.getString(3));
				j.setMdate(rset.getDate(4));
				j.setMpoint(rset.getInt(5));
				j.setMpercent(rset.getInt(6));
				j.setReward(rset.getInt(7));
				
				list.add(j);
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
		String sql = prop.getProperty("myJoinGoalList");  //goal.properties 에서 가져옴
		
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
	
	// 골 참여 전에 이미 참여한 골인지 조회
		public int selectMyGoal(Connection con, Join j) {
			int result =0; // 리턴할 값
			ResultSet rset=null;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("selctMyGoal"); // goal.properties 에서 작성후 가져올것
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, j.getUserid());
				pstmt.setInt(2, j.getGno());

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
		
		// 참여하기 버튼 클릭시  JOIN 테이블 추가
		public int insertJoin(Connection con, Join j) {
			int result = 0;
		
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("goalJoin"); // goal.properties 에서 작성후 가져올것
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, j.getUserid());
				pstmt.setInt(2, j.getGno());
				pstmt.setInt(3, j.getMpoint());
				
				
				result= pstmt.executeUpdate();
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}
		
		public int joinCancel(Connection con, Join j) {
			int result = 0;
			
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("ckaducnlth"); // goal.properties 에서 작성후 가져올것
			System.out.println("dao의 조인 : "+j);
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, j.getUserid());
				pstmt.setInt(2, j.getGno());
				
				
				result= pstmt.executeUpdate();
				
				System.out.println("dao : "+ result);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}
}
