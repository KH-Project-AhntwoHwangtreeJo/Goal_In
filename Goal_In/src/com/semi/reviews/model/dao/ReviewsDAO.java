package com.semi.reviews.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.auth.model.vo.Auth;
import com.semi.goal.model.vo.Goal;
import com.semi.join.model.vo.Join;
import com.semi.reviews.model.vo.Reviews;
import static com.semi.common.JDBCTemplate.*;

public class ReviewsDAO {
	private Properties prop;

	public ReviewsDAO() {
		prop = new Properties();

		String filePath = ReviewsDAO.class.getResource("/config/reviews.properties").getPath();

		try {
			prop.load(new FileReader(filePath));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public int insertReviews(Connection con, Reviews review) {
		int result = 0; // 리턴되는 결과

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReviews");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, review.getUserId());
			pstmt.setInt(2, review.getGno());
			pstmt.setString(3, review.getRContent());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 내 계정이 참여한 GOAL을 조회하는 기능
	public ArrayList<Join> selectList(Connection con, String userId) {

		// 리턴되는 리스트 (결과를 담고있는 리스트) 를 선언
		// join테이블을 조회하기 떄문에 리스트에 JOIN객체를 add
		ArrayList<Join> joinList = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null; // db의 결과가 들어있는 애

		// properties파일에서 쿼리 템플릿을 가져옴(getter)
		// 내가 요청할 쿼리템플릿
		String sql = prop.getProperty("myJoinList");

		try {
			// 앞에서 넘겨 받은 db커넥션에 쿼리를 넣는다 (set)
			pstmt = con.prepareStatement(sql);
			// 내가 요청할 쿼리템플릿에 파라미터를 넣는다 (set)
			// 예) 첫번째 물음표에 내 ID를 넣는다.
			pstmt.setString(1, userId);

			// 위에서 설정한 쿼리를 실행 (executeQuery)
			// rset은 쿼리의 결과를 날것으로 저장하고 있는 애
			rset = pstmt.executeQuery();

			// db의 결과를 JOIN객체로 변환해야한다.
			// 쿼리의 결과는 0개일수도 있고, 100개가 넘을 수도있다.
			while (rset.next()) { // 하나씩 작업 수행

				// 하나씩 JOIN 객체로 변환
				Join join = new Join();
				join.setUserid(rset.getString(1));
				join.setGno(rset.getInt(2));
				join.setSuccess(rset.getString(3));
				join.setMdate(rset.getDate(4));
				join.setMpoint(rset.getInt(5));
				join.setMpercent(rset.getInt(6));
				join.setReward(rset.getInt(7));

				// 변환된 JOIN객체를 리스트에 append
				joinList.add(join);
			}

			System.out.println("userId :" + userId);
			System.out.println(joinList);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// db연산끝
			close(rset);
			close(pstmt);
		}

		return joinList;
	}

	public ArrayList<Goal> selectMyGoalList(Connection con, String userId) {

		ArrayList<Goal> goalList = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("myJoinGoalList");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				// 쿼리 결과를 goal객체로 변환한다.
				Goal goal = new Goal();
				goal.setGno(rset.getInt("GNO"));
				goal.setGcategory(rset.getString("GCATEGORY"));
				goal.setGoalname(rset.getString("GOALNAME"));
				goal.setGcontent(rset.getString("GCONTENT"));
				goal.setGoalinone(rset.getString("GOALINONE"));
				goal.setGmaxnum(rset.getInt("GMAXNUM"));
				goal.setGcurrnum(rset.getInt("GCURRNUM"));
				goal.setGspoint(rset.getInt("GSPOINT"));
				goal.setEnrolldate(rset.getDate("ENROLL_DATE"));
				goal.setStartdate(rset.getDate("START_DATE"));
				goal.setEnddate(rset.getDate("END_DATE"));
				goal.setPercent(rset.getInt("PERCENT"));
				goal.setGstatus(rset.getString("GSTATUS"));
				goal.setGimg(rset.getString("GIMG"));
				goal.setGwriter(rset.getString("GWRITER"));

				goalList.add(goal);
			}
			System.out.println("list:" + goalList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		System.out.println(goalList);

		return goalList;
	}

	public ArrayList<String> selectWritedReviews(Connection con, String userId, String gno) {
		// TODO Auto-generated method stub

		// 리턴되는 리스트 (결과를 담고있는 리스트) 를 선언
		// 작성되어있는 리뷰를 저장하는 리스트, REVIEW테이블을 SELECT 한다.
		ArrayList<String> writedReviewList = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null; // db의 결과가 들어있는 애

		// properties파일에서 쿼리 템플릿을 가져옴(getter)
		// 내가 요청할 쿼리템플릿
		String sql = prop.getProperty("selectWritedReview");

		try {
			// 앞에서 넘겨 받은 db커넥션에 쿼리를 넣는다 (set)
			pstmt = con.prepareStatement(sql);
			// 내가 요청할 쿼리템플릿에 파라미터를 넣는다 (set)
			// 예) 첫번째 물음표에 내 ID를 넣는다.
			pstmt.setString(1, userId);
			pstmt.setString(2, gno);

			// 위에서 설정한 쿼리를 실행 (executeQuery)
			// rset은 쿼리의 결과를 날것으로 저장하고 있는 애
			rset = pstmt.executeQuery();

			// db의 결과를 String객체로 변환해야한다.
			// 쿼리의 결과는 0개일수도 있고, 100개가 넘을 수도있다.
			while (rset.next()) { // 하나씩 작업 수행

				String rContent = rset.getString(1); // r_content

				// 변환된 String객체를 리스트에 append
				writedReviewList.add(rContent);
			}

			System.out.println("userId :" + userId);
			System.out.println("gno :" + gno);
			System.out.println(writedReviewList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// db연산끝
			close(rset);
			close(pstmt);
		}

		return writedReviewList;

	}

	/*
	 * public ArrayList<String> deleteReviews(Connection con, String userId, String
	 * gno) { // 리턴되는 리스트 (결과를 담고있는 리스트) 를 선언 // 작성되어있는 리뷰를 저장하는 리스트, REVIEW테이블을
	 * SELECT 한다. ArrayList<String> deleteReviews = new ArrayList<>();
	 * 
	 * 
	 * PreparedStatement pstmt = null; ResultSet rset = null; // db의 결과가 들어있는 애
	 * 
	 * // properties파일에서 쿼리 템플릿을 가져옴(getter) // 내가 요청할 쿼리템플릿 String sql =
	 * prop.getProperty("deleteReviews");
	 * 
	 * try { // 앞에서 넘겨 받은 db커넥션에 쿼리를 넣는다 (set) pstmt = con.prepareStatement(sql); //
	 * 내가 요청할 쿼리템플릿에 파라미터를 넣는다 (set) // 예) 첫번째 물음표에 내 ID를 넣는다. pstmt.setString(1,
	 * userId); pstmt.setString(2, gno);
	 * 
	 * // 위에서 설정한 쿼리를 실행 (executeQuery) // rset은 쿼리의 결과를 날것으로 저장하고 있는 애 rset =
	 * pstmt.executeQuery();
	 * 
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { // db연산끝
	 * close(rset); close(pstmt); }
	 * 
	 * return deleteReviews; }
	 */

	public int deleteReviews(Connection con, String userId, int gno) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteReviews");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userId);
			pstmt.setInt(2, gno);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int reviewDupCheck(Connection con, String userId, int gno) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reviewDupCheck");

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userId);
			pstmt.setInt(2, gno);

			rset = pstmt.executeQuery();

			if (rset.next()) {// 있기만 하면
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

	public ArrayList<Reviews> top3Review(Connection con) {
		ArrayList<Reviews> reviewTop3List = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectTop3Review");

		try {
			pstmt = con.prepareStatement(sql);

			rset = pstmt.executeQuery();

			reviewTop3List = new ArrayList<Reviews>();

			while (rset.next()) {
				Reviews reviews = new Reviews();

				reviews.setUserId(rset.getString("userId"));
				reviews.setGno(rset.getInt("gno"));
				reviews.setRDate(rset.getDate("rDate"));
				reviews.setRContent(rset.getString("rContent"));
				reviews.setrStatus(rset.getString("rStatus"));

				reviewTop3List.add(reviews);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return reviewTop3List;
	}

	public int updateReviews(Connection con, Reviews reviews) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateReviews");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reviews.getRContent());
			pstmt.setString(2, reviews.getUserId());
			pstmt.setInt(3, reviews.getGno());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Reviews> selectReviewList(Connection con, String userId) {
		ArrayList<Reviews> reviewList = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null; // db의 결과가 들어있는 애

		// properties파일에서 쿼리 템플릿을 가져옴(getter)
		// 내가 요청할 쿼리템플릿
		String sql = prop.getProperty("selectReviewList");

		try {
			// 앞에서 넘겨 받은 db커넥션에 쿼리를 넣는다 (set)
			pstmt = con.prepareStatement(sql);
			// 내가 요청할 쿼리템플릿에 파라미터를 넣는다 (set)
			// 예) 첫번째 물음표에 내 ID를 넣는다.
			pstmt.setString(1, userId);

			// 위에서 설정한 쿼리를 실행 (executeQuery)
			// rset은 쿼리의 결과를 날것으로 저장하고 있는 애
			rset = pstmt.executeQuery();

			// db의 결과를 String객체로 변환해야한다.
			// 쿼리의 결과는 0개일수도 있고, 100개가 넘을 수도있다.
			while (rset.next()) { // 하나씩 작업 수행

				Reviews r = new Reviews();
				
				r.setGno(rset.getInt("GNO"));
				r.setUserId(userId);
				r.setRDate(rset.getDate("R_DATE"));
				r.setrStatus(rset.getString("RSTATUS"));
				// 변환된 String객체를 리스트에 append
				reviewList.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// db연산끝
			close(rset);
			close(pstmt);
		}

		return reviewList;
	}
	
	// 골 디테일에서 보여줄 상위 3개 후기 출력문
	public ArrayList<Reviews> top3Reviews(Connection con, int gno) {
		ArrayList<Reviews> top3List = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTop3Review");
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gno);
			
			
			rset = pstmt.executeQuery();
			
			top3List = new ArrayList<Reviews>();
			
			while(rset.next()) {
				Reviews reviews = new Reviews();
				
				reviews.setUserId(rset.getString("MEMBER_ID"));
				reviews.setGno(rset.getInt("GNO"));
				reviews.setRDate(rset.getDate("R_DATE"));
				reviews.setRContent(rset.getString("R_CONTENT"));
				reviews.setrStatus(rset.getString("RSTATUS"));
				
				
				System.out.println(reviews);
				top3List.add(reviews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return top3List;
	}
	// 골 디테일 더보기 > 해당 골의 모든 리뷰 불러오기 
		public ArrayList<Reviews> ReviewsAllList(Connection con, int gno) {
			ArrayList<Reviews> Reviewslist = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("ReviewsAllList");
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, gno);
				System.out.println("dao gno : " + gno);

				rset = pstmt.executeQuery();

				Reviewslist = new ArrayList<Reviews>();

				while (rset.next()) {
					Reviews a = new Reviews();
					a.setUserId(rset.getString("MEMBER_ID"));
					a.setRContent(rset.getString("R_CONTENT"));
					a.setRDate(rset.getDate("R_DATE"));
					
					Reviewslist.add(a);
					System.out.println("리뷰z "
							+ ": "+  Reviewslist);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return Reviewslist;

		}


}
