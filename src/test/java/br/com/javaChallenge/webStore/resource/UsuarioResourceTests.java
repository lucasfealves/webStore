package br.com.javaChallenge.webStore.resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.javaChallenge.webStore.model.Usuario;
import br.com.javaChallenge.webStore.service.UsuarioService;

@SpringBootTest
@AutoConfigureMockMvc
class UsuarioResourceTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UsuarioService usuarioService; 
	
	@Test
	void listar() throws Exception {

		mockMvc.perform(get("/usuario")
	            .contentType("application/json"))
	            .andExpect(status().isOk());
		
		List<Usuario> listaClientesFones = usuarioService.listar();
		
		assertThat(listaClientesFones.size()).isGreaterThan(0);
	}
	
	@Test
	void editar() throws Exception {

		mockMvc.perform(get("/usuario/1")
	            .contentType("application/json")
	            .param("usuarioId", "1"))
	            .andExpect(status().isOk());
		
		Usuario usuario = usuarioService.editar(1l);
		
		assertThat(usuario.getId()).isGreaterThan(0);
	}

}
