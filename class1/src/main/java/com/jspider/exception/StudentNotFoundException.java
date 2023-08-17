package com.jspider.exception;

public class StudentNotFoundException extends RuntimeException {
	private String messege;

	public StudentNotFoundException(String messege) {
		this.messege = messege;
	}

	public String getMessege() {
		return messege;
	}
	

}
