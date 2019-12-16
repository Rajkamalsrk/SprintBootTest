package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProviderExceptionController {

	@ExceptionHandler(value = ProviderNotfoundException.class)
	   public ResponseEntity<Object> exception(ProviderNotfoundException exception) {
	      return new ResponseEntity<>("Provider not found in FAD System!!", HttpStatus.NOT_FOUND);
	   }
	
	@ExceptionHandler(value = ProviderDuplicateException.class)
	   public ResponseEntity<Object> exception1(ProviderDuplicateException exception) {
	      return new ResponseEntity<>("Provider is Duplicate !!", HttpStatus.NOT_FOUND);
	   }
}
