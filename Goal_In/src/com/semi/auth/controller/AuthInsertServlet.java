package com.semi.auth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.auth.model.service.AuthService;
import com.semi.auth.model.vo.Auth;

/**
 * Servlet implementation class AuthInsertServlet
 */
@WebServlet("/aInsert.ao")
public class AuthInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드용 서블릿 auth.jsp 에서! 
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
		// webapps/resources/authUploadFiles
		String root = request.getServletContext().getRealPath("/");
		String savePath = root + "resources/authUploadFiles"; //파일 저장할 경로
		
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
		int gno = Integer.parseInt(mre.getParameter("gno"));
		String userid = mre.getParameter("userid");
		
		// 5-2. 파일 전송 후 저장하기
		// 전달받은 파일을 먼저 저장한 후에 해당 파일의 
		// 이름을 가져온다.
		String signcf = mre.getFilesystemName("signcf");
		
		
		  //System.out.println(gno); 
		  //System.out.println(userid);
		  //System.out.println(signcf);
		
		// 6. 전달받은 값을 서비스로 넘기기
		Auth a = new Auth(userid, gno, signcf);  
		
		int result = new AuthService().insertAuth(a);
		//System.out.println("RESULT: "+result);
		if (result > 0) {
			// response.sendRedirect("goalDetail.go");
			response.sendRedirect("/Goal_In/index.jsp");
		} else {
			request.setAttribute("error-msg", "인증 등록 실패");
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
