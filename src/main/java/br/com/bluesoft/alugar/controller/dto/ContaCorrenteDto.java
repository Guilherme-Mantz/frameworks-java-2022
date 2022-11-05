package br.com.bluesoft.alugar.controller.dto;

import br.com.bluesoft.alugar.modelo.ContaCorrente;

public class ContaCorrenteDto {

	private String banco;
	private Integer agencia;
	private Integer contaCorrente;

	public ContaCorrenteDto(ContaCorrente contaCorrente) {
		this.banco = contaCorrente.getBanco();
		this.agencia = contaCorrente.getAgencia();
		this.contaCorrente = contaCorrente.getContaCorrente();
	}

	public String getBanco() {
		return banco;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Integer getContaCorrente() {
		return contaCorrente;
	}

}
