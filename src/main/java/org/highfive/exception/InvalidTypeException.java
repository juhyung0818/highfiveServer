package org.highfive.exception;

public class InvalidTypeException extends HighfiveException {

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.INVALID_TYPE;
	}

}
