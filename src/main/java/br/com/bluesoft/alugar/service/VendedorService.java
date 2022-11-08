package br.com.bluesoft.alugar.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.bluesoft.alugar.controller.form.VendedorForm;
import br.com.bluesoft.alugar.controller.form.atualizar.AtualizarVendedorForm;
import br.com.bluesoft.alugar.modelo.Vendedor;
import br.com.bluesoft.alugar.repository.VendedorRepository;

@Service
public class VendedorService {

	private VendedorRepository vendedorRepository;
	
	public VendedorService(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}
	
	public Optional<Vendedor> buscarVendedorPeloCpf(Long cpf) {
		return vendedorRepository.findByCpf(cpf);
	}

	public List<Vendedor> listar() {
		return vendedorRepository.findAll();
	}

	public Optional<Vendedor> buscarPeloId(Integer id) {
		return vendedorRepository.findById(id);
	}

	@Transactional
	public Vendedor cadastrar(VendedorForm vendedorForm) {
		Vendedor vendedorCriado = vendedorForm.toVendedor();
		Vendedor vendedor =  vendedorRepository.save(vendedorCriado);
		
		return vendedor;
	}

	@Transactional
	public Vendedor atualizar(Vendedor vendedor, AtualizarVendedorForm atualizarVendedorForm) {
		Vendedor vendedorAtualizado = atualizarVendedorForm.atualizar(vendedor);
		return vendedorAtualizado;
	}

	@Transactional
	public void deletar(Integer vendedorKey) {
		vendedorRepository.deleteById(vendedorKey);
		
	}
	
}
