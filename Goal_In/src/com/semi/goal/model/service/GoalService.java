package com.semi.goal.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.goal.model.dao.GoalDAO;
import com.semi.goal.model.vo.Goal;
import com.semi.join.model.vo.Join;
import com.semi.member.exception.MemberException;
import com.semi.member.model.vo.Member;
	// 기본 서비스
public class GoalService {
	private Connection con;
	private GoalDAO gDAO = new GoalDAO();
	
	// 골 생성 서비스
		public int insertGoal(Goal g) {
			con = getConnection();
			
			int result1 = gDAO.insertGoal(con, g);
			int result3=0; // 둘다 성공 했을 때 리턴 값
			int firstPoint=g.getGspoint();
			
				if(result1 >0) { // goalinsert 성공
					commit(con);    // 추가저장
					System.out.println("골은 등록 했다?");
					
					// 지금막 등록한 골 번호 조회해 옴 
					int gno = gDAO.selectLastGoalNo(con);
					
					Join j = new Join();
					j.setGno(gno);
					j.setUserid(g.getGwriter());
					j.setMpoint(firstPoint);
					
					int result2= gDAO.goalJoin(con, j);  // 추가
					
						if(result2 > 0) {
							result3=1;
							commit(con);
						} else {
							System.out.println("Joingoal 실패");
						}
						
				}else {
					System.out.println("insertGoal 실패");
				}
				
				if(result3==0) rollback(con);
				
			close(con);
			
			return result3;                    
		}
		
	
	// Main 골 Top5 조회용
	public ArrayList<Goal> selectTop5() {
		con = getConnection();
		
		ArrayList<Goal> list = gDAO.selectTop5(con);
		
		close(con);
		
		return list;
	}
	//  Main 최신 업데이트 골
	public ArrayList<Goal> selectList(String gcategory) {
		con = getConnection();
		
		ArrayList<Goal> list = gDAO.selectList(con,gcategory);
	
		close(con);
		
		return list;
	}
	
	// Main 검색바용 서비스
	public ArrayList<Goal> searchGoal(String keyword) {
		con = getConnection();
		ArrayList<Goal> list = null;
		
		// 컨디션에 뭐라도 내용이 들어왔다면
		// 조건부 검색 실시(제목, 내용 등)
		if(keyword.length() > 0) {
			list = gDAO.searchGoal(con, keyword);
			
		} else { // 검색 조건이 없다면 전체 검색을 실시
			list = gDAO.searchAllList(con);
		}
		
		close(con);
		
		return list;
	}
	
	// 전체 조회용 
	public ArrayList<Goal> selectAllList() {
		con = getConnection();
		
		ArrayList<Goal> list = gDAO.selectAllList(con);
		
		close(con);
		
		return list;
	}
	// Goal 디테일 페이지 조회용
	public Goal selectOne(int gno) {
		con = getConnection();
		Goal g = gDAO.selectOne(con, gno);
		
		close(con);
		
		return g;
		
	}
	
	// 완료된 골 리스트 조회
	public ArrayList<Goal> selectDoneList() {
		con = getConnection();
		
		ArrayList<Goal> list = gDAO.selectDoneList(con);
		
		close(con);
		
		return list;
	}
	
	// 관리자 골 전체 리스트 불러오기
	public ArrayList<Goal> selectList() throws MemberException {
		con = getConnection();
		
		ArrayList<Goal> list = gDAO.selectAdminGoalList(con);
		
		close(con);
		
		return list;
	}
	 // 관리자 골 게시상태 변경
	public int updateStatus(int gno, String status) {
		con = getConnection();

		int result = gDAO.updateStatus(con, gno, status);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}
	
	
	// 골 관련 컨텐츠 개수(후기, 좋아요, 인증) 조회용
			public int[] selectContentCnt(int gno) {
				con = getConnection();
				
				int[] cnt = gDAO.selectContentCnt(con, gno);
				
				close(con);
				
				return cnt;
			}

			// Goal 작성자 이미지 , 닉네임 가져오기
			public Member selectGoalWriter(int gno) {
				con = getConnection();
				
				Member w = gDAO.selectGoalWriter(con, gno);
				
				close(con);
				
				return w;
			}


			public int[] selectContentCnt2(String userid, int gno) {
				
				con = getConnection();
				
				int[] cnt2 = gDAO.selectContentCnt2(con, userid, gno);
				
				
				close(con);
				
				return cnt2;
			}




}
