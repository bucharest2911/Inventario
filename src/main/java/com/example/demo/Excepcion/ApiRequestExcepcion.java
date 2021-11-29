package com.example.demo.Excepcion;

public class ApiRequestExcepcion extends RuntimeException {

	public ApiRequestExcepcion(String mensaje) {
		super(mensaje);
	}
	
}
