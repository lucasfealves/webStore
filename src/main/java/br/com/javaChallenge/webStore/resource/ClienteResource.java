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
import br.com.javaChallenge.webStore.model.Cliente;
import br.com.javaChallenge.webStore.service.ClienteService;

@RestController
public class ClienteResource implements IResource<Cliente> {
	
	@Autowired
	private ClienteService clienteService;
	
	@Override
	@GetMapping("/cliente")
	public List<Cliente> listar() {
		return clienteService.listar();
	}
	
	@Override
	@GetMapping("/cliente/{clienteId}")
	public Cliente editar(@PathVariable Long clienteId) {
		return clienteService.editar(clienteId);
	}

	@PostMapping("/cliente")
	@Override
	public WebServiceResponse adicionar(@RequestBody @Valid Cliente T) {
		return clienteService.adicionar(T);
	}
}
