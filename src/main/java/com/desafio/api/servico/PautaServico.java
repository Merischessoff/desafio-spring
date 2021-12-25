package com.desafio.api.servico;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.api.DesafioAplicacao;
import com.desafio.api.DTO.PautaDTO;
import com.desafio.api.modelo.Pauta;
import com.desafio.api.repositorio.PautaRepositorio;
import com.desafio.api.servico.validacao.ValidacaoPautaServico;

@Service
public class PautaServico{

	@Autowired
	private PautaRepositorio pautaRepositorio;
	private ValidacaoPautaServico validacaoPautaServico = new ValidacaoPautaServico();
	private static Logger logger = LoggerFactory.getLogger(DesafioAplicacao.class);
	
	public Pauta criarPauta(PautaDTO pautaDTO) {
		Pauta pauta = new Pauta();
		pauta.setIdPauta(null);
		pauta.setDescricaoPauta(pautaDTO.getDescricaoPauta());
		pauta.setNomePauta(pautaDTO.getNomePauta());
		validacaoPautaServico.validaCriarPauta(pauta);
		logger.info("Criando Pauta API!");
		return pautaRepositorio.save(pauta);
	}
	
}
