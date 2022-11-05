package br.com.bluesoft.alugar.utils;

import java.time.LocalDate;

import br.com.bluesoft.alugar.modelo.Vendedor;

public class ComissaoUtil {

	private static final Float COMISSAO_PADRAO = 10f; 
	private static final Float COMISSAO_PARA_MAIS_DE_CINCO_ANOS = 13f;
	
	public static Float calcularComissao(Vendedor vendedor, Float totalDoAluguel) {
		Float comissao;
		LocalDate dataAdmissao = vendedor.getDataAdmissao();
		
		if(LocalDate.now().getYear() - dataAdmissao.getYear() > 5) {
			comissao = totalDoAluguel * COMISSAO_PARA_MAIS_DE_CINCO_ANOS / 100;
		}
		else {
			comissao = totalDoAluguel * COMISSAO_PADRAO / 100;
		}
		
		return comissao;
	}
}
