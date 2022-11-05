package br.com.bluesoft.alugar.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cliente_key")
	private Integer clienteKey;
	private String nome;
	private Long cpf;
	private String email;
	private Long celular;
	
	public Cliente() {
	}

	public Cliente(String nome, Long cpf, String email, Long celular) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
	}

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

	public Integer getClienteKey() {
		return clienteKey;
	}

	public void setClienteKey(Integer cliente_key) {
		this.clienteKey = cliente_key;
	}

}
