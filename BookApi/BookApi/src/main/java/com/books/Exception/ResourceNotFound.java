package com.books.Exception;

import org.springframework.http.HttpStatus;
public class ResourceNotFound extends RuntimeException{
	private final static long serialversionuid=1L;

	public ResourceNotFound(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
}