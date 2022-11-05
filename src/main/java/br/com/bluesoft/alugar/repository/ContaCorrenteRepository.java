package br.com.bluesoft.alugar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bluesoft.alugar.modelo.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {

	@Query("SELECT conta FROM ContaCorrente conta WHERE conta.vendedor.cpf = :cpf")
	ContaCorrente buscaPorVendedor(Long cpf);

}
