package org.highfive.domain;

public class SearchKeyword extends PageVO{

	private String keyword;
	private int flag;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public int getFlag(){
		return flag;
	}
	
	public void setFlag(int flag){
		this.flag = flag;
	}
	
}
