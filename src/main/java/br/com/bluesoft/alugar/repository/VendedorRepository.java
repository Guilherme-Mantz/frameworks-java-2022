package br.com.bluesoft.alugar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bluesoft.alugar.modelo.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

	Optional<Vendedor> findByCpf(Long cpf);

}
