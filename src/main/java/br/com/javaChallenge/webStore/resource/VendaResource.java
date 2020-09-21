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
import br.com.javaChallenge.webStore.model.Venda;
import br.com.javaChallenge.webStore.service.VendaService;

@RestController
@CrossOrigin("${origem-permitida}")
public class VendaResource implements IResource<Venda> {
	
	@Autowired
	private VendaService vendaService;
	
	@Override
	@GetMapping("/venda")
	public List<Venda> listar() {
		return vendaService.listar();
	}
	
	@Override
	@GetMapping("/venda/{venda}")
	public Venda editar(@PathVariable Long venda) {
		return vendaService.editar(venda);
	}
	
	@Override
	@PostMapping("/venda")
	public WebServiceResponse adicionar(@RequestBody @Valid Venda T) {
		return vendaService.adicionar(T);
	}
}
