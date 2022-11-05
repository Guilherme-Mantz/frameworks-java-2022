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

import br.com.bluesoft.alugar.controller.dto.VendedorDto;
import br.com.bluesoft.alugar.controller.form.AtualizarVendedorForm;
import br.com.bluesoft.alugar.controller.form.VendedorForm;
import br.com.bluesoft.alugar.modelo.Vendedor;
import br.com.bluesoft.alugar.repository.VendedorRepository;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@GetMapping
	public List<VendedorDto> listarVendedores() {
		List<Vendedor> vendedores = vendedorRepository.findAll();
		List<VendedorDto> dto = VendedorDto.toVendedorDto(vendedores);

		return dto;
	}

	@GetMapping("/{id}")
	public ResponseEntity<VendedorDto> buscarVendedorPeloId(@PathVariable Integer id) {
		Optional<Vendedor> vendedor = vendedorRepository.findById(id);
		if (vendedor.isPresent()) {
			return ResponseEntity.ok(new VendedorDto(vendedor.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<VendedorDto> cadastrarVendedor(@RequestBody @Valid VendedorForm vendedorForm, UriComponentsBuilder uriBuilder) {
		
		Vendedor vendedor = vendedorForm.toVendedor();
		vendedorRepository.save(vendedor);
		
		URI uri = uriBuilder.path("/vendedores/{vendedorKey}").buildAndExpand(vendedor.getVendedorKey()).toUri();
		return ResponseEntity.created(uri).body(new VendedorDto(vendedor));
	}

	@PutMapping("/atualizar/{cpf}")
	@Transactional
	public ResponseEntity<VendedorDto> atualizarVendedor(@PathVariable Long cpf, @RequestBody @Valid AtualizarVendedorForm atualizarVendedorForm) {
		Optional<Vendedor> vendedor = vendedorRepository.findByCpf(cpf);
		if(vendedor.isPresent()) {
			Vendedor vendedorAtualizado = atualizarVendedorForm.atualizar(vendedor.get());
			return ResponseEntity.ok(new VendedorDto(vendedorAtualizado));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deletar/{cpf}")
	@Transactional
	public ResponseEntity<?> deletarVendedor(@PathVariable Long cpf) {
		
		Optional<Vendedor> vendedor = vendedorRepository.findByCpf(cpf);
		if(vendedor.isPresent()) {
			vendedorRepository.deleteById(vendedor.get().getVendedorKey());
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

}
