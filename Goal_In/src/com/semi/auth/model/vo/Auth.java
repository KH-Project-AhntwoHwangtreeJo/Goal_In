package com.semi.auth.model.vo;

import java.sql.Date;

public class Auth {
	private int signnum;         // 인증번호
	private String userid;       // 회원 아이디
	private int gno;             // 골 번호
	private String signcf;       // 골인원 사진인증
	private Date signdate;       // 인증 일자
	private String signtf;       // 인증 유효성
	
	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 전체 생성자
	public Auth(int signnum, String userid, int gno, String signcf, Date signdate, String signtf) {
		super();
		this.signnum = signnum;
		this.userid = userid;
		this.gno = gno;
		this.signcf = signcf;
		this.signdate = signdate;
		this.signtf = signtf;
	}
	
	// 인증하기 작성용 생성자
	public Auth(String userid,int gno,  String signcf) {
		super();
		this.gno = gno;
		this.userid = userid;
		this.signcf = signcf;
	}
	
	// 인증 신고하기
	public Auth(int signnum, String userid) {
		super();
		this.signnum = signnum;
		this.userid = userid;
	}
	
	public int getSignnum() {
		return signnum;
	}

	public void setSignnum(int signnum) {
		this.signnum = signnum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getSigncf() {
		return signcf;
	}
	public void setSigncf(String signcf) {
		this.signcf = signcf;
	}
	public Date getSigndate() {
		return signdate;
	}
	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
	public String getSigntf() {
		return signtf;
	}
	public void setSigntf(String signtf) {
		this.signtf = signtf;
	}
	@Override
	public String toString() {
		return "auth [signnum=" + signnum + ", userid=" + userid + ", gno=" + gno + ", signcf=" + signcf + ", signdate="
				+ signdate + ", signtf=" + signtf + "]";
	}
	
	
}
