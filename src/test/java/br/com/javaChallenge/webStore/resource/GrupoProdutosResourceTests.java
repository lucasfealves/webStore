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

import br.com.javaChallenge.webStore.model.GrupoProduto;
import br.com.javaChallenge.webStore.service.GrupoProdutosService;

@SpringBootTest
@AutoConfigureMockMvc
class GrupoProdutosResourceTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private GrupoProdutosService grupoProdutosService; 
	
	@Test
	void listar() throws Exception {

		mockMvc.perform(get("/grupoProdutos")
	            .contentType("application/json"))
	            .andExpect(status().isOk());
		
		List<GrupoProduto> listaClientesFones = grupoProdutosService.listar();
		
		assertThat(listaClientesFones.size()).isGreaterThan(0);
	}
	
	@Test
	void editar() throws Exception {

		mockMvc.perform(get("/grupoProdutos/1")
	            .contentType("application/json")
	            .param("grupoId", "1"))
	            .andExpect(status().isOk());
		
		GrupoProduto grupoProduto = grupoProdutosService.editar(1l);
		
		assertThat(grupoProduto.getId()).isGreaterThan(0);
	}
}
