package br.com.javaChallenge.webStore.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaChallenge.webStore.business.ClienteBusiness;
import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.IResource;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Cliente;
import br.com.javaChallenge.webStore.repository.ClienteRepository;

@RestController
public class ClienteResource implements IResource<Cliente> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	private WebServiceResponse vWebServiceResponse;
	
	@GetMapping("/cliente")
	@Override
	public WebServiceResponse Listar() {
		try {
			List<Cliente> vLista = clienteRepository.findAll();
			vWebServiceResponse = new WebServiceResponse(vLista);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}
	
	@GetMapping("/cliente/{clienteId}")
	@Override
	public WebServiceResponse editar(@PathVariable Long clienteId) {
		try {
			Cliente vObjeto = clienteRepository.findById(clienteId).get();
			vWebServiceResponse = new WebServiceResponse(vObjeto);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(false, true, e.getMessage());
		}
		return vWebServiceResponse;
	}

	@PostMapping("/cliente")
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
