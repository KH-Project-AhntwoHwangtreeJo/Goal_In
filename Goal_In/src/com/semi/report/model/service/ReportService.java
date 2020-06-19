package com.semi.report.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.semi.auth.model.vo.Auth;
import com.semi.join.model.dao.JoinDAO;
import com.semi.report.model.dao.ReportDAO;
import com.semi.report.model.vo.Report;

public class ReportService {
	private ReportDAO rDAO = new ReportDAO();
	private Connection con;
	
	public HashMap<String, Object> selectList() {
		con = getConnection();
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		ArrayList<Report> list = rDAO.listReport(con);
		ArrayList<Auth> alist = rDAO.listSign(con);

		hmap.put("list", list);  // Join 리스트
		hmap.put("alist", alist); // 골리스트
		
		close(con);
		
		return hmap;
		
		
		
	}

	public int updateStatus(int signNum, String status) {
		con = getConnection();

		int result = rDAO.updateStatus(con, signNum, status);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}
	
}
