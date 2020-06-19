package com.semi.point.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Point implements Serializable{

	private static final long serialVersionUID = 1212121L;
	
	private String userid;  // 회원 아이디
	private Date paydate;   // 결제일자
	private int price;      // 금액
	private String method;
	private int pBalance;
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Point(String userid, Date paydate, int price, String method, int pBalance) {
		super();
		this.userid = userid;
		this.paydate = paydate;
		this.price = price;
		this.method = method;
		this.pBalance = pBalance;
	}
	public Point(int price) {
		super();
		this.price = price;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getPaydate() {
		return paydate;
	}
	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getpBalance() {
		return pBalance;
	}
	public void setpBalance(int pBalance) {
		this.pBalance = pBalance;
	}
	@Override
	public String toString() {
		return "point [userid=" + userid + ", paydate=" + paydate + ", price=" + price + ", method=" + method
				+ ", pBalance=" + pBalance + "]";
	}
	
	
	
}
