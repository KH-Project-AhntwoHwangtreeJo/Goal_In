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

@WebServlet("/ReivewsAllList.ao")
public class ReviewAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReviewAllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewsService as = new ReviewsService();
		
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		ArrayList<Reviews> Reviewslist = as.ReviewsAllList(gno);
		
		/*
		 * response.setContentType("application/json; charset=utf-8");
		 * 
		 * new Gson().toJson(Reviewslist, response.getWriter());
		 */
		
		
		  String page = "";
		  
		  if(Reviewslist != null) {
		  
		  request.setAttribute("Reviewslist", Reviewslist);
		  
		  
		  page = "views/reviews/reviewsDetail.jsp"; } else {
		  request.setAttribute("error-msg", "게시글 목록 조회 실패"); page =
		  "views/common/errorPage.jsp"; }
		  
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
