package br.com.javaChallenge.webStore.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.javaChallenge.webStore.business.ClienteBusiness;
import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.IService;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Cliente;
import br.com.javaChallenge.webStore.repository.ClienteRepository;

@Service
public class ClienteService implements IService<Cliente> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	private WebServiceResponse vWebServiceResponse;
	
	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente editar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId).get();
	}

	@Override
	public WebServiceResponse adicionar(@RequestBody @Valid Cliente T) {
		try {
			try {
				clienteBusiness.validaCliente(T);
				Cliente vObjeto = clienteRepository.save(T);
				vWebServiceResponse = new WebServiceResponse(vObjeto);
			} catch (BusinessException e) {
				vWebServiceResponse = new WebServiceResponse(true, false, e.getMessage());
			}
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
}
