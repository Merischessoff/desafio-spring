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
	
	private static int ZERO_SESSAO_TEMPO_EM_MINUTOS = 0;
	private static int PADRAO_SESSAO_TEMPO_EM_MINUTOS = 1;
	
	public void validaAbrirSessao(Sessao sessao) {
		if(sessao.getPauta().getIdPauta() == null)
			throw new ExcessaoDesafioServico("É necessário ter uma pauta na sessão!");
		
		if(sessaoRepositorio.buscaPautaSessaoAberta(sessao.getPauta().getIdPauta()) != null)
			throw new ExcessaoDesafioServico("Ja existe uma sessão aberta para a agenda informada!");
		
		if(sessao.getTempoDeterminado() <= ZERO_SESSAO_TEMPO_EM_MINUTOS)
			sessao.setTempoDeterminado(PADRAO_SESSAO_TEMPO_EM_MINUTOS);
	}
}
