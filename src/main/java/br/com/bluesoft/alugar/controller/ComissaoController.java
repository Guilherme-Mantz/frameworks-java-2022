package br.com.bluesoft.alugar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluesoft.alugar.controller.dto.ComissaoDto;
import br.com.bluesoft.alugar.service.ComissaoService;

@RestController
@RequestMapping("/comissoes")
public class ComissaoController {

	private ComissaoService comissaoService;

	public ComissaoController(ComissaoService comissaoService) {
		this.comissaoService = comissaoService;
	}

	@GetMapping("/listar")
	public List<ComissaoDto> buscarComissao() {

		List<ComissaoDto> comissoes = comissaoService.listar();
		return comissoes;

	}

	@GetMapping("/{cpf}")
	public ComissaoDto buscarComissaoPeloCpf(@PathVariable Long cpf) {
		return comissaoService.buscarComissoesPeloCpf(cpf);
	}
}
