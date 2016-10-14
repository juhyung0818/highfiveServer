package org.highfive.exception;

public class NotAuthoriedException extends HighfiveException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.ACCESS_DENIED;
	}

}
