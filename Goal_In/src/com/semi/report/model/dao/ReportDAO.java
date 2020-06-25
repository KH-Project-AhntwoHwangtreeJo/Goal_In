package com.semi.report.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.semi.auth.model.vo.Auth;
import com.semi.join.model.dao.JoinDAO;
import com.semi.join.model.vo.Join;
import com.semi.report.model.vo.Report;

public class ReportDAO {
	private Properties prop;

	public ReportDAO() {
		prop = new Properties();

		String filePath = ReportDAO.class.getResource("/config/report.properties").getPath();

		// System.out.println(filePath);

		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Report> listReport(Connection con) {
		ArrayList<Report> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reportList");

		try {
			pstmt = con.prepareStatement(sql);

			rset = pstmt.executeQuery();

			list = new ArrayList<Report>();

			while (rset.next()) {
				Report r = new Report();

				r.setSignnum(rset.getInt(1));
				r.setUserid(rset.getString(2));

				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Auth> listSign(Connection con) {
		ArrayList<Auth> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("signList");

		try {
			pstmt = con.prepareStatement(sql);

			rset = pstmt.executeQuery();

			list = new ArrayList<Auth>();

			while (rset.next()) {
				Auth a = new Auth();

				a.setSignnum(rset.getInt(1));
				a.setUserid(rset.getString(2));
				a.setGno(rset.getInt(3));
				a.setSigncf(rset.getString(4));
				a.setSigndate(rset.getDate(5));
				a.setSigntf(rset.getString(6));

				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int updateStatus(Connection con, int signNum, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("RstatusUpdate");
		if (status.equals("false")) {
			status = "N";
		} else {
			status = "Y";
		}
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, status);
			pstmt.setInt(2, signNum);

			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Auth> listSign2(Connection con) {
		ArrayList<Auth> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("authallList");

		try {
			pstmt = con.prepareStatement(sql);

			rset = pstmt.executeQuery();

			list = new ArrayList<Auth>();

			while (rset.next()) {
				Auth a = new Auth();
				
				a.setSignnum(rset.getInt(1));
				a.setUserid(rset.getString(2));
				a.setGno(rset.getInt(3));
				a.setSigncf(rset.getString(4));
				a.setSigndate(rset.getDate(5));
				a.setSigntf(rset.getString(6));
				
				list.add(a);
				
			}
			
			System.out.println("dao :  " + list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
}
