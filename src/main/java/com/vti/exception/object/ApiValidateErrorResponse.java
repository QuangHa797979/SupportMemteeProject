package com.vti.exception.object;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.vti.exception.ApiErrorRespone;

public class ApiValidateErrorResponse extends ApiErrorRespone {

	private List<ValidateError> errors;

	public ApiValidateErrorResponse(HttpStatus status, String message, List<ValidateError> errors) {
		super(status, message, "");
		this.errors = errors;
	}

	public List<ValidateError> getErrors() {
		return errors;
	}
	
}
