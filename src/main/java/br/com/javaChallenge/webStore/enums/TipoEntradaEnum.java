package br.com.javaChallenge.webStore.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoEntradaEnum {
	
	API(1, "Integração API"),
	WEB(2, "Incluído pelo site"),
	ECOMMERCE(3, "Integração Ecommerce");

	private TipoEntradaEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	@JsonValue
    public int toValue() {
        return ordinal();
    }

	private Integer id;
	
	private String descricao;

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
