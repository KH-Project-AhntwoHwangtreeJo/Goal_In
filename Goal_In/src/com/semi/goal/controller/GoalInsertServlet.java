package com.semi.goal.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.goal.model.service.GoalService;
import com.semi.goal.model.vo.Goal;

/**
 * Servlet implementation class GoalInsertServlet
 */
@WebServlet("/gInsert.go")
public class GoalInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoalInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드용 서블릿 boardInsertForm.jsp 에서! 
				// MultipartRequest
				
				// 1. 전송받을 최대 크기 설정하기
				// 10MB -> (Byte 크기로 변환하기)
				// (1024 Byte -> 1KB  / 1024KB -> 1MB)
				// 1024 * 1024 * 10;
				int maxSize = 1024 * 1024 * 10;  // 10MB
				
				// 2. multipart/form-data 형식으로 전송되었는지 확인하기
				if ( ! ServletFileUpload.isMultipartContent(request)) { // 멀티 파트로 안보냈다면
					request.setAttribute("error-msg", "multipart로 전송되지 않았습니다.");
					
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				} 
				
				// 3. 웹 상의 루트 (최상위) 경로를 활용하여 저장할 폴더 위치 설정하기
				// webapps/resources/boardUploadFiles
				String root = request.getServletContext().getRealPath("/");
				String savePath = root + "resources/enrollFiles"; //파일 저장할 경로
				
				// 4. 설정한 정보들 바탕으로 멀티파트 객체 생성하기
				// request --> MultipartRequest
				MultipartRequest mre = new MultipartRequest(
																request,   // 속성 변경을 위한 원본 객체
																savePath, // 저장할 파일경로
																maxSize,  // 저장할 파일 최대 크기
																"UTF-8",  // 저장할 문자셋
																new DefaultFileRenamePolicy()
																      // 만약 폴더에 같은 이름의 파일이 
																      // 새로 저장될 경우 자동으로
																      // 이름을 바꿔주는 정책이다.
																	  // 000.txt --> 0001.txt --> 0002.txt
						);
				// --------------------- 파일 업로드 설정 끝! ----------------------//
				
				// 5-1. 기본 전송값 처리하기 
		// 골 제목, 소개글, 목표, 수용인원, 시작일자, 종료일자
		
		String gcategory =mre.getParameter("gcategory");
		String goalname = mre.getParameter("goalname");
		String gcontent = mre.getParameter("gcontent");
		String goalinone = mre.getParameter("goalinone");
		int gmaxnum = Integer.parseInt(mre.getParameter("gmaxnum"));
		String startdate = mre.getParameter("startdate");
		String enddate = mre.getParameter("enddate");
		int money = Integer.parseInt(mre.getParameter("money"));

		// 5-2. 파일 전송 후 저장하기
		// 전달받은 파일을 먼저 저장한 후에 해당 파일의 
		// 이름을 가져온다.
		String gimg = mre.getFilesystemName("gimg");
		String gwriter = mre.getParameter("gwriter");
		
		System.out.println("시작 날짜 : " + startdate);
		System.out.println("종료 날짜 : " + enddate);
		System.out.println("카테고리 : " + gcategory);
		System.out.println("이름 : " + goalname);
		System.out.println("내용: " + gcontent);
		System.out.println("목표: " + goalinone);
		System.out.println("수용인원: " + gmaxnum);
		System.out.println("파일 경로: " + gimg);
		System.out.println("골 작성자 : " + gwriter);
		System.out.println("투자금 : "+ money);
		
		// 시작 날짜
		Date startDate = new Date(new GregorianCalendar().getTimeInMillis());
		
		if (startdate != null && ! startdate.equals("")) {
			String[] dateArr = startdate.split("-");
			int[] intArr = new int[dateArr.length];
			
			for(int i = 0; i <dateArr.length ; i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}
			
			startDate = new Date(new GregorianCalendar(intArr[0], intArr[1]-1, intArr[2]).getTimeInMillis());		
		}
		
		// 종료 날짜
		Date endDate = new Date(new GregorianCalendar().getTimeInMillis());
		
		if (enddate != null && ! enddate.equals("")) {
			String[] edateArr = enddate.split("-");
			int[] intArr = new int[edateArr.length];
			
			for(int i = 0; i <edateArr.length ; i++) {
				intArr[i] = Integer.parseInt(edateArr[i]);
			}
			
			endDate = new Date(new GregorianCalendar(intArr[0], intArr[1]-1, intArr[2]).getTimeInMillis());		
		}
		System.out.println("날짜 배열 후================");
		System.out.println("시작 날짜 : " + startDate);
		System.out.println("종료 날짜 : " + endDate);
		System.out.println("카테고리 : " + gcategory);
		System.out.println("이름 : " + goalname);
		System.out.println("내용: " + gcontent);
		System.out.println("목표: " + goalinone);
		System.out.println("수용인원: " + gmaxnum);
		System.out.println("파일 경로: " + gimg);
		System.out.println("골 작성자 : " + gwriter);
		System.out.println("투자금 : "+ money);
		// 6. 전달받은 값을 서비스로 넘기기
				Goal g = new Goal(gcategory, goalname, gcontent, 
						     goalinone, gmaxnum, money,startDate, endDate, gimg, gwriter);
				g.setGspoint(money);
		
		int result = new GoalService().insertGoal(g);
		
		if (result > 0) {
			// response.sendRedirect("goalDetail.go");
			response.sendRedirect("/Goal_In/index.jsp");
		} else {
			request.setAttribute("error-msg", "골 등록 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
