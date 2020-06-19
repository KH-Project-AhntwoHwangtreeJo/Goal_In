package com.semi.join.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.join.model.service.JoinService;
import com.semi.join.model.vo.Join;

/**
 * Servlet implementation class myJoinGoalServlet
 */
@WebServlet("/myJoin.jo")
public class myJoinGoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myJoinGoalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		JoinService js = new JoinService();
		
		
		String userid = request.getParameter("userid");
		System.out.println("userid : "+userid);
		
		hmap = js.selectList(userid); 

		String page = "";
		if(hmap != null) {
			
			request.setAttribute("list", hmap.get("list"));
			request.setAttribute("glist", hmap.get("glist"));
			
			page = "views/join/join.jsp";
		} else {
			request.setAttribute("error-msg", "참여중인 골 조회 실패");
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
