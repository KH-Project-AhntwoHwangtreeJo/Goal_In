package com.semi.reviews.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;


import com.semi.goal.model.vo.Goal;
import com.semi.join.model.vo.Join;
import com.semi.reviews.model.dao.ReviewsDAO;
import com.semi.reviews.model.vo.Reviews;



public class ReviewsService {
	private Connection con;
	private ReviewsDAO reviewsDAO = new ReviewsDAO(); 
	
	public int insertReviews(Reviews review) {
		con =getConnection();
		
		int result = reviewsDAO.insertReviews(con, review);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public HashMap<String, Object> selectReviews(String userId) {

		// 조회하기위해 db연결하는 부분
		con = getConnection();
		
		// '참여한 GOAL' 목록을 JOIN테이블에서 조회
		ArrayList<Join> list = reviewsDAO.selectList(con, userId);
	
		// '참여한 GOAL'의 GOAL정보를 가져오기 위한 SELECT
		// 왜냐, join테이블에는 GNO만 있고 'gno'만있고 goal 상세정보가 없어서
		ArrayList<Goal> glist = reviewsDAO.selectMyGoalList(con, userId);

		ArrayList<Reviews> reviewList = reviewsDAO.selectReviewList(con, userId);
		// select 2번한 결과를 합치기 위한 맵
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("list", list);
		hmap.put("glist", glist);
		hmap.put("reviewList", reviewList);
		
		return hmap;
	}

	public ArrayList<String> selectWritedReviews(String userId, String gno) {
		// TODO Auto-generated method stub
		
		// 조회하기위해 db연결하는 부분
		con = getConnection();
		
		ArrayList<String> resultList = reviewsDAO.selectWritedReviews(con, userId, gno);
		
		return resultList;
		
	}

	/*
	 * public ArrayList<String> deleteReviews(String userId, String gno) { con =
	 * getConnection();
	 * 
	 * ArrayList<String> resultList = reviewsDAO.deleteReviews(con, userId, gno);
	 * 
	 * return resultList;
	 * 
	 * }
	 */

	public int deleteReviews(String userId, int gno) {
		con = getConnection();
		int result = reviewsDAO.deleteReviews(con, userId, gno);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public int reviewDupCheck(String userId, int gno) {
		con = getConnection();
		
		int result = reviewsDAO.reviewDupCheck(con, userId, gno);
		
		close(con);
		return result;
	}

	public int updateReviews(Reviews reviews) {
		con =getConnection();
		
		int result = reviewsDAO.updateReviews(con, reviews);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<Reviews> top3Reviews(int gno) {
		con = getConnection();
		
		ArrayList<Reviews> top3List = reviewsDAO.top3Reviews(con, gno);
		
		close(con);
		
		return top3List;
	}
	
	// 골 디테일 더보기 > 해당 골의 모든 리뷰 불러오기 
		public ArrayList<Reviews> ReviewsAllList(int gno) {
			con = getConnection();
				
				ArrayList<Reviews> Reviewslist = reviewsDAO.ReviewsAllList(con, gno);		
				
				close(con);
				
				
				return Reviewslist;

			}


	

}
