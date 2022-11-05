package br.com.bluesoft.alugar.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comissao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comissao_key")
	private Integer comissaoKey;

	@Column(name = "valor_comissao")
	private BigDecimal valorComissao;

	@ManyToOne
	@JoinColumn(name = "vendedor_key")
	private Vendedor vendedor;
	
	public Comissao() {
	}

	public Comissao(BigDecimal valorComissao, Vendedor vendedor) {
		this.valorComissao = valorComissao;
		this.vendedor = vendedor;
	}

	public Integer getComissaoKey() {
		return comissaoKey;
	}

	public void setComissaoKey(Integer comissaoKey) {
		this.comissaoKey = comissaoKey;
	}

	public BigDecimal getValorComissao() {
		return valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
