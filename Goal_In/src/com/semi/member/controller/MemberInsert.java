package com.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.common.PwdEncryptor;
import com.semi.member.exception.MemberException;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/mInsert.me")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsert() {
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
		String savePath = root + "resources/memberImg"; //파일 저장할 경로
		
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
		
		// 회원 가입 서비스 연동 서블릿
		// 5-1. 기본 전송값 처리하기 
		// 입력한 회원 정보 받아오기
				String mImage = mre.getParameter("mimage");
				String userId = mre.getParameter("userid");
				String userPwd = PwdEncryptor.encodePwd(mre.getParameter("userpwd"));
				String userName = mre.getParameter("username");
				String nickName = mre.getParameter("nickname");


				// 010-1111-2222
				String phone = mre.getParameter("tel1") + "-"
						+ mre.getParameter("tel2") + "-"
						+ mre.getParameter("tel3");
				String email = mre.getParameter("email");
				String address = mre.getParameter("address");

				// 5-2. 파일 전송 후 저장하기
				// 전달받은 파일을 먼저 저장한 후에 해당 파일의 
				// 이름을 가져온다.
				String gimg = mre.getFilesystemName("gimg");
	

		
		

		// VO 사용하기
		// 회원 가입 시 정보를 하나로 묶어 전달하는 역할
		Member m = new Member(userId, userPwd, userName, address, nickName,  email, phone, gimg);
	
		System.out.println("가입 정보 확인 : " + m);
		
		// 회원 가입 실행
		MemberService ms = new MemberService();
		
		try {
			ms.insertMember(m);
			// 회원 가입 성공!
			System.out.println("회원 가입 성공!");
			
			response.sendRedirect("index.jsp");
			
		} catch (MemberException e) {
		
			System.out.println("회원 가입 실패!");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
			request.setAttribute("error-msg", "회원 가입 실패");
			request.setAttribute("exception", e);
			
			view.forward(request, response);
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
