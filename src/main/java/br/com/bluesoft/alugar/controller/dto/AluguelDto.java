package br.com.bluesoft.alugar.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.bluesoft.alugar.modelo.Aluguel;

public class AluguelDto {

	private Long cpfCliente;
	private Long cpfVendedor;
	private String placaCarro;
	private Integer quantidadeDeDias;
	private LocalDate dataDoAlugel;
	private BigDecimal valorTotal;

	public AluguelDto(Aluguel aluguel) {
		this.cpfCliente = aluguel.getCliente().getCpf();
		this.cpfVendedor = aluguel.getVendedor().getCpf();
		this.placaCarro = aluguel.getCarro().getPlaca();
		this.quantidadeDeDias = aluguel.getQuantidadeDeDias();
		this.dataDoAlugel = aluguel.getDataDoAluguel();
		this.valorTotal = aluguel.getValorTotal();
	}

	public Long getCpfCliente() {
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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public LocalDate getDataDoAlugel() {
		return dataDoAlugel;
	}

}
