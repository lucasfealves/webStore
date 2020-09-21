package br.com.javaChallenge.webStore.resource;

import java.util.List;
import java.util.stream.Collectors;

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
import br.com.javaChallenge.webStore.model.VendasItens;
import br.com.javaChallenge.webStore.service.VendaItensService;

@RestController
@CrossOrigin("${origem-permitida}")
public class VendaItensResource implements IResource<VendasItens> {
	
	@Autowired
	private VendaItensService vendaItensService;

	@Override
	public List<VendasItens> listar() {
		return null;
	}
	
	@GetMapping("/vendaItens/{venda}")
	public List<VendasItens> listar(@PathVariable Long venda) {
		return vendaItensService.listar().stream()
				.filter(x -> x.getVenda().getId()==venda)
				.collect(Collectors.toList());
	}

	@Override
	@GetMapping("/vendaItens/item/{itemVenda}")
	public VendasItens editar(@PathVariable Long itemVenda) {
		return vendaItensService.editar(itemVenda);
	}

	@Override
	@PostMapping("/vendaItens")
	public WebServiceResponse adicionar(@RequestBody @Valid VendasItens T) {
		return vendaItensService.adicionar(T);
	}
}
