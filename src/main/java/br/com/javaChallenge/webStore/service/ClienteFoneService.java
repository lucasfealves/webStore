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
import br.com.javaChallenge.webStore.model.ClienteFone;
import br.com.javaChallenge.webStore.repository.ClienteFoneRepository;

@Service
public class ClienteFoneService implements IService<ClienteFone> {
	
	@Autowired
	private ClienteFoneRepository clienteFoneRepository;
	
	private WebServiceResponse vWebServiceResponse;
	
	@Override
	public List<ClienteFone> listar() {
		return clienteFoneRepository.findAll();
	}
	
	public List<ClienteFone> listar(@PathVariable Long clienteId) {
		
		return clienteFoneRepository.findAll().stream()
				.filter(x -> x.getCliente().getId()==clienteId)
				.collect(Collectors.toList());
	}
	
	@Override
	public ClienteFone editar(@PathVariable Long foneId) {
		
		return clienteFoneRepository.findById(foneId).get();
	}

	@Override
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
