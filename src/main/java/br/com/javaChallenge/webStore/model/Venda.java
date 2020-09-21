package br.com.javaChallenge.webStore.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.javaChallenge.webStore.core.IBase;

@Entity
public class Venda implements IBase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity=Usuario.class, fetch=FetchType.LAZY)
	@JoinColumn(name="codUsuario")
	private Usuario Usuario;
	
	@ManyToOne(targetEntity=Cliente.class, fetch=FetchType.LAZY)
	@JoinColumn(name="codCliente")
	private Cliente Cliente;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	
}
