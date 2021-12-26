package com.desafio.api.servico.validacao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.api.modelo.Sessao;
import com.desafio.api.modelo.Voto;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;

@Service
public class ValidacaoVotoServico {
	
		
	public void validaResultadoVotos(Sessao sessao) {
		if(sessao.getIdSessao() == null)
			throw new ExcessaoDesafioServico("É necessário o id da sessão para a contagem dos votos!");
		
		if(sessao == null)
			throw new ExcessaoDesafioServico("Sessao Não foi encontrada.");
	}
	
	public void validaEscolhaVoto(Voto voto) {
		if(voto.getEscolha() < 0 && voto.getEscolha() > 1) 
			throw new ExcessaoDesafioServico("Voto Inválido! Use '1' para sim ou '0' para não");
	}
	
	public void validaExisteSessaoFechada(Voto voto) {
		if(voto.getSessao() == null)
			throw new ExcessaoDesafioServico("Sessão de votação não encontrada.");
		
		if(voto.getSessao().getTempoSessao().isBefore(LocalDateTime.now()))
			throw new ExcessaoDesafioServico("Sessão de votação fechada.");		
	}
	
	public void validaAssociacaoVoto(Voto voto, List<Voto> votos) {
		for(Voto v : votos) {
			if(v.getSessao().getIdSessao() == voto.getSessao().getIdSessao() 
				&& v.getCpfAssociado().equalsIgnoreCase(voto.getCpfAssociado()))
				throw new ExcessaoDesafioServico("Voto de associado já contado.");
		}
	}
	
	public  void validaInformacoes(Voto voto) {
		if(voto.getSessao() == null)
			throw new ExcessaoDesafioServico("Sessão deve ser informada.");
		
		if(voto.getEscolha() > 1 && voto.getEscolha() < 0)
			throw new ExcessaoDesafioServico("Escolha deve ser informada.");
		
		if(voto.getCpfAssociado() == null)
			throw new ExcessaoDesafioServico("Cpf do associado deve ser informado.");		
	}
}
