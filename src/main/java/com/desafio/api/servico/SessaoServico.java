package com.desafio.api.servico;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.api.modelo.Sessao;
import com.desafio.api.DTO.SessaoDTO;
import com.desafio.api.modelo.Pauta;
import com.desafio.api.repositorio.PautaRepositorio;
import com.desafio.api.repositorio.SessaoRepositorio;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;
import com.desafio.api.servico.validacao.ValidacaoSessaoServico;

@Service
public class SessaoServico {

	@Autowired
	private SessaoRepositorio sessaoRepositorio;
	
	@Autowired
	private PautaRepositorio pautaRepositorio;
	
	private ValidacaoSessaoServico validacaoSessaoServico = new ValidacaoSessaoServico();
	
	public Sessao abrirSessao(SessaoDTO sessaoDTO) {
		Sessao sessao = new Sessao();
		sessao.setIdSessao(null);
		sessao.setTempoDeterminado(sessaoDTO.getTempoDeterminado());
		sessao.setTempoSessao(LocalDateTime.now().plusMinutes(sessaoDTO.getTempoDeterminado()));
		Optional<Pauta> pautaOp = pautaRepositorio.findById(sessaoDTO.getIdPauta());
		sessao.setPauta(pautaOp.get());
		//validacaoSessaoServico.validaAbrirSessao(sessao);
		//log.info("Session opened successfully.");
		return sessaoRepositorio.save(sessao);
	}
}