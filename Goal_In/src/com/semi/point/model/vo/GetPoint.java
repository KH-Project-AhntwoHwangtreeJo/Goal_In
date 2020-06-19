package com.semi.point.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class GetPoint implements Serializable{
	
	
	private String memberId;
	private int gno;
	private String mYn;
	private Date mDate;
	private int mPoint;
	private String jStatus;
	private double ratio;
	private int calc;
	private int ern;
	
	public GetPoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetPoint(String memberId, int gno, String mYn, Date mDate, int mPoint, String jStatus, double ratio,
			int calc, int ern) {
		super();
		this.memberId = memberId;
		this.gno = gno;
		this.mYn = mYn;
		this.mDate = mDate;
		this.mPoint = mPoint;
		this.jStatus = jStatus;
		this.ratio = ratio;
		this.calc = calc;
		this.ern = ern;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public String getmYn() {
		return mYn;
	}

	public void setmYn(String mYn) {
		this.mYn = mYn;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	public int getmPoint() {
		return mPoint;
	}

	public void setmPoint(int mPoint) {
		this.mPoint = mPoint;
	}

	public String getjStatus() {
		return jStatus;
	}

	public void setjStatus(String jStatus) {
		this.jStatus = jStatus;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public int getCalc() {
		return calc;
	}

	public void setCalc(int calc) {
		this.calc = calc;
	}

	public int getErn() {
		return ern;
	}

	public void setErn(int ern) {
		this.ern = ern;
	}

	@Override
	public String toString() {
		return "GetPoint [memberId=" + memberId + ", gno=" + gno + ", mYn=" + mYn + ", mDate=" + mDate + ", mPoint="
				+ mPoint + ", jStatus=" + jStatus + ", ratio=" + ratio + ", calc=" + calc + ", ern=" + ern + "]";
	}
	
	
	
	
	
	
}
