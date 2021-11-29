package com.example.demo.modelo;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="usuarios")

public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nombre_usuario")
	private String nombre;
	@Column(name="edad")
	private Integer edad;
	@Column(name="fecha_ingreso")
	private  OffsetDateTime fechaIngreso;
	@ManyToOne
	@JoinColumn(name="cargo_id")
	private Cargo cargo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public OffsetDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(OffsetDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	 
	
}
