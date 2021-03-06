package org.highfive.domain;

import java.util.Date;

public class BoardVO extends PageVO{

	private int bno;
	private String title;
	private String content;
	private String writer; //uid
	private Date regdate;
	private String startdate;
	private String enddate;
	private int viewcnt;
	private int replycnt;
	private String language;
	//korean : 1
	//foreign : 0
	private int flag;
	private boolean like;
	private String uname;

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String contnet) {
		this.content = contnet;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public boolean getLike(){
		return like;
	}
	public void setLike(boolean like){
		this.like = like;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", startdate=" + startdate + ", enddate=" + enddate + ", viewcnt=" + viewcnt + ", replycnt="
				+ replycnt + ", language=" + language + ", flag=" + flag + ", like=" + like + ", uname=" + uname + "]";
	}
	
}
