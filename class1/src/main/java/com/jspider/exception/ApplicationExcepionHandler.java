package com.jspider.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jspider.util.ErrorStructure;

@RestControllerAdvice
public class ApplicationExcepionHandler {
	
	
    @ExceptionHandler
	public ResponseEntity<ErrorStructure> studentNotfoundByid(StudentNotFoundException ex) {
	    ErrorStructure structure=new  ErrorStructure();
	    structure.setStatus(HttpStatus.NOT_FOUND.value());
	    structure.setMessage(ex.getMessege());
	    structure.setRootCause("Student not prasent given the id!!");
  
    	return new ResponseEntity<ErrorStructure>(structure, HttpStatus.NOT_FOUND);
	}
}
