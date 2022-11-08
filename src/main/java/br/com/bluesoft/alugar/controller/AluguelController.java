package br.com.bluesoft.alugar.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bluesoft.alugar.controller.dto.AluguelDto;
import br.com.bluesoft.alugar.controller.dto.DetalhesAluguelDto;
import br.com.bluesoft.alugar.controller.form.AluguelForm;
import br.com.bluesoft.alugar.modelo.Aluguel;
import br.com.bluesoft.alugar.service.AluguelService;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
	
	private AluguelService aluguelService;
	
	public AluguelController(AluguelService aluguelService) {
		this.aluguelService = aluguelService;
	}

	@PostMapping
	public ResponseEntity<AluguelDto> alugarCarro(@RequestBody @Valid AluguelForm formAluguel, UriComponentsBuilder uriBuilder){

		Aluguel aluguel = aluguelService.gerarAluguel(formAluguel);
		
		URI uri = uriBuilder.path("/aluguel/{id}").buildAndExpand(aluguel.getAluguelKey()).toUri();
		return ResponseEntity.created(uri).body(new AluguelDto(aluguel));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesAluguelDto> buscarAluguel(@PathVariable Integer id){
		
		Optional<Aluguel> aluguel = aluguelService.buscarPeloId(id);
		if(aluguel.isPresent()) {
			return ResponseEntity.ok(new DetalhesAluguelDto(aluguel.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
