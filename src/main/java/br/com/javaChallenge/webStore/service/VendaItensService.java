package br.com.javaChallenge.webStore.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.javaChallenge.webStore.core.IService;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.VendasItens;
import br.com.javaChallenge.webStore.repository.VendaItensRepository;

@Service
public class VendaItensService implements IService<VendasItens> {
	
	@Autowired
	private VendaItensRepository vendaItensRepository;
	
	@Override
	public List<VendasItens> listar() {
		return vendaItensRepository.findAll();
	}
	
	@Override
	public VendasItens editar(@PathVariable Long venda) {
		return vendaItensRepository.findById(venda).get();
	}
	
	public List<VendasItens> listar(@PathVariable Long venda) {
		return vendaItensRepository.findAll().stream()
				.filter(x -> x.getVenda().getId()==venda)
				.collect(Collectors.toList());
	}
	
	@Override
	public WebServiceResponse adicionar(@RequestBody @Valid VendasItens T) {
		//return vendaItensRepository.save(T);
		return null;
	}
}
