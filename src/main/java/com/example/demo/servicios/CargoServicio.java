package com.example.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CargoDto;
import com.example.demo.modelo.Cargo;
import com.example.demo.repositorios.cargoRepository;
@Service
public class CargoServicio {

	@Autowired
	private cargoRepository cargorepository;
	
	
	
	public Cargo save(CargoDto cargodto) {
		
		Cargo cargo=new Cargo();
		
		 
		cargo.setNombreCargo(cargodto.getNombre());
		this.cargorepository.save(cargo);
		return cargo;
	}
	
	
	
}
