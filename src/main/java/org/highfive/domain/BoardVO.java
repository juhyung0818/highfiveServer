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
	private int flag;

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
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", contnet=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", startdate=" + startdate + ", enddate=" + enddate + ", viewcnt=" + viewcnt + ", replycnt="
				+ replycnt + ", language=" + language + ", flag=" + flag + "]";
	}
}
