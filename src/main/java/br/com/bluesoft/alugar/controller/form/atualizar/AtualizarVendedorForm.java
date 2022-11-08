package br.com.bluesoft.alugar.controller.form.atualizar;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import br.com.bluesoft.alugar.modelo.Vendedor;

public class AtualizarVendedorForm {
	
	@NotBlank
	private String nome;
	
	@NotNull
	private Long cpf;
	
	@NotNull
	@PastOrPresent
	private LocalDate dataAdmissao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	public Vendedor atualizar(Vendedor vendedor) {

		vendedor.setNome(this.nome);
		vendedor.setCpf(this.cpf);
		vendedor.setDataAdmissao(this.dataAdmissao);
		
		return vendedor;
	}
}