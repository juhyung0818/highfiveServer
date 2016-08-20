package org.highfive.exception;

public abstract class HighfiveException extends RuntimeException{
	private static final long serialVersionUID = 8570300479191506240L;

	public abstract ExceptionCode getExceptionCode();
}
