package com.semi.join.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.join.model.service.JoinService;
import com.semi.join.model.vo.Join;

/**
 * Servlet implementation class JoinUpdateStatusServlet
 */
@WebServlet("/joinCancel.jo")
public class JoinUpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinUpdateStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		int result=0;  // 인서트결과
		
		
		// 2. 입력한 회원 정보 받아오기
		String member_id = request.getParameter("userid");
		int gno = Integer.parseInt(request.getParameter("gno"));	
		
		System.out.println("서블릿의 아이디임"+member_id);
		System.out.println("서블릿의 골번호임"+gno);
		
		// VO 사용하기
		// 회원 가입 시 정보를 하나로 묶어 전달하는 역할
		
		Join j = new Join(member_id, gno);
	
		System.out.println("j : "+j);
		
		JoinService js = new JoinService();
		
		// 이미 참여중인지 조회
		result = js.joinCancel(j);
		
		System.out.println("서블릿의 result임 : "+result);
		// ------------여기까진 나옴
		if(result==0) {
			response.sendRedirect("/Goal_In/myJoin.jo?userid="+member_id);
			
		}else {
			response.sendRedirect("/Goal_In/myJoin.jo?userid="+member_id);
			System.out.println("안된것같다");
//			request.setAttribute("error-msg","이미 참여중인 골 입니다.");
//			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
