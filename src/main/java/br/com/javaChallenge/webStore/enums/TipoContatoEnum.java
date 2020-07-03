package br.com.javaChallenge.webStore.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoContatoEnum {
	
	Celular(1, "Número Celular"),
	TelefoneFixo(2, "Número Telefone Fixo");

	private TipoContatoEnum(Integer id, String descricao) {
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
