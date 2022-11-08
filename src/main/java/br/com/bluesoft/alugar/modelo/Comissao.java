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
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "vendedor_key")
	private Vendedor vendedor;

	@ManyToOne
	@JoinColumn(name = "aluguel_key")
	private Aluguel aluguel;

	public Comissao() {
	}

	public Comissao(BigDecimal valor, Vendedor vendedor, Aluguel aluguel) {
		this.valor = valor;
		this.vendedor = vendedor;
		this.aluguel = aluguel;
	}

	public Integer getComissaoKey() {
		return comissaoKey;
	}

	public void setComissaoKey(Integer comissaoKey) {
		this.comissaoKey = comissaoKey;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

}
