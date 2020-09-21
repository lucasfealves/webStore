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

import br.com.javaChallenge.webStore.model.Venda;
import br.com.javaChallenge.webStore.service.VendaService;

@SpringBootTest
@AutoConfigureMockMvc
class VendaResourceTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private VendaService vendaService; 
	
	@Test
	void listar() throws Exception {

		mockMvc.perform(get("/venda")
	            .contentType("application/json"))
	            .andExpect(status().isOk());
		
		List<Venda> listaVenda = vendaService.listar();
		
		assertThat(listaVenda.size()).isGreaterThan(0);
	}
	
	@Test
	void editar() throws Exception {

		mockMvc.perform(get("/venda/1")
	            .contentType("application/json")
	            .param("venda", "1"))
	            .andExpect(status().isOk());
		
		Venda venda = vendaService.editar(1l);
		
		assertThat(venda.getId()).isGreaterThan(0);
	}
}
