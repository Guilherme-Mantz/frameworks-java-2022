package br.com.bluesoft.alugar.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.bluesoft.alugar.controller.form.AluguelForm;
import br.com.bluesoft.alugar.factory.AluguelFactory;
import br.com.bluesoft.alugar.modelo.Aluguel;
import br.com.bluesoft.alugar.repository.AluguelRepository;

@Service
public class AluguelService {
	
	private AluguelFactory aluguelFactory;
	private AluguelRepository aluguelRepository;
	private ComissaoService comissaoService;
	
	public AluguelService(AluguelFactory aluguelFactory, AluguelRepository aluguelRepository, ComissaoService comissaoService) {
		this.aluguelFactory = aluguelFactory;
		this.aluguelRepository = aluguelRepository;
		this.comissaoService = comissaoService;
	}

	@Transactional
	public Aluguel gerarAluguel(AluguelForm formAluguel) {
		Aluguel aluguelCriado = aluguelFactory.criarAluguel(formAluguel);
		Aluguel aluguel = aluguelRepository.save(aluguelCriado);
		
		/*Gerar Comissao*/
		comissaoService.gerarComissao(aluguel);
		
		return aluguel;
	}
	
	public Optional<Aluguel> buscarPeloId(Integer id) {
		return aluguelRepository.findById(id);
	}
	
}
