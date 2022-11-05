package br.com.bluesoft.alugar.controller.dto;

import java.math.BigInteger;
import java.time.LocalDate;

import br.com.bluesoft.alugar.modelo.Aluguel;

public class AluguelDto {

	private BigInteger cpfCliente;
	private Long cpfVendedor;
	private String placaCarro;
	private Integer quantidadeDeDias;
	private LocalDate dataDoAlugel;
	private Float valorTotal;

	public AluguelDto(Aluguel aluguel) {
		this.cpfCliente = aluguel.getCliente().getCpf();
		this.cpfVendedor = aluguel.getVendedor().getCpf();
		this.placaCarro = aluguel.getCarro().getPlaca();
		this.quantidadeDeDias = aluguel.getQuantidadeDeDias();
		this.dataDoAlugel = aluguel.getDataDoAluguel();
		this.valorTotal = aluguel.getValorTotal();
	}

	public BigInteger getCpfCliente() {
		return cpfCliente;
	}

	public Long getCpfVendedor() {
		return cpfVendedor;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public Integer getQuantidadeDeDias() {
		return quantidadeDeDias;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public LocalDate getDataDoAlugel() {
		return dataDoAlugel;
	}

}
