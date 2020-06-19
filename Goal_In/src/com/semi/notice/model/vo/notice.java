package com.semi.notice.model.vo;

import java.sql.Date;

public class notice {
	private int nno;          // 공지사항 번호
	private String ntitle;    // 제목
	private String nwriter;   // 작성자
	private String ncontent;  // 내용
	private Date ndate;       // 작성일자
	private int ncount;       // 조회수
	private String nstatus;   // 삭제유무
	
	public notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public notice(int nno, String ntitle, String nwriter, String ncontent, Date ndate, int ncount, String nstatus) {
		super();
		this.nno = nno;
		this.ntitle = ntitle;
		this.nwriter = nwriter;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.ncount = ncount;
		this.nstatus = nstatus;
	}

	public notice(String ntitle, String ncontent) {
		super();
		this.ntitle = ntitle;
		this.ncontent = ncontent;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNwriter() {
		return nwriter;
	}

	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public Date getNdate() {
		return ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

	public int getNcount() {
		return ncount;
	}

	public void setNcount(int ncount) {
		this.ncount = ncount;
	}

	public String getNstatus() {
		return nstatus;
	}

	public void setNstatus(String nstatus) {
		this.nstatus = nstatus;
	}

	@Override
	public String toString() {
		return "notice [nno=" + nno + ", ntitle=" + ntitle + ", nwriter=" + nwriter + ", ncontent=" + ncontent
				+ ", ndate=" + ndate + ", ncount=" + ncount + ", nstatus=" + nstatus + "]";
	}
	
	
	
}
