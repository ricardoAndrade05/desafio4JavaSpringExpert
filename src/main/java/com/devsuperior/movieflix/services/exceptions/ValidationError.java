package com.devsuperior.movieflix.services.exceptions;

import java.util.ArrayList;
import java.util.List;


public class ValidationError extends StandardError {
	
	private List<FieldMessage> erros = new ArrayList<>();
	
	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErro(String campo, String mensagem) {
		this.erros.add(new FieldMessage(campo, mensagem));
	}
}
