package br.com.javaChallenge.webStore.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaChallenge.webStore.core.IResource;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.ClienteFone;
import br.com.javaChallenge.webStore.service.ClienteFoneService;

@RestController
public class ClienteFoneResource implements IResource<ClienteFone> {
	
	@Autowired
	private ClienteFoneService clienteFoneService;
	
	@Override
	@GetMapping("/clienteFone/foneClientes")
	public List<ClienteFone> listar() {
		return clienteFoneService.listar();
	}
	
	@GetMapping("/clienteFone/foneCliente/{clienteId}")
	public List<ClienteFone> listar(@PathVariable Long clienteId) {
		return clienteFoneService.listar(clienteId);
	}
	
	@Override
	@GetMapping("/clienteFone/{foneId}")
	public ClienteFone editar(@PathVariable Long foneId) {
		return clienteFoneService.editar(foneId);
	}
	
	@Override
	@PostMapping("/clienteFone")
	public WebServiceResponse adicionar(@RequestBody @Valid ClienteFone T) {
		return clienteFoneService.adicionar(T);
	}
}
