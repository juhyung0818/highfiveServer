package org.highfive.domain;

public class FavoritesVO {

	private int fno;
	private String uid;
	private int bno;
	
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
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
		return "FavoritesVO [fno=" + fno + ", uid=" + uid + ", bno=" + bno + "]";
	}
}
