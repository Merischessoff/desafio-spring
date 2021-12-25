package com.desafio.api.servico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.api.modelo.Sessao;
import com.desafio.api.DesafioAplicacao;
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
	private static Logger logger = LoggerFactory.getLogger(DesafioAplicacao.class);

	public Sessao abrirSessao(SessaoDTO sessaoDTO) {
		Sessao sessao = new Sessao();
		List<Sessao> sessoes = new ArrayList<Sessao>();
		sessoes = sessaoRepositorio.findAll();
		sessao.setIdSessao(null);
		sessao.setTempoDeterminado(sessaoDTO.getTempoDeterminado());
		sessao.setTempoSessao(LocalDateTime.now().plusMinutes(sessaoDTO.getTempoDeterminado()));
		Optional<Pauta> pautaOp = pautaRepositorio.findById(sessaoDTO.getIdPauta());
		sessao.setPauta(pautaOp.get());
		validacaoSessaoServico.validaAbrirSessao(sessao, sessoes);
		logger.info("Abrindo sessão!");
		return sessaoRepositorio.save(sessao);
	}
}