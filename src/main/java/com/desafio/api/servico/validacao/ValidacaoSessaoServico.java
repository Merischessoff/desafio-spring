package com.desafio.api.servico.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.desafio.api.modelo.Pauta;
import com.desafio.api.modelo.Sessao;
import com.desafio.api.repositorio.SessaoRepositorio;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;


public class ValidacaoSessaoServico {
	
	@Autowired
	private SessaoRepositorio sessaoRepositorio;
	
	private static int ZERO_SESSION_TIME_IN_MINUTES = 0;
	private static int DEFAULT_SESSIONN_TIME_IN_MINUTES = 1;
	
	public void validaAbrirSessao(Sessao sessao) {
		if(sessao.getPauta().getIdPauta() == null)
			throw new ExcessaoDesafioServico("É necessário ter uma pauta na sessão!");

		if(!sessaoRepositorio.existsById(sessao.getIdSessao()))
			throw new ExcessaoDesafioServico("Sessão não existe!");
		
		if(sessaoRepositorio.buscaPautaSessaoAberta(sessao.getPauta().getIdPauta()) != null)
			throw new ExcessaoDesafioServico("Ja existe uma sessão aberta para a agenda informada!");
		
		if(sessao.getTempoDeterminado() <= ZERO_SESSION_TIME_IN_MINUTES)
			sessao.setTempoDeterminado(DEFAULT_SESSIONN_TIME_IN_MINUTES);
	}
}
