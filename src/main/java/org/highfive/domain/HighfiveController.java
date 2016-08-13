package org.highfive.domain;

import java.util.Date;

public class HighfiveController {

	private int hno;
	private String sender;
	private String receiver;
	private Date regdate;
	private Boolean falg;
	
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Boolean getFalg() {
		return falg;
	}
	public void setFalg(Boolean falg) {
		this.falg = falg;
	}
	@Override
	public String toString() {
		return "HighfiveController [hno=" + hno + ", sender=" + sender + ", receiver=" + receiver + ", regdate="
				+ regdate + ", falg=" + falg + "]";
	}
}
