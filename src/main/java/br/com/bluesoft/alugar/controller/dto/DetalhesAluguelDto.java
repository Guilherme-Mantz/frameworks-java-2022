package br.com.bluesoft.alugar.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.bluesoft.alugar.modelo.Aluguel;

public class DetalhesAluguelDto {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String nomeCliente;
	private String modeloCarro;
	private String placaCarro;
	private String nomeVendedor;
	private Integer quantidadeDeDias;
	private BigDecimal valorTotal;
	private LocalDate dataDoAlugel;

	public DetalhesAluguelDto(Aluguel aluguel) {
		this.nomeCliente = aluguel.getCliente().getNome();
		this.modeloCarro = aluguel.getCarro().getModelo();
		this.placaCarro = aluguel.getCarro().getPlaca();
		this.nomeVendedor = aluguel.getVendedor().getNome();
		this.quantidadeDeDias = aluguel.getQuantidadeDeDias();
		this.valorTotal = aluguel.getValorTotal();
		this.dataDoAlugel = aluguel.getDataDoAluguel();
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public Integer getQuantidadeDeDias() {
		return quantidadeDeDias;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public String getDataDoAlugel() {
		return dataDoAlugel.format(formatter);
	}

}
