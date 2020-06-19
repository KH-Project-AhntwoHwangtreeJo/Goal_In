package com.semi.reviews.model.vo;

import java.sql.Date;

public class Reviews {
	private String userId;   // 유저아이디
	private int gno;         // 골 번호
	private Date rDate;      // 리뷰 작성일
	private String rContent; // 리뷰 작성내용
	private String rStatus; // 현재 활성화 여부
	
	// 기본 생성자
	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	// 모든 생성자
	public Reviews(String userId, int gno, Date rDate, String rContent, String rStatus) {
		super();
		this.userId = userId;
		this.gno = gno;
		this.rDate = rDate;
		this.rContent = rContent;
		this.rStatus = rStatus;
	}
	
	// 리뷰 작성 생성자
	public Reviews(String userId, Date rDate, String rContent) {
		super();
		this.userId = userId;
		this.rDate = rDate;
		this.rContent = rContent;
	}
	
	// 골 디테일에서 조회용 생성자
	public Reviews(String userId, int gno, String rContent) {
		super();
		this.userId = userId;
		this.gno = gno;
		this.rContent = rContent;
	}
	// ??????
	public Reviews(String rContent) {
		super();
		this.rContent = rContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public Date getRDate() {
		return rDate;
	}
	public void setRDate(Date rDate) {
		this.rDate = rDate;
	}
	public String getRContent() {
		return rContent;
	}
	public void setRContent(String rContent) {
		this.rContent = rContent;
	}
	
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	@Override
	public String toString() {
		return "Reviews [userId=" + userId + ", gno=" + gno + ", rDate=" + rDate + ", rContent=" + rContent
				+ ", rStatus=" + rStatus + "]";
	}
	
	
}
