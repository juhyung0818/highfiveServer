package org.highfive.domain;

public class FavoritesVO {

	private String uid;
	private int bno;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "FavoritesVO [uid=" + uid + ", bno=" + bno + "]";
	}
}
