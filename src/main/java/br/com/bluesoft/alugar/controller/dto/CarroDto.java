package br.com.bluesoft.alugar.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bluesoft.alugar.modelo.Carro;

public class CarroDto {

	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private Integer ano;
	private Integer quilometragem;
	private BigDecimal diaria;

	public CarroDto(Carro carro) {
		this.placa = carro.getPlaca();
		this.marca = carro.getMarca();
		this.modelo = carro.getModelo();
		this.cor = carro.getCor();
		this.ano = carro.getAno();
		this.quilometragem = carro.getQuilometragem();
		this.diaria = carro.getDiaria();
	}

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

	public static List<CarroDto> toCarroDto(List<Carro> carros) {
		return carros.stream().map(CarroDto::new).collect(Collectors.toList());
	}

}
