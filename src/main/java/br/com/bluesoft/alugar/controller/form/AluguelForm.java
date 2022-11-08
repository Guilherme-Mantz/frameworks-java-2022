package br.com.bluesoft.alugar.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AluguelForm {

	@NotNull
	private Long cpfCliente;
	
	@NotNull
	private Long cpfVendedor;
	
	@NotBlank
	private String placaCarro;
	
	@NotNull
	private Integer quantidadeDeDias;

	public Long getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(Long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Long getCpfVendedor() {
		return cpfVendedor;
	}

	public void setCpfVendedor(Long cpfVendedor) {
		this.cpfVendedor = cpfVendedor;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public Integer getQuantidadeDeDias() {
		return quantidadeDeDias;
	}

	public void setQuantidadeDeDias(Integer quantidadeDeDias) {
		this.quantidadeDeDias = quantidadeDeDias;
	}
}
