package com.example.customer.exception;

public class CustomerErrorResponse {
	
	private int statusCode;
	private String errorMsg;
	private long timeStamp;
	
	public CustomerErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public CustomerErrorResponse(int statusCode, String errorMsg, int timeStamp) {
		super();
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
		this.timeStamp = timeStamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
