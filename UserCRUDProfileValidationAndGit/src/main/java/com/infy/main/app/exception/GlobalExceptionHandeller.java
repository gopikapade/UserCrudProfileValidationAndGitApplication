package com.infy.main.app.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeller {

	@ExceptionHandler(UserNameNotValidException.class)
	public ApiError UsernameNameNotValidExceptio(UserNameNotValidException username, HttpServletRequest request) {
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), username.getMessage(), new Date(),
				HttpStatus.NOT_FOUND, request.getRequestURI());

		return error;

	}

	@ExceptionHandler(PassWordNotValidException.class)
	public ApiError PasswordIsnotValid(PassWordNotValidException exception, HttpServletRequest request) {

		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date(),
				HttpStatus.NOT_FOUND, request.getRequestURI());

		return error;

	}

	@ExceptionHandler(FirstnameNotValidException.class)
	public ApiError firstNameISNotValid(FirstnameNotValidException exception, HttpServletRequest request) {
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date(),
				HttpStatus.NOT_FOUND, request.getRequestURI());
		return error;

	}
	
	@ExceptionHandler(LastnameNotValidException.class)
	public ApiError LastnameISNotValid(LastnameNotValidException exception,HttpServletRequest request)
	{
		ApiError error=new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date(), HttpStatus.NOT_FOUND, request.getRequestURI());
		return error;
		
	}
	
	@ExceptionHandler(EmailIdNotValidException.class)
	public ApiError EmailNotValid(EmailIdNotValidException exception,HttpServletRequest response) {
		
		ApiError error=new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date(), HttpStatus.NOT_FOUND, response.getRequestURI());
		
		return error;
		
		
	}
	
	@ExceptionHandler(ContatctNotValidException.class)
	public ApiError ContactNotvalid(ContatctNotValidException exception,HttpServletRequest request) {
		
		
		return new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date(), HttpStatus.NOT_FOUND, request.getRequestURI());
		
		
	}
	
	@ExceptionHandler(DataNotFoundInDataBase.class)
	public ApiError Datanotfoundindatabase(DataNotFoundInDataBase exception,HttpServletRequest request)
	{
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date(), HttpStatus.NOT_FOUND, request.getRequestURI());
		
		return apiError;
	}
	

}
