package org.highfive.domain;

import java.util.Date;

public class HighfiveVO extends PageVO{
		
	private String receiver;
	private String sender;
	//0 : sender = receiver
	//1 : sender -> receiver
	//2 : receiver <- sender
	private int flag;
	private Date sendDate;

	public Date getSenddate() {
		return sendDate;
	}

	public void setSenddate(Date senddate) {
		this.sendDate = senddate;
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
