package com.example.demo.Controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.MercanciaDto;
import com.example.demo.modelo.Mercancia;
import com.example.demo.repositorios.MercanciaRepository;
import com.example.demo.servicios.MercanciaServicio;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/mercancia")
public class MercanciaController {

	@Autowired
	private MercanciaServicio mercanciaServicio;

	@PostMapping("/guardarmercancia")
	public ResponseEntity<?> save(@RequestBody MercanciaDto mercanciadto) {

		return this.mercanciaServicio.save(mercanciadto) != null ? new ResponseEntity<String>("exito", HttpStatus.OK)
				: new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/listarmercanciaporusuario")
	@ResponseBody
	public List<Mercancia> getUsers(@RequestParam(required = false) Integer idUsuario) {
		List<Mercancia> mercancias = this.mercanciaServicio.listar(idUsuario);

		if (mercancias != null) {
			return mercancias;
		}

		return new ArrayList<Mercancia>();

	}

	@PutMapping("/actualizarmercancia")
	public ResponseEntity<?> actualizar(@RequestBody MercanciaDto mercanciadto) {

		return this.mercanciaServicio.save(mercanciadto) != null
				? new ResponseEntity<String>(" Actualiexito", HttpStatus.OK)
				: new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/obtenermercancia")
	public ResponseEntity<?> getMercancia(@RequestParam(required = false) Integer idmercancia) {
		Mercancia mercancia = this.mercanciaServicio.getMercanciaById(idmercancia);
		return mercancia != null ? new ResponseEntity<>(mercancia, HttpStatus.OK)
				: new ResponseEntity<>(mercancia, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/eliminarmercancia")
	public ResponseEntity<?> deleteMercancia(@RequestParam(required = false) Integer idmercancia,
			@RequestParam(required = false) Integer idUsuario) {
		Mercancia mercancia = this.mercanciaServicio.eliminarMercancia(idmercancia, idUsuario);
		return mercancia != null ? new ResponseEntity<>(mercancia, HttpStatus.OK)
				: new ResponseEntity<>("no existe esta mercancia", HttpStatus.BAD_REQUEST);
	}

}
