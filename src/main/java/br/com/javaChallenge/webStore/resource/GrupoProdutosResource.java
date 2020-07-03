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
import br.com.javaChallenge.webStore.repository.GrupoProdutosRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class GrupoProdutosResource implements IResource<GrupoProduto>{
	
	@Autowired
	private GrupoProdutosRepository grupoProdutosRepository;
	
	private WebServiceResponse vWebServiceResponse;
	
	@GetMapping("/grupoProdutos")
	@Override
	public WebServiceResponse Listar() {
		try {
			List<GrupoProduto> vLista = grupoProdutosRepository.findAll();
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
			GrupoProduto vObjeto = grupoProdutosRepository.findById(grupoId).get();
			vWebServiceResponse = new WebServiceResponse(vObjeto);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}

	@PostMapping("/grupoProdutos")
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
