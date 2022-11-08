package br.com.bluesoft.alugar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bluesoft.alugar.controller.dto.ComissaoDto;
import br.com.bluesoft.alugar.modelo.Comissao;

public interface ComissaoRepository extends JpaRepository<Comissao, Integer>{

    @Query("SELECT new br.com.bluesoft.alugar.controller.dto.ComissaoDto(c.vendedor, SUM(c.valor))"
    	  + "FROM Comissao AS c GROUP BY c.vendedor")
    List<ComissaoDto> buscarComissoes();

    @Query("SELECT new br.com.bluesoft.alugar.controller.dto.ComissaoDto(c.vendedor, SUM(c.valor)) "
    		+ "FROM Comissao AS c WHERE c.vendedor.cpf = :cpf GROUP BY c.vendedor")
    ComissaoDto buscarComissaoPorCpf(@Param("cpf")Long cpf);

}
