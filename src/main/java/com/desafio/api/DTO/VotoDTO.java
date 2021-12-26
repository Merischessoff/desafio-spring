package com.desafio.api.DTO;

import com.desafio.api.modelo.Sessao;

public class VotoDTO {
	
	private Sessao sessao;
	private Long contagemVotosSim;
	private Long contagemVotosNao;
	
	public VotoDTO(Sessao sessao, Long contagemVotosSim, Long contagemVotosNão) {
		super();
		this.sessao = sessao;
		this.contagemVotosSim = contagemVotosSim;
		this.contagemVotosNao = contagemVotosNão;
	}

	public VotoDTO() {
		super();
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Long getContagemVotosSim() {
		return contagemVotosSim;
	}

	public void setContagemVotosSim(Long contagemVotosSim) {
		this.contagemVotosSim = contagemVotosSim;
	}

	public Long getContagemVotosNao() {
		return contagemVotosNao;
	}

	public void setContagemVotosNao(Long contagemVotosNão) {
		this.contagemVotosNao = contagemVotosNão;
	}

	
	
	
}
