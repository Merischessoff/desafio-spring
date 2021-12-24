package com.desafio.api.DTO;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.desafio.api.modelo.Pauta;
import com.desafio.api.modelo.Sessao;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class VotoSessaoDTO {
	
	private String cpfAssociado;
	private String escolha;
	private Long idSessao;
	
	public VotoSessaoDTO(String cpfAssociado, String escolha, Long idSessao) {
		super();
		this.cpfAssociado = cpfAssociado;
		this.escolha = escolha;
		this.idSessao = idSessao;
	}

	public VotoSessaoDTO() {
		super();
	}

	public String getCpfAssociado() {
		return cpfAssociado;
	}

	public void setCpfAssociado(String cpfAssociado) {
		this.cpfAssociado = cpfAssociado;
	}

	public String getEscolha() {
		return escolha;
	}

	public void setEscolha(String escolha) {
		this.escolha = escolha;
	}

	public Long getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(Long idSessao) {
		this.idSessao = idSessao;
	}
	

	
	
	
}
