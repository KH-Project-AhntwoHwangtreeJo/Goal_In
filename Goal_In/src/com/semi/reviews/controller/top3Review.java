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
import com.semi.reviews.model.vo.Reviews;

/**
 * Servlet implementation class top3Review
 */
@WebServlet("/top3Review.bo")
public class top3Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public top3Review() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewsService reviewsService = new ReviewsService();
		
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		ArrayList<Reviews> top3List = reviewsService.top3Reviews(gno);
		System.out.println(top3List);
		
		 
		 response.setContentType("application/json; charset=utf-8");
		 new Gson().toJson(top3List, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
