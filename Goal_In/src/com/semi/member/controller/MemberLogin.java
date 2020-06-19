package com.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.common.PwdEncryptor;
import com.semi.member.exception.MemberException;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/login.me")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("UTF-8");
		// 2. 정보 받아오기
		String userid = request.getParameter("userid");
		String userpwd = PwdEncryptor.encodePwd(request.getParameter("userpwd"));
		String originpwd = (String)request.getAttribute("originpwd");
		
		System.out.println("원본 비밀번호 : " + originpwd);
		System.out.println("암호화 비밀번호 : " + userpwd);
				
		Member m = new Member(userid, userpwd);
		
		// 3. 회원 정보를 담아 데이터베이스와 비교하기
		MemberService ms = new MemberService();
		
		try {
			 m = ms.selectMember(m);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("member", m);
			response.sendRedirect("index.jsp");
			System.out.println(m);
			
		} catch(MemberException e) {
			
			request.setAttribute("error-msg", "회원 로그인 실패!");
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
