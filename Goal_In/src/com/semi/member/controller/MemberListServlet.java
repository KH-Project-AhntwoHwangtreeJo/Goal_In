package com.semi.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.member.exception.MemberException;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;



/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/selectList.no")
public class MemberListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항 글 여러 개를 DB에서 조회하여
		// 목록 형태로 (ArrayList) 데이터를 전달하는 서블릿
		ArrayList<Member> list = new ArrayList<Member>();
		
		MemberService ns = new MemberService();
		
		String page = null;
		
		try {
			list = ns.selectList();
			request.setAttribute("list", list);
			 page="views/admin/User.jsp";
			
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