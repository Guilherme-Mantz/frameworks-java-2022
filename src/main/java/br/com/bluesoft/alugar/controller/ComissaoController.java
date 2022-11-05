package br.com.bluesoft.alugar.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluesoft.alugar.controller.dto.ComissaoDto;
import br.com.bluesoft.alugar.modelo.Aluguel;
import br.com.bluesoft.alugar.modelo.Comissao;
import br.com.bluesoft.alugar.repository.ComissaoRepository;
import br.com.bluesoft.alugar.utils.ComissaoUtil;

@RestController
@RequestMapping("/comissao")
public class ComissaoController {

	@Autowired
	private ComissaoRepository comissaoRepository;
	
	@GetMapping("/busca")
	public List<ComissaoDto> buscarComissao(String cpf){
		
		if(cpf == "") {
			List<Comissao> comissoes = comissaoRepository.buscarComissoes();
			List<ComissaoDto> dto = ComissaoDto.toComissaoDto(comissoes);
			
			return dto;
		}
		else {
			List<Comissao> comissao = comissaoRepository.buscaPorCpf(Long.valueOf(cpf));
			List<ComissaoDto> dto = ComissaoDto.toComissaoDto(comissao);
			
			return dto;
		}
	}

	public void saveComissao(Aluguel aluguel) {
		Float valorComissao = ComissaoUtil.calcularComissao(aluguel.getVendedor(), aluguel.getValorTotal());
	
		Comissao comissao = new Comissao(new BigDecimal(valorComissao), aluguel.getVendedor());
		comissaoRepository.save(comissao);
		
	}
	
}
