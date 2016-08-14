package org.highfive.domain;

public class TestVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
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
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "TestVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}
	
}
