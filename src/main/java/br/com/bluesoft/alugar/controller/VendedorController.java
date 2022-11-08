package br.com.bluesoft.alugar.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
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

import br.com.bluesoft.alugar.controller.dto.VendedorDto;
import br.com.bluesoft.alugar.controller.form.VendedorForm;
import br.com.bluesoft.alugar.controller.form.atualizar.AtualizarVendedorForm;
import br.com.bluesoft.alugar.modelo.Vendedor;
import br.com.bluesoft.alugar.service.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	private VendedorService vendedorService;
	
	public VendedorController(VendedorService vendedorService) {
		this.vendedorService = vendedorService;
	}

	@GetMapping
	public List<VendedorDto> listarVendedores() {
		List<Vendedor> vendedores = vendedorService.listar();
		List<VendedorDto> dto = VendedorDto.toVendedorDto(vendedores);

		return dto;
	}

	@GetMapping("/{id}")
	public ResponseEntity<VendedorDto> buscarVendedorPeloId(@PathVariable Integer id) {
		Optional<Vendedor> vendedor = vendedorService.buscarPeloId(id);
		if (vendedor.isPresent()) {
			return ResponseEntity.ok(new VendedorDto(vendedor.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<VendedorDto> cadastrarVendedor(@RequestBody @Valid VendedorForm vendedorForm, UriComponentsBuilder uriBuilder) {
		
		Vendedor vendedor = vendedorService.cadastrar(vendedorForm);
		
		URI uri = uriBuilder.path("/vendedores/{vendedorKey}").buildAndExpand(vendedor.getVendedorKey()).toUri();
		return ResponseEntity.created(uri).body(new VendedorDto(vendedor));
	}

	@PutMapping("/atualizar/{cpf}")
	@Transactional
	public ResponseEntity<VendedorDto> atualizarVendedor(@PathVariable Long cpf, @RequestBody @Valid AtualizarVendedorForm atualizarVendedorForm) {
		Optional<Vendedor> vendedor = vendedorService.buscarVendedorPeloCpf(cpf);
		if(vendedor.isPresent()) {
			Vendedor vendedorAtualizado = vendedorService.atualizar(vendedor.get(), atualizarVendedorForm);
			return ResponseEntity.ok(new VendedorDto(vendedorAtualizado));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deletar/{cpf}")
	@Transactional
	public ResponseEntity<?> deletarVendedor(@PathVariable Long cpf) {
		
		Optional<Vendedor> vendedor = vendedorService.buscarVendedorPeloCpf(cpf);
		if(vendedor.isPresent()) {
			vendedorService.deletar(vendedor.get().getVendedorKey());
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

}
