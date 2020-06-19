package com.semi.love.model.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.semi.goal.model.vo.Goal;
import com.semi.love.model.dao.LoveDAO;
import com.semi.love.model.vo.Love;

public class LoveService {
	private LoveDAO lDAO = new LoveDAO();
	private Connection con;

	public HashMap<String, Object> selectList(String userid) {
		con = getConnection();
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		ArrayList<Love> list = lDAO.selectList(con, userid);
		ArrayList<Goal> glist = lDAO.selectMyGoalList(con, userid);

		hmap.put("list", list);  // Join 리스트
		hmap.put("glist", glist); // 골리스트
		
		close(con);
		
		return hmap;
	}

	public int selectOneLove(Love l) {
		con = getConnection();
		int result= 0; //서블릿으로 넘겨줄 값
		result = lDAO.selectMyGoal(con, l);
		
		System.out.println("이미 있는 지 조회? : "+result);

		close(con);
		
		return result;
	}

	public int insertLove(Love l) {
		con = getConnection();
		int result = 0; //서블릿으로 넘겨줄 값
		
		result = lDAO.insertJoin(con,l);
		if(result>0) commit(con);
		else rollback(con);

		close(con);
		
		return result;
	}

	public int deleteLove(Love l) {
		con = getConnection();
		int result = 0; //서블릿으로 넘겨줄 값
		
		result = lDAO.deleteLove(con,l);
		if(result>0) commit(con);
		else rollback(con);

		close(con);
		
		return result;
	}

	

}
