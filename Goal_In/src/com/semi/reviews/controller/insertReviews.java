package com.semi.reviews.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.reviews.model.service.ReviewsService;
import com.semi.reviews.model.vo.Reviews;



/**
 * Servlet implementation class insertReviews
 */
@WebServlet("/insertReviews.bo")
public class insertReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertReviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		int gno = Integer.parseInt(request.getParameter("gno"));
		String rContent = request.getParameter("rContent");
		
		Reviews review = new Reviews(userId, gno, rContent);
		System.out.println("받나요?");
		System.out.println(review);
		
		ReviewsService reviewsService = new ReviewsService();
		int result = reviewsService.insertReviews(review);
		
		if (result > 0) { // 성공
			new Gson().toJson(result, response.getWriter());
		} else { // 실패
			request.setAttribute("error-msg", "리뷰 추가 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
					.forward(request, response);
		}
		
		/*
		if(result > 0) {
			response.sendRedirect("reviewList.bo?gno=" + gno);			
		} else {
			request.setAttribute("error-msg", "리뷰 추가 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp")
					.forward(request, response);
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
