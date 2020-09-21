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

import br.com.javaChallenge.webStore.model.ClienteFone;
import br.com.javaChallenge.webStore.service.ClienteFoneService;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteFoneResourceTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ClienteFoneService clienteFoneService; 
	
	@Test
	void listar() throws Exception {

		mockMvc.perform(get("/clienteFone/foneClientes")
	            .contentType("application/json"))
	            .andExpect(status().isOk());
		
		List<ClienteFone> listaClientesFones = clienteFoneService.listar();
		
		assertThat(listaClientesFones.size()).isGreaterThan(0);
	}
	
	@Test
	void editar() throws Exception {

		mockMvc.perform(get("/clienteFone/1")
	            .contentType("application/json")
	            .param("foneId", "1"))
	            .andExpect(status().isOk());
		
		ClienteFone clientesFone = clienteFoneService.editar(1l);
		
		assertThat(clientesFone.getId()).isGreaterThan(0);
	}

}
