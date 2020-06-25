package com.semi.goal.model.dao;

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
import com.semi.member.model.vo.Member;

public class GoalDAO {
	private Properties prop;
	// 기본 DAO
	public GoalDAO() {
		prop = new Properties();

		String filePath = GoalDAO.class.getResource("/config/goal.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Goal 만들기
	public int insertGoal(Connection con, Goal g) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertGoal"); // goal.properties 에서 작성후 가져올것

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, g.getGcategory());
			pstmt.setString(2, g.getGoalname());
			pstmt.setString(3, g.getGcontent());
			pstmt.setString(4, g.getGoalinone());
			pstmt.setInt(5, g.getGmaxnum());
			pstmt.setDate(6, g.getStartdate());
			pstmt.setDate(7, g.getEnddate());
			pstmt.setString(8, g.getGimg());
			pstmt.setString(9, g.getGwriter());

			result = pstmt.executeUpdate();// DB 실행 안함

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	 // Goal 생성시 만든 사람은 자동 Join 테이블 인서트
		public int goalJoin(Connection con, Join j) {
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("goalJoin"); // goal.properties 에서 작성후 가져올것
			
			try {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, j.getUserid());
				pstmt.setInt(2, j.getGno());
				pstmt.setInt(3, j.getMpoint());
				
				result = pstmt.executeUpdate();// DB 실행 
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		
		}
		
	// main Top 5 조회용 
	public ArrayList<Goal> selectTop5(Connection con) {
		ArrayList<Goal> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTop10");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Goal>();
			
			while(rset.next()) {
				Goal g = new Goal();
				
				g.setGno(rset.getInt("GNO"));
				g.setGoalname(rset.getString("GOALNAME"));
				g.setGcurrnum(rset.getInt("GCURRNUM"));
				g.setStartdate(rset.getDate("START_DATE"));
				g.setEnddate(rset.getDate("END_DATE"));
				g.setGimg(rset.getString("GIMG"));
				
				list.add(g);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	// 최근 게시글 상위 8개 
	public ArrayList<Goal> selectList(Connection con, String gcategory) {
		ArrayList<Goal> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gcategory);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Goal>();
			
			while(rset.next()) {
				Goal g = new Goal();
				
				g.setGno(rset.getInt("GNO"));
				g.setGoalname(rset.getString("GOALNAME"));
				g.setGspoint(rset.getInt("GSPOINT"));
				g.setStartdate(rset.getDate("START_DATE"));
				g.setEnddate(rset.getDate("END_DATE"));
				g.setGcurrnum(rset.getInt("GCURRNUM"));
				g.setGimg(rset.getString("GIMG"));
				
				list.add(g);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}
	
	// 검색바 
	public ArrayList<Goal> searchGoal(Connection con, String keyword) {
		ArrayList<Goal> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchGoal");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			pstmt.setString(4, keyword);
			
			
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
	    }finally {
	         close(rset);
	         close(pstmt);
	    }
		
		return list;
	}
	
	// 전체리스트 출력
	public ArrayList<Goal> selectAllList(Connection con) {
		ArrayList<Goal> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllGoaling");  //goal.properties 에서 가져옴
		
		try {
			pstmt = con.prepareStatement(sql);

			
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
		
		System.out.println("안끝난거만 dao : "+list);
		
		return list;

	}
	
	
	
	// 골 등록 후 마지막 골 번호(지금막 등록한 것) 조회 
	public int selectLastGoalNo(Connection con) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLastGoal"); // goal.properties 에서 가져옴
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
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
	
	// select AllList로 연결하면 되는거 아닌가요??????
	public ArrayList<Goal> searchAllList(Connection con) {
		ArrayList<Goal> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllGoal");  //goal.properties 에서 가져옴
		
		try {
			pstmt = con.prepareStatement(sql);
			
			// 1. 마지막 행의 번호를 가져옴
			// 2. 첫 행의 번호를 가져옴
			//int startRow = (currentPage -1) * limit +1; // 첫번째 글 가져옴
			//int endRow = startRow + limit -1;
			
			//pstmt.setInt(1, endRow);
			//pstmt.setInt(2, startRow);
			
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
	
	// 골 한개 디테일 페이지 조회용
	public Goal selectOne(Connection con, int gno) {
		Goal g = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		

		String sql = prop.getProperty("selectOneGoal");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, gno);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				g = new Goal();
				
				g.setGno(rset.getInt("gno"));
				g.setGcategory(rset.getString("gcategory"));
				g.setGoalname(rset.getString("goalname"));
				g.setGcontent(rset.getString("gcontent"));
				g.setGoalinone(rset.getString("goalinone"));
				g.setGmaxnum(rset.getInt("gmaxnum"));
				g.setGcurrnum(rset.getInt("gcurrnum"));
				g.setGspoint(rset.getInt("gspoint"));
				g.setEnrolldate(rset.getDate("enroll_date"));
				g.setStartdate(rset.getDate("start_date"));
				g.setEnddate(rset.getDate("end_date"));
				g.setPercent(rset.getInt("percent"));
				g.setGstatus(rset.getString("gstatus"));
				g.setGimg(rset.getString("gimg"));
				g.setGwriter(rset.getString("gwriter"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return g;
	}
	
	// 완료된 골 리스트 조회
	public ArrayList<Goal> selectDoneList(Connection con) {
		ArrayList<Goal> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("goalCompleteList");  //goal.properties 에서 가져옴
		
		try {
			pstmt = con.prepareStatement(sql);

			
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
		
		System.out.println("안끝난거만 dao : "+list);
		
		return list;

	}
	// 관리자 전체 리스트 
	public ArrayList<Goal> selectAdminGoalList(Connection con) {
		ArrayList<Goal> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdminGoalList");

		try {
			pstmt = con.prepareStatement(sql);

			rset = pstmt.executeQuery();

			list = new ArrayList<Goal>();

			while (rset.next()) {
				Goal n = new Goal();

				n.setGno(rset.getInt(1));
				n.setGcategory(rset.getString(2));
				n.setGoalname(rset.getString(3));
				n.setGcontent(rset.getString(4));
				n.setGoalinone(rset.getString(5));
				n.setGmaxnum(rset.getInt(6));
				n.setGstatus(rset.getString(13));
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
	// 관리자 골 게시상태 변경
	public int updateStatus(Connection con, int gno, String status) {
		int result  = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("GstatusUpdate");
		if(status.equals("false")) {
			status = "N";
		} else {
			status = "Y";
		}
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, status);
			pstmt.setInt(2, gno);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
	}
	
	// 디테일 페이지 갯수 카운팅
	public int[] selectContentCnt(Connection con, int gno) {
		 int[] cnt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectContentCnt");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gno);
			pstmt.setInt(2, gno);
			pstmt.setInt(3, gno);
			
			rset = pstmt.executeQuery();

			cnt = new int[3];

			while (rset.next()) {
				for(int i = 0 ; i < 3 ; i++) cnt[i] = rset.getInt((i+1)); // 데이터 베이스 시작은 1부터!
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(rset);
			close(pstmt);
		}

		return cnt;
	}

	public Member selectGoalWriter(Connection con, int gno) {
		Member w= null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		String sql = prop.getProperty("selectGoalWriter"); 
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, gno);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
			w =new Member();
			
			w.setNickname(rset.getString(5));
			w.setMimage(rset.getString(11));
			w.setUserid(rset.getString(1));	
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return w;
	}

	public int[] selectContentCnt2(Connection con, String userid, int gno) {
			int[] cnt2 = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectContentCnt2");

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setInt(2, gno);
				pstmt.setString(3, userid);
				pstmt.setInt(4, gno);
				
				rset = pstmt.executeQuery();

				cnt2 = new int[2];
				
				

				while (rset.next()) {
					for(int i = 0 ; i < 2 ; i++) cnt2[i] = rset.getInt((i+1)); // 데이터 베이스 시작은 1부터!
				}
				

			} catch (SQLException e) {
				e.printStackTrace();

			} finally {
				close(rset);
				close(pstmt);
			}

			return cnt2;
	}
}
