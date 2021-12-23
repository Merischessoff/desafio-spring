package com.desafio.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafio.api.modelo.Pauta;
import com.desafio.api.repositorio.PautaRepositorio;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;
import com.desafio.api.servico.validacao.ValidacaoPautaServico;


@Service
public class PautaServico{

	@Autowired
	private PautaRepositorio pautaRepositorio;
	
	private ValidacaoPautaServico validacaoPautaServico;

	public Pauta criarPauta(Pauta pauta) {
		validacaoPautaServico.validaCriarPauta(pauta);
		pauta.setIdPauta(null);
		//log
		return pautaRepositorio.save(pauta);
	}
	
}
