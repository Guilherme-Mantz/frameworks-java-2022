package br.com.bluesoft.alugar.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.bluesoft.alugar.controller.form.ClienteForm;
import br.com.bluesoft.alugar.controller.form.atualizar.AtualizarClienteForm;
import br.com.bluesoft.alugar.modelo.Cliente;
import br.com.bluesoft.alugar.repository.ClienteRepository;

@Service
public class ClienteService {
	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Optional<Cliente> buscarClientePeloCpf(Long cpf) {
		return clienteRepository.findByCpf(cpf);
	}

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> buscarClientePeloId(Integer id) {
		return clienteRepository.findById(id);
	}

	@Transactional
	public Cliente cadastrar(ClienteForm clienteForm) {
		Cliente clienteCriado = clienteForm.toCliente();
		Cliente cliente = clienteRepository.save(clienteCriado);
		
		return cliente;
	}

	@Transactional
	public Cliente atualizar(Cliente cliente, AtualizarClienteForm atualizarClienteForm) {
		Cliente clienteAtualizado = atualizarClienteForm.atualizar(cliente);
		return clienteAtualizado;
	}

	@Transactional
	public void deletar(Integer clienteKey) {
		clienteRepository.deleteById(clienteKey);
	}
}
