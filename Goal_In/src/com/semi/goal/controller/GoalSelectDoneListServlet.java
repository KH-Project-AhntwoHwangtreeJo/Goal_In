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
import com.semi.goal.model.vo.PageInfo;

/**
 * Servlet implementation class GoalSelectListServlet
 */
@WebServlet("/goalCompleteList.go")
public class GoalSelectDoneListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoalSelectDoneListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 게시판 목록 처리 서블릿이다.
		ArrayList<Goal> list = new ArrayList<Goal>();
		GoalService gs = new GoalService();
		
		
		list = gs.selectDoneList();
		String page = "";
		if(list != null) {

			request.setAttribute("list", list);

			
			page = "views/goal/goalAllList.jsp";
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
