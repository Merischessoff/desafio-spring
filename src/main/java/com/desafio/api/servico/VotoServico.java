package com.desafio.api.servico;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.api.DTO.VotoSessaoDTO;
import com.desafio.api.modelo.Pauta;
import com.desafio.api.modelo.Sessao;
import com.desafio.api.modelo.Voto;
import com.desafio.api.repositorio.SessaoRepositorio;
import com.desafio.api.repositorio.VotoRepositorio;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;
import com.desafio.api.servico.validacao.ValidacaoPautaServico;
import com.desafio.api.servico.validacao.ValidacaoVotoServico;

@Service
public class VotoServico {
	
	@Autowired
	private VotoRepositorio votoRepositorio;
	
	@Autowired
	private SessaoRepositorio sessaoRepositorio;
	
	private ValidacaoVotoServico validacaoVotoServico = new ValidacaoVotoServico();
	
	
	private Sessao sessao;
	
	public Voto resultadoVotos(Long idSessao) {	
		validacaoVotoServico.validaResultadoVotos(idSessao);
		Voto voto = votoRepositorio.resultadoVotos(idSessao);
		//log.info("Voting result calculated successfully.");
		return voto;
	}
		
	public Voto votar(VotoSessaoDTO votoDTO) {
		Voto voto = new Voto();
		voto.setCpfAssociado(votoDTO.getCpfAssociado());
		voto.setEscolha(votoDTO.getEscolha());
		voto.setIdVoto(null);
		Optional<Sessao> sessaoOp = sessaoRepositorio.findById(votoDTO.getIdSessao());
		voto.setSessao(sessaoOp.get());
		//validacaoVotoServico.validaInformacoes(voto);
		//validacaoVotoServico.validaAssociacaoVoto(voto);
		//validacaoVotoServico.validaEscolhaVoto(voto);
		//validacaoVotoServico.validaExisteSessaoFechada(voto);
		//log.info("Vote successfully counted.");
		return votoRepositorio.save(voto);
	}

}
