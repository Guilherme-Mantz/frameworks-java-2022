package br.com.bluesoft.alugar.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.bluesoft.alugar.modelo.Aluguel;
import br.com.bluesoft.alugar.modelo.Carro;
import br.com.bluesoft.alugar.modelo.Cliente;
import br.com.bluesoft.alugar.modelo.Vendedor;
import br.com.bluesoft.alugar.repository.CarroRepository;
import br.com.bluesoft.alugar.repository.ClienteRepository;
import br.com.bluesoft.alugar.repository.VendedorRepository;

public class AluguelForm {

	@NotBlank
	private String cpfCliente;
	
	@NotNull
	private Long cpfVendedor;
	
	@NotBlank
	private String placaCarro;
	
	@NotNull
	private Integer quantidadeDeDias;

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Long getCpfVendedor() {
		return cpfVendedor;
	}

	public void setCpfVendedor(Long cpfVendedor) {
		this.cpfVendedor = cpfVendedor;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public Integer getQuantidadeDeDias() {
		return quantidadeDeDias;
	}

	public void setQuantidadeDeDias(Integer quantidadeDeDias) {
		this.quantidadeDeDias = quantidadeDeDias;
	}

	public Aluguel toAluguel(ClienteRepository clienteRepository, VendedorRepository vendedorRepository, CarroRepository carroRepository) {
		
		Optional<Cliente> cliente = clienteRepository.findByCpf(Long.valueOf(this.cpfCliente));
		Optional<Vendedor> vendedor = vendedorRepository.findByCpf(this.cpfVendedor);
		Optional<Carro> carro = carroRepository.findById(this.placaCarro);
		
		if(cliente.isEmpty() && carro.isEmpty() && vendedor.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		BigDecimal valorTotal = carro.get().getDiaria().multiply(new BigDecimal(this.quantidadeDeDias));
		Aluguel aluguel = new Aluguel(cliente.get(), vendedor.get(), carro.get(), quantidadeDeDias, LocalDate.now(), valorTotal);
		
		return aluguel;
	}

}
