package com.desafio.api.servico.validacao;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.desafio.api.enums.VotoEscolhaEnum;
import com.desafio.api.modelo.Sessao;
import com.desafio.api.modelo.Voto;
import com.desafio.api.repositorio.SessaoRepositorio;
import com.desafio.api.repositorio.VotoRepositorio;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;

public class ValidacaoVotoServico {
	
	@Autowired
	private SessaoRepositorio sessaoRepositorio;
	
	@Autowired
	private VotoRepositorio votoRepositorio;
		
	public void validaResultadoVotos(Long idSessao) {
		if(idSessao == null)
			throw new ExcessaoDesafioServico("É necessário o id da sessão para a contagem dos votos!");
		Optional<Sessao> sessaoOp = sessaoRepositorio.findById(idSessao);
		Sessao sessao = sessaoOp.get();
		if(sessao == null)
			throw new ExcessaoDesafioServico("Sessao Não foi encontrada.");
		
		if(sessao.getTempoSessao().isAfter(LocalDateTime.now()))
			throw new ExcessaoDesafioServico("A sessão de votação ainda está aberta.");
	}
	
	public void validaEscolhaVoto(Voto voto) {
		voto.setEscolha(voto.getEscolha().toUpperCase().trim());
		if(!(VotoEscolhaEnum.ESCOLHA_SIM).equals(voto.getEscolha()) && !(VotoEscolhaEnum.ESCOLHA_NAO.getValue()).equals(voto.getEscolha()))
			throw new ExcessaoDesafioServico("Voto Inválido! Use 'SIM' ou 'NÂO'");
	}
	
	public void validaExisteSessaoFechada(Voto voto) {
		Optional<Sessao> sessaoOp = sessaoRepositorio.findById(voto.getSessao().getIdSessao());
		Sessao sessao = sessaoOp.get();
		if(sessao == null)
			throw new ExcessaoDesafioServico("Sessão de votação não encontrada.");
		
		if(sessao.getTempoSessao().isBefore(LocalDateTime.now()))
			throw new ExcessaoDesafioServico("Sessão de votação fechada.");		
	}
	
	public void validaAssociacaoVoto(Voto voto) {
		if(votoRepositorio.buscaAssociacaoVoto(voto.getSessao().getIdSessao(), voto.getCpfAssociado())  != null)
			throw new ExcessaoDesafioServico("Voto de associado já contado.");
	}
	
	public  void validaInformacoes(Voto voto) {
		if(voto.getSessao() == null)
			throw new ExcessaoDesafioServico("Sessão deve ser informada.");
		
		if(voto.getEscolha()  == null)
			throw new ExcessaoDesafioServico("Escolha deve ser informada.");
		
		if(voto.getCpfAssociado() == null)
			throw new ExcessaoDesafioServico("Cpf do associado deve ser informado.");		
	}
	
//	private void validateIfAssociateCannotVoteOrCPFIsInvalid(Voto voto) {
//		try {
//			if(cpfClient.getCpf(voteRequest.getCpfAssociate()).getStatus().equals(AssociacaoStatusEnum.ASSOCIATE_CANNOT_VOTE.getValue()))
//				throw new ChallengeException("Associate cannot vote.");
//		} catch (FeignException e) {
//			throw new ChallengeException("Associate's CPF is invalid.");
//		}
//	}
}
