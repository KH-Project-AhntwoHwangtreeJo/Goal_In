package com.semi.reviews.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.reviews.model.service.ReviewsService;

/**
 * Servlet implementation class SelectReviews
 */
@WebServlet("/selectReviews.bo")
public class selectReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectReviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		ReviewsService reviewService = new ReviewsService();
		String userId = request.getParameter("userId"); //화면에서 부터 넘어온 ID
		
		hmap = reviewService.selectReviews(userId);
		
		String page = "";
		if(hmap != null) {
			
			request.setAttribute("list", hmap.get("list"));
			request.setAttribute("glist", hmap.get("glist"));
			request.setAttribute("reviewList", hmap.get("reviewList"));
			
			page = "views/reviews/reviews.jsp"; 
		} else {
			request.setAttribute("error-msg", "참여한 골 조회 실패");
			page = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
