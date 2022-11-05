package br.com.bluesoft.alugar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.bluesoft.alugar.modelo.Vendedor;

public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

	Vendedor findByCpf(Long cpf);

}
