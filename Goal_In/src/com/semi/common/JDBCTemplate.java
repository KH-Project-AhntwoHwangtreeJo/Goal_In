package com.semi.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {
public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			// 데이터 베이스 연결 방법
			// 1. 일반적인 연결
			/*
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"JSP", "JSP");
			*/
			
			// 2. JNDI 방식
			//  - 데이터 베이스 연결 객체인 DataSource를 사용하여
			//    context.xml에 데이터베이스 연결 정보를 등록하고
			//    해당 정보로 데이터 베이스를 연결하는 방법
			// ** JNDI (Java Naming and Directory Interface)
			//    Java 코드를 특정 폴더나 파일의 이름으로 가져오는 방식
			//    (향후 배울 스프링 프레임워크에 좀더 흡사한 방식)
			Context initContext = new InitialContext();
			
			DataSource ds = (DataSource)initContext
					                  .lookup("java:comp/env/jdbc/oracleDB"); 
			con = ds.getConnection();
			
			con.setAutoCommit(false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	} 
	
	// 오버로딩 기술 적용!
	public static void close(Connection con) {
		try {
			if(con != null && !con.isClosed()) 
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && ! stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			
			if(rset != null && ! rset.isClosed())
				rset.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			if(con != null && ! con.isClosed())
				con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			if(con != null && ! con.isClosed())
				con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
