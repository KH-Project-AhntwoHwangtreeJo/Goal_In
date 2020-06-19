package com.semi.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String userid;
	private String userpwd;
	private String username;
	private String address;
	private String nickname;
	private String email;
	private String phone;
	private int balance;
	private Date enrollDate;
	private String mStatus;
	private String mimage;
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Member(String userid, String userpwd, String username, String address, String nickname, String email,
			String phone, int balance, Date enrollDate, String mStatus, String mimage) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.address = address;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.enrollDate = enrollDate;
		this.mStatus = mStatus;
		this.mimage = mimage;
	}

	// 회원 가입용 생성자
	public Member(String userid, String userpwd, String username, String address, String nickname, String email,
			String phone, String mimage) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.address = address;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.mimage = mimage;
	}
	
	// 로그인용 생성자
	public Member(String userid, String userpwd) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
	}


	@Override
	public String toString() {
		return "Member [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", address=" + address
				+ ", nickname=" + nickname + ", email=" + email + ", phone=" + phone + ", balance=" + balance
				+ ", enrollDate=" + enrollDate + ", mStatus=" + mStatus + ", mimage=" + mimage + "]";
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUserpwd() {
		return userpwd;
	}


	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}


	public String getmStatus() {
		return mStatus;
	}


	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}


	public String getMimage() {
		return mimage;
	}


	public void setMimage(String mimage) {
		this.mimage = mimage;
	}
	
	
	
	
	
}