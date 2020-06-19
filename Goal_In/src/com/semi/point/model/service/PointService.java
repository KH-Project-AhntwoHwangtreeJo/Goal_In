package com.semi.point.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;


import java.sql.Connection;
import java.util.ArrayList;

import com.semi.point.model.dao.PointDAO;
import com.semi.point.model.vo.GetPoint;
import com.semi.point.model.vo.Point;



public class PointService {

	private PointDAO pDAO = new PointDAO();
	private Connection con;
	
	public int insertPoint(Point p) {
		con = getConnection();
		
		int result = pDAO.insertPoint(con, p);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<Point> selectList(String userid, int startRow, int endRow) {
		con = getConnection();
		ArrayList<Point> list = pDAO.selectList(con, userid, startRow, endRow);

		close(con);

		return list;
	}
	

	public int getPointListCount(String userId) {
		con = getConnection();
		
		int result = pDAO.getPointListCount(con, userId);
		
		close(con);
		
		return result;
	}

	public int getUsedPointListCount(String userId) {
		con = getConnection();
		
		int result = pDAO.getUsedPointListCount(con, userId);
		
		close(con);
		
		return result;
	}

	public ArrayList<GetPoint> selectUsedList(String userid, int startRow, int endRow) {
		con = getConnection();
		ArrayList<GetPoint> list = pDAO.selectUsedList(con, userid, startRow, endRow);

		close(con);

		return list;
	}

	
	
	
	
	
	
	
}
