package org.highfive.exception;

public class UserIdDuplicatedException extends HighfiveException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.USER_ID_DUPLICATE;
	}
	
}
