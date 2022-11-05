package br.com.bluesoft.alugar.utils;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.bluesoft.alugar.modelo.Vendedor;

public class ComissaoUtil {

	private static final BigDecimal COMISSAO_PADRAO = new BigDecimal(10); 
	private static final BigDecimal COMISSAO_PARA_MAIS_DE_CINCO_ANOS = new BigDecimal(13);
	
	public static BigDecimal calcularComissao(Vendedor vendedor, BigDecimal totalDoAluguel) {
		BigDecimal comissao;
		LocalDate dataAdmissao = vendedor.getDataAdmissao();
		
		if(LocalDate.now().getYear() - dataAdmissao.getYear() > 5) {
			comissao = totalDoAluguel.multiply(COMISSAO_PARA_MAIS_DE_CINCO_ANOS).divide(new BigDecimal(100));
		}
		else {
			comissao = totalDoAluguel.multiply(COMISSAO_PADRAO).divide(new BigDecimal(100));
		}
		
		return comissao;
	}
}
