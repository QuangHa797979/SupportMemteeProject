package com.vti.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;

public class ApiErrorRespone {
	private HttpStatus status;
	private String message;
	private String detailMessage;
	
	public ApiErrorRespone(HttpStatus status, String message, String detailMessage) {
		this.status = status;
		this.message = message;
		this.detailMessage = detailMessage;
	}
	
	public ApiErrorRespone(HttpStatus badRequest, ConstraintViolationException exception) {
	}

	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetailMessage() {
		return detailMessage;
	}
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
	
	
	
	
}
