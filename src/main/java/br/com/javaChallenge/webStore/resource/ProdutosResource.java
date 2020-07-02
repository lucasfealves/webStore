package br.com.javaChallenge.webStore.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Produtos;
import br.com.javaChallenge.webStore.repository.ProdutosRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class ProdutosResource {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	/*
	 * @Autowired private EstoqueMovimentoRepository estoqueMovimentoRepository;
	 */	
	private WebServiceResponse vWebServiceResponse;

	
	@GetMapping("/produtos")
	public WebServiceResponse listar() {
		try {
			List<Produtos> vLista = produtosRepository.findAll();
			vWebServiceResponse = new WebServiceResponse(vLista);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse; 
	}
	
	@GetMapping("/produtos/{produtoId]")
	public WebServiceResponse editar(@PathVariable Long produtoId) {
		try {
			Produtos vObj = produtosRepository.findById(produtoId).get();
			vWebServiceResponse = new WebServiceResponse(vObj);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
	
	@PostMapping("/produtos")
	public WebServiceResponse adicionar(@RequestBody @Valid Produtos T) {
		try {
			Produtos vObj = produtosRepository.save(T);
			vWebServiceResponse = new WebServiceResponse(vObj);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
}
