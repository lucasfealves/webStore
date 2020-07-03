package br.com.javaChallenge.webStore.business;

import org.springframework.stereotype.Service;

import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.model.Validation;
import br.com.javaChallenge.webStore.model.Produto;

@Service
public class ProdutoBusiness {

	public void validaProduto(Produto entity) throws BusinessException {
		Validation validation = new Validation();
		validation.checkFieldEmpty(entity.getNome(), "Nome");
		validation.checkFieldEmpty(entity.getReferencia(), "Referencia");
		validation.checkFieldEmpty(entity.getGrupo().getNome(), "Grupo de Produto");
		
		StringBuilder validations = validation.getValidations();
		if (validations.length() > 0) {
			throw new BusinessException(validations.toString());	
		}
		
	}
}
