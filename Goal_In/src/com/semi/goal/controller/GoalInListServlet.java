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
import com.semi.member.exception.MemberException;




@WebServlet("/GselectList.no")
public class GoalInListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   
    public GoalInListServlet() {
        super();
    }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항 글 여러 개를 DB에서 조회하여
		// 목록 형태로 (ArrayList) 데이터를 전달하는 서블릿
		ArrayList<Goal> list = new ArrayList<Goal>();
		
		GoalService ns = new GoalService();
		
		String page = null;
		
		try {
			list = ns.selectList();
			request.setAttribute("list", list);
			 page="views/admin/Goal.jsp";
			
		} catch(MemberException e) {
			
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 목록 조회 실패");
			 page="common/errorPage.jsp";
			
		} finally {
			request.getRequestDispatcher(page).forward(request, response);			
		}
		
	}
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}