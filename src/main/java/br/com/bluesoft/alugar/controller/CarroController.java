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

import br.com.bluesoft.alugar.controller.dto.CarroDto;
import br.com.bluesoft.alugar.controller.form.AtualizarCarroForm;
import br.com.bluesoft.alugar.controller.form.CarroForm;
import br.com.bluesoft.alugar.modelo.Carro;
import br.com.bluesoft.alugar.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarroController {

	@Autowired
	private CarroRepository carroRepository;

	@GetMapping
	public List<CarroDto> listarCarros() {
		List<Carro> carros = carroRepository.findAll();
		List<CarroDto> dto = CarroDto.toCarroDto(carros);

		return dto;
	}

	@GetMapping("/{placa}")
	public ResponseEntity<CarroDto> buscarPelaPlaca(@PathVariable String placa) {
		Optional<Carro> carro = carroRepository.findById(placa);
		if (carro.isPresent()) {
			return ResponseEntity.ok(new CarroDto(carro.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<CarroDto> cadastrarCarro(@RequestBody @Valid CarroForm carroForm, UriComponentsBuilder uriBuilder) {
		
		Carro carro = carroForm.toCarro();
		carroRepository.save(carro);
		
		URI uri = uriBuilder.path("/carros/{placa}").buildAndExpand(carro.getPlaca()).toUri();
		return ResponseEntity.created(uri).body(new CarroDto(carro));
	}

	@PutMapping("/atualizar/{placa}")
	@Transactional
	public ResponseEntity<CarroDto> atualizarCarro(@PathVariable String placa, @RequestBody @Valid AtualizarCarroForm atualizarCarroForm) {
		Optional<Carro> carro = carroRepository.findByPlaca(placa);
		if(carro.isPresent()) {
			Carro carroAtualizado = atualizarCarroForm.atualizar(carro.get());
			return ResponseEntity.ok(new CarroDto(carroAtualizado));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deletar/{placa}")
	@Transactional
	public ResponseEntity<?> deletarCarro(@PathVariable String placa) {
		
		Optional<Carro> carro = carroRepository.findByPlaca(placa);
		if(carro.isPresent()) {
			carroRepository.deleteById(placa);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
		
	}
}
