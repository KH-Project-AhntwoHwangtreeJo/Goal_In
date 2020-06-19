package com.semi.goal.model.vo;

import java.io.Serializable;

public class PageInfo implements Serializable{
	// 페이지 처리와 관련된 변수를 모두 담는 객체 이다.  GoalSelectListServlet 에서 연결
	private int currentPage;
	private int listCount;
	private int limit;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int startRow;
	private int endRow;
	
	
	public PageInfo() {
		super();
	}

	public PageInfo(String curPage, int listCount) {
		super();
		this.currentPage = 1;

		if(curPage != null) {
			this.currentPage = Integer.parseInt(curPage);
		}
		
		this.listCount = listCount;
		this.limit = 10;
		this.maxPage = (int)((double)listCount/limit + 0.9);
		this.startPage = ((int)((double)currentPage/limit + 0.9)-1)*limit+1;
		this.endPage = startPage + limit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		startRow = (currentPage - 1) * limit + 1;
		endRow = startRow + limit - 1;
		
	}

	
	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	
	
	

}
