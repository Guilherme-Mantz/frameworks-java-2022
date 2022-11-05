package br.com.bluesoft.alugar.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.bluesoft.alugar.repository.AluguelRepository;
import br.com.bluesoft.alugar.repository.CarroRepository;
import br.com.bluesoft.alugar.repository.ClienteRepository;
import br.com.bluesoft.alugar.repository.VendedorRepository;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private ComissaoController comissaoController;
	
	@Autowired
	private CarroRepository carroRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<AluguelDto> alugarCarro(@RequestBody @Valid AluguelForm formAluguel, UriComponentsBuilder uriBuilder){
		Aluguel aluguel = formAluguel.toAluguel(clienteRepository, vendedorRepository, carroRepository);
		aluguelRepository.save(aluguel);
		
		/*Gerar Comissao*/
		comissaoController.saveComissao(aluguel);
		
		URI uri = uriBuilder.path("/aluguel/{id}").buildAndExpand(aluguel.getAluguelKey()).toUri();
		return ResponseEntity.created(uri).body(new AluguelDto(aluguel));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesAluguelDto> buscarAluguel(@PathVariable Integer id){
		
		Optional<Aluguel> aluguel = aluguelRepository.findById(id);
		if(aluguel.isPresent()) {
			return ResponseEntity.ok(new DetalhesAluguelDto(aluguel.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
