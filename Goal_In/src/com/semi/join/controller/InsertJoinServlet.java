package com.semi.join.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.join.model.service.JoinService;
import com.semi.join.model.vo.Join;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class InsertJoinServlet
 */
@WebServlet("/ij.jo")
public class InsertJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		int result1=0; // 조회결과
		int result2=0; // 인서트결과
		
		
		// 2. 입력한 회원 정보 받아오기
		String member_id = request.getParameter("user_id");
		int gno = Integer.parseInt(request.getParameter("gno"));	
		int m_point = Integer.parseInt(request.getParameter("point"));
		
		HttpSession session = request.getSession();
		
		session.getAttribute("member");
		
		Member m = (Member) session.getAttribute("member");
		
		m.setBalance(m.getBalance() - m_point);
		
		session.setAttribute("member", m);
		
		// VO 사용하기
		// 회원 가입 시 정보를 하나로 묶어 전달하는 역할
		
		Join j = new Join(member_id, gno, m_point);
	
		System.out.println("j : "+j);
		
		JoinService js = new JoinService();
		
		// 이미 참여중인지 조회
		result1 = js.selectOneJoin(j);
		// ------------여기까진 나옴
		if(result1==0) {
			result2= js.insertJoin(j); // 골 참여하기 실행
			System.out.println("추가 됨 ? : "+result2);
			
			
			if(result2>0) { // 인서트 결과가 0보다 크면 삽입 성공
				
				response.sendRedirect("gsol.go?gno="+ gno);
				System.out.println("추가 됨 ? : 추가됨");
				
			}else { 
				// 인서트 결과가 0이면 추가가 안됨
				response.sendRedirect("gsol.go?gno="+ gno);
				System.out.println("추가 됨 ? : 추가안됨");
//				request.setAttribute("error-msg","골 참여 실패!");
//				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
			}
			
		}else {
			
			System.out.println("추가 됨 ? : 이미있어서 아됨");
			
			response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('이미 등록했었던 골입니다');");
            out.println("history.back();");
            out.println("</script>");
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
