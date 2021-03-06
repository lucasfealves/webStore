package br.com.javaChallenge.webStore.core;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.javaChallenge.webStore.core.model.WebServiceResponse;

public interface IResource<T> {

	WebServiceResponse vWebServiceResponse = null;
	
	List<T> listar();
	T editar(@PathVariable Long id);
	WebServiceResponse adicionar(@RequestBody @Valid T T); 
}
