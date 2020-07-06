package com.semi.join.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.semi.goal.model.vo.Goal;
import com.semi.join.model.dao.JoinDAO;
import com.semi.join.model.vo.Join;


public class JoinService {
	private JoinDAO jDAO = new JoinDAO();
	private Connection con;
		
	// 마이페이지에서 참여중인 골 조회용

		public HashMap<String, Object> selectList(String userid) {
			con = getConnection();
			
			HashMap<String, Object> hmap = new HashMap<String, Object>();
			
			ArrayList<Join> list = jDAO.selectList(con, userid);
			ArrayList<Goal> glist = jDAO.selectMyGoalList(con, userid);

			hmap.put("list", list);  // Join 리스트
			hmap.put("glist", glist); // 골리스트
			
			close(con);
			
			return hmap;
		}

	
	
		// 참여하기 클릭시 이미 참여중인지 조회
		public int selectOneJoin(Join j) {
			con = getConnection();
			int result= 0; //서블릿으로 넘겨줄 값
			result = jDAO.selectMyGoal(con, j);
			
			System.out.println("이미 있는 지 조회? : "+result);

			close(con);
			
			return result;
		}
		
		// 위에 selectOneJoin 실행 후  참여중이지 않으면 참여하기 
		public int insertJoin(Join j) {
			con = getConnection();
			int result = 0; //서블릿으로 넘겨줄 값
			
			result = jDAO.insertJoin(con,j);
			if(result>0) commit(con);
			else rollback(con);

			close(con);
			
			return result;
		}

		public int joinCancel(Join j) {
			con = getConnection();
			int result= 0; //서블릿으로 넘겨줄 값
			result = jDAO.joinCancel(con, j);
			
			System.out.println("이미 있는 지 조회? : "+result);
			if(result>0) commit(con);
			else rollback(con);
			close(con);
			
			return result;
		}


		//2020-07-02  (성공여부 변경)
		public int updateGoalSuccess(String userid, int gno) {
			con = getConnection();

			int result = jDAO.updateGoalSuccess(con, userid, gno);

			if (result > 0)
				commit(con);
			else
				rollback(con);

			close(con);

			return result;
		}



		public int joinCnt(String userid) {
			con = getConnection();
			
			int joincnt = jDAO.joinCnt(con, userid);
			
			System.out.println(joincnt);
			close(con);
			
			return joincnt;
		}




}
