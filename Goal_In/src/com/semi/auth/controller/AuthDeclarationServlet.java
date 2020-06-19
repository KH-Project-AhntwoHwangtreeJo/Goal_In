package com.semi.auth.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.auth.model.service.AuthService;
import com.semi.auth.model.vo.Auth;

/**
 * Servlet implementation class AuthDeclaration
 */
@WebServlet("/aDeclaration.ao")
public class AuthDeclarationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthDeclarationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int signnum = Integer.parseInt(request.getParameter("signnum"));
		String userid = request.getParameter("userid");
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		//System.out.println(signnum);
		//System.out.println(userid);
		
		Auth a = new Auth(signnum, userid);
		
		AuthService as = new AuthService();
		
		int result1 = as.authDeclarationSelect(signnum, userid);
		
		
		if ( result1 > 0 ) { // 이미 신고한경우!
			
			//1.  response.sendRedirect("/Goal_In/AuthImgAllList.ao?gno="+gno);
			
			//System.out.println("result1 : " + result1 + "이미 신고했어요");
			
//	2.		request.setAttribute("error-msg", "신고 실패");
//			request.getRequestDispatcher("/Goal_In/AuthImgAllList.ao").forward(request, response);
			
			
//			response.setContentType("text/html; charset=UTF-8");
//			 
//			PrintWriter out = response.getWriter();
//			 
//			out.println("<script>alert('이미 신고한 사진입니다.'); location.href='/Goal_In/AuthImgAllList.ao?gno='+gno;</script>");
//			
//			out.flush(); 
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			out.println("<script>");
			out.println("alert('이미 신고한 사진입니다!!!');");
			out.println("history.back();");
			out.println("</script>");

		} else { // 신고 안된경우
			
			int result = as.authDeclaration(signnum, userid);
			
			//System.out.println("result : " + result + "신고 안했었네");
			
			 if(result > 0) { // 신고등록 성공한 경우
				 
	    	  	 response.sendRedirect("/Goal_In/goalList.go");  // 신고 했으니까 목록으로 가자
	    	  	 
		      } else { // 신고 등록 실패한경우 
		    	  
		    	  request.setAttribute("error-msg", "신고 실패");
				  request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
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
