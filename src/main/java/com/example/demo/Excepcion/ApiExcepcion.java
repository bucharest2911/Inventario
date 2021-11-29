package com.example.demo.Excepcion;

import org.springframework.http.HttpStatus;

public class ApiExcepcion {
private String mensaje;
private HttpStatus httpstatus;

public ApiExcepcion(String mensaje,HttpStatus http) {
	this.mensaje=mensaje;
	this.httpstatus=http;
}

public String getMensaje() {
	return mensaje;
}

public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}
 




}
