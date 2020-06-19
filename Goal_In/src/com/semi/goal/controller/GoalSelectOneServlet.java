package com.semi.goal.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.goal.model.service.GoalService;
import com.semi.goal.model.vo.Goal;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class GoalSelectOneServlet
 */
@WebServlet("/gsol.go")
public class GoalSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoalSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		GoalService gs = new GoalService();
		Goal g = gs.selectOne(gno);
		int[] cnt = gs.selectContentCnt(gno);
		Member w = gs.selectGoalWriter(gno);
		System.out.println(w);
		String page = "";
	      
	      if(g != null) {
	         request.setAttribute("goal", g);
	         request.setAttribute("cnt", cnt);
	         request.setAttribute("writer", w);
	         page = "views/goal/goalDetail.jsp";
	      } else {
	         request.setAttribute("error-msg", "게시글 상세 보기 실패");
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
