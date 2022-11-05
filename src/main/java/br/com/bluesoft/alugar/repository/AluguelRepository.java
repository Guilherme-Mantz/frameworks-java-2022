package br.com.bluesoft.alugar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.bluesoft.alugar.modelo.Aluguel;

public interface AluguelRepository extends CrudRepository<Aluguel, Integer> {

}
