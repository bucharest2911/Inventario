package com.example.demo.modelo;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="mercancia")
public class Mercancia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre_mercancia")
	private String nombreMercancia;
	
	@Column(name="fecha_ingreso")
	private  OffsetDateTime fechaIngreso;
	
	 
	
	@ManyToOne
	@JoinColumn(name="usuario_creado")
	private Usuario usuarioCreado;
 
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="fecha_creacion")
	@CreationTimestamp
	private OffsetDateTime fechaCreacion;

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

	public OffsetDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(OffsetDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	 

 

	public Usuario getUsuarioCreado() {
		return usuarioCreado;
	}

	public void setUsuarioCreado(Usuario usuarioCreado) {
		this.usuarioCreado = usuarioCreado;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public OffsetDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(OffsetDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
	
}
