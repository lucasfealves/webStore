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

import br.com.javaChallenge.webStore.model.Cliente;
import br.com.javaChallenge.webStore.service.ClienteService;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteResourceTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ClienteService clienteService; 
	
	@Test
	void listar() throws Exception {

		mockMvc.perform(get("/cliente")
	            .contentType("application/json"))
	            .andExpect(status().isOk());
		
		List<Cliente> listaClientesFones = clienteService.listar();
		
		assertThat(listaClientesFones.size()).isGreaterThan(0);
	}
	
	@Test
	void editar() throws Exception {

		mockMvc.perform(get("/cliente/1")
	            .contentType("application/json")
	            .param("clienteId", "1"))
	            .andExpect(status().isOk());
		
		Cliente clientes = clienteService.editar(1l);
		
		assertThat(clientes.getId()).isGreaterThan(0);
	}


}
