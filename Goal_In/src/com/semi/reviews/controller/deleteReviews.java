package com.semi.reviews.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.notice.model.service.NoticeService;
import com.semi.reviews.model.service.ReviewsService;

/**
 * Servlet implementation class deleteReviews
 */
@WebServlet("/deleteReviews.bo")
public class deleteReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteReviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String userId = request.getParameter("user_id");
		//String gno = request.getParameter("review_goal_name");
		//System.out.println(userId);
		//System.out.println(gno);
		String userId  = request.getParameter("userId");
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		ReviewsService reviewsService = new ReviewsService();
		
		int result = reviewsService.deleteReviews(userId,gno);
		
		if(result > 0) {
			response.sendRedirect("selectReviews.bo?userId="+userId);
		} else {
			request.setAttribute("error-msg", "공지사항 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
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
