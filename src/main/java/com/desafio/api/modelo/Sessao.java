package com.desafio.api.modelo;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Sessao {
	private Long idSessao;
	private int tempoDeterminado;
	private LocalDateTime fimDoTempo;
	
	@OneToOne
	@JoinColumn(name = "idPauta")
	private Pauta pauta;

	public Sessao(Long idSessao, int tempoDeterminado, LocalDateTime fimDoTempo, Pauta pauta) {
		super();
		this.idSessao = idSessao;
		this.tempoDeterminado = tempoDeterminado;
		this.fimDoTempo = fimDoTempo;
		this.pauta = pauta;
	}
	
	

	public Sessao() {
		super();
	}

	

	public Long getIdSessao() {
		return idSessao;
	}



	public void setIdSessao(Long idSessao) {
		this.idSessao = idSessao;
	}



	public int getTempoDeterminado() {
		return tempoDeterminado;
	}



	public void setTempoDeterminado(int tempoDeterminado) {
		this.tempoDeterminado = tempoDeterminado;
	}



	public LocalDateTime getFimDoTempo() {
		return fimDoTempo;
	}



	public void setFimDoTempo(LocalDateTime fimDoTempo) {
		this.fimDoTempo = fimDoTempo;
	}



	public Pauta getPauta() {
		return pauta;
	}



	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}



	@Override
	public int hashCode() {
		return Objects.hash(fimDoTempo, idSessao, pauta, tempoDeterminado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessao other = (Sessao) obj;
		return Objects.equals(fimDoTempo, other.fimDoTempo) && Objects.equals(idSessao, other.idSessao)
				&& Objects.equals(pauta, other.pauta) && tempoDeterminado == other.tempoDeterminado;
	}

	@Override
	public String toString() {
		return "Sessao [idSessao=" + idSessao + ", tempoDeterminado=" + tempoDeterminado + ", fimDoTempo=" + fimDoTempo
				+ ", pauta=" + pauta + "]";
	}
	
	
}
