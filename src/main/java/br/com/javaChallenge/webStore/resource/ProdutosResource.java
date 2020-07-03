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

import br.com.javaChallenge.webStore.business.ProdutoBusiness;
import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Produto;
import br.com.javaChallenge.webStore.repository.ProdutosRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class ProdutosResource {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private ProdutoBusiness produtoBusiness;

	private WebServiceResponse vWebServiceResponse;

	
	@GetMapping("/produtos")
	public WebServiceResponse listar() {
		try {
			List<Produto> vLista = produtosRepository.findAll();
			vWebServiceResponse = new WebServiceResponse(vLista);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse; 
	}
	
	@GetMapping("/produtos/{produtoId}")
	public WebServiceResponse editar(@PathVariable Long produtoId) {
		try {
			Produto vObj = produtosRepository.findById(produtoId).get();
			vWebServiceResponse = new WebServiceResponse(vObj);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
	
	@PostMapping("/produtos")
	public WebServiceResponse adicionar(@RequestBody @Valid Produto T) {
		try {
			try {
				produtoBusiness.validaProduto(T);
			} catch (BusinessException e) {
				vWebServiceResponse = new WebServiceResponse(true, false, e.getMessage());
			}
			Produto vObj = produtosRepository.save(T);
			vWebServiceResponse = new WebServiceResponse(vObj);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
}
