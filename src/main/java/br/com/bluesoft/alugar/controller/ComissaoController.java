package br.com.bluesoft.alugar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluesoft.alugar.controller.dto.ComissaoDto;
import br.com.bluesoft.alugar.repository.ComissaoRepository;

@RestController
@RequestMapping("/comissoes")
public class ComissaoController {

	@Autowired
	private ComissaoRepository comissaoRepository;

	@GetMapping("/listar")
	public List<ComissaoDto> buscarComissao() {

		List<ComissaoDto> comissoes = comissaoRepository.buscarComissoes();
		return comissoes;

	}

	@GetMapping("/{cpf}")
	public ComissaoDto buscarComissaoPeloCpf(@PathVariable Long cpf) {
		return comissaoRepository.buscarComissaoPorCpf(cpf);
	}
}
