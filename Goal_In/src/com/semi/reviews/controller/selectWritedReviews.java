package com.semi.reviews.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.reviews.model.service.ReviewsService;

/**
 * Servlet implementation class selectWritedReviews
 */
@WebServlet("/selectWritedReviews.bo")
public class selectWritedReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectWritedReviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// f/e에서 전달받은 파라미터 2개 가져오기
		// member_id, gno
		String userId = request.getParameter("userId");
		String gno = request.getParameter("gno");
		
		ReviewsService reviewsService = new ReviewsService();

		// 서비스로 전달
		ArrayList<String> result = reviewsService.selectWritedReviews(userId, gno);
		System.out.println("result : "+result);
		
		
		
		if(result.isEmpty()) { // 작성한 리뷰가 없을 경우,
			System.out.println("!");
			//new Gson().toJson("", response.getWriter()); // 공백을 리턴
		} else { // SELECT의 결과값이 있으면, 
			System.out.println("@");
			String writedReview = result.get(0);
			System.out.println(writedReview);
			new Gson().toJson(writedReview, response.getWriter());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
