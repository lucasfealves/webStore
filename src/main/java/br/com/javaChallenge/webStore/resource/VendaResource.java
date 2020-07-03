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

import br.com.javaChallenge.webStore.business.VendaBusiness;
import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Venda;
import br.com.javaChallenge.webStore.repository.VendaRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class VendaResource {
	
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private VendaBusiness vendaBusiness;

	private WebServiceResponse vWebServiceResponse;
	
	@GetMapping("/venda")
	public List<Venda> listar() {
		return vendaRepository.findAll();
	}

	@GetMapping("/venda/{venda}")
	public Venda listar(@PathVariable Long venda) {
		return vendaRepository.findById(venda).get();
	}
	
	@PostMapping("/venda")
	public WebServiceResponse adicionar(@RequestBody @Valid Venda T) {
		try {
			try {
				vendaBusiness.validaVenda(T);
			} catch (BusinessException e) {
				vWebServiceResponse = new WebServiceResponse(true, false, e.getMessage());
			}
			@Valid
			Venda venda = vendaRepository.save(T);
			vWebServiceResponse = new WebServiceResponse(venda);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(true, false, e.getMessage());
		}

		return vWebServiceResponse ;
	}
}
