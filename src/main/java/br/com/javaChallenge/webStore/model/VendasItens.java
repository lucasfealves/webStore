package br.com.javaChallenge.webStore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.javaChallenge.webStore.core.IBase;

@Entity
public class VendasItens implements IBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity=Venda.class,fetch=FetchType.LAZY)
	@JoinColumn(name="codVenda", nullable = false)
	private Venda venda;
	
	@ManyToOne(targetEntity=Produto.class,fetch=FetchType.LAZY)
	@JoinColumn(name="codItem")
	private Produto item;
	
	@Column(precision = 17, scale = 2, nullable = false)
	private BigDecimal qtde;
	
	@Column(precision = 17, scale = 2, nullable = false)
	private BigDecimal valorUni;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getItem() {
		return item;
	}

	public void setItem(Produto item) {
		this.item = item;
	}

	public BigDecimal getQtde() {
		return qtde;
	}

	public void setQtde(BigDecimal qtde) {
		this.qtde = qtde;
	}

	public BigDecimal getValorUni() {
		return valorUni;
	}

	public void setValorUni(BigDecimal valorUni) {
		this.valorUni = valorUni;
	}

}
