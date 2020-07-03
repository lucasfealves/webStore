package br.com.javaChallenge.webStore.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.ClienteFone;
import br.com.javaChallenge.webStore.repository.ClienteFoneRepository;

@RestController
public class ClienteFoneResource {
	
	@Autowired
	private ClienteFoneRepository clienteFoneRepository;
	
	private WebServiceResponse vWebServiceResponse;
	
	@GetMapping("/clienteFone/foneCliente/{clienteId}")
	public WebServiceResponse listar(@PathVariable Long clienteId) {
		try {
			List<ClienteFone> vLista = clienteFoneRepository.findAll().stream()
					.filter(x -> x.getCliente().getId()==clienteId)
					.collect(Collectors.toList());
			vWebServiceResponse = new WebServiceResponse(vLista);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
	
	@GetMapping("/clienteFone/{foneId}")
	public WebServiceResponse editar(@PathVariable Long foneId) {
		try {
			ClienteFone vObj = clienteFoneRepository.findById(foneId).get();
			vWebServiceResponse = new WebServiceResponse(vObj);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}

	@PostMapping("/clienteFone")
	public WebServiceResponse adicionar(@RequestBody @Valid ClienteFone T) {
		try {
			ClienteFone vObj = clienteFoneRepository.save(T);
			vWebServiceResponse = new WebServiceResponse(vObj);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
}
