package br.com.bluesoft.alugar.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.bluesoft.alugar.modelo.Cliente;

public class AtualizarClienteForm {

	@NotBlank
	private String nome;

	@NotNull
	private Long cpf;

	@NotNull
	private String email;

	@NotNull
	private Long celular;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public Cliente atualizar(Cliente cliente) {

		cliente.setNome(this.nome);
		cliente.setCpf(this.cpf);
		cliente.setEmail(this.email);
		cliente.setCelular(this.celular);

		return cliente;
	}
}
