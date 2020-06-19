package com.semi.point.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.goal.model.vo.PageInfo;
import com.semi.member.model.vo.Member;
import com.semi.point.model.service.PointService;
import com.semi.point.model.vo.GetPoint;
import com.semi.point.model.vo.Point;


/**
 * Servlet implementation class PointListServlet
 */
@WebServlet("/pList.po")
public class PointListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Point> list = new ArrayList<Point>();
		ArrayList<GetPoint> plist = new ArrayList<GetPoint>();
		
		PointService ps = new PointService();
		
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("member");
		System.out.println(m.getUserid());
		int listCount = ps.getPointListCount(m.getUserid());
		int usedlistCount = ps.getUsedPointListCount(m.getUserid());
		
		System.out.println(listCount);
		System.out.println(usedlistCount);
		
		String curPage = request.getParameter("currentPage");
		PageInfo pi = new PageInfo(curPage, listCount);
		list = ps.selectList(m.getUserid(), pi.getStartRow(), pi.getEndRow());
		
		String curPage2 = request.getParameter("currentPage2");
		PageInfo upi = new PageInfo(curPage2, usedlistCount);	
		plist = ps.selectUsedList(m.getUserid(), upi.getStartRow(), upi.getEndRow());	
		
		String page = null;
		
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			
			request.setAttribute("plist", plist);
			request.setAttribute("upi", upi);
			page = "views/point/point.jsp";
			
		} else {
			request.setAttribute("error-msg", "공지사항 목록 조회 실패");
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
