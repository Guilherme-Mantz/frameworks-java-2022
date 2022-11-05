package br.com.bluesoft.alugar.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bluesoft.alugar.modelo.Comissao;

public class ComissaoDto {

	private String nomeVendedor;
	private Long cpf;
	private BigDecimal valor;

	private String banco;
	private Integer agencia;
	private Integer contaCorrente;

	public ComissaoDto(Comissao comissao) {
		this.nomeVendedor = comissao.getVendedor().getNome();
		this.cpf = comissao.getVendedor().getCpf();
		this.valor = comissao.getValorComissao();

		this.banco = comissao.getVendedor().getContaCorrente().getBanco();
		this.agencia = comissao.getVendedor().getContaCorrente().getAgencia();
		this.contaCorrente = comissao.getVendedor().getContaCorrente().getContaCorrente();
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public String getCpf() {
		return cpf.toString();
	}

	public BigDecimal getValor() {
		return valor;
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

	public static List<ComissaoDto> toComissaoDto(List<Comissao> comissoes) {
		return comissoes.stream().map(ComissaoDto::new).collect(Collectors.toList());

	}

}
