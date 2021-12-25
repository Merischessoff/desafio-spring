package com.desafio.api.servico.validacao;

import com.desafio.api.modelo.Pauta;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;


public class ValidacaoPautaServico {
	
	public void validaCriarPauta(Pauta pauta) {
		if(pauta.getNomePauta() == null) 
			throw new ExcessaoDesafioServico("O nome da pauta é necessário!");
	}
	
}
