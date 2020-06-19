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
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/NselectList.no")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항 글 여러 개를 DB에서 조회하여
		// 목록 형태로 (ArrayList) 데이터를 전달하는 서블릿
		ArrayList<notice> list = new ArrayList<notice>();
		
		NoticeService ns = new NoticeService();
		
		list = ns.selectList();
		System.out.println(list);
		String page = null;
		
		if(list != null) {
			request.setAttribute("list", list);
			page = "/views/admin/Notice.jsp";
			
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
