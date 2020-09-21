package br.com.javaChallenge.webStore.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.javaChallenge.webStore.core.IService;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.GrupoProduto;
import br.com.javaChallenge.webStore.repository.GrupoProdutosRepository;

@Service
public class GrupoProdutosService implements IService<GrupoProduto> {
	
	@Autowired
	private GrupoProdutosRepository grupoProdutosRepository;
	
	private WebServiceResponse vWebServiceResponse;
	
	@Override
	public List<GrupoProduto> listar() {
		return grupoProdutosRepository.findAll();
	}
	
	@Override
	public GrupoProduto editar(@PathVariable Long grupoId) {
		return grupoProdutosRepository.findById(grupoId).get();
	}

	@Override
	public WebServiceResponse adicionar(@RequestBody @Valid GrupoProduto T) {
		try {
			GrupoProduto vObjeto = grupoProdutosRepository.save(T);
			vWebServiceResponse = new WebServiceResponse(vObjeto);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
}
