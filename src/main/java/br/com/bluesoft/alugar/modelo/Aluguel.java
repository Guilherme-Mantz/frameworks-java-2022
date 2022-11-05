package br.com.bluesoft.alugar.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluguel")
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aluguel_key")
	private Integer aluguelKey;

	@ManyToOne
	@JoinColumn(name = "cliente_key")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "vendedor_key")
	private Vendedor vendedor;

	@ManyToOne
	@JoinColumn(name = "carro_placa")
	private Carro carro;

	@Column(name = "quantidade_de_dias_alugado")
	private Integer quantidadeDeDias;

	@Column(name = "data_do_aluguel")
	private LocalDate dataDoAluguel;

	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	public Aluguel() {
	}

	public Aluguel(Cliente cliente, Vendedor vendedor, Carro carro, Integer quantidadeDeDias, LocalDate dataDoAluguel,
			BigDecimal valorTotal) {
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.carro = carro;
		this.quantidadeDeDias = quantidadeDeDias;
		this.dataDoAluguel = dataDoAluguel;
		this.valorTotal = valorTotal;
	}

	public Integer getAluguelKey() {
		return aluguelKey;
	}

	public void setAluguelKey(Integer aluguelKey) {
		this.aluguelKey = aluguelKey;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Integer getQuantidadeDeDias() {
		return quantidadeDeDias;
	}

	public void setQuantidadeDeDias(Integer quantidadeDeDias) {
		this.quantidadeDeDias = quantidadeDeDias;
	}

	public LocalDate getDataDoAluguel() {
		return dataDoAluguel;
	}

	public void setDataDoAluguel(LocalDate dataDoAluguel) {
		this.dataDoAluguel = dataDoAluguel;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
