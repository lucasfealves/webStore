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
import br.com.javaChallenge.webStore.model.GrupoProduto;
import br.com.javaChallenge.webStore.service.GrupoProdutosService;

@RestController
@CrossOrigin("${origem-permitida}")
public class GrupoProdutosResource implements IResource<GrupoProduto> {
	
	@Autowired
	private GrupoProdutosService grupoProdutosService;
	
	@Override
	@GetMapping("/grupoProdutos")
	public List<GrupoProduto> listar() {
		return grupoProdutosService.listar(); 
	}
	
	@Override
	@GetMapping("/grupoProdutos/{grupoId}")
	public GrupoProduto editar(@PathVariable Long grupoId) {
		return grupoProdutosService.editar(grupoId);
	}

	@Override
	@PostMapping("/grupoProdutos")
	public WebServiceResponse adicionar(@RequestBody @Valid GrupoProduto T) {
		return grupoProdutosService.adicionar(T);
	}
}
