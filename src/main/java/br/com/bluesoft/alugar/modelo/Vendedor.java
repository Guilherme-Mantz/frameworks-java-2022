package br.com.bluesoft.alugar.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vendedor_key")
	private Integer vendedorKey;
	private String nome;
	private Long cpf;
	
	@Column(name="data_admissao")
	private LocalDate dataAdmissao;
	
	@OneToOne(mappedBy = "vendedor")
	private ContaCorrente contaCorrente;

	public Integer getVendedorKey() {
		return vendedorKey;
	}

	public void setVendedorKey(Integer vendedorKey) {
		this.vendedorKey = vendedorKey;
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

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

}
