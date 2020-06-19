package com.semi.love.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.join.model.service.JoinService;
import com.semi.join.model.vo.Join;
import com.semi.love.model.service.LoveService;
import com.semi.love.model.vo.Love;

/**
 * Servlet implementation class deleteLoveServlet
 */
@WebServlet("/dl.lo")
public class deleteLoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteLoveServlet() {
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
		String member_id = request.getParameter("userId");
		int gno = Integer.parseInt(request.getParameter("gno"));	
		
		// VO 사용하기
		// 회원 가입 시 정보를 하나로 묶어 전달하는 역할
		
		Love l = new Love(member_id, gno);
	
		System.out.println("l : "+l);
		
		LoveService ls = new LoveService();
		
		// 이미 참여중인지 조회
		result = ls.deleteLove(l);
		// ------------여기까진 나옴
		if(result==0) {
			response.sendRedirect("myLove.lo?userid"+member_id);
			
		}else {
			response.sendRedirect("myLove.lo?userid"+member_id);
			System.out.println("안된것같다");
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
