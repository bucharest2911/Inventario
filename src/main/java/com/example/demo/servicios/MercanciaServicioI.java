package com.example.demo.servicios;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.MercanciaDto;
import com.example.demo.Excepcion.ApiRequestExcepcion;
import com.example.demo.modelo.Mercancia;
import com.example.demo.modelo.MercanciaUsuario;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorios.MercanciaRepository;
import com.example.demo.repositorios.MercanciaUsuarioRepository;
import com.example.demo.repositorios.UsuarioRepository;

@Service
public class MercanciaServicioI {
	@Autowired
	private MercanciaRepository mercanciaRepositorio;
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	@Autowired
	private MercanciaUsuarioRepository mercanciausuarioRepositorio;

	public Mercancia save(MercanciaDto mercanciadto) {

		Mercancia mercanciaencontrada = this.getMercanciaById(mercanciadto.getId());
		MercanciaUsuario mercanciaUsuario = null;

		if (mercanciaencontrada != null) {

			mercanciaUsuario = new MercanciaUsuario();

			this.llenar(mercanciaencontrada, mercanciaUsuario, mercanciadto);
			mercanciaencontrada = this.mercanciaRepositorio.save(mercanciaencontrada);

		} else {
			mercanciaencontrada = new Mercancia();
			this.llenar(mercanciaencontrada, mercanciaUsuario, mercanciadto);
		}
		return this.mercanciaRepositorio.save(mercanciaencontrada);

	}

	public void llenar(Mercancia mercancia, MercanciaUsuario mercanciaUsuario, MercanciaDto mercanciadto) {

		Usuario usuario;
		Optional<Usuario> usuariobtenido = this.usuarioRepositorio.findById(mercanciadto.getIdUsuario());

		if (usuariobtenido != null) {

			if (mercanciaUsuario == null) {
				Mercancia mercanciacomparar = this.getMercanciaByName(mercanciadto.getNombreMercancia());
				if (mercanciacomparar != null) {
					throw new ApiRequestExcepcion("ya existe esta mercancia con ese nombre");
				}
				if (mercanciadto.getFechaIngreso().isAfter(OffsetDateTime.now())) {
					throw new ApiRequestExcepcion("la fecha de ingreso debe ser men");
				}
				usuario = usuariobtenido.get();
				mercancia.setUsuarioCreado(usuario);
				mercancia.setCantidad(mercanciadto.getCantidadTotal());
				mercancia.setNombreMercancia(mercanciadto.getNombreMercancia());

				mercancia.setFechaIngreso(mercanciadto.getFechaIngreso());

			} else {

				Mercancia mercanciacomparar = this.getMercanciaByName(mercanciadto.getNombreMercancia());
				if (mercanciacomparar != null) {
					throw new ApiRequestExcepcion("ya existe esta mercancia con ese nombre");
				}

				usuario = usuariobtenido.get();
				mercancia.setUsuarioCreado(usuario);
				mercancia.setCantidad(mercanciadto.getCantidadTotal());
				mercancia.setNombreMercancia(mercanciadto.getNombreMercancia());
				mercancia.setFechaIngreso(mercanciadto.getFechaIngreso());
			}

		}

	}

	public Mercancia getMercanciaById(Integer id) {
		Mercancia mercanciaencontrada = null;
		List<Mercancia> mercancias = (List<Mercancia>) this.mercanciaRepositorio.findAll();
		for (Mercancia mercancia : mercancias) {
			if (mercancia.getId() == id && mercancia.getId() != null) {
				mercanciaencontrada = mercancia;
			}
		}
		return mercanciaencontrada;

	}

	public Mercancia getMercanciaByName(String nombre) {
		List<Mercancia> mercancias = (List<Mercancia>) this.mercanciaRepositorio.findAll();
		Mercancia mercanciaencontrada = null;
		for (Mercancia mercancia : mercancias) {

			if (mercancia.getNombreMercancia() != null) {
				if (mercancia.getNombreMercancia().equalsIgnoreCase(nombre)) {
					mercanciaencontrada = mercancia;
				}
			}

		}
		return mercanciaencontrada;
	}

	public List<Mercancia> listar(Integer id) {
		List<Mercancia> mercancias = (List<Mercancia>) this.mercanciaRepositorio.findAll();
		List<Mercancia> findByMercanciaWithUsuario = new ArrayList<Mercancia>();
		for (Mercancia mercancia : mercancias) {
			if (mercancia.getId() == id) {
				findByMercanciaWithUsuario.add(mercancia);
			}
		}
		return findByMercanciaWithUsuario;
	}

}
