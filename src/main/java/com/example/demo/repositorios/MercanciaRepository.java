package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Cargo;
import com.example.demo.modelo.Mercancia;

public interface MercanciaRepository extends CrudRepository<Mercancia,Integer> {

	
	
}
