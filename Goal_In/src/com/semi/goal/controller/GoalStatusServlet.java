package com.semi.goal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.goal.model.service.GoalService;


@WebServlet("/GoalStatus.do")
public class GoalStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GoalStatusServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Gno = Integer.parseInt(request.getParameter("Gno"));
		String status = request.getParameter("status");
			System.out.println(status);
		
int result = new GoalService().updateStatus(Gno, status);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
