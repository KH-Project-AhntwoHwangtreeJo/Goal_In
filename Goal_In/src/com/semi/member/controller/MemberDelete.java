package com.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.semi.common.PwdEncryptor;
import com.semi.member.exception.MemberException;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdate
 */
@WebServlet("/mDelete.me")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원 아이디 가져오기
		HttpSession session = request.getSession(false);
				
		String userid = ((Member)session.getAttribute("member")).getUserid();
		String userpwd = PwdEncryptor.encodePwd(request.getParameter("userpwd"));
		//String originpwd = (String)request.getAttribute("originpwd");

		 System.out.println("회원 기존 아이디  : " + userid); 
		 System.out.println("회원 입력 비밀번호  : " + request.getParameter("userpwd"));

				
				
				MemberService ms = new MemberService();
				
				
				try {
					ms.deleteMember(userid, userpwd);
					
					System.out.println("회원 탈퇴 성공!");
					
					session.invalidate();
					
					response.sendRedirect("index.jsp");
					
				} catch(MemberException e) {
					request.setAttribute("error-msg", "회원 탈퇴 수행 중 에러 발생!");
					request.setAttribute("exception", e);
					
					request
					.getRequestDispatcher("views/common/errorPage.jsp")
					.forward(request, response);
				}
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
