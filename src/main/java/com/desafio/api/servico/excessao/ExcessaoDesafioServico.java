package com.desafio.api.servico.excessao;

import java.util.Random;

public class ExcessaoDesafioServico extends RuntimeException{
	private static final long serialVersionUID = new Random().nextLong();
	private String mensagem;
	
	public ExcessaoDesafioServico(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
