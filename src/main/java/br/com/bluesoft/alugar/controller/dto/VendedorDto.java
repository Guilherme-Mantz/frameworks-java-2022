package br.com.bluesoft.alugar.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bluesoft.alugar.modelo.Vendedor;

public class VendedorDto {

	private String nome;
	private Long cpf;
	private LocalDate dataAdmissao;

	public VendedorDto(Vendedor vendedor) {
		this.nome = vendedor.getNome();
		this.cpf = vendedor.getCpf();
		this.dataAdmissao = vendedor.getDataAdmissao();
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public static List<VendedorDto> toVendedorDto(List<Vendedor> vendedores) {
		return vendedores.stream().map(VendedorDto::new).collect(Collectors.toList());
	}
}
