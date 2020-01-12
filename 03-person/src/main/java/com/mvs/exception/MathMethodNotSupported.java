package com.mvs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MathMethodNotSupported extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MathMethodNotSupported(String exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}

}
