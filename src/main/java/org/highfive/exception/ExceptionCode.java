package org.highfive.exception;

public enum ExceptionCode {

	NONE(200, "success"),
	USER_ID_DUPLICATE(100, "user id duplicated"),
	INVALID_TYPE(300, "invalid type"),
	NOT_EXIST(400, "not exist"),
	ACCESS_DENIED(500, "you don't have permission.");
	
	private int code;
	private String message;
	
	ExceptionCode(int code, String message){
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
