package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CargoDto;
import com.example.demo.modelo.Cargo;
import com.example.demo.servicios.CargoServicio;

@RestController
@CrossOrigin(origins="http://localhost:4200") 
@RequestMapping("/api/cargo")
public class CargoController {
	
	@Autowired
	private CargoServicio cargoservicio;
	
 
	
	@PostMapping("/guardarcargo")
	 
	public ResponseEntity<?> guardarCargo(@RequestBody CargoDto cargodto) {
		
		
	return new ResponseEntity<>(this.cargoservicio.save(cargodto),HttpStatus.OK);	
		
	}
	
	 

}
