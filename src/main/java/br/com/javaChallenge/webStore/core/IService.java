package br.com.javaChallenge.webStore.core;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.javaChallenge.webStore.core.model.WebServiceResponse;

public interface IService<T> {
	
	public List<T> listar();
	public T editar(@PathVariable Long id);
	public WebServiceResponse adicionar(@RequestBody @Valid T T); 

}
