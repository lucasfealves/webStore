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

import br.com.javaChallenge.webStore.core.IResource;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Produto;
import br.com.javaChallenge.webStore.service.ProdutosService;

@RestController
@CrossOrigin("${origem-permitida}")
public class ProdutosResource implements IResource<Produto> {
	
	@Autowired
	private ProdutosService produtosService;

	@Override
	@GetMapping("/produtos")
	public List<Produto> listar() {
		return produtosService.listar(); 
	}
	
	@Override
	@GetMapping("/produtos/{produtoId}")
	public Produto editar(@PathVariable Long produtoId) {
		return produtosService.editar(produtoId);
	}
	
	@Override
	@PostMapping("/produtos")
	public WebServiceResponse adicionar(@RequestBody @Valid Produto T) {
		return produtosService.adicionar(T);
	}
}
