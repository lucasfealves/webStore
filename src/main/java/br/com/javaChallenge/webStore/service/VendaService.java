package br.com.javaChallenge.webStore.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.javaChallenge.webStore.business.VendaBusiness;
import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.IService;
import br.com.javaChallenge.webStore.core.model.WebServiceResponse;
import br.com.javaChallenge.webStore.model.Venda;
import br.com.javaChallenge.webStore.repository.VendaRepository;

@Service
public class VendaService implements IService<Venda> {
	
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private VendaBusiness vendaBusiness;

	private WebServiceResponse vWebServiceResponse;
	
	@Override
	public List<Venda> listar() {
		return vendaRepository.findAll();
	}

	public Venda listar(@PathVariable Long venda) {
		return vendaRepository.findById(venda).get();
	}
	
	@Override
	public Venda editar(@PathVariable Long venda) {
		return vendaRepository.findById(venda).get();
	}
	
	@Override
	public WebServiceResponse adicionar(@RequestBody @Valid Venda T) {
		try {
			try {
				vendaBusiness.validaVenda(T);
			} catch (BusinessException e) {
				vWebServiceResponse = new WebServiceResponse(true, false, e.getMessage());
			}
			@Valid
			Venda venda = vendaRepository.save(T);
			vWebServiceResponse = new WebServiceResponse(venda);
		} catch (Exception e) {
			vWebServiceResponse = new WebServiceResponse(true, false, e.getMessage());
		}

		return vWebServiceResponse ;
	}
}
