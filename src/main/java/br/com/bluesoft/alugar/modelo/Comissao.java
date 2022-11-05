package br.com.bluesoft.alugar.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

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
	@JoinColumn(name = "conta_corrente_key")
	private ContaCorrente contaCorrente;

	@Column(name = "data_comissao")
	private LocalDate dataComissao;

	public Comissao() {
	}

	public Comissao(BigDecimal valor, Vendedor vendedor, ContaCorrente contaCorrente, LocalDate dataComissao) {
		this.valor = valor;
		this.vendedor = vendedor;
		this.contaCorrente = contaCorrente;
		this.dataComissao = dataComissao;
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

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public LocalDate getDataComissao() {
		return dataComissao;
	}

	public void setDataComissao(LocalDate dataComissao) {
		this.dataComissao = dataComissao;
	}

}
