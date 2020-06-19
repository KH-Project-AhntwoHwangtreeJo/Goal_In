package com.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.notice.model.service.NoticeService;
import com.semi.notice.model.vo.notice;

@WebServlet("/adminSelectOne.no")
public class NoticeSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeSelectOneServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 공지사항의 글 번호를 받아
		// 해당 게시글을 상세 보기하는 화면으로
		// 이동하는 서블릿

		int nno = Integer.parseInt(request.getParameter("nno"));

		NoticeService ns = new NoticeService();

		String page = null;

		try {
			notice n = ns.selectOne(nno);
			request.setAttribute("notice", n);
			page = "views/admin/NoticeDetail.jsp";

		} finally {
			request.getRequestDispatcher(page).forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
