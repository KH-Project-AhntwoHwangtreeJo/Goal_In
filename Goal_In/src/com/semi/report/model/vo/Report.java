package com.semi.report.model.vo;

public class Report {
	private int signnum;    // 인증번호
	private String userid;  // 신고자아이디를 유저아이디로 받아옴
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Report(int signnum, String userid) {
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
	
	
}
