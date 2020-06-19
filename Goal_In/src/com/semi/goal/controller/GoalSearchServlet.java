package com.semi.goal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.goal.model.service.GoalService;
import com.semi.goal.model.vo.Goal;

/**
 * Servlet implementation class GoalSearchServlet
 */
@WebServlet("/searchGoal.go")
public class GoalSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoalSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 검색 키워드
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		ArrayList<Goal> list = new ArrayList<Goal>();
		
		GoalService ns = new GoalService();
		
		list = ns.searchGoal(keyword);
		
		String page = "";
		System.out.println(list);
		
		if(list != null) {
			// 조회 성공!
			request.setAttribute("list", list);
			page = "views/goal/goalAllList.jsp";
			
		} else {
			request.setAttribute("error-msg", "공지사항 검색 실패!");
			page = "/goalList.go";
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
