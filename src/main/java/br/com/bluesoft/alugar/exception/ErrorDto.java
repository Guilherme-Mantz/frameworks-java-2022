package br.com.bluesoft.alugar.exception;

public class ErrorDto {

	private String mensagem;

	public ErrorDto(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

}
