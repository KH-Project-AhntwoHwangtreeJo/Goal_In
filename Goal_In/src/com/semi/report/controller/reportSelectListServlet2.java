package com.semi.report.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.auth.model.vo.Auth;
import com.semi.join.model.service.JoinService;
import com.semi.notice.model.service.NoticeService;
import com.semi.notice.model.vo.notice;
import com.semi.report.model.service.ReportService;
import com.semi.report.model.vo.Report;

/**
 * Servlet implementation class reportSelectListServlet
 */
@WebServlet("/RselectList2.no")
public class reportSelectListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportSelectListServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		ReportService rs = new ReportService();
		
		
		
		hmap = rs.selectList2();

		String page = "";
		if(hmap != null) {
			
	
			request.setAttribute("alist", hmap.get("alist"));
			System.out.println(hmap);
			
			
			page = "views/admin/Report2.jsp";
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
