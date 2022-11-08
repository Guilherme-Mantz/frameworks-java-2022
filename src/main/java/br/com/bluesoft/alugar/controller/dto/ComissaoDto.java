package br.com.bluesoft.alugar.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bluesoft.alugar.modelo.Comissao;
import br.com.bluesoft.alugar.modelo.Vendedor;

public class ComissaoDto {

	private String vendedor;
	private Long cpf;
	private BigDecimal valor;
	private ContaCorrenteDto conta;

	public ComissaoDto(Comissao comissao) {
		this.vendedor = comissao.getVendedor().getNome();
		this.cpf = comissao.getVendedor().getCpf();
		this.valor = comissao.getValor();
		this.conta = new ContaCorrenteDto(comissao.getVendedor().getContaCorrente());
	}

	public ComissaoDto(Vendedor vendedor, BigDecimal valor) {
		this.vendedor = vendedor.getNome();
		this.cpf = vendedor.getCpf();
		this.valor = valor;
		this.conta = new ContaCorrenteDto(vendedor.getContaCorrente());
	}

	public String getVendedor() {
		return vendedor;
	}

	public Long getCpf() {
		return cpf;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public ContaCorrenteDto getConta() {
		return conta;
	}

	public static List<ComissaoDto> toComissaoDto(List<Comissao> comissoes) {
		return comissoes.stream().map(ComissaoDto::new).collect(Collectors.toList());
	}
}
