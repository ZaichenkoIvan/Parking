package com.example.parking.exception;

public class IdUncorrectedRuntimeException extends RuntimeException {
	public IdUncorrectedRuntimeException() {
	}

	public IdUncorrectedRuntimeException(String s) {
		super(s);
	}

	public IdUncorrectedRuntimeException(String s, Throwable throwable) {
		super(s, throwable);
	}
}
