package com.example.demo.modelo;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
public class MercanciaUsuario {

	@EmbeddedId
	private MercanciaUsuarioKey id;
	@ManyToOne
	@MapsId("usuarioId")
	@JoinColumn(name = "usuario_modifica")
	private Usuario usuarioModifica;

	@ManyToOne
	@MapsId("mercanciaId")
	@JoinColumn(name = "mercancia_id")
	private Mercancia mercanciaModifica;

	@Column(name = "fecha_de_modificacion")
	private OffsetDateTime fechaModificada;

	public MercanciaUsuarioKey getId() {
		return id;
	}

	public void setId(MercanciaUsuarioKey id) {
		this.id = id;
	}

	public Usuario getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(Usuario usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

	public Mercancia getMercanciaModifica() {
		return mercanciaModifica;
	}

	public void setMercanciaModifica(Mercancia mercanciaModifica) {
		this.mercanciaModifica = mercanciaModifica;
	}

	public OffsetDateTime getFechaModificada() {
		return fechaModificada;
	}

	public void setFechaModificada(OffsetDateTime fechaModificada) {
		this.fechaModificada = fechaModificada;
	}

}
