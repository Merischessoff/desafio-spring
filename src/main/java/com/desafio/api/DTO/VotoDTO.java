package com.desafio.api.DTO;

import java.util.Objects;

import com.desafio.api.modelo.Sessao;

public class VotoDTO {
	
	private Sessao sessao;
	private Long contagemVotosSim;
	private Long contagemVotosNão;
	
	public VotoDTO(Sessao sessao, Long contagemVotosSim, Long contagemVotosNão) {
		super();
		this.sessao = sessao;
		this.contagemVotosSim = contagemVotosSim;
		this.contagemVotosNão = contagemVotosNão;
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

	public Long getContagemVotosNão() {
		return contagemVotosNão;
	}

	public void setContagemVotosNão(Long contagemVotosNão) {
		this.contagemVotosNão = contagemVotosNão;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contagemVotosNão, contagemVotosSim, sessao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VotoDTO other = (VotoDTO) obj;
		return Objects.equals(contagemVotosNão, other.contagemVotosNão)
				&& Objects.equals(contagemVotosSim, other.contagemVotosSim) && Objects.equals(sessao, other.sessao);
	}

	@Override
	public String toString() {
		return "VotoDTO [sessao=" + sessao + ", contagemVotosSim=" + contagemVotosSim + ", contagemVotosNão="
				+ contagemVotosNão + "]";
	}
	
	
	
}
