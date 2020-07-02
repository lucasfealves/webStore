package br.com.javaChallenge.webStore.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.javaChallenge.webStore.core.IBase;

@Entity
public class Ticket implements IBase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 80, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Integer tipoTicket;
	
	@Column(precision = 17, scale = 2,nullable = false)
	private BigDecimal valorTicket;
	
	@Column(precision = 17, scale = 2, nullable = false)
	private BigDecimal valorCosumo;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataValidade;
	
	@Column(nullable = false)
	private Integer generoTicket;
	
	@OneToMany(mappedBy="itemTicket")
	@MapKey
	private Map<Long, VendasItens> vendas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTipoTicket() {
		return tipoTicket;
	}

	public void setTipoTicket(Integer tipoTicket) {
		this.tipoTicket = tipoTicket;
	}

	public BigDecimal getValorTicket() {
		return valorTicket;
	}

	public void setValorTicket(BigDecimal valorTicket) {
		this.valorTicket = valorTicket;
	}

	public BigDecimal getValorCosumo() {
		return valorCosumo;
	}

	public void setValorCosumo(BigDecimal valorCosumo) {
		this.valorCosumo = valorCosumo;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Integer getGeneroTicket() {
		return generoTicket;
	}

	public void setGeneroTicket(Integer generoTicket) {
		this.generoTicket = generoTicket;
	}

	public Map<Long, VendasItens> getVendas() {
		return vendas;
	}

	public void setVendas(Map<Long, VendasItens> vendas) {
		this.vendas = vendas;
	}
	
}
