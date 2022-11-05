package br.com.bluesoft.alugar.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import br.com.bluesoft.alugar.modelo.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

	Cliente findByCpf(BigInteger cpf);

}
