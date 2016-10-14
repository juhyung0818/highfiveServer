package org.highfive.domain;

public class PageVO {

	//class for paging
	private int page; //page Number;
	private int perPageNum; //number of board 

	PageVO(){
		perPageNum = 10;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public int getPerPageNum(){
		return perPageNum;
	}
	
}
