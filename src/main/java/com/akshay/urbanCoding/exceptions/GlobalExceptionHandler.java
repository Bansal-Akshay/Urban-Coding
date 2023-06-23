package com.akshay.urbanCoding.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.akshay.urbanCoding.payloads.ApiResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String,String>> constraintViolationExceptionHandler(ConstraintViolationException ex){
		Map<String,String> resp=new HashMap<>();
		ex.getConstraintViolations().forEach((violation)->{
			String fieldName = "";
	        if (violation.getPropertyPath() != null) {
	            fieldName = violation.getPropertyPath().toString();
	        }
	        String msg = violation.getMessage();
	        resp.put(fieldName, msg);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
}
