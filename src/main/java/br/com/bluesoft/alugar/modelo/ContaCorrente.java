package br.com.bluesoft.alugar.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="conta_corrente_key")
	private Integer contaCorrenteKey;
	private String banco;
	private Integer agencia;
	
	@Column(name="conta_corrente")
	private Integer contaCorrente;

	
	@ManyToOne
	@JoinColumn(name="vendedor_key")
	private Vendedor vendedor;

	public Integer getContaCorrenteKey() {
		return contaCorrenteKey;
	}

	public void setContaCorrenteKey(Integer contaCorrenteKey) {
		this.contaCorrenteKey = contaCorrenteKey;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Integer contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

}
