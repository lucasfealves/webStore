package br.com.javaChallenge.webStore.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaChallenge.webStore.core.model.WebServiceResponse;

@RestController
public class ErrorResource {
	
	private WebServiceResponse vWebServiceResponse;
	
	@GetMapping("/error")
	public WebServiceResponse listar(@PathVariable Long clienteId) {
		vWebServiceResponse = new WebServiceResponse(false, true, "Erro");
		return vWebServiceResponse;
	}

}
