package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Mercancia;
import com.example.demo.modelo.MercanciaUsuario;

public interface MercanciaUsuarioRepository  extends CrudRepository<MercanciaUsuario,Integer>{

}
