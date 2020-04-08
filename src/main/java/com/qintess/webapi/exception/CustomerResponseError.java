package com.qintess.webapi.exception;

import java.sql.Timestamp;

public class CustomerResponseError {

	private int status;
	private String message;
	private Timestamp timestamp;

	public CustomerResponseError() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
