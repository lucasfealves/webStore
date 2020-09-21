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

import br.com.javaChallenge.webStore.model.VendasItens;
import br.com.javaChallenge.webStore.service.VendaItensService;

@SpringBootTest
@AutoConfigureMockMvc
class VendaItensResourceTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private VendaItensService vendaItensService; 
	
	@Test
	void listar() throws Exception {

		mockMvc.perform(get("/vendaItens/1")
	            .contentType("application/json")
	            .param("venda", "1"))
	            .andExpect(status().isOk());
		
		List<VendasItens> listaClientesFones = vendaItensService.listar();
		
		assertThat(listaClientesFones.size()).isGreaterThan(0);
	}
	
	@Test
	void editar() throws Exception {

		mockMvc.perform(get("/vendaItens/1")
	            .contentType("application/json")
	            .param("itemVenda", "1"))
	            .andExpect(status().isOk());
		
		VendasItens vendaItens = vendaItensService.editar(1l);
		
		assertThat(vendaItens.getId()).isGreaterThan(0);
	}

}
