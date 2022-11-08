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

import br.com.bluesoft.alugar.controller.dto.CarroDto;
import br.com.bluesoft.alugar.controller.form.CarroForm;
import br.com.bluesoft.alugar.controller.form.atualizar.AtualizarCarroForm;
import br.com.bluesoft.alugar.modelo.Carro;
import br.com.bluesoft.alugar.service.CarroService;

@RestController
@RequestMapping("/carros")
public class CarroController {

	private CarroService carroService;
	
	public CarroController(CarroService carroService) {
		this.carroService = carroService;
	}

	@GetMapping
	public List<CarroDto> listarCarros() {
		List<Carro> carros = carroService.listarCarros();
		List<CarroDto> dto = CarroDto.toCarroDto(carros);

		return dto;
	}

	@GetMapping("/{placa}")
	public ResponseEntity<CarroDto> buscarPelaPlaca(@PathVariable String placa) {
		Optional<Carro> carro = carroService.buscarCarroPelaPlaca(placa);
		if (carro.isPresent()) {
			return ResponseEntity.ok(new CarroDto(carro.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<CarroDto> cadastrarCarro(@RequestBody @Valid CarroForm carroForm, UriComponentsBuilder uriBuilder) {
		Carro carro = carroService.cadastrar(carroForm);
		
		URI uri = uriBuilder.path("/carros/{placa}").buildAndExpand(carro.getPlaca()).toUri();
		return ResponseEntity.created(uri).body(new CarroDto(carro));
	}

	@PutMapping("/atualizar/{placa}")
	public ResponseEntity<CarroDto> atualizarCarro(@PathVariable String placa, @RequestBody @Valid AtualizarCarroForm atualizarCarroForm) {
		Optional<Carro> carro = carroService.buscarCarroPelaPlaca(placa);
		if(carro.isPresent()) {
			Carro carroAtualizado = carroService.atualizar(carro.get(), atualizarCarroForm);
			return ResponseEntity.ok(new CarroDto(carroAtualizado));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deletar/{placa}")
	public ResponseEntity<?> deletarCarro(@PathVariable String placa) {
		
		Optional<Carro> carro = carroService.buscarCarroPelaPlaca(placa);
		if(carro.isPresent()) {
			carroService.deletar(placa);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
		
	}
}
