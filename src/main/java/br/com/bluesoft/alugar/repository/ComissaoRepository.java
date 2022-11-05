package br.com.bluesoft.alugar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.bluesoft.alugar.modelo.Comissao;

public interface ComissaoRepository extends CrudRepository<Comissao, Integer>{

	@Query("SELECT sum(c.valorComissao), c.vendedor FROM Comissao c group by c.vendedor")
	List<Comissao> buscarComissoes();

	@Query("SELECT sum(c.valorComissao), c.vendedor FROM Comissao c WHERE c.vendedor.cpf = :cpf group by c.vendedor")
	List<Comissao> buscaPorCpf(Long cpf);

}
