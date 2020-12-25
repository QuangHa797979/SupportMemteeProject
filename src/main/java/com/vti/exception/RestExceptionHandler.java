package com.vti.exception;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vti.config.MessageProperty;
import com.vti.exception.object.ApiValidateErrorResponse;
import com.vti.exception.object.ValidateError;

//Khai báo 1 thằng exception Global

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> handleAll(Exception exception) {
		ApiErrorRespone error = new ApiErrorRespone(HttpStatus.INTERNAL_SERVER_ERROR,
				"Đã có lỗi từ server. Liên hệ Duyn03@gmai.com", exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	// Not found entity (getById not found)
	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<?> handlExceptionNotFound(EntityNotFoundException exception) {
		ApiErrorRespone error = new ApiErrorRespone(HttpStatus.NOT_FOUND, "Không tìm thấy dữ liệu bạn yêu cầu",
				exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException exception, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		ApiErrorRespone error = new ApiErrorRespone(HttpStatus.BAD_REQUEST, "Không mapping parameter!",
				exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorRespone error = new ApiErrorRespone(HttpStatus.BAD_REQUEST, "Không mapping parameter!",
				exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	// bean validation error
	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
		ApiErrorRespone error = new ApiErrorRespone(HttpStatus.BAD_REQUEST, "Không mapping parameter!",
				exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ValidateError> errors = new ArrayList<>();
		for (ObjectError error : exception.getBindingResult().getAllErrors()) {
			String fieldName = "";
			for (Object obj : error.getArguments()) {
				if (obj instanceof DefaultMessageSourceResolvable) {
					DefaultMessageSourceResolvable argument = (DefaultMessageSourceResolvable) obj;
					fieldName += argument.getDefaultMessage();
				}
			}
			errors.add(new ValidateError(fieldName, error.getDefaultMessage()));
		}

		ApiValidateErrorResponse error = new ApiValidateErrorResponse(HttpStatus.BAD_REQUEST, "Lỗi tham số", errors);
		return new ResponseEntity<>(error, error.getStatus());
	}
}
