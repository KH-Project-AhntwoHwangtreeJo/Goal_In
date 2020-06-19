package com.semi.join.model.vo;

import java.sql.Date;

public class Join {
	private String userid;   // 회원 아이디
	private int gno;      // 골 번호
	private String success;  // 성공 여부(n이면 투자포인트 차감 y이면 reward에 숫자 기입)
	private Date mdate;      // 참여일자
	private int mpoint;      // 투자 포인트
	private int mpercent;    // 개인달성률
	private int reward;      // 보상금 (n은 0, y일 경우 기입 mpoint보다 작을수 없다)
	
	public Join() {
		super();
		// TODO Auto-generated constructor stub
	}
	// 전체 생성자
	public Join(String userid, int gno, String success, Date mdate, int mpoint, int mpercent, int reward) {
		super();
		this.userid = userid;
		this.gno = gno;
		this.success = success;
		this.mdate = mdate;
		this.mpoint = mpoint;
		this.mpercent = mpercent;
		this.reward = reward;
	}
	
	// 참여하기 생성자
	public Join(String userid, int gno, int mpoint) {
		super();
		this.userid = userid;
		this.gno = gno;
		this.mpoint = mpoint;
	}
	
	
	public Join(String userid, int gno) {
		super();
		this.userid = userid;
		this.gno = gno;
	}
	public Join(int mpoint) {
		super();
		this.mpoint = mpoint;
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
	public void setGno(int gno2) {
		this.gno = gno2;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	public int getMpercent() {
		return mpercent;
	}
	public void setMpercent(int mpercent) {
		this.mpercent = mpercent;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	@Override
	public String toString() {
		return "Join [userid=" + userid + ", gno=" + gno + ", success=" + success + ", mdate=" + mdate + ", mpoint="
				+ mpoint + ", mpercent=" + mpercent + ", reward=" + reward + "]";
	}
	
}
