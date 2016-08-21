package org.highfive.domain;

public class highfiveVO {
	private int hno;
	private String receiver;
	private String sender;
	private int hiFlag;
	private String senddate;
	
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public int getHiFlag() {
		return hiFlag;
	}
	public void setHiFlag(int hiFlag) {
		this.hiFlag = hiFlag;
	}
	
	@Override
	public String toString() {
		return "highfiveVO [hno=" + hno + ", receiver=" + receiver + ", sender=" + sender + ", hiFlag=" + hiFlag
				+ ", senddate=" + senddate + "]";
	}
}
