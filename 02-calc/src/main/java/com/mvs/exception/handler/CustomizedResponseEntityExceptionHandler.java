package com.mvs.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mvs.exception.MathMethodNotSupported;
import com.mvs.exception.ResponseException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseException> handleAllException(Exception ex, WebRequest request) {
		ResponseException re = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(re, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MathMethodNotSupported.class)
	public final ResponseEntity<ResponseException> handleBadRequestException(Exception ex, WebRequest request) {
		ResponseException re = new ResponseException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(re, HttpStatus.BAD_REQUEST);
	}

}
