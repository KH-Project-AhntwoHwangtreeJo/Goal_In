package com.semi.member.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.common.PwdEncryptor;
import com.semi.member.exception.MemberException;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdate
 */
@WebServlet("/mUpdate.me")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		// 1. 인코딩 -- EncodingFilter가 대신 
		// 2. 회원 정보 수정용 데이터 받아오기
		String mimage = mre.getParameter("mimage");
		String userpwd = PwdEncryptor.encodePwd(mre.getParameter("userpwd"));
		String address = mre.getParameter("address");
		String nickname = mre.getParameter("nickname");
		String phone = mre.getParameter("tel1") + "-"
				 + mre.getParameter("tel2") + "-"
				 + mre.getParameter("tel3");
		String email = mre.getParameter("email");
	
			    
		
		// 해당 회원의 원본 정보 가져오기
		HttpSession session = request.getSession(false);
		
		Member m = (Member)session.getAttribute("member");
		
		
		m.setUserpwd(userpwd);
		m.setNickname(nickname);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);
		// 기존 정보를 setter를 사용해서 새로운 정보로 바꾸기
		// 5-2. 파일 전송 후 저장
		String Mimage = mre.getFilesystemName("mimage");
		
		// 만약 전달한 파일이 있다면 파일 변경,
		// 그렇지 않다면 이전 파일 사용하기
		if(mimage != null) {
			System.out.println(m.getMimage());
			if(m.getMimage() != null) {
				// 만약 이전 파일이 있었다면 삭제
				File originFile = new File(savePath+"/"+m.getMimage());
				System.out.println("파일 삭제 확인 : " + originFile.delete());
			}
			
			m.setMimage(mimage);
		}
		

		System.out.println("변경한 회원 정보 확인 : " + m);
		
		// 회원 정보 수정 서비스 실행하기
		MemberService ms = new MemberService();
		
		try {
			ms.updateMember(m);
			
			System.out.println("회원 정보 변경 성공!");
			
			session.invalidate(); //회원 정보가 변경되면 재 로그인!!
			
			response.sendRedirect("index.jsp");
			
		} catch(MemberException e) {
			 // 회원 정보 변경 실패...
			
			System.out.println("회원 정보 변경 실패");
			
			request.setAttribute("error-msg", "회원 정보 변경 실패!");
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
