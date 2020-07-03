package br.com.javaChallenge.webStore.business;

import br.com.javaChallenge.webStore.core.BusinessException;
import br.com.javaChallenge.webStore.core.model.Validation;
import br.com.javaChallenge.webStore.model.Usuario;

public class UsuarioBusiness {
	
	public void validaUsuario(Usuario entity) throws BusinessException {
		Validation validation = new Validation();
		validation.checkFieldEmpty(entity.getNome(), "Nome");
		
		StringBuilder validations = validation.getValidations();
		if (validations.length() > 0) {
			throw new BusinessException(validations.toString());	
		}
		
	}
}
