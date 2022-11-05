package br.com.bluesoft.alugar.modelo;

import java.math.BigInteger;

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
	private BigInteger cpf;
	private String email;
	private BigInteger celular;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigInteger getCpf() {
		return cpf;
	}

	public void setCpf(BigInteger cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getCelular() {
		return celular;
	}

	public void setCelular(BigInteger celular) {
		this.celular = celular;
	}

	public Integer getClienteKey() {
		return clienteKey;
	}

	public void setClienteKey(Integer cliente_key) {
		this.clienteKey = cliente_key;
	}

}
