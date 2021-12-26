package com.desafio.api.servico;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.api.DesafioAplicacao;
import com.desafio.api.DTO.VotoDTO;
import com.desafio.api.DTO.VotoSessaoDTO;
import com.desafio.api.modelo.Sessao;
import com.desafio.api.modelo.Voto;
import com.desafio.api.repositorio.SessaoRepositorio;
import com.desafio.api.repositorio.VotoRepositorio;
import com.desafio.api.servico.validacao.ValidacaoVotoServico;

@Service
public class VotoServico {
	
	@Autowired
	private VotoRepositorio votoRepositorio;
	
	@Autowired
	private SessaoRepositorio sessaoRepositorio;
	
	private ValidacaoVotoServico validacaoVotoServico = new ValidacaoVotoServico();
	
	private static Logger logger = LoggerFactory.getLogger(DesafioAplicacao.class);
	
	public VotoDTO resultadoVotos(Long idSessao) {	
		Optional<Sessao> sessaoOp = sessaoRepositorio.findById(idSessao);
		Sessao sessao = sessaoOp.get();
		validacaoVotoServico.validaResultadoVotos(sessao);
		VotoDTO voto = votoRepositorio.resultadoVotos(idSessao);
		logger.info("Resultado votos API");
		return voto;
	}
		
	public Voto votar(VotoSessaoDTO votoDTO) {
		Voto voto = new Voto();
		voto.setCpfAssociado(votoDTO.getCpfAssociado());
		voto.setEscolha(votoDTO.getEscolha());
		voto.setIdVoto(null);
		Optional<Sessao> sessaoOp = sessaoRepositorio.findById(votoDTO.getIdSessao());
		voto.setSessao(sessaoOp.get());
		validacaoVotoServico.validaInformacoes(voto);
		List<Voto> votos = votoRepositorio.findAll();
		validacaoVotoServico.validaAssociacaoVoto(voto, votos);
		validacaoVotoServico.validaEscolhaVoto(voto);
		validacaoVotoServico.validaExisteSessaoFechada(voto);
		logger.info("Votando API");
		return votoRepositorio.save(voto);
	}

}
