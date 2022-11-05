package br.com.bluesoft.alugar.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluesoft.alugar.modelo.Aluguel;
import br.com.bluesoft.alugar.modelo.Comissao;
import br.com.bluesoft.alugar.modelo.ContaCorrente;
import br.com.bluesoft.alugar.repository.ComissaoRepository;
import br.com.bluesoft.alugar.repository.ContaCorrenteRepository;
import br.com.bluesoft.alugar.utils.ComissaoUtil;

@Service
public class ComissaoService {
	
	@Autowired
	private ComissaoRepository comissaoRepository;
	
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	public void gerarComissao(Aluguel aluguel) {
		BigDecimal valorComissao = ComissaoUtil.calcularComissao(aluguel.getVendedor(), aluguel.getValorTotal());
		
		ContaCorrente contaCorrente = contaCorrenteRepository.buscaPorVendedor(aluguel.getVendedor().getCpf());
	
		Comissao comissao = new Comissao(valorComissao, aluguel.getVendedor(), contaCorrente ,aluguel.getDataDoAluguel());
		comissaoRepository.save(comissao);
		
	}
}
