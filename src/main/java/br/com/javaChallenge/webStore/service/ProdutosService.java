package br.com.javaChallenge.webStore.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.javaChallenge.webStore.business.ProdutoBusiness;
import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.IService;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Produto;
import br.com.javaChallenge.webStore.repository.ProdutosRepository;

@Service
public class ProdutosService implements IService<Produto> {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private ProdutoBusiness produtoBusiness;

	private WebServiceResponse vWebServiceResponse;

	public List<Produto> listar() {
		return produtosRepository.findAll();
	}
	
	@Override
	public Produto editar(@PathVariable Long produtoId) {
		return produtosRepository.findById(produtoId).get();
	}
	
	@Override
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
