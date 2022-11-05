package br.com.bluesoft.alugar.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import br.com.bluesoft.alugar.modelo.Carro;

public class CarroForm {
	
	@NotBlank
	private String placa;

	@NotBlank
	private String marca;

	@NotBlank
	private String modelo;

	@NotBlank
	private String cor;

	@NotNull
	private Integer ano;

	@NotNull
	@PositiveOrZero(message = "O valor da quilometragem deve ser positivo")
	private Integer quilometragem;

	@NotNull
	@Positive(message = "O valor da diária deve ser um número positivo")
	private BigDecimal diaria;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	public BigDecimal getDiaria() {
		return diaria;
	}

	public void setDiaria(BigDecimal diaria) {
		this.diaria = diaria;
	}

	public Carro toCarro() {
		return new Carro(placa, marca, modelo, cor, ano, quilometragem, diaria);
	}
}
