package br.com.bluesoft.alugar.factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.bluesoft.alugar.controller.form.AluguelForm;
import br.com.bluesoft.alugar.exception.BusinessException;
import br.com.bluesoft.alugar.modelo.Aluguel;
import br.com.bluesoft.alugar.modelo.Carro;
import br.com.bluesoft.alugar.modelo.Cliente;
import br.com.bluesoft.alugar.modelo.Vendedor;
import br.com.bluesoft.alugar.service.CarroService;
import br.com.bluesoft.alugar.service.ClienteService;
import br.com.bluesoft.alugar.service.VendedorService;

@Service
public class AluguelFactory {
	
	private ClienteService clienteService;
	private VendedorService vendedorService;
	private CarroService carroService;
	
	public AluguelFactory(ClienteService clienteService, VendedorService vendedorService, CarroService carroService) {
		this.clienteService = clienteService;
		this.vendedorService = vendedorService;
		this.carroService = carroService;
	}

	public Aluguel criarAluguel(AluguelForm formAluguel) {
		
		Cliente cliente = buscarCliente(formAluguel.getCpfCliente());
		Vendedor vendedor = buscarVendedor(formAluguel.getCpfVendedor());
		Carro carro = buscarCarro(formAluguel.getPlacaCarro());
		
		BigDecimal valorTotal = carro.getDiaria().multiply(BigDecimal.valueOf(formAluguel.getQuantidadeDeDias()));
		
		Aluguel aluguel = new Aluguel(cliente, vendedor, carro, formAluguel.getQuantidadeDeDias(), LocalDate.now(), valorTotal);
		
		return aluguel;
	}
	
	private Cliente buscarCliente(Long cpf) {
		Optional<Cliente> optionalCliente = clienteService.buscarClientePeloCpf(cpf);
		return optionalCliente.orElseThrow(() -> new BusinessException("Cliente não encontrado!"));
	}
	
	private Vendedor buscarVendedor(Long cpf) {
		Optional<Vendedor> optionalVendedor = vendedorService.buscarVendedorPeloCpf(cpf);
		return optionalVendedor.orElseThrow(() -> new BusinessException("Vendedor não encontrado!"));
	}
	
	private Carro buscarCarro(String placa) {
		Optional<Carro> optionalCarro = carroService.buscarCarroPelaPlaca(placa);
		return optionalCarro.orElseThrow(() -> new BusinessException("Carro não encontrado!"));
	}
}
