package br.com.bluesoft.alugar.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import br.com.bluesoft.alugar.controller.form.ClienteForm;
import br.com.bluesoft.alugar.controller.form.atualizar.AtualizarClienteForm;
import br.com.bluesoft.alugar.modelo.Cliente;
import br.com.bluesoft.alugar.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping
	public List<ClienteDto> listarClientes() {
		List<Cliente> clientes = clienteService.listar();
		List<ClienteDto> dto = ClienteDto.toClienteDto(clientes);

		return dto;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> buscarClientePeloId(@PathVariable Integer id) {
		Optional<Cliente> cliente = clienteService.buscarClientePeloId(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
		
		Cliente cliente = clienteService.cadastrar(clienteForm);

		URI uri = uriBuilder.path("/clientes/{clienteKey}").buildAndExpand(cliente.getClienteKey()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

	@PutMapping("/atualizar/{cpf}")
	public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable Long cpf, @RequestBody @Valid AtualizarClienteForm atualizarClienteForm) {
		
		Optional<Cliente> cliente = clienteService.buscarClientePeloCpf(cpf);
		if (cliente.isPresent()) {
			Cliente clienteAtualizado = clienteService.atualizar(cliente.get(), atualizarClienteForm);
			return ResponseEntity.ok(new ClienteDto(clienteAtualizado));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deletar/{cpf}")
	public ResponseEntity<?> deletarCliente(@PathVariable Long cpf) {

		Optional<Cliente> cliente = clienteService.buscarClientePeloCpf(cpf);
		if (cliente.isPresent()) {
			clienteService.deletar(cliente.get().getClienteKey());
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
}
