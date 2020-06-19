package com.semi.auth.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.semi.auth.model.service.AuthService;
import com.semi.auth.model.vo.Auth;

/**
 * Servlet implementation class AuthDetailImgTop6Servlet
 */
@WebServlet("/DetailImgTop6.ao")
public class AuthDetailImgTop6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthDetailImgTop6Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthService as = new AuthService();
		
		int gno = Integer.parseInt(request.getParameter("gno"));
		// String userid = request.getParameter("userid");
		
		ArrayList<Auth> alist = as.detailImgTop6(gno);
		
		response.setContentType("application/json; charset=utf-8");
		//System.out.println(alist);
		new Gson().toJson(alist, response.getWriter());  // 작성된것을 가져와서 alist에 보내겠다
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
