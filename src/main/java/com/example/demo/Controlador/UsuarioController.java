package com.example.demo.Controlador;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositorios.UsuarioRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepositorio;

	@GetMapping("/obtenerusuarios")
	public ResponseEntity<?> getUsuarios() {
		return new ResponseEntity<>(this.usuarioRepositorio.findAll(), HttpStatus.OK);
	}

}
