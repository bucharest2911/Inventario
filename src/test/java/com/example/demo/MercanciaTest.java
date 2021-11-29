package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.modelo.Mercancia;
import com.example.demo.repositorios.MercanciaRepository;
import com.example.demo.servicios.MercanciaServicio;
import com.example.demo.servicios.UsuarioServicio;
 
@SpringBootTest
@RunWith(SpringRunner.class)
 
public class MercanciaTest {
@InjectMocks	
private Mercancia mercancia;	
@Autowired
private MercanciaServicio mercanciaServicio;	
@Mock
private MercanciaRepository mercanciarepository;
 
 
 
	

@Test
public void test() {
	Mockito.when(this.mercanciarepository.findById(2)).then(null);
}
	
}
