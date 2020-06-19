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
 * Servlet implementation class AuthImgAllListServlet
 */
@WebServlet("/AuthImgAllList.ao")
public class AuthImgAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthImgAllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuthService as = new AuthService();
		
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		ArrayList<Auth> allalist = as.authImgAllList(gno);
		
		String page = "";
		
		if(allalist != null) {

			request.setAttribute("allalist", allalist);

			
			page = "views/auth/authAllList.jsp";
		} else {
			request.setAttribute("error-msg", "게시글 목록 조회 실패");
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
