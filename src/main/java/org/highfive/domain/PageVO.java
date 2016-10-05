package org.highfive.domain;

public class PageVO {

	//class for paging
	private int page; //page Number;
	private int flag; //board flag
	private int perPageNum; //number of board 

	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	PageVO(){
		perPageNum = 3;
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
