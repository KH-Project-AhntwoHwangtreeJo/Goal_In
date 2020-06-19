package com.semi.goal.model.vo;


import java.io.Serializable;
import java.sql.Date;

public class Goal implements Serializable{

	private static final long serialVersionUID = 9021L;
	
	private int gno;          // 글 번호
	private String gcategory;  // 골 카테고리
	private String goalname;  // 골 이름
	private String gcontent;  // 골 소개글
	private String goalinone; // 골 목표
	private int gmaxnum;      // 수용 인원
	private int gcurrnum;     // 참여 인원수
	private int gspoint;      // 누적 포인트
	private Date enrolldate;  // 등록일자
	private Date startdate;   // 시작일자
	private Date enddate;     // 종료일자
	private int percent;      // 전체 회원의 달성률 (전체 사용자중에 몇명이 성공했다)
	private String gstatus;   // 현재 활성화 여부 (N이면 끝난 골)
	private String gimg;         // 골 메인 이미지
	private String gwriter;      // 골 작성자
	
	public Goal() {
		super();
	}

	

	public Goal(int gno, String gcategory, String goalname, String gcontent, String goalinone, int gmaxnum,
			int gcurrnum, int gspoint, Date enrolldate, Date startdate, Date enddate, int percent, String gstatus,
			String gimg, String gwriter) {
		super();
		this.gno = gno;
		this.gcategory = gcategory;
		this.goalname = goalname;
		this.gcontent = gcontent;
		this.goalinone = goalinone;
		this.gmaxnum = gmaxnum;
		this.gcurrnum = gcurrnum;
		this.gspoint = gspoint;
		this.enrolldate = enrolldate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.percent = percent;
		this.gstatus = gstatus;
		this.gimg = gimg;
		this.gwriter = gwriter;
	}


	// 골 등록용 생성자
	public Goal(String gcategory, String goalname, String gcontent, String goalinone, int gmaxnum, int gspoint,
			Date startdate, Date enddate, String gimg, String gwriter) {
		super();
		this.gcategory = gcategory;
		this.goalname = goalname;
		this.gcontent = gcontent;
		this.goalinone = goalinone;
		this.gmaxnum = gmaxnum;
		this.gspoint = gspoint;
		this.startdate = startdate;
		this.enddate = enddate;
		this.gimg = gimg;
		this.gwriter = gwriter;
	}



	@Override
	public String toString() {
		return "Goal [gno=" + gno + ", gcategory=" + gcategory + ", goalname=" + goalname + ", gcontent=" + gcontent
				+ ", goalinone=" + goalinone + ", gmaxnum=" + gmaxnum + ", gcurrnum=" + gcurrnum + ", gspoint="
				+ gspoint + ", enrolldate=" + enrolldate + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", percent=" + percent + ", gstatus=" + gstatus + ", gimg=" + gimg + ", gwriter=" + gwriter + "]";
	}



	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public String getGcategory() {
		return gcategory;
	}

	public void setGcategory(String gcategory) {
		this.gcategory = gcategory;
	}

	public String getGoalname() {
		return goalname;
	}

	public void setGoalname(String goalname) {
		this.goalname = goalname;
	}

	public String getGcontent() {
		return gcontent;
	}

	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}

	public String getGoalinone() {
		return goalinone;
	}

	public void setGoalinone(String goalinone) {
		this.goalinone = goalinone;
	}

	public int getGmaxnum() {
		return gmaxnum;
	}

	public void setGmaxnum(int gmaxnum) {
		this.gmaxnum = gmaxnum;
	}

	public int getGcurrnum() {
		return gcurrnum;
	}

	public void setGcurrnum(int gcurrnum) {
		this.gcurrnum = gcurrnum;
	}

	public int getGspoint() {
		return gspoint;
	}

	public void setGspoint(int gspoint) {
		this.gspoint = gspoint;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getGstatus() {
		return gstatus;
	}

	public void setGstatus(String gstatus) {
		this.gstatus = gstatus;
	}

	public String getGimg() {
		return gimg;
	}

	public void setGimg(String gimg) {
		this.gimg = gimg;
	}



	public String getGwriter() {
		return gwriter;
	}



	public void setGwriter(String gwriter) {
		this.gwriter = gwriter;
	}

	
	
}
