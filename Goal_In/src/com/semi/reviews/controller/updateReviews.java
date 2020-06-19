package com.semi.reviews.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.reviews.model.service.ReviewsService;
import com.semi.reviews.model.vo.Reviews;

/**
 * Servlet implementation class updateReviews
 */
@WebServlet("/updateReviews.bo")
public class updateReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateReviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//기본 전송값 처리
		String rContent = request.getParameter("rContent");
		String userId = request.getParameter("userId");
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		Reviews reviews = new Reviews();
		
		reviews.setRContent(rContent);
		reviews.setUserId(userId);
		reviews.setGno(gno);
		
		int result = new ReviewsService().updateReviews(reviews);
		
		if (result > 0) {
			
			response.sendRedirect("selectReviews.bo");
			
		} else {
			
			request.setAttribute("msg", "리뷰 수정 실패!!");
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
