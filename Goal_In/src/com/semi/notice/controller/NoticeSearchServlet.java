package com.semi.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.notice.model.service.NoticeService;
import com.semi.notice.model.vo.notice;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/searchNotice.no")
public class NoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 검색 카테고리
		String condition = request.getParameter("con");
		// 검색 키워드
		String keyword = request.getParameter("keyword");
		
		ArrayList<notice> list = new ArrayList<notice>();
		
		NoticeService ns = new NoticeService();
		
		list = ns.searchNotice(condition, keyword);
		
		String page = "";
		
		if(list != null) {
			// 조회 성공!
			request.setAttribute("list", list);
			page = "views/notice/noticeList.jsp";
		} else {
			request.setAttribute("error-msg", "공지사항 검색 실패!");
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
