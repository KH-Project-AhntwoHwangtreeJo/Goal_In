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

/**
 * Servlet implementation class UsedPointListServlet
 */
@WebServlet("/uPointList.po")
public class UsedPointListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsedPointListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<GetPoint> plist = new ArrayList<GetPoint>();
		PointService ps = new PointService();
		
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("member");
		
		
		int listCount = ps.getUsedPointListCount(m.getUserid());
		String curPage = request.getParameter("currentPage");
		
		PageInfo upi = new PageInfo(curPage, listCount);
		
		plist = ps.selectUsedList(m.getUserid(), upi.getStartRow(), upi.getEndRow());
		
		String page = null;
		
		if(plist != null) {
			request.setAttribute("list", plist);
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
