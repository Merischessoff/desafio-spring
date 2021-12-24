package com.desafio.api.modelo;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sessao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSessao;
	private int tempoDeterminado;
	private LocalDateTime tempoSessao;
	
	@OneToOne
	@JoinColumn(name = "idPauta")
	private Pauta pauta;

	public Sessao(Long idSessao, int tempoDeterminado, LocalDateTime tempoSessao, Pauta pauta) {
		super();
		this.idSessao = idSessao;
		this.tempoDeterminado = tempoDeterminado;
		this.tempoSessao = tempoSessao;
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

	public LocalDateTime getTempoSessao() {
		return tempoSessao;
	}

	public void setTempoSessao(LocalDateTime tempoSessao) {
		this.tempoSessao = tempoSessao;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSessao, pauta, tempoDeterminado, tempoSessao);
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
		return Objects.equals(idSessao, other.idSessao) && Objects.equals(pauta, other.pauta)
				&& tempoDeterminado == other.tempoDeterminado && Objects.equals(tempoSessao, other.tempoSessao);
	}

	@Override
	public String toString() {
		return "Sessao [idSessao=" + idSessao + ", tempoDeterminado=" + tempoDeterminado + ", tempoSessao="
				+ tempoSessao + ", pauta=" + pauta + "]";
	}

	
	
	
}
