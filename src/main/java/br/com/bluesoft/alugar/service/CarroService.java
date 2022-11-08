package br.com.bluesoft.alugar.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.bluesoft.alugar.controller.form.CarroForm;
import br.com.bluesoft.alugar.controller.form.atualizar.AtualizarCarroForm;
import br.com.bluesoft.alugar.modelo.Carro;
import br.com.bluesoft.alugar.repository.CarroRepository;

@Service
public class CarroService {
	
	private CarroRepository carroRepository;
	
	public CarroService(CarroRepository carroRepository) {
		this.carroRepository = carroRepository;
	}

	public Optional<Carro> buscarCarroPelaPlaca(String placa) {
		return carroRepository.findById(placa);
	}

	public List<Carro> listarCarros() {
		return carroRepository.findAll();
	}

	@Transactional
	public Carro cadastrar(CarroForm carroForm) {
		Carro carro = carroForm.toCarro();
		Carro carroCriado = carroRepository.save(carro);
		
		return carroCriado;
	}
	
	@Transactional
	public Carro atualizar(Carro carro,AtualizarCarroForm atualizarCarroForm) {
		Carro carrtoAtualizado = atualizarCarroForm.atualizar(carro);
		return carrtoAtualizado;
	}
	
	@Transactional
	public void deletar(String placa) {
		carroRepository.deleteById(placa);
	}
}
