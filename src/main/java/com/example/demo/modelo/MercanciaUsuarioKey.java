package com.example.demo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MercanciaUsuarioKey implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Column(name = "usuario_id")
	private Integer usuarioId;
	@Column(name = "mercancia_id")
	private Integer mercanciaId;

}
