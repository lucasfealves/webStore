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
import br.com.javaChallenge.webStore.model.GrupoProdutos;
import br.com.javaChallenge.webStore.repository.GrupoProdutosRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class GrupoProdutosResource implements IResource<GrupoProdutos>{
	
	@Autowired
	private GrupoProdutosRepository grupoProdutosRepository;
	
	private WebServiceResponse vWebServiceResponse;
	
	@GetMapping("/grupoProdutos")
	@Override
	public WebServiceResponse Listar() {
		try {
			List<GrupoProdutos> vLista = grupoProdutosRepository.findAll();
			vWebServiceResponse = new WebServiceResponse(vLista);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse; 
	}
	
	@GetMapping("/grupoProdutos/{grupoId}")
	@Override
	public WebServiceResponse editar(@PathVariable Long grupoId) {
		try {
			GrupoProdutos vObjeto = grupoProdutosRepository.findById(grupoId).get();
			vWebServiceResponse = new WebServiceResponse(vObjeto);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}

	@PostMapping("/grupoProdutos")
	@Override
	public WebServiceResponse adicionar(@RequestBody @Valid GrupoProdutos T) {
		try {
			GrupoProdutos vObjeto = grupoProdutosRepository.save(T);
			vWebServiceResponse = new WebServiceResponse(vObjeto);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
}
