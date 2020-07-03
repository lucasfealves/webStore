package br.com.javaChallenge.webStore.business;

import org.springframework.stereotype.Service;

import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.model.Validation;
import br.com.javaChallenge.webStore.model.Cliente;

@Service
public class ClienteBusiness {

	public void validaCliente(Cliente entity) throws BusinessException {
		Validation validation = new Validation();
		validation.checkFieldEmpty(entity.getNome(), "Nome");
		validation.checkFieldEmpty(entity.getCpfCnpj(), "CPF/CNPJ");
		
		StringBuilder validations = validation.getValidations();
		if (validations.length() > 0) {
			throw new BusinessException(validations.toString());	
		}
		
	}
}
