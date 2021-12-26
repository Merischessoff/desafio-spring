package com.desafio.api.modelo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Voto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoto;
	private String cpfAssociado;
	private int escolha;
	
	@OneToOne
	@JoinColumn(name = "ID_SESSAO_VOTO")
	private Sessao sessao;

	public Voto(Long idVoto, String cpfAssociado, int escolha, Sessao sessao) {
		super();
		this.idVoto = idVoto;
		this.cpfAssociado = cpfAssociado;
		this.escolha = escolha;
		this.sessao = sessao;
	}

	public Voto() {
		super();
	}

	public Long getIdVoto() {
		return idVoto;
	}

	public void setIdVoto(Long idVoto) {
		this.idVoto = idVoto;
	}

	public String getCpfAssociado() {
		return cpfAssociado;
	}

	public void setCpfAssociado(String cpfAssociado) {
		this.cpfAssociado = cpfAssociado;
	}

	public int getEscolha() {
		return escolha;
	}

	public void setEscolha(int escolha) {
		this.escolha = escolha;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfAssociado, escolha, idVoto, sessao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		return Objects.equals(cpfAssociado, other.cpfAssociado) && Objects.equals(escolha, other.escolha)
				&& Objects.equals(idVoto, other.idVoto) && Objects.equals(sessao, other.sessao);
	}

	@Override
	public String toString() {
		return "Voto [idVoto=" + idVoto + ", cpfAssociado=" + cpfAssociado + ", escolha=" + escolha + ", sessao="
				+ sessao + "]";
	}
	
	
}
