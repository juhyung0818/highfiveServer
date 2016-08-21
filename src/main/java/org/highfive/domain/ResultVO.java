package org.highfive.domain;

import org.highfive.exception.ExceptionCode;

public class ResultVO {
	private int code = ExceptionCode.NONE.getCode();
	private String message =ExceptionCode.NONE.getMessage();
	private Object result;
	
	public ResultVO() {}
	public ResultVO(Object result){
		this.result = result;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ResultVO [code=" + code + ", message=" + message + ", result=" + result + "]";
	}
}
