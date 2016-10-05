package org.highfive.exception;

public class NotExistException extends HighfiveException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.NOT_EXIST;
	}

}
