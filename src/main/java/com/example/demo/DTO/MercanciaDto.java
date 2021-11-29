package com.example.demo.DTO;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class MercanciaDto implements Serializable{
	private Integer id=-1;
	private String nombreMercancia;
	private Integer cantidadTotal;
	private OffsetDateTime fechaIngreso;
	private Integer idUsuario;

	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public OffsetDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(OffsetDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreMercancia() {
		return nombreMercancia;
	}

	public void setNombreMercancia(String nombreMercancia) {
		this.nombreMercancia = nombreMercancia;
	}

	public Integer getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(Integer cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

}
