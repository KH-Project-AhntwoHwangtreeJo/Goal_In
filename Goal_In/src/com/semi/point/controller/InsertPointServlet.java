package com.semi.point.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;
import com.semi.point.model.service.PointService;
import com.semi.point.model.vo.Point;

/**
 * Servlet implementation class InsertPointServlet
 */
@WebServlet("/pInsert.po")
public class InsertPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPointServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			
			int price = Integer.parseInt(request.getParameter("price"));
			Date pDate = new Date(sdf.parse(request.getParameter("date")).getTime());
			HttpSession session = request.getSession(false);
			Member m = (Member)session.getAttribute("member");
			m.setBalance(m.getBalance() + price);
			session.setAttribute("member", m);
			
			Point p = new Point();
			
			p.setUserid(m.getUserid());
			p.setPaydate(pDate);
			p.setPrice(price);
			p.setpBalance(m.getBalance());
			
			PointService ps = new PointService();
			
			int result = ps.insertPoint(p);
			
			System.out.println(result);
			
			if(result > 0) {
				response.sendRedirect("pList.po");
			} else {
				request.setAttribute("error-msg", "공지사항 등록 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp")
				       .forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
