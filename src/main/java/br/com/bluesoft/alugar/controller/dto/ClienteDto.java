package br.com.bluesoft.alugar.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.bluesoft.alugar.modelo.Cliente;

public class ClienteDto {

	private String nome;
	private Long cpf;
	private String email;
	private Long celular;

	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		this.celular = cliente.getCelular();
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public Long getCelular() {
		return celular;
	}

	public static List<ClienteDto> toClienteDto(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
}
