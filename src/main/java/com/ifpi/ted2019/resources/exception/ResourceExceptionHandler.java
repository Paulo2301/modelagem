package com.ifpi.ted2019.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ifpi.ted2019.services.exceptions.ObjectNotFoundExcepition;

@ControllerAdvice //Manipulador de excessões
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundExcepition.class)
	public ResponseEntity<StandardError>objecteNotFound(ObjectNotFoundExcepition e, 
			HttpServletRequest request){
		StandardError err= new StandardError(HttpStatus.NOT_FOUND.value(),
				e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
