package br.com.bluesoft.alugar.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.bluesoft.alugar.controller.dto.ComissaoDto;
import br.com.bluesoft.alugar.modelo.Aluguel;
import br.com.bluesoft.alugar.modelo.Comissao;
import br.com.bluesoft.alugar.modelo.Vendedor;
import br.com.bluesoft.alugar.repository.ComissaoRepository;

@Service
public class ComissaoService {
	
	private static final BigDecimal COMISSAO_PADRAO = new BigDecimal(10); 
	private static final BigDecimal COMISSAO_PARA_MAIS_DE_CINCO_ANOS = new BigDecimal(13);
	
	private static Integer TEMPO_CASA_PARA_SENIOR = 5;
	
	private ComissaoRepository comissaoRepository;
	
	public ComissaoService(ComissaoRepository comissaoRepository) {
		this.comissaoRepository = comissaoRepository;
	}

	@Transactional
	public void gerarComissao(Aluguel aluguel) {
		
		BigDecimal totalDoAluguel = aluguel.getValorTotal();
		Vendedor vendedor = aluguel.getVendedor();
		
		LocalDate dataAdmissao = vendedor.getDataAdmissao();
		LocalDate dataAtual = LocalDate.now();
		
		int anosDiferenca = dataAtual.getYear() - dataAdmissao.getYear();
		Boolean admissaoMaiorQueCincoAnos = anosDiferenca > TEMPO_CASA_PARA_SENIOR;
		
		BigDecimal valorComissao = BigDecimal.ZERO;
		if(admissaoMaiorQueCincoAnos) {
			valorComissao = COMISSAO_PARA_MAIS_DE_CINCO_ANOS.divide(BigDecimal.valueOf(100)).multiply(totalDoAluguel);
		}
		else {
			valorComissao = COMISSAO_PADRAO.divide(BigDecimal.valueOf(100)).multiply(totalDoAluguel);
		}
	
		Comissao comissao = new Comissao(valorComissao, vendedor, aluguel);
		
		comissaoRepository.save(comissao);
	}

	public List<ComissaoDto> listar() {
		return comissaoRepository.buscarComissoes();
	}

	public ComissaoDto buscarComissoesPeloCpf(Long cpf) {
		return comissaoRepository.buscarComissaoPorCpf(cpf);
	}
}
