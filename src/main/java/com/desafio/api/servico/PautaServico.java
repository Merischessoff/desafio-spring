package com.desafio.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.api.DTO.PautaDTO;
import com.desafio.api.modelo.Pauta;
import com.desafio.api.repositorio.PautaRepositorio;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;
import com.desafio.api.servico.validacao.ValidacaoPautaServico;


@Service
public class PautaServico{

	@Autowired
	private PautaRepositorio pautaRepositorio;
	
	private ValidacaoPautaServico validacaoPautaServico = new ValidacaoPautaServico();

	public Pauta criarPauta(PautaDTO pautaDTO) {
		Pauta pauta = new Pauta();
		pauta.setIdPauta(null);
		pauta.setDescricaoPauta(pautaDTO.getDescricaoPauta());
		pauta.setNomePauta(pautaDTO.getNomePauta());
		validacaoPautaServico.validaCriarPauta(pauta);
		//log
		return pautaRepositorio.save(pauta);
	}
	
}
