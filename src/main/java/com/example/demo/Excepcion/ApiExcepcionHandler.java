package com.example.demo.Excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ApiExcepcionHandler {
  @ExceptionHandler({ApiRequestExcepcion.class})
	public ResponseEntity<Object> handleRequestException(ApiExcepcion excepcion){
		ApiExcepcion apiexcepcion=new ApiExcepcion(excepcion.getMensaje(),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(apiexcepcion,HttpStatus.BAD_REQUEST);
	}
	
}
