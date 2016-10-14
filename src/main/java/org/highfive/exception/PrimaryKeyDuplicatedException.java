package org.highfive.exception;

public class PrimaryKeyDuplicatedException extends HighfiveException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.PRIMARY_KEY_DUPLICATE;
	}
	
}
