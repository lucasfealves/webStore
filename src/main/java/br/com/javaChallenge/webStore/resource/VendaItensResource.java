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

import br.com.javaChallenge.webStore.model.VendasItens;
import br.com.javaChallenge.webStore.repository.VendaItensRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class VendaItensResource {
	
	@Autowired
	private VendaItensRepository vendaItensRepository;
	
	@GetMapping("/vendaItens/{venda}")
	public List<VendasItens> listar(@PathVariable Long venda) {
		return vendaItensRepository.findAll().stream()
				.filter(x -> x.getVenda().getId()==venda)
				.collect(Collectors.toList());
	}
	
	@PostMapping("/vendaItens")
	public VendasItens adicionar(@RequestBody @Valid VendasItens T) {
		return vendaItensRepository.save(T);
	}
}
