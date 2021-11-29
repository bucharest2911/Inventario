package com.example.demo;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.Controlador.UsuarioController;
import com.example.demo.modelo.Mercancia;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorios.MercanciaRepository;
import com.example.demo.repositorios.UsuarioRepository;
import com.example.demo.servicios.MercanciaServicio;
import com.example.demo.servicios.UsuarioServicio;
 
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioTest {
    @InjectMocks
	private Usuario usuario;
   @Autowired
	 private MockMvc mock;
	 @Autowired
	private UsuarioServicio usuarioServicio;
	 @Autowired
	 private UsuarioController usuarioControlador;
	 
	@Test
	public void Test() throws Exception {
		 
		this.mock.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/mercancia/eliminarMercancia?idmercancia=4&idUsuario=1"))
		.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("no existe esta mercancia"));
	}
}
