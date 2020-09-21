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

import br.com.javaChallenge.webStore.model.Produto;
import br.com.javaChallenge.webStore.service.ProdutosService;

@SpringBootTest
@AutoConfigureMockMvc
class ProdutosResourceTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProdutosService produtosService; 
	
	@Test
	void listar() throws Exception {

		mockMvc.perform(get("/produtos")
	            .contentType("application/json"))
	            .andExpect(status().isOk());
		
		List<Produto> listaClientesFones = produtosService.listar();
		
		assertThat(listaClientesFones.size()).isGreaterThan(0);
	}
	
	@Test
	void editar() throws Exception {

		mockMvc.perform(get("/produtos/1")
	            .contentType("application/json")
	            .param("produtoId", "1"))
	            .andExpect(status().isOk());
		
		Produto grupoProduto = produtosService.editar(1l);
		
		assertThat(grupoProduto.getId()).isGreaterThan(0);
	}
}
