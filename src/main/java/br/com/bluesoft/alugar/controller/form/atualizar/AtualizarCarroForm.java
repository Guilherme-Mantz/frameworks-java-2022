package br.com.bluesoft.alugar.controller.form.atualizar;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import br.com.bluesoft.alugar.modelo.Carro;

public class AtualizarCarroForm {
	
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

	public Carro atualizar(Carro carro) {
		
		carro.setMarca(this.marca);
		carro.setModelo(this.modelo);
		carro.setCor(this.cor);
		carro.setAno(this.ano);
		carro.setQuilometragem(this.quilometragem);
		carro.setDiaria(this.diaria);

		return carro;
	}
}
