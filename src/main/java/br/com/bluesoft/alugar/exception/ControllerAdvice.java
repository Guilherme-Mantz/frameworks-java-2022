package br.com.bluesoft.alugar.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(value = (BusinessException.class))
	public ResponseEntity<ErrorDto> handler(BusinessException ex, BadRequest request){
		return ResponseEntity.badRequest().body(new ErrorDto(ex.getMessage()));
	}
	
}
