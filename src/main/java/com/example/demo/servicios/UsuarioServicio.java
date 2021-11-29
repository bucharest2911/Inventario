package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repositorios.UsuarioRepository;

@Service
public class UsuarioServicio {
    @Autowired
	private UsuarioRepository usuariorepositorio;
	
    
    
    public List<Usuario> findUsuario() {
    	return (List<Usuario>) this.usuariorepositorio.findAll();
    }
	
}
