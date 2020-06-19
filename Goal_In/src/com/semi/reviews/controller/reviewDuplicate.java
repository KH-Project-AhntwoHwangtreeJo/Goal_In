package com.semi.reviews.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.reviews.model.service.ReviewsService;

/**
 * Servlet implementation class reviewDuplicate
 */
@WebServlet("/reviewDuplicate.bo")
public class reviewDuplicate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reviewDuplicate() {
      super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { String userId =
		request.getParameter("userId"); 
		int gno =Integer.parseInt(request.getParameter("gno"));

		ReviewsService reviewsService = new ReviewsService();

		int result = reviewsService.reviewDupCheck(userId, gno);
		System.out.println("result : " + result);
		
		response.setContentType("application/json; charset=UTF-8");
		
    	new Gson().toJson(result, response.getWriter());
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
