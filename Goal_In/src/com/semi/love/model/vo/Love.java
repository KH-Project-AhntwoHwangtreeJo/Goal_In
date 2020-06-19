package com.semi.love.model.vo;

public class Love {
	private String userid;   // 회원 아이디
	private int gno;
	public Love() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Love(String userid, int gno) {
		super();
		this.userid = userid;
		this.gno = gno;
	}
	public Love(String userid) {
		super();
		this.userid = userid;
	}
	
	public Love(int gno) {
		super();
		this.gno = gno;
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
	@Override
	public String toString() {
		return "love [userid=" + userid + ", gno=" + gno + "]";
	}
	
	
}
