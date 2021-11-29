package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Mercancia;
import com.example.demo.modelo.Usuario;

public interface UsuarioRepository    extends CrudRepository<Usuario,Integer> {

}
