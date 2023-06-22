package com.mse.handler;


import com.mse.error.ErrorPage;
import com.mse.exception.NoEmployeeFoundException;
import com.mse.exception.NoInstituteFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(NoInstituteFoundException.class)
	public ResponseEntity<ErrorPage> showCustomMsg1(NoInstituteFoundException obj) {
		return new ResponseEntity<ErrorPage>(
				new ErrorPage(LocalDateTime.now(), obj.getMessage(),500),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
		Map<String,String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
		{errors.put(error.getField(), error.getDefaultMessage());} );
		return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity<ErrorPage> showCustomMsg2(NoEmployeeFoundException obj) {
		return new ResponseEntity<ErrorPage>(
				new ErrorPage(LocalDateTime.now(), obj.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value()),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorPage> showCustomMsg1(SQLIntegrityConstraintViolationException obj) {
		return new ResponseEntity<ErrorPage>(
				new ErrorPage(LocalDateTime.now(),  obj.getMessage(), 500),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	

	
	
	
}
