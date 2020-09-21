package br.com.javaChallenge.webStore.business;

import org.springframework.stereotype.Service;

import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.model.Validation;
import br.com.javaChallenge.webStore.model.Venda;

@Service
public class VendaBusiness {

	public void validaVenda(Venda entity) throws BusinessException {
		Validation validation = new Validation();
		
		
		StringBuilder validations = validation.getValidations();
		if (validations.length() > 0) {
			throw new BusinessException(validations.toString());	
		}
		
	}
}
