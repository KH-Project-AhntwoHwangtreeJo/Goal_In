package com.semi.member.exception;


	public class MemberException extends Exception {

		// 사용자 정의 예외
		// 만약 서버에서 어떠한 일을 처리하는 도중
		// 예외가 발생할 경우 개발자나 사용자가
		// 알기 쉬운 메시지를 미리 등록하여
		// 에러를 보다 편리하게 처리하도록 하는
		// 에러 전용 클래스
		
		public MemberException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public MemberException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}
		
	}


