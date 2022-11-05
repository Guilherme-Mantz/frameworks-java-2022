package br.com.bluesoft.alugar.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bluesoft.alugar.controller.dto.ClienteDto;
import br.com.bluesoft.alugar.controller.form.AtualizarClienteForm;
import br.com.bluesoft.alugar.controller.form.ClienteForm;
import br.com.bluesoft.alugar.modelo.Cliente;
import br.com.bluesoft.alugar.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<ClienteDto> listarClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDto> dto = ClienteDto.toClienteDto(clientes);

		return dto;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> buscarClientePeloId(@PathVariable Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {

		Cliente cliente = clienteForm.toCliente();
		clienteRepository.save(cliente);

		URI uri = uriBuilder.path("/clientes/{clienteKey}").buildAndExpand(cliente.getClienteKey()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

	@PutMapping("/atualizar/{cpf}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable Long cpf, @RequestBody @Valid AtualizarClienteForm atualizarClienteForm) {
		
		Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
		if (cliente.isPresent()) {
			Cliente clienteAtualizado = atualizarClienteForm.atualizar(cliente.get());
			return ResponseEntity.ok(new ClienteDto(clienteAtualizado));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deletar/{cpf}")
	@Transactional
	public ResponseEntity<?> deletarCliente(@PathVariable Long cpf) {

		Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
		if (cliente.isPresent()) {
			clienteRepository.deleteById(cliente.get().getClienteKey());
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
}
