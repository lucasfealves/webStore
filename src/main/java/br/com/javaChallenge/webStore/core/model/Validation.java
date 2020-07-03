package br.com.javaChallenge.webStore.core.model;

import java.util.ArrayList;
import java.util.List;

public class Validation {
	
	private StringBuilder validations;

	public Validation() {
		super();
		validations = new StringBuilder();
	}

	public void checkFieldEmpty(String value, String fieldNome) {
		if (value == null || (value != null && value.length() <= 0)) {
			validations.append("Campo " + fieldNome + " não foi preenchido");
		}
	}
	
	public void checkFieldEquals(String value, String valuesEquals, String fieldNome) {
		if (value == null || (value != null && value.length() <= 0)) {
			if (!value.equals(valuesEquals)) {
				validations.append("Campo " + fieldNome + " não foi preenchido corretamente! Valor esperado " + valuesEquals);
			}
		}
	}

	public void checkFieldEquals(Integer value, Integer valuesEquals, String fieldNome) {
		if (value != null && value != valuesEquals) {
			validations.append("Campo " + fieldNome + " não foi preenchido corretamente! Valor esperado " + valuesEquals);
		}
	}

	public StringBuilder getValidations() {
		return validations;
	}

	public void setValidations(StringBuilder validations) {
		this.validations = validations;
	}
	
}
