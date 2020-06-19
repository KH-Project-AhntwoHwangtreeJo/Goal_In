package com.semi.notice.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.semi.notice.model.dao.noticeDAO;
import com.semi.notice.model.vo.notice;

public class NoticeService {
	private noticeDAO nDAO = new noticeDAO();
	private Connection con;

	public ArrayList<notice> selectList() {
		con = getConnection();

		ArrayList<notice> list = nDAO.selectList(con);

		close(con);

		return list;
	}

	public notice selectOne(int nno) {
		con = getConnection();

		notice n = nDAO.selectOne(con, nno);

		if (n != null) {
			// 조회수 1증가
			int result = nDAO.updateReadCount(con, nno);

			if (result > 0)
				commit(con);
			else
				rollback(con);
		}

		close(con);

		return n;
	}

	public int insertNotice(notice n) {
		con = getConnection();

		int result = nDAO.insertNotice(con, n);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public notice updateView(int nno) {
		con = getConnection();
		notice n = nDAO.selectOne(con, nno);

		close(con);

		return n;
	}

	public int updateNotice(notice n) {
		con = getConnection();

		int result = nDAO.updateNotice(con, n);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public int deleteNotice(int nno) {
		con = getConnection();

		int result = nDAO.deleteNotice(con, nno);

		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public ArrayList<notice> searchNotice(String condition, String keyword) {
		con = getConnection();
		ArrayList<notice> list = null;

		// 컨디션에 뭐라도 내용이 들어왔다면
		// 조건부 검색 실시(제목, 내용 등)
		if (condition.length() > 0) {
			list = nDAO.searchList(con, condition, keyword);

		} else { // 검색 조건이 없다면 전체 검색을 실시
			list = nDAO.selectList(con);
		}

		close(con);

		return list;
	}

	// 일반 유저 공지사항 리스트 화면
	public ArrayList<notice> userNoticeList() {
		con = getConnection();

		ArrayList<notice> list = nDAO.userNoticeList(con);

		close(con);

		return list;

	}

}
