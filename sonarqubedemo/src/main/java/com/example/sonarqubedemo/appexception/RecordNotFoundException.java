package com.example.sonarqubedemo.appexception;

public class RecordNotFoundException extends Exception {

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}

}
